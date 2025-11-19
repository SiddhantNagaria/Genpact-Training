package com.firstspringproject.hello_world;

public class Concepts {
	
	/* pom.xml 
	 * Project Object Model
	 * - core configuration file of any maven project
	 * - tells Maven what your project is, what dependency it needs, how it should be built
	 * 
	 * POJO class HelloWorld
	 * -> Let the Spring IoC container create and manage this object of this class
	 * -> make use of configuration file
	 * -> config.xml 
	 * -> with the help of beans in config file
	 * -> src/main/resources
	 * -> default path where the config file is looked for
	 * 
	 * Bean
	 * -> refer to an object that is instantiated, configured and managed by spring ToC
	 * 
	 * setter injection
	 * constructor injection
	 * 
	 * constructor injection - with multiple arguments
	 * use inner bean (inject another object as a constructor parameter)
	 * HelloWorld - message
	 * modify this - two parameters - message 
	 *             - address - object type - belongs to Address class (another POJO class)
	 * 
	 * Inject Collections
	 * - POJO - List, Set, Map
	 */

}
