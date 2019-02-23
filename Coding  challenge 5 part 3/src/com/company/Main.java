package com.company;

public class Main {

    public static void main(String[] args) {
	double [] nums = {3.54,3.98,2.98,5.76,9.09};
	double sum = 0;
	for(int i = 0; i<5;i++){
	   // sum = sum+nums[i]
	    sum += nums[i];
    }
	// format so we can make the numbers more clean
	System.out.format("the sum of all of these numbers is %.2f",sum);
	System.out.println(" ");
	double averageNums = sum/nums.length;
	System.out.format(" the average of these numbers is %.2f", averageNums);
    }
}
