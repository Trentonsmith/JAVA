package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
String password = "shark50";
        String passwordIn;
	do{
	    System.out.println("Please enter the password");
	    passwordIn = scanner.nextLine();
    }while(passwordIn.equals(password) == false);
	System.out.println("PASSWORD ACCEPTED");
    }
}
