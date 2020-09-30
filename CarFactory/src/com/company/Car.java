package com.company;

import java.util.Scanner;

public abstract class Car {
    public static Scanner carScanner = new Scanner(System.in);
    private static int carCount = 0;
    boolean isElectric;
    String make;
    String model;
    int numOfMiles;
    String condition;
    int ID;


    public Car(boolean isElectric, String make, String model, int numOfMiles, String condition, int ID) {
        this.isElectric = isElectric;
        this.make = make;
        this.model = model;
        this.numOfMiles = numOfMiles;
        this.condition = condition;
        this.ID = ID;
        carCount++;
    }

    boolean isElectric() {
        return isElectric;
    }

   String getMake() {
        return make;
    }

    String getModel() {
        return model;
    }

    int getNumOfMiles() {
        return numOfMiles;
    }

    String getCondition() {
        return condition;
    }

    public static int getCarCount() {
        return carCount;
    }

    public int getID() {
        return ID;
    }

    abstract void drive(int miles);

    public void setNumOfMiles(int numOfDrivenMiles){
        numOfMiles += numOfDrivenMiles;
    }

    @Override
    public String toString() {
        String description ="\n\nType of vehicle: " + this.getClass().getSimpleName() + "\n\n" + "make: " + make + "\n\n" + "model: " + model + "\n\n" + "is electric: " + isElectric + "\n\n"
                + "miles driven: " + numOfMiles + "\n\n" + "condition: "  + condition + "\n\n" + "ID: " + ID + "\n\n\n --------------------------------------";
        return description;

    }
}
