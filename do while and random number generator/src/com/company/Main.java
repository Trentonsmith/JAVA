package com.company;
// allows us to call upon random number
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String rollAgain;
        do {
            // chooses random number, either 1 2 3 4 5 or 6 and assigns it to an integer "num"
            int num = ThreadLocalRandom.current().nextInt(1, 7);
            System.out.println("You rolled a:  " + num);
            System.out.println("roll again? yes/no");
            rollAgain = scanner.nextLine();
        }while(rollAgain.equals("yes"));

    }
}
