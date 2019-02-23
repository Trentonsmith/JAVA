package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	String [] favoriteFoods = new String[5];
	String foodIn;
	for(int i = 0;i<favoriteFoods.length;i++ ){
	    System.out.println("What is a food you like?");
	    foodIn = scanner.nextLine();
	    favoriteFoods[i] = foodIn;
	    if(i>=3){
	        System.out.println("Sorry no memory left");
	        break;
        }
    }
	for(int i = 0; i<favoriteFoods.length; i++){
	    System.out.println(favoriteFoods[i]);
    }
    }
}
