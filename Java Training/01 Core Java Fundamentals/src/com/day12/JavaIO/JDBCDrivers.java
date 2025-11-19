package com.day12.JavaIO;

public class JDBCDrivers {
	
	// JDBC defines four types of drivers
	// - based on how they communicate with the database
	
	// Type 1
	// -> Driver Name -> JDBC-ODBC Bridge Driver
	// -> Convert JDBC calls into ODBC calls
	// -> Requires ODBC driver installation
	// -> Obsolete now
    // ODBC -> Open Database Connectivity
	// -> Microsoft standard API - accessing relational dbs
	// - platform specific/dependent
	
	// Type 2
	// - Native-API Driver 
	// - platform specific
	// - uses native client libraries 
	// - Oracle - OCI to communicate
	// - convert JDBC calls into native API calls of db client
	// Java App -> JDBC API -> TYpe 2 driver (Java + Native Code) -> Db's native client library (like Oracle OCI) -> Db
	// Oracle db -> type 2 -> oracle.jdbc.driver.OracleDriver 
	// -> OCI -> Oracle Call Interface	
	
	// Type 3	
	// - Network Protocol Driver
	// -> actas a middle layer n/w driver b/w Java app and db
	// -> instead of directly connecting to db, communicate witha middleware(app server)
	// -> actually handles the actual db connection
	// Java App -> JDBC API ->type 3 Driver -> Middele Server(transalte call to db protocol) -> db
	// web app java -. connect to db in a diff n/w
	// -> clients -> instead of direct access -> use typw 3 driver
	// -> send db req to middleware server -> WebLogic, IBM Webshpere -> 
	// -> platform independent
	
	// Type 4
	// - pure java driver - Thin driver
	// - most widely used driver
	// - 100% java based driver
	// - jdbc call into db protocol - no need native libraries, miidleware
	// - Thin -> elimiates all extra transaltion layers - no ODBC, No native API, no middleaware
	// Java App -> JDBC API -> TYpe 4 Driver -> Db
	// - com.mysql.cj.jbcd.Driver -> type 4
	// - direct db connection, easy deployemnt, high performance, support all dbs
	// - MySQL, PostGreSQL, SQL Server, Oracle, DB2......
	// - each db needs its own jar file
	// - mysql - jr file is not going to work with oracle

}
