package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class Word {
   private int numOfSpaces = 0;
    ArrayList<Integer> whereTheSpacesAre = new ArrayList<>();
    int howManyWereThere = 0;
  private  ArrayList<Letter> myArrayList;
   private int numOfVisibleLetters = 0;
   private int guessesRemaining = 7;


    public Word(char[] myWordArray){


        myArrayList = new ArrayList<>();

        for(int i = 0; i<myWordArray.length;i++){
            if(myWordArray[i] != ' ') {
                myArrayList.add(new Letter(myWordArray[i]));

            }
            else{
                myArrayList.add(new Letter(myWordArray[i]));
                myArrayList.get(i).isASpace = true;
                numOfSpaces++;
            }
            //myArray is the "finished" product
        }
    }

    public class Letter{
        boolean isASpace;
        char letter;
        boolean isVisible = false;
         public Letter(char letter)
         {
             if(letter == ' '){
                 this.letter = letter;
                 isASpace = true;

             }
             else {
                 this.letter = letter;
                 isASpace = false;
             }
         }
            public char getLetter(){
             return letter;
            }
    }

    public void printVisibleLetters(){
        for(int i =0; i<myArrayList.size();i++){
            if(myArrayList.get(i).getLetter() == ' '){
                System.out.print("  |  ");
                continue;
            }

        if(!myArrayList.get(i).isVisible) {
            System.out.print(" _ ");

        }
            else {
                System.out.print(myArrayList.get(i).getLetter());
            }

        }

    }

    public ArrayList<Letter> getMyArrayList(){
        return myArrayList;
    }

    public boolean isItInTheWord(char guess){
        howManyWereThere = 0;
        boolean hadTheLetter = false;
        for(int i = 0; i < myArrayList.size(); i++){

            if(myArrayList.get(i).getLetter() == ' '){
                continue;
            }
                if (myArrayList.get(i).getLetter() == guess) {
                    myArrayList.get(i).isVisible = true;
                    hadTheLetter = true;
                    howManyWereThere++;

                }
        }
        if(hadTheLetter) {
            System.out.println("There were " + howManyWereThere + " " + guess + "'s\n");
        }
        return hadTheLetter;
    }

    public int getGuessesRemaining() {
        return guessesRemaining;
    }

    public int getNumOfVisibleLetters() {
        return numOfVisibleLetters;
    }

    public void decrementGuessesRemainingByOne(){
        guessesRemaining--;
    }

    public int getHowManyWereThere() {
        return howManyWereThere;
    }

    public void newAmountOfVisibleLetters(){
        numOfVisibleLetters += howManyWereThere;
    }

    public int getNumOfSpaces() {
        return numOfSpaces;
    }
}
