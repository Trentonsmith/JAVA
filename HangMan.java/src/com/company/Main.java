package com.company;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
   public static boolean hasWon = false;
    public static char[] wordToUse;
    public static Console con = System.console();
   public static ArrayList<Character> alreadyGuessed = new ArrayList<>();
        public static Scanner myScanner = new Scanner(System.in);
   public static Console console = System.console();
    public static void main(String[] args){
        startGame();
    }









    public static void startGame() {
        System.out.println("Welcome to Hangman, type a word to play with then press enter");
        wordToUse = myScanner.nextLine().toLowerCase().toCharArray();

 //           wordToUse = con.readPassword();

        Word theWord = new Word(wordToUse);
        while(theWord.getGuessesRemaining() > 0 && theWord.getNumOfVisibleLetters() != theWord.getMyArrayList().size() - theWord.getNumOfSpaces()) {


            theWord.printVisibleLetters();
            boolean isValidResponse = false;
            char guess = ' ';
            System.out.println("\nGuess a Letter");
            while (!isValidResponse) {
                if (myScanner.hasNext("[abcdefghijklmnopqrstuvwxyz]")) {
                    char[] arrayOfLetters = myScanner.nextLine().toCharArray();


                    if (arrayOfLetters.length > 1 || arrayOfLetters.length < 1) {
                        System.out.println("Please enter one letter");
                    }
                    else {
                        if (!alreadyGuessed.contains(arrayOfLetters[0])) {
                            guess = arrayOfLetters[0];
                            isValidResponse = true;
                            alreadyGuessed.add(guess);
                        }
                        else {
                            System.out.println("That letter was already chosen sorry");
                        }
                    }

                } else {
                    System.out.println("Enter a lowercase letter please");
                    myScanner.nextLine();
                }

            }

                if (theWord.isItInTheWord(guess)) {
                    System.out.println("Good Job" + "\nguesses remaining: " + theWord.getGuessesRemaining());
                    // this is where we increment the amount of visible letters
                    theWord.newAmountOfVisibleLetters();
                        continue;

                }


           if (!theWord.isItInTheWord(guess)){
               theWord.decrementGuessesRemainingByOne();
                System.out.println("There were no " + guess +"'s" +"\nguesses remaining: " + theWord.getGuessesRemaining());
            }

        }

        if(theWord.getGuessesRemaining() <= 0){
            System.out.println("\n\nYou have lost");
        }

        if(theWord.getNumOfVisibleLetters() == theWord.getMyArrayList().size() - theWord.getNumOfSpaces()){
            for(Word.Letter theLetter: theWord.getMyArrayList()) {
                System.out.print(theLetter.getLetter());
            }
            System.out.println("\n\nYou have Won!!!");
       }

    }

}
