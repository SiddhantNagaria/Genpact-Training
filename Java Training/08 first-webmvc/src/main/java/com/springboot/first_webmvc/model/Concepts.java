package com.springboot.first_webmvc.model;

public class Concepts {

	/*
	 	Spring MVC - Form tag library
	 		build dynamic , data bound html forms in web applications
	 		bind html form fields to Java model objects (POJOs) very easily
	 		reduce boilerplate code
	 		handle validation and error messages
	 		spring take care of reading / writing the values (form) automatically
	 		
	 	JSP -> Java Server Pages
	 		- server side technology - used to create dynamic web pages using java
	 	 	- allows you to mix - HTML code and Java code
	 	 	-					: page layout and design
	 	 	-					: Java Code - for dynamic content - display data from db, from submission
	 	 	- enhanced HTML page with Java Capability
	 	 	- JSP page - what happens when JSP runs on server
	 	 	-		   - its compiled into a servlet (a java class)
	 	 				- the java code executes on server
	 	 				- output - pure HTML - is sent back to browser
	  
	  
	  	JSP pages in path -> src/main/resources/META-INF/resources/WEB-INF/jsp/ ...... not directly accessible in  your browser
	  	
	  	Web Service :
	  	
	  		- s/w component that allows two applications which can be running on different platform 
	  		- use differnet languages
	  		- communicate each other over a network
	  		
	  		
	  		- web service exposes a set of operations (APIs)
	  		- that other applications can call using standard protocol
	  		- http and data format - JSON data format
	  		
	  		
	  		- banking app - show live currency exchange rate
	  		= maintain your own exchange rate - setup
	  		- instead of consume a web service - provided by another system
	  		- another system - maintain exchange rates
	  		- get that information via HTTP request
	  		
	  		
	  		- widely used in distributed systems and microservices
	  		ecommerce - payment service , order service , customer service , delivery service
	  		
	  		
	  		Monolithic architecture - entire application in one single application
	  		
	  		Micro-services Architecture : entire application is created as microservices , not as one application
	  		
	  		E-commerce -> payment service - one sb project, order service, another , customer service , delivery service
	  		
	  		project -> creating rest APIs
	  		
	  		Types of web service 0
	  		
	  			1. SOAP Web service -	simple object access protocol
	  								-	Data Format - XML
	  								-	Protocol - SOAP Protocol
	  			
	  			2. REST Web Service : Representational state transfer
	  								- Data format - JSON, XML, YAML
	  								- Protocol : HTTP
	  								
	  				- lightweight, architectural style for designing network applications, fast, scalable
	  				REST -> allows communication over HTTP
	  				
	  				Rest Web Services -> exposes resources (like users, orders, products etc)
	  									- that can be accessess and manipulates using standard HTTP methods
	  				
	  				Resource : everything is treated as a resource
	  				URI : each resource is identified by a URI
	  				HTTP methods - perform actions on resources
	  				Stateless	:	each request is independent - that server does not store client's state
	  				
	  				HTTP methods : 
	  					GET : retreive a resource -> GET - http://localhost:8080/users	-> All users
	  					
	  					POST : create a new resource - > POST http://localhost:8080/users
	  					
	  					PUT : update resource - PUT http://localhost:8080/users/101
	  					
	  					DELETE : delete resources - DELETE http://localhost:8080/users/101
	  					
	  					
	  					@RestController :
	  					
	  					HTTP status codes :
	  					
	  					200 OK -> request successful
	  					201 Created -> resource created - POST new record
	  					204 No content - dleeted or updated successfully
	  					
	  					400 bad request - invalid input -> missing some required fields - http://localhost:8080/users
	  					
	  					404 Not Found - resources not found
	  					
	  					500 interval server error -> server side failure -> db error
	  					
	  					
	  				Flow Diagram -> 
	  					Client(Postman / Browser/ Mobile) :
	  						-> HTTP request (get, ....)
	  					
	  					Spring Boot rest controller 
	  						-service layer (business logic)
	  						
	  					Repository Layer (JDBC)
	  						- Fetch data from DB
	  						
	  					Controller return JSO response
	  						- http response 200 OK
	  						
	  					Client receives data
	  					
	  	
	  	Hotel Management Project
	  		model
	  		service
	  		controller - REST endpoints
	  		exception handling
	  		repository layer
	  		Utils
	  		DTO
	  		
	  		SPRINGBOOT  Project -> web , jdbc, mysql Connector , validation, dev tools
	  		
	  	
	  	
	 */
}
