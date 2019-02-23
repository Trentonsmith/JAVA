package com.company;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        int randomNumber = ThreadLocalRandom.current().nextInt(1, 101);
        Scanner scanner = new Scanner(System.in);
        System.out.println("I will choose a numer from 1-100, if you get it wrong, I will tell you whether you are too high or too low");
        int guessNum;
        int i = 0;
        do{
            guessNum = scanner.nextInt();
            if(guessNum > randomNumber){
                System.out.println("Too high, try again");
            }
            else if (guessNum < randomNumber){
                System.out.println("Too low, try again");
            }
            i++;
        }while(guessNum != randomNumber);
        System.out.println("correct, the number was " + randomNumber+ "!!! It took you "+i+ " guesses.");
    }
}
