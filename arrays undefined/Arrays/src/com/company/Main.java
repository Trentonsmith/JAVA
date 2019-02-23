package com.company;

public class Main {

    public static void main(String[] args) {
	int [] b = {34,76,89,1009};
       //will print 34
        System.out.println(b[0]);
       //changes b index 2 (89) to 51
        b[2] = 51;
      // use for statements to print all of the array
        for(int i = 0;i<=3;i++){
            System.out.println(b[i]);
        }

    }
}
