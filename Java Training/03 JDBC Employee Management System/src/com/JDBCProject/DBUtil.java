package com.JDBCProject;

//create connection of java with mysql
import java.sql.Connection; //represent a session with the database - ems_db
import java.sql.DriverManager; // manages jdbc drivers and connections
import java.sql.SQLException; // handle database relate errors



public class DBUtil {

	// JDBC - URL (url for ems_db), username - root, password -

	// static - class level
	// final - should not be modifiable
	private static final String URL = "jdbc:mysql://localhost:3306/ems_db";
	private static final String USER = "root";
	private static final String PASSWORD = "Genpact@123456789";

	// load mysql jdbc driver
	// create connection only once
	// when class is loaded first
	// static - load mysql JDBC driver into memory
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // tell java to look for driver class in .jar file -added
			System.out.println("MySQL Driver loaded successfully");
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to load MySQL driver : " + e.getMessage());
		}
	}

	// establish connection
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connecition established");
		} catch (SQLException e) {
			System.out.println("Connection failed : " + e.getMessage());
		}
		return connection;
	}

	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
				System.out.println("Database connection closed");
			} catch (SQLException e) {
				System.out.println("Error closing connection :" + e.getMessage());
			}
		}
	}
}
