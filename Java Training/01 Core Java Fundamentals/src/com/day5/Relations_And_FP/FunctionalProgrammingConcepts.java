package com.day5.Relations_And_FP;

import java.util.Comparator;

public class FunctionalProgrammingConcepts {
	
	// Java 8
	// Before Java 8 - OOP
	// Java 8 - Functional Programming
	// - focussing on what to do and not how to do
	// - Lambda Expressions ->
	
	// FP - boilerplate code
	// reduced boilerplate code
	// improved readability
	// Comparator<EmployeeComparator> nameComparator = (e1, e2) -> e1.name.compareTo(e2.name);
    // enabled parallel stream execution - Stream API
	// filter map
	// Lambdas, Streams, FunctionalInterfaces - what to achieve
	
	// Functional Interface 
	// -> an interface that contains exactly one abstract method
	// customer - give discount -> regularCustomer - 10%
	//                             premium - 20%
	//                             festiveDiscount - 30%
	// we can use lambda expressions
	
	// Lambda Expressions : ->
	// short unnamed function 
	// concise way to implement function or functional interface
	// we do not need to define proper function
	// anonymous method
	// syntax -> (parameters) -> expression
	// short calculations
	// streams
	// Not to use lambda -> complex logic
	// interface - more than abstract methods - not to use lambda functions
	// forEach
	
	// Method References -> :: -> reference operator
	// With method reference
	// Call a constructor -> Employee :: new 
	// Call Instance Method -> objName/className :: instanceMethod
	// Call static Method -> ClassName :: staticMethod
	
	// Streams API
	// - Java 8 
	// - used to process collections in a more functional, declarative way
	// - Pipeline -> takes data -> performs transformations -> produces result
	// - without modiying the original data
   // - takes a sequence of elements from List
	
	// Employee - dept
	// filter emps whose are form IT dept - 2 emps
	// convert name to Upper Case
	
	// fetch only IT emps -> using filter()
	// name - Upper Case -> use map()
}
