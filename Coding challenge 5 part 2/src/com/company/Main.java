package com.company;

public class Main {

    public static void main(String[] args) {
	int [] trent = new int[20];
	for(int i = 0;i<trent.length; i++){
	    trent[i] = i+1;
    }
	for(int i = trent.length-1;i>=0;i--){
	    System.out.println(trent[i]);
    }
    }
}
