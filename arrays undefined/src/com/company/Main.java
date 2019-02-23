package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	// creates array with 7 spaces that are all 0 until defined
        int [] trent = new int[7];
        String [] fortuneTeller = new String[3];
        fortuneTeller[0] = "You will go far in life!";
        fortuneTeller[1] = "You will have great prosperity";
        fortuneTeller[2] = "You will be surrounded with your friends for all your life";
        System.out.println("I will predict your future, pick a number 1-3");
        int b = scanner.nextInt()-1;
        System.out.println(fortuneTeller[b]);

    }
}
