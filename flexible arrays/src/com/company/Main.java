package com.company;

public class Main {

    public static void main(String[] args) {
int [] b = {34,45,76,903,12373,9807};
// now by using b.length the program will always print the amount of numbers contained in b
for(int i = 0;i<b.length;i++ ){
    System.out .println(b[i]);
}
// in order to list the numbers backwards, int i will now be equal to b.length-1(because arrays start with zeroes) and need to be greater than 0 followed by i--
    }
}
