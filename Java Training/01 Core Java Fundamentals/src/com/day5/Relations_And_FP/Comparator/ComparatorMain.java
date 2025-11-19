package com.day5.Relations_And_FP.Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<EmployeeComparator> employees = new ArrayList<>();
		employees.add(new EmployeeComparator(2101,"Vandana",75000));
		employees.add(new EmployeeComparator(1102,"Ishita",55000));
		employees.add(new EmployeeComparator(1003,"Ishita",65000));
		employees.add(new EmployeeComparator(1103,"Ishita",85000));
		employees.add(new EmployeeComparator(1083,"Vandana",95000));
		employees.add(new EmployeeComparator(1003,"Ankit",65000));

		// create comparator for sorting by name
		Comparator<EmployeeComparator> nameComparator = (e1, e2) -> e1.name.compareTo(e2.name);
		Comparator<EmployeeComparator> salaryComparator = (e1, e2) -> Double.compare(e2.salary, e1.salary);
		// original list first'
		// use collections.sort (list,namecomparator) and print
		// use collections.sort (list,salarycomparator) and print
		// both 
		// combined thing - by name A-Z, then by salary desc
		// first sort by name - string string comparison
		// sorted list by name - namelist
		// .thencomparing - take this namelist
		// make the comparison on salary in desc order
		Comparator<EmployeeComparator> combinedComparator = 
				Comparator.comparing((EmployeeComparator e) -> e.name)   
				          .thenComparing((EmployeeComparator e) -> e.salary);
		
		Collections.sort(employees, combinedComparator);
		employees.forEach(System.out::println);// method reference
		// for a class System.out -> predifned in Java
		// -> existing method -> println
		// System.out :: println
		
		// printing with lambda expression
		employees.forEach(item -> System.out.println(item));
		
		// Ankit, Ishita -3 , Vandana-3
		// subset - Ishita -> 55000
		//                    85000
		//                    65000
		                      
	}

}
