package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	//because scanner is only looking for 1 token (collection of characters without a space) it will only read the first name
	//System.out.print("What's your name?");
       // String name = scanner.next();
        //if input is john doe, out put will be john because only one token is read.

        //this tells the scanner to read the entire line of input, not just one token
        String fullName = scanner.nextLine();



    }
}
