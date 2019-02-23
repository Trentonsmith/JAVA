package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	System.out.println("Welcome to roller coaster world");
	System.out.println("Please enter your height in centimeters");
	Scanner scanner = new Scanner(System.in);
	int heightInput = scanner.nextInt();
	if(heightInput >= 150){
	    System.out.println("You are tall enough to ride this ride");
    }
	else if(heightInput < 150){
		System.out.println("You are not tall enough too ride this ride");
	}

    }
}
