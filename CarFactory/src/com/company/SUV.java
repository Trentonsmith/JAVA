package com.company;

import java.util.Scanner;

public class SUV extends Car{
    public boolean sunRoof;
    public boolean isSunRoofOpen;
    static int numOfSUV = 0;

    public SUV(boolean isElectric, String make, String model, int numOfMiles, String condition,int ID,boolean sunRoof) {
        super(isElectric, make, model, numOfMiles, condition,ID);
        this.sunRoof = sunRoof;
        isSunRoofOpen = false;
        numOfSUV++;
    }

    @Override
    void drive(int miles) {
        String openOrClose = "N/A";
        if(sunRoof){
            int choice = 0;
            boolean validAnswer = false;
            while(!validAnswer)
            System.out.println("Press 1 for an open sun-roof"+
                    "\nPress 2 for a closed sun-roof");
            if(carScanner.hasNextInt()){
                int num = carScanner.nextInt();
                carScanner.nextLine();
                if(num == 1||num == 2){
                    if(num == 1){
                        openOrClose = "open";
                    }else{
                        openOrClose = "closed";
                    }
                }else{
                    System.out.println("please enter 1 or 2");
                }

            }else{
                System.out.println("Please enter 1 or 2");
            }
        }
        System.out.println("Now driving SUV " + getMake() +" "+ getModel() + miles + " miles\nsun-roof is " + openOrClose);
        setNumOfMiles(miles);
        System.out.println("miles driven: " + miles +"\ntotal miles on vehicle is now: " + numOfMiles);
    }

    public void setSunRoofOpen(){
    if(sunRoof){
        if(!isSunRoofOpen) {
            isSunRoofOpen = true;
            System.out.println("SunRoof is now open");
        }else{
            System.out.println("SunRoof already open");
        }
    }
    else {
        System.out.println("No SunRoof on this car, sorry");
    }
    }

    public void setSunRoofClosed(){

        if(sunRoof){
            if(isSunRoofOpen) {
                isSunRoofOpen = false;
                System.out.println("SunRoof is now closed");
            }else{
                System.out.println("SunRoof already closed");
            }
        }
        else {
            System.out.println("No SunRoof on this car, sorry");
        }
    }

    public boolean isSunRoofOpen() {
        return isSunRoofOpen;
    }

    public static int getNumOfSUV() {
        return numOfSUV;
    }
    public String writeable(){
        String s = ID + "," + "S" + "," + isElectric + "," + make + "," + model + "," + numOfMiles + "," + condition + "," +  sunRoof + "\n";
        return s;
    }
}
