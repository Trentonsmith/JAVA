package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Employee> empList = new ArrayList<>();
        for(int i = 0; i < 8;i++){
            System.out.println("Enter name");
            String name = scanner.nextLine();
            System.out.println("Enter age");
            int age = scanner.nextInt();
            scanner.nextLine();
            Employee temp = new Employee(name,age);
            empList.add(temp);
        }

        for(Employee emp: empList){
            System.out.println(emp.name + " is " +emp.age + " years old");
        }
        employeeAgeComparator comparator = new employeeAgeComparator();
        Collections.sort(empList,comparator);
        for(Employee emp: empList){
            System.out.println(emp.name + " is " +emp.age + " years old");
        }
    }
}
