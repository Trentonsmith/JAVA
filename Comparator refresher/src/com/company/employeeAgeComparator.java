package com.company;

import java.util.Comparator;

public class employeeAgeComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
        if(o1.age > o2.age){
            return 1;
        }else if(o1.age<o2.age){
            return -1;
        }else{
            return o1.name.compareToIgnoreCase(o2.name);
        }
    }
}
