package com.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


//	replace XML with configuration file
//tell Spring to scan package for all annotations - @Service , @Repository , @Autowired , ...............

//@Configuration
//@ComponentScan(basePackages = "com.annotations")
//public class AppConfig {

	//
	
//}

@Configuration
public class AppConfig{
	
	//define beans manually
	//called as Java based configuration
	
	@Bean
	public BookRepository bookRepository() {
		return new BookRepository();
	}
	
	@Bean
	public BookService bookService() {
		return new BookService();
	}
}



