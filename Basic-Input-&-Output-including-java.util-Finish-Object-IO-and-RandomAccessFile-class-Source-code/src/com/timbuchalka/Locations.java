package com.timbuchalka;


import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Locations implements Map<Integer, Location> {
        private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();
        private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();
        private static RandomAccessFile ra;
        public static void main(String[] args) throws IOException {
//            try (ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))) {
//                for(Location location : locations.values()) {
//                    locFile.writeObject(location);
//                }
//            }
            
            try(RandomAccessFile rao = new RandomAccessFile("locations_rand.dat", "rwd")){
                // gets how many locations we have
                rao.write(locations.size());
                // each entry in the index is going to be 3 ints (Location ID, offset from this point to the location record, size/length of location record)
                int indexSize = locations.size() * 3 * Integer.BYTES;
                // we know the start of the location records will be: the size of the index plus the first int (size) and this second int we are making right now(data offset)
                int locationStart = (int) (indexSize + rao.getFilePointer() + Integer.BYTES);
                rao.writeInt(locationStart);
                // we will be writing the locations first because we don't know the offset (due to different amount of exits and other variables)
                // so we will write all the locations the go back and make the index
                long indexStart = rao.getFilePointer();
                // sets us up at the point after where our Index will be, so the pointer "skips" over the first 2 ints and the now empty data to where the location records should be
                int startPointer = locationStart;
                rao.seek(startPointer);
                
                // writing out each location record
                for(Location location: locations.values()) {
                    // write ID
                    rao.writeInt(location.getLocationID());
                    // write description
                    rao.writeUTF(location.getDescription());
                    StringBuilder builder = new StringBuilder();
                    // for every exit, write ((direction) (comma) (what room the exit leads to))
                    for (String direction : location.getExits().keySet()) {
                        if (!direction.equalsIgnoreCase("q")) {
                            builder.append(direction);
                            builder.append(",");
                            builder.append(location.getExits().get(direction));
                            builder.append(",");
                            // direction, locationID, direction, LocationID
                        }
                    }
                    rao.writeUTF(builder.toString());
                    // the start pointer shows us where the record starts, rao.getFilePointer gets where our file ended off.
                    IndexRecord record = new IndexRecord(startPointer, (int) (rao.getFilePointer() - startPointer));
                    // puts the location ID as the key to the map, and the data we will put in the index later (starting point and length) as the value
                    index.put(location.getLocationID(), record);
                    // puts the startPointer where we last wrote to it (before start of Index)
                    // we are going to use this to get the location length because on the next loop we will write more bytes(moving filePointer)
                    //  and we know the startPoint is the beginning and the new filePointer is the end so we can get size of location
                    startPointer = (int) rao.getFilePointer();
                
               
                }

                // now that we've written all the locations we're going back to our start index and writing it out
                rao.seek(indexStart);
                for(Integer LocationID: index.keySet()){
                    //locationID
                    rao.writeInt(LocationID);
                    // start of location record (startByte is a field of our IndexRecord class
                    rao.writeInt(index.get(LocationID).getStartByte());
                    // length of location record (getting length in bytes of Location) Length is field of IndexRecord
                    rao.writeInt(index.get(LocationID).getLength());
                }
                
            }

        }

        // 1. This first four bytes will contain the number of locations (bytes 0-3)
        // 2. The next four bytes will contain the start offset of the locations section (bytes 4-7)
        // 3. The next section of the file will contain the index (the index is 1692 bytes long.  It will start at byte 8 and end at byte 1699
        // 4. The final section of the file will contain the location records (the data). It will start at byte 1700


        static {
                try{
                    ra = new RandomAccessFile("locations_rand.dat", "rwd");
                    int numLocations = ra.readInt();
                    long locationsStartPoint = ra.readInt();
                    // while we are still in the index (index is before location records
                    while(ra.getFilePointer() < locationsStartPoint){
                        int locationID = ra.readInt();
                        int locationStart = ra.readInt();
                        int locationLength = ra.readInt();
                        IndexRecord record = new IndexRecord(locationStart,locationLength);
                        // loading the index into the program so we can use it.
                        index.put(locationID, record);
                    }
                    
                }catch (IOException e){
                    System.out.println("IOException in static initializer block");
                }
                
        }
        
        public Location getLocation(int locationID) throws IOException{
            // we now have the index loaded into the program so we can use the map
            IndexRecord record = index.get(locationID);
            // goes to start of record
            ra.seek(record.getStartByte());
            // reads locationID
            int id = ra.readInt();
            // reads Description
            String description = ra.readUTF();
            // we made a string builder for the exits
            String exits = ra.readUTF();
            // splitting string by comma
            String[] exitPart = exits.split(",");
            // we are going to pass the exits manually instead of passing map into constructor
            Location location = new Location(locationID,description,null);
            if(locationID != 0){
                for(int i = 0; i < exitPart.length; i++){
                    System.out.println("exitPart = " + exitPart[i]);
                    System.out.println("exitPart[+1] = " + exitPart[1]);
                    String direction = exitPart[i];
                    // incrementing i first then getting value so when it gets to the next
                    // iteration of the for-loop it will have incremented twice
                    int destination = Integer.parseInt(exitPart[++i]);
                    location.addExit(direction,destination);
                    
                }
            }
            return location;
        }

        @Override
        public int size() {
            return locations.size();
        }

        @Override
        public boolean isEmpty() {
            return locations.isEmpty();
        }

        @Override
        public boolean containsKey(Object key) {
            return locations.containsKey(key);
        }

        @Override
        public boolean containsValue(Object value) {
            return locations.containsValue(value);
        }

        @Override
        public Location get(Object key) {
            return locations.get(key);
        }

        @Override
        public Location put(Integer key, Location value) {
            return locations.put(key, value);
        }

        @Override
        public Location remove(Object key) {
            return locations.remove(key);
        }

        @Override
        public void putAll(Map<? extends Integer, ? extends Location> m) {

        }

        @Override
        public void clear() {
            locations.clear();

        }

        @Override
        public Set<Integer> keySet() {
            return locations.keySet();
        }

        @Override
        public Collection<Location> values() {
            return locations.values();
        }

        @Override
        public Set<Entry<Integer, Location>> entrySet() {
            return locations.entrySet();
        }
        public void close() throws IOException{
            ra.close();
        }
}
