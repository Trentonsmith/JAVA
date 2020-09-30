package com.company;

public class Main {

    public static void main(String[] args) {
	Mammal mammal = new Mammal();
	mammal.walk();
        System.out.println(mammal.laysEggs);
        Mammal mammal2 = new Mammal(){

            @Override
            public void walk() {
                System.out.println("overridden method");
            }
        };

        mammal2.walk();
    }
}
