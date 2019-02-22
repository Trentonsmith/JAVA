package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	System.out.println("How much is the bill?");
	Scanner scanner = new Scanner(System.in);
	double priceOfMeal = scanner.nextDouble();
	System.out.println("How many people are there?");
	int totalPeople = scanner.nextInt();
	System.out.format("the price per person will be %.2f",priceOfMeal/totalPeople);
    }
}
