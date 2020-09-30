package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("enter number");
printFibSequence(scanner.nextInt());
    }
    public static void printFibSequence(int divisor){
        scanner.nextLine();
        ArrayList<Integer> fibList = new ArrayList<>();
        int a = 0;
        int b = 0;
        int c = 1;
        int index = 0;
        while(c < 10000){
            index++;
            a = b;
            b = c;
            c = a+b;
            fibList.add(c);
            if(c % divisor == 0){
                System.out.println("\n\n\n num is: " + index);
                System.out.println();
                return;
            }

        }
        return;
    }

    public static void isAPalindrome(int theList){

    }
}
