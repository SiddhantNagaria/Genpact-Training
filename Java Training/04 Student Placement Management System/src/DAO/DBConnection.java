package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/placement_db";
	private static final String USER = "root"; // change as needed
	private static final String PASS = "Genpact@123456789"; // change as needed

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // load MySQL driver
			System.out.println("MySQL Driver loaded successfully");
		} catch (ClassNotFoundException e) {
			System.err.println("MySQL Driver not found.");
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("Connecition established");
		} catch (SQLException e) {
			System.out.println("Connection failed : " + e.getMessage());
		}
		return connection;
	}
}
