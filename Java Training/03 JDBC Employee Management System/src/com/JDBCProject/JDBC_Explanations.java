package com.JDBCProject;

public class JDBC_Explanations {
	//JDBC :
		//Java Database Connectivity
		//Java API - lets Java apps interact with relational DBs
		//JDBC Drivers
		//pre defined interfaces and classes :
		//	connect to database
		//	send SQL statements
		//	retrieve results
		//	handles transaction

	//Java Code - talks to JDBC API - driver - implement that API for DB.
	//Server side , desktop apps , microservices - interaction with DB
	//Standarized - API across all apps

	//High level architecture -
	//	JDBC API(interface : connection, statement, preparedstatement, callable statement, resultSet, etc.)
	//JDBC Driver  Manager / Data Source - locate and connect drivers
	//JDBC Driver - implementation - using JAR file, translate JDBC calls

	// Eclipse - java project - 
	//we need to add JAR file
	//-MySQL

	//Employee mgmt. system :

	//add new emps
	//view all emps / search emps by email
	//update emp info
	//delete emps - leave organization
	//generating reports 
	//special data types - Boolean , date (hire_date), blob


	
	// Statement , PreparedStatement
	
	//CRUD Operations - send SQL commands to the database
	//Statement , PreparedStatement , Callable statement
	
	//statement - is an interface used to execute the static SQL queries
	//static - query is fixed and does not accept parameters
	//executeQuery(sql) - method return resultSet - select
	//executeUpdate(sql) - method used to insert, update, delete
	//simple onetime queries 
	
	//PreparedStatement - ? ? ? ?
	//used to dynamic or parameterized queries
	//query can accept parameters
	//input values from user
	//sql query - pre-compiled once - can be used multiple times
	//repeated execution
	
	//CRUD Application
	//1. Model class - Employee - creating object - represent table record
	//2. every model class DAO class - add(), update(),delete(), getAll()
	//		- Prepared Statement
	// 		- Dynamic Queries
	//3. MainApp
	
	// ResultSet -> storing data returned from the database
	
		// Statement
		// - Run static SQL queries
		// that do not include user input
		// - DDL (create table) , select * from employee;
		// - admin queries -> 
		// - create department table
		
		
		// CallableStatement Interface
		// - MySql - Stored Procedures -> (function)
		// - used for stored procedures
		// - used to call stored procedures that are created and stored inside db - mysql
		
		// Stored Procedure
		// function - set of statements
		// fetch emp salary by id
		// sql query -> 
		// create a stored procedure SP for this - function (Java)
		// fetch emp salary by id - call SP (3)  
		
		
		// Select -> executed query -> all emps -> ResultSet
		// keeps the connection open while reading data
		
		// RowSet 
		// updated version of the ResultSet
		// javax.sql -> package -> extension of java.sql package
		
		// JdbcRowSet -> wrapper around ResultSet - connected RowSet - keeps the connection open while reading
		
		// CachedRowSet -> disconnected rowset 
		//              -> select all employees
		//              -> update some changes - can be done offline
		//              -> can be modified offline - changes updates
		//              -> disconnects the connected
		//              -> later we can synchronize with db	
		
		// FilteredRowSet -> CachedRowSet with filtering capability 
		//                -> based on condition - subset of rows
		
		// JoinRowSet -> used to join two or more RowSets in memory w/o using SQL join
		//            -> employee, dept
		//            -> join the results from employee rowset and dept rowset
		
		// WebRowSet -> XML based rowset - can read/write XML format for data interchange
		
		// Why ?
		// To work offline with data 
		// update data in memory
		// sync back later 
		// filter join
		// web service -> send data over network
		// scrollable -> forward / backward easily
		
		// ResultSetMetaData - get meta data about the columns
		// db reports - tool, db inspection utility
		// -> an interface
		// Metadata - data about data
		// - cols count
		// - names of cols
		// - types of cols
		
		// Fetch Db Metadata
		// database level details
		// Interface - DatabaseMetaData
		// - db version, db name
		// - list of tables
		// - stored procedure, primary keys
		// - report generation, documentation,
		
		
		// Project 
		
		// creating tables to inserting data to updations to deletions
		// - all these shoudl be done via JDBC API
		
		// emp 
		// dept
		// dept head - are emps
		// movie_name 
		
		// Interoperability between JDBC and MySQL data types
	    // -> When Java communicating with MySql through JDBC
	    // -> both systems - use different data representaions
	    // -> Java - java.lang, java.sql
	    // -> int, float, double, String
	    // -> MYSQL : INT, VARCHAR, DATE, DECIMAL
	   // -> JDBC -> provides a mapping layer - ensures type compatbility
	   // -> ensure data consistency
	   // -> prevent type mismatch errors - insert, select, updated
	   // -> preparedStatement , resultSet -> setInt, getInt
		// -> MYSQL Type           Equivalent Java Type       setXXX, getXXX()
	    // -> INT, INTEGER         int - java.lang            setInt, getInt
	    // -> BIGINT               long - long int            setLong, getLong
	   // ->  SMALLINT,            short, byte                setShort, getShort
	   //     TINYINT
	   //     REAL,                float
	   //     FLOAT
	   //     DECIMAL              double
	   //   CHAR, vARCHAR          String
	   //    TIME                  java.sql.Time
	   // DATETIME,
	   // TIMESTAMP                 java.sql.Timestamp
	   // BLOB                      java.sql.Blob
	   // BOOLEAN                   boolean
		 
		
		// employee - profile_pic = NULL -> longblob -> stored in binary 
	    // last_login - timestamp = NULL -> DATe and Time both
		
		//  3 | Anjali Gupta -> update this record , add profile_pic , last_login

	    // last login -> simply add using timestamp -> just like we added hire_date

	    // profile_pic -> binary object
	    
	    // files concept

	    // some image - image path 

	    // add image 
	    // create a file object in java - give image path
	    // File - predefined class in Java  - work with binary data
	    // input -> FileInputStream -> create a file object with image path as input 

	    // Anjali Record - profile_pic is added;
	    // select anjali record
	    
	    // retrieve image
	   //  FileOutputStream - get the image from the SQL table and we store it in some path
	   
}