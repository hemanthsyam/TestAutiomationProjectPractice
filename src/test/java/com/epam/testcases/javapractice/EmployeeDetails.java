package com.epam.testcases.javapractice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDetails {

    public static void main(String[] args) {
        List<Employee> employees=new ArrayList<>();

        employees.add(new Employee("hemanth kumar","masarapadi",23));
        employees.add(new Employee("rakesh ","vasa",24));
        employees.add(new Employee("karthik","p",21));
        employees.add(new Employee("lokesh","shingadi",27));
        employees.add(new Employee("Bhargav","boyapati",22));


        List<Employee> employeeslist=employees.stream()
                .sorted(Comparator.comparing(Employee::getAge)).collect(Collectors.toList());

        for (Employee employee:employeeslist)
        {
            System.out.println(employee);
        }


    }
}
