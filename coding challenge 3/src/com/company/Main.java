package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
       System.out.println("Enter a number for X");
        int X = scanner.nextInt();
       System.out.println("Enter a number for Y");
       int Y = scanner.nextInt();
       if(X==Y){
           System.out.println("X and Y are equal");
       }
       else if(X>Y){
           System.out.println("X is greater than Y by: " + (X-Y));
       }
       else if(Y>X){
           System.out.println("Y is greater than X by: " + (Y-X));
       }
       else{
           System.out.println("Please enter a valid whole number");
       }

    }
}
