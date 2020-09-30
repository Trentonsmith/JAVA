package com.company;

public class Jeep extends Car{
    static int jeepCount = 0;
    public boolean hasFourWheelDrive;
    public boolean inFourWheelDrive;
    public Jeep(boolean isElectric, String make, String model, int numOfMiles, String condition,int ID, boolean hasFourWheelDrive) {
        super(isElectric, make, model, numOfMiles, condition, ID);
        this.hasFourWheelDrive = hasFourWheelDrive;
        jeepCount++;
    }
    @Override
    public void drive(int miles){
        if(hasFourWheelDrive){
            System.out.println();
        }
        System.out.println("Now driving the Jeep "+ getMake() + " "+ getModel()  +" "+ miles + " miles");
        System.out.println("4Wheel drive is ");
        if(hasFourWheelDrive){
            if(inFourWheelDrive) {
                System.out.print("on");
            }
            else{
                System.out.println("off");
            }
        }else{
            System.out.print("no four wheel drive");
        }
        setNumOfMiles(miles);
        System.out.println("miles driven: " + miles +"\ntotal miles on vehicle is now: " + numOfMiles);
    }

    public void turnFourWheelDriveOn(){
        if(hasFourWheelDrive){
            if(!inFourWheelDrive) {
                inFourWheelDrive = true;
                System.out.println("Four Wheel drive is now on");
            }else{
                System.out.println("Already in four wheel drive");
            }
        }else{
            System.out.println("No four wheel drive");
        }

    }
    public void turnFourWheelDriveOff(){
        if(hasFourWheelDrive){
            if(inFourWheelDrive) {
                inFourWheelDrive = false;
                System.out.println("Four Wheel drive is now off");
            }else{
                System.out.println("Already not in four wheel drive");
            }
        }else{
            System.out.println("No four wheel drive");
        }
    }

    public static int getJeepCount() {
        return jeepCount;
    }

    public boolean isHasFourWheelDrive() {
        return hasFourWheelDrive;
    }

    public boolean isInFourWheelDrive() {
        return inFourWheelDrive;
    }

    public String writeable(){
        String s = ID + "," +"J" + "," + isElectric + "," + make + "," + model + "," + numOfMiles + "," + condition + "," +  hasFourWheelDrive + "\n";
        return s;
    }
}
