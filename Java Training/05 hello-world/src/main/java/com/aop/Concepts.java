package com.aop;

public class Concepts {

	/*
	 	AOP  - aspect oriented programming
	 	
	 	Business Proejcts - business logic - defined classes
	 	cross cutting concerns - logging, security
	 	separate from business logic
	 	log the transaction - business logic is implementing - log that
	 	method()
	 	before execution - log - yet to be started
	 	method is executing - log - executing
	 	method get finishes - log - finished
	 	
	 	include this additional functionality into our projects w/o disturbing the main logic
	 	handle this   =we have a module - AOP
	 	
	 	Concepts of Spring AOP-
	 		- Aspect -> modular unit that encapsulates the cross cutting concern
	 					class which will do the task - logging
	 					mark the class as Aspect with @Aspect annotation
	 		- Advice ->action taken by aspect at a specific point
	 				- several types of Advice - 
	 					@Before : executes before the advised method
	 					Main Logic Class - method()
	 					Aspect : @Before("method1()")
	 					@After : execute after all the advised method , no matter whatever is outcome
	 					@AfterRunning - Encloses the method , allow custom logic to be executed before
	 					@Around - Encloses the method , allow custom logic to be executed before
	 									and after the method call
			- Joint Point : 
					specific point in execution of a program - method execution, constructor called,
					field access.
			- Point Cut - advices -> @Before(method1())
						- an expression the defines  where an advice should be applied.
						- select specific join point
						- uses expressions to match method signatures
			- Weaving - 
					-Process of linking aspect to the business logic
					-effectively applying the advice at the specified joint points
			
			
		How Spring AOP works ?
		
		- AOP Utilizes a proxy based approach.
		- when a bean is advised by an aspect.
		- Spring creates a proxy object - wraps the orignial bean
		- All calls to the advised methods of original bean as now intercepted by this proxy object.
		- class sample s = method1()
		s.method1()  -> call the proxy -> after after, before
			
	 	
	 
	 */
}
