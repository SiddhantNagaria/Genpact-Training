package com.day5.Relations_And_FP.Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableMain {

	public static void main(String[] args) {

		List<Employee> employees = new ArrayList<>();
		
		employees.add(new Employee(2101, "Emp1", 75000));
		employees.add(new Employee(1102, "Emp2", 55000));
		employees.add(new Employee(1003, "Emp3", 65000));
		
		System.out.println("Before Sorting");
		employees.forEach(System.out::println); // toString()
		
		System.out.println();
		
		Collections.sort(employees); // Use compareTo method which we have overriden
		System.out.println("After Sorting");
		employees.forEach(System.out::println);

	}

}
