package com.company;

public class Main {

    public static void main(String[] args) {
        // prints from 0-9
	for(int i=0;i<10;i++){
	    System.out.println(i);
    }
	System.out.println("--------------");



        // will print from 0-6
        for(int i = 0;i<10;i++){
          if(i == 7){
              break;
            }
            System.out.println(i);
        }
        System.out.println("----------");

        // will print numbers 0-9 except for 7
        for(int i = 0; i<10;i++){
            if(i == 7){
                continue;
            }
            System.out.println(i);
        }





    }
}
