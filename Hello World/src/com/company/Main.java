package com.company;
import java.util.Scanner;
// calling scanner into program
public class Main {

    public static void main(String[] args) {
        // Scanner A = stores the scanner as a variable
    //add scanner for us to use, System.in tells it to scan the input
	Scanner UV= new Scanner(System.in);
	//A.next tells the program not to stop running and wait for scanner to detect something
        //string b = A.next tells the computer to store the input
       String repeater = UV.next();
       //so if i type hello into input, the string b will equal hello
        System.out.println(repeater);



    }
}
