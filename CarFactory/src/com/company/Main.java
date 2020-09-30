package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
     public static HashMap<Integer,Car> idCarFinder = new HashMap<>();
    // creates a arraylist to store cars made in the same runtime
   public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

// read and write file to store cars
        readFromFile();
        boolean quit = false;
        while(!quit){
            System.out.println("What would you like to do? " +
                    "\n 1. List Cars" +
                    "\n 2. Make New Car"+
                    "\n 3. Delete Car"+
                    "\n 4. Drive Car"+
                    "\n 4. Quit(autosaves)");

           int choice = checkIfInt(1,4);
           switch (choice) {
               case 1:
                   readFromFile();
                   for (Map.Entry e : idCarFinder.entrySet()) {
                       System.out.println(e.getValue());
                   }
                   break;
               case 2:
                   writeToFile();
                   System.out.println("Finished");
                   break;
               case 3:
                   boolean succesfulDelete = false;
                   while (!succesfulDelete) {
                       System.out.println("What is the ID number of the car you'd like to delete?(if you want the list of cars press any non-number)");
                       if (!scanner.hasNextInt()) {
                           for (Map.Entry entry : idCarFinder.entrySet()) {
                               System.out.println("ID: " + entry.getKey() + "Car details: " + entry.getValue());
                           }
                       }
                       int queryID = checkIfInt();
                       if (idCarFinder.containsKey(queryID)){
                           System.out.println("Deleting " + idCarFinder.get(queryID).getMake() + " " + idCarFinder.get(queryID).getModel() + " ID: " + queryID);
                           idCarFinder.remove(queryID,idCarFinder.get(queryID));
                           updateFileToCurrentMap();
                           succesfulDelete = true;
                       }
                       else{
                           System.out.println("Invalid answer try agaian \n");
                       }
                   }
           break;
               case 4:
                   quit = true;
                   updateFileToCurrentMap();
                   break;
           }


        }
     // writeToFile();
    }
    public static void driveCar(){
        int ID = 0;
        boolean validChoice = false;
        while(!validChoice) {
            System.out.println("What is the ID of the car you would like to drive?(press any non-number to see list of available cars.");
            if (!scanner.hasNextInt()) {
                for (Map.Entry e : idCarFinder.entrySet()) {
                    System.out.println(e.getValue());
                }
            } else {
                while (true) {
                    ID = scanner.nextInt();
                    scanner.nextLine();
                    if (idCarFinder.containsKey(ID)) {
                        System.out.println("Found Vehicle, starting drive now");
                        validChoice = true;
                        break;
                    } else {
                        System.out.println("{please enter a valid Vehicle ID");
                    }

                }
            }
        }
            System.out.println("now entering Car Driver");
        System.out.println("How far are we driving?");
        int miles = checkIfInt();
        idCarFinder.get(ID).drive(miles);



    }

    public static void writeToFile() {
        try (FileWriter writer = new FileWriter("Cars.txt", true)) {
            char carClass = 'A';
            System.out.println("Enter a \n" +
                    "S for SUV\n" +
                    "J for Jeep\n" +
                    "M for Motorcycle");
            boolean correctVehicleClass = true;
            do {
                String tryClass = scanner.next().toUpperCase();
                scanner.nextLine();

                if ((tryClass.equalsIgnoreCase("S") || tryClass.equals("M") || tryClass.equals("J")) && tryClass.length() < 2 && tryClass.length() > 0) {
                    carClass = tryClass.charAt(0);
                    correctVehicleClass = true;
                } else {
                    System.out.println("Please enter a single valid letter");
                    correctVehicleClass = false;
                }
            } while (!correctVehicleClass);
            switch (carClass) {
                case 'S':
                    System.out.println("Is the SUV electric?");
                    boolean isElectric = checkInputToCharTorF();
                    System.out.println("What is the make of the SUV?");
                    String make = scanner.nextLine();
                    System.out.println("What is the model of the SUV?");
                    String model = scanner.nextLine();
                    System.out.println("How many miles are on the vehicle?");
                    int numOfMiles = checkIfInt();
                    System.out.println("What is the condition of the car?");
                    String condition = scanner.nextLine();
                    System.out.println("what is the ID number of your SUV");
                    int ID = checkIfIntAndNotRepeatId();
                    System.out.println("does the SUV have a sunRoof?");
                    boolean hasSunRoof = checkInputToCharTorF();
                    writer.write(ID + "," + carClass + "," + isElectric + "," + make + "," + model + "," + numOfMiles + "," + condition + "," +  hasSunRoof + "\n");
                  idCarFinder.put(ID, new SUV(isElectric, make, model, numOfMiles, condition, ID, hasSunRoof));
                    break;

                case 'J':
                    System.out.println("Is the Jeep electric?");
                    isElectric = checkInputToCharTorF();
                    System.out.println("What is the make of the Jeep?");
                     make = scanner.nextLine();
                    System.out.println("What is the model of the Jeep?");
                     model = scanner.nextLine();
                    System.out.println("How many miles are on the Jeep?");
                     numOfMiles = checkIfInt();
                    System.out.println("What is the condition of the Jeep?");
                     condition = scanner.nextLine();
                    System.out.println("what is the ID number of your Jeep (just make one up if you don't have a name for it)");
                    ID = checkIfIntAndNotRepeatId();
                    System.out.println("Does the car have 4 wheel drive?");
                    boolean hasFourWheelDrive = checkInputToCharTorF();
                    writer.write( ID + "," +carClass + "," + isElectric + "," + make + "," + model + "," + numOfMiles + "," + condition + "," +  hasFourWheelDrive + "\n");
                    idCarFinder.put(ID, new Jeep(isElectric, make, model, numOfMiles, condition, ID, hasFourWheelDrive));
                    break;
                case 'M':
                    System.out.println("Is the Motorcycle electric?");
                    isElectric = checkInputToCharTorF();
                    System.out.println("What is the make of the Motorcycle?");
                    make = scanner.nextLine();
                    System.out.println("What is the model of the Motorcycle?");
                    model = scanner.nextLine();
                    System.out.println("How many miles are on the Motorcycle?");
                    numOfMiles = checkIfInt();
                    System.out.println("What is the condition of the Motorcycle?");
                    condition = scanner.nextLine();
                    System.out.println("what is the ID number of your Motorcycle (just make one up if you don't have a name for it)");
                    ID = checkIfIntAndNotRepeatId();
                    System.out.println("How tall are the handlebars in feet?");
                    int handleBarHeightInFeet = checkIfInt();
                    writer.write(ID + "," + carClass + "," + isElectric + "," + make + "," + model + "," + numOfMiles + "," + condition + "," + handleBarHeightInFeet + "\n");
                    idCarFinder.put(ID,new Motorcycle(isElectric, make, model, numOfMiles, condition, ID, handleBarHeightInFeet));
                    break;
                    default:
                        System.out.println("Error, now exiting");
                        break;


            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static boolean checkInputToCharTorF() {
        System.out.println("Enter T for true and F for false");

        boolean validAnswer = false;
        while (!validAnswer) {
            String input = scanner.nextLine();
            if (input.toCharArray().length == 1) {
                if (!input.equalsIgnoreCase("T") && !input.equalsIgnoreCase("f")) {
                    System.out.println("Try again");
                    validAnswer = false;
                } else {
                    if (input.equalsIgnoreCase("f")) {
                        return false;
                    } else {
                        return true;
                    }
                }
            } else {
                System.out.println("invalid answer try again");
                validAnswer = false;
            }
        }
        return false;
    }
    public static int checkIfInt() {
        while (true) {
            System.out.println("enter a number");
            if (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                scanner.nextLine();
                return num;
            }else{
                scanner.nextLine();
                System.out.println("Please enter a valid number");
            }
        }
    }


        public static void readFromFile(){
        try(BufferedReader reader = new BufferedReader(new FileReader("Cars.txt"))){
            String carInfo;
            // checks if end of file or if it's a !empty file!
            while ((carInfo = reader.readLine()) != null&&!carInfo.equalsIgnoreCase("")) {
                String[] myArray = carInfo.split(",");
                int ID = Integer.parseInt(myArray[0]);
                // if it's already in the map, don't overwrite
                if (!idCarFinder.containsKey(ID)) {
                    switch (myArray[1]) {
                        case "S":
                            boolean isElectric;
                            isElectric = wordToBool(myArray[2]);
                            String make = myArray[3];
                            String model = myArray[4];
                            int numOfMiles = Integer.parseInt(myArray[5]);
                            String condition = myArray[6];
                            boolean sunRoof = wordToBool(myArray[7]);
                            SUV newSUV = new SUV(isElectric, make, model, numOfMiles, condition, ID, sunRoof);
                            idCarFinder.put(ID, newSUV);
                            break;
                        case "J":
                            isElectric = wordToBool(myArray[2]);
                            make = myArray[3];
                            model = myArray[4];
                            numOfMiles = Integer.parseInt(myArray[5]);
                            condition = myArray[6];
                            boolean hasFourWheelDrive = wordToBool(myArray[7]);
                            Jeep newJeep = new Jeep(isElectric, make, model, numOfMiles, condition, ID, hasFourWheelDrive);
                            idCarFinder.put(ID, newJeep);

                            break;
                        case "M":

                            isElectric = wordToBool(myArray[2]);
                            make = myArray[3];
                            model = myArray[4];
                            numOfMiles = Integer.parseInt(myArray[5]);
                            condition = myArray[6];
                            int heightOfHandleBarInFeet = Integer.parseInt(myArray[7]);
                            Motorcycle newMoto = new Motorcycle(isElectric, make, model, numOfMiles, condition, ID, heightOfHandleBarInFeet);
                            idCarFinder.put(ID, newMoto);
                            break;


                    }
                }
                
                
                
            }

        }catch (IOException e){
            e.printStackTrace();
        }


        }

        public static boolean wordToBool(String bool){
        if(bool.equalsIgnoreCase("true")){
            return true;
        }else if(bool.equalsIgnoreCase("false")){
            return false;
        }else{
            System.out.println("error");
            return false;
        }
        }
    public static int checkIfInt(int minConstraint, int maxConstraint){
        while(true){
            int num;
            System.out.println("enter a number");
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                scanner.nextLine();
                if (num >= minConstraint && num <= maxConstraint) {
                    return num;
                } else {
                    System.out.println("Enter a number between " + minConstraint + " and " + maxConstraint + " inclusively");
                }
            }else {
                scanner.nextLine();
            }

        }
    }

    public static int checkIfIntAndNotRepeatId(){
        while (true) {
            System.out.println("enter a number");
            if (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                scanner.nextLine();
                if(idCarFinder.containsKey(num)){
                    System.out.println("That number has already been taken");
                    continue;
                }
                return num;
            }else{
                scanner.nextLine();
                System.out.println("Please enter a valid number");
            }
        }
    }

    public static void updateFileToCurrentMap(){
        try(FileWriter finalWriter = new FileWriter("Cars.txt",false)){
            for(Map.Entry entry: idCarFinder.entrySet()){
                if(entry.getValue().getClass() == Jeep.class){
                    Jeep tempJeep = ((Jeep)entry.getValue());
                    finalWriter.write(tempJeep.writeable());
                }
                else if(entry.getValue().getClass() == SUV.class){
                    SUV tempSUV = ((SUV)entry.getValue());
                    finalWriter.write(tempSUV.writeable());
                }else if(entry.getValue().getClass() == Motorcycle.class){
                    Motorcycle tempMoto = ((Motorcycle)entry.getValue());
                    finalWriter.write(tempMoto.writeable());
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    }
