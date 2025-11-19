package com.day5.Relations_And_FP.Comparable;

public class Employee implements Comparable<Employee>{
	
	public Employee(int id, String name, double salary) {
		
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	int id;
	String name;
	double salary;
	
	@Override
	public int compareTo(Employee other) {		
		// asc order of salary
		// asc order of ids
		return Double.compare(this.id, other.id);
	}
	
	// Case 1 : E1, E2 - E1.compareTo(E2)
	// Generic : List of EMps - Collection - Collections.sort() <- use comapreTo

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}	

}
