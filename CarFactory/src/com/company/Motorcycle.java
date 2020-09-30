package com.company;

public class Motorcycle extends Car {
    public int handleBarHeightInFeet;
    static int numOfMoto = 0;

    public Motorcycle(boolean isElectric, String make, String model, int numOfMiles, String condition, int ID, int handleBarHeightInFeet) {
        super(isElectric, make, model, numOfMiles, condition, ID);
        this.handleBarHeightInFeet = handleBarHeightInFeet;
        numOfMoto++;
    }

    public int getHandleBarHeightInFeet() {
        return handleBarHeightInFeet;
    }

    public static int getNumOfMoto() {
        return numOfMoto;
    }

    @Override
    public void drive(int miles){
        if(handleBarHeightInFeet > 2){
            System.out.println("Now High-Riding motorcycle " + getMake() +" "+ getModel()+ " " + miles +" miles");
        }
        else{
            System.out.println("Now Low-Riding motorcycle " + getMake() +" "+ getModel()+ " " + miles +" miles");
        }
        setNumOfMiles(miles);
        System.out.println("miles driven: " + miles +"\ntotal miles on vehicle is now: " + numOfMiles);
    }

    public String writeable(){
        String s = ID + "," + "M" + "," + isElectric + "," + make + "," + model + "," + numOfMiles + "," + condition + "," + handleBarHeightInFeet + "\n";
        return s;
    }

}
