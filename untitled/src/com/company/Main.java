package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //replace numbers with %d and strings with %s and floats and doubles with %f you can add a .1 inbetween like %.1f to round to one decimal place
    	//just d% or f% will round it to a whole number
	System.out.println("What's your name?");
	Scanner Scan = new Scanner(System.in);
	String nameInput = Scan.next();
	System.out.println("Hello "+ nameInput);
	System.out.println("How old are you?");
	int ageInput = Scan.nextInt();
	System.out.println("Your name is "+nameInput+ " Your age is "+ageInput);
	System.out.println("what is your height in meters");
	double heightInput = Scan.nextDouble();
	double averageMaleHeightDifference = heightInput-1.75;
	double averageFemaleHeightDifference = heightInput-1.62;
	System.out.println("Difference in height from average: ");
	System.out.format("%.2f m in difference if male\n",averageMaleHeightDifference );
	System.out.format("%.2f m in difference if female", averageFemaleHeightDifference);


    }
}
