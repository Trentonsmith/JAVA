package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//	int x = 99;
//	int y = 0;
//        System.out.println(divideLBYL(x,y));
//        System.out.println(divideEAFP(x,y));
//        System.out.println(divide(x,y));
        int x = getIntEAFP();
        System.out.println("x is " + x);
    }
    public static int getInt(){
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }

    private static int getIntEAFP(){
        Scanner s = new Scanner(System.in);
        try {
            return s.nextInt();
        }catch (InputMismatchException e){
            return 0;
        }

    }
private static int getIntLBYL(){
    Scanner s = new Scanner(System.in);
    boolean isValid = true;
    System.out.println("Enter a integer");
    String input = s.next();
    for(int i = 0; i < input.length(); i++){
        if(!Character.isDigit(input.charAt(i))){
            isValid = false;
            break;
        }
    }
    if(isValid){
        return Integer.parseInt(input);
    }

    return 0;
}

    // EAFP = easier to ask forgiveness
// lbyl = look before you leap
    private static int divideLBYL(int x, int y){
        // checks if the divisor is 0, checking before computation
        if(y != 0){
            return x / y;
        }
        else{
            return 0;
        }
    }
   private static int divideEAFP(int x, int y){
        // tries to do equation no matter what and catches if it gives of this exception
        try{
            return x/y;
        } catch (ArithmeticException e){
            return 0;
        }
   }

   private static int divide(int x, int y){
        return x / y;
   }


}
