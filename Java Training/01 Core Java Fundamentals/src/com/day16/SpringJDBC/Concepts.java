package com.day16.SpringJDBC;

public class Concepts {

	/*
	 	
	  JDBC template - core helper class in spring jdbc
	  	simplifies using raw jdbc
	  	wraps the low level jdbc boilerplate (connection handling, statement creation, parameter binding)
	  	exception handling
	  	Idea - do not have to manage connection , preparedStatement, resultset
	  	
	  Advs:
	  	less code
	  	Thread safe - a single instance can be reused across thread
	  	convinient codes
	  	
	  Spring Arch Part :
	  	Data Source : JDBCTemplate needs some data source
	  					spring configures data source -> inject it into JDBCTemplate
	  					application file ->
	  	Transaction Manager :
	  		Higher level
	  		connection used, close connection -------------
	  	Exception handling - SQL Errors, SQLException
	  	
	  JDBC Template :
	  	useful built in callback
	  	
	  	1. RowMapper <T> :- map a single row from resultset to domain object
	  						used with query()
	  						for each row call -> mapRow(rs, rownum) -> return object
	  	2. ResultSetExtractor <T> :- get entire result - > grouping
	  	3. PreparedStatementCreator : SQL , Parameters
	  	4. PreparedStatementSetter : set parameters
	  	
	  	
	  query()-
	  queryForObject() - expecting one row
	  update()
	  queryForList() -> list of maps
	  execute()
	  
	  Project :  Inventory management project
	  				maven, mysql -> spring jdbc , mysql-connector
	  				
	  Problem - 
	  
	 
	 */
}
