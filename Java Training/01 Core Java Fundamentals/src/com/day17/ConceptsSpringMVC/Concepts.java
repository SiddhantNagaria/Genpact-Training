package com.day17.ConceptsSpringMVC;

public class Concepts {

	
	/*
	 Spring Boot - 
	  built on the top of Spring ecosystem
	  reduces the amount of configuration and boilerplate
	  needed to built the spring application
	  
	It provides:
		Auto Configuration -
			inspect the classpath and application properties - automatically configure
					many spring components
		
		Starter dependencies -
			convenient dependency bundles - spring-boot-starter-web, spring-boot-starter-jpa
		
		Embedded Servers - 
			run web apps with embedded servers - tomcat server - localhost : 8080
			
		Production ready features -
			external configuration , logging, runtime management, metrics
		
	Advs :
		1. faster time - working app
			minimal setup - main class, bundled dependencies - run an app
		2. auto configuration
		3. easier dependency management
		4. microservices apps, cloud apps can be easily created
		
	
	Annotations :
		@SpringBootApplication -
				single annotation combines - : @Configuration (declares bean)
											   @EnableAutoCOnfiguration (turns on auto-configuration)
											   @ComponentScan (scan the components in package)
				
				one main class - annotated with @SpringBootApplication
				
		Starter dependency -> spring-boot-starter-web -> Spring MVC + embedded Tomcat
						   -> spring-boot-starter-jpa -> spring data jpa
		
		Configuration - application.properties or application.yml
					  - data source , port no : specify
		
		Spring MVC -
			Spring - model view controller - web app with Tomcat server
			
				- employee, user - one layer - model layer
				- view layer - view pages - html pages
				- controller layer - package controller - define 3 html - index, about, contact
				- www.example.com/index - page index should be displayed
									/about - page about should be displayed
									/contact - page contact should be displayed
				@Controller
				
				@RestController
			
		Tomcat Server -> open source Java application server - Apache Software Foundation
					- deploy and run Java based applications
		
		Browser(Client) -> Http request - > server -> process the request - send back html response to client
	  
	  
	  
	 
	 */
}
