package com.day13.SpringFramework;

public class Spring {

	//Spring
	
	/*
	 
	 	popular and powerful - java application
	 	secure , scalable enterprise level application
	 	provides with a infrastructure - make you of this infrastructure
	 	
	 	GOAL -
	 		let developers focus on business logic 
	 		low level details - object creation (new), security , transactions managed
	 		
	 	Characteristics :
	 	1. lightweight framework
	 			Spring core features - can be done w/o loading the entire framework
	 			modular - you can use only the parts you need
	 			core module
	 			integrating spring with mysql - spring JDBC module
	 			web based apps - Spring MVC module
	 			JARs are small
	 	
	 	2. IoC and DI:
	 		IOC - inversion of control
	 			before IoC -> classes - new keyword = object
	 				tight coupling - high dependency
	 			
	 			IoC - control is shifted to IoC
	 			Framework takes responsibility of object creation , configuration and lifecycle
	 			control "inversion" is achieved through IoC container and DI dependency Injection
	 			IoC container
	 			Core module is the implementation of spring using IoC container - objects (callls as beans)
	 			instantiation to destruction
	 			DI - IoC associated with DI
	 				purpose is to inject the dependencies
	 				Instead of objects looking for dependencies -> let framework handle
	 				DI - inject dependency - other object to be injected to class
	 				IOC DI - loose coupling
	 	
	 	3. Configuration : 
	 		spring IoC container makes use of configuration file
	 		manage beans and dependencies
	 		XML File 
	 		Java based configuration, annotation based
	 		
	 	4. Integration with other framework
	 		JPA , JUnit
	 		boilerplate code can be reduced
	 		
	 		
	 	Core Container :-
	 		Foundation layer
	 		Basic functionality
	 		DI & Bean management
	 		
	 		1. Core
	 			Lifecycle of beans
	 		
	 		2. Beans
	 		
	 		3.	Context
	 			build on based on bean module
	 			provide access to object
	 		
	 		4. sPEL -
	 			Spring expression language
	 	
	 	AOP - 
	 		Aspect Oriented Programming
	 		
	 	
	 	5. Enterprise Application -
	 		security, transaction management, web services , data access
	 		
	 	
	 	BEAN AUTO-WIRING :-
	 	
	 		spring automatically inject dependencies
	 		not defining explicitly 
	 		<property> ,(setter) , <constructor-args>, (constructor) - explicitly
	 		automatic matching rules
	 		rules - matches - by type
	 						- by name
	 						- constructor argument
	 	
	 	
	 	AC - Application Context
	 		- spring automatically resolve and inject dependencies b/w bean within spring container
	 		   automatically detect and inject the required beans based on certain rules
	 		- XML
	 		- Annotation
	 		- ByType - spring search AC for a bean that matched the type of the property
	 		- ByName - spring find a bean with same name as property
	 		- Constructor - march constructor args with Beans by Type
	 		- Setter - setter methods called after object is created
	 	
	 	XML - autowiring , byType , constructor
	 	
	 	
	 	Annotation based configuration :
	 		instead of writing bean definition in XML file
	 		use Java annotation directly inside source code
	 		@Component - example of annotation
	 			- predefined
	 			- specific purpose
	 			- directly inserted in Java files
	 			- depending on which annotation we use:
	 				spring - which classes are beans
	 				how to inject them
	 				how to configure the application context
	 				shifting from XML to annotations now
	 				Advs : 
	 					Less XML configuration
	 					near to code - more easier to maintain
	 					readable
	 					
	 					
	 		Bean Declaration Annotation : 
	 		
	 		1. @Component -
	 			mark a class as a spring managed bean
	 		
	 		2. @Service -
	 			specialized type of @Component - Service Layer
	 		
	 		3. @Repository -
	 			specialized type of @Component from DAO layer (interacts with db)
	 		
	 		4. @Controller -
	 			specialized type of @Component for web controllers
	 		
	 		5. @RestController -
	 			speclialized type of @Component for REST APIs
	 		
	 	Dependency INject Annotations :-
	 		
	 		1.@Autowired : 
	 			inject dependency automatically byType
	 			
	 		2. @Qualifier:
	 			used along with @autowired
	 			when multiple beans of same type exist
	 			select one by name
	 			name we wil specify in qualifier
	 		
	 	Configuration & Scanning :
	 		@Configuration :
	 			Mark a class as a source of bean definition (replaces XML)
	 		@Bean :
	 			define a bean method inside a configuration class
	 			along with @Configuration
	 		@ComponentScan:
	 			tells spring which packages to scan for annotated components
	 			give package name
	 	
	 		
	 	
	 	SPRING CORE
	 	SPRING JDBC
	 	SPRING WEB MVC
	 		
	 
	 */
}
