package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        String Name = scanner.nextLine();
        System.out.println("Your name is "+ Name.length()+ " letters long");
        System.out.println(Name+ ", how old are you?");
        int Age = scanner.nextInt();
        System.out.println("you have lived "+ Age+ " years. In another " + Age+" years you will be "+ Age*2+" years old");

    }
}
