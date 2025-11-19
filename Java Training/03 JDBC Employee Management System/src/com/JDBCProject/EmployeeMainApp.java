package com.JDBCProject;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class EmployeeMainApp {
	public static void main(String[] args) {
//		Connection conn = DBUtil.getConnection();
//		try {
//			if (conn != null) {
//				System.out.println("Connected to database : " + conn.getCatalog());
//			} else {
//				System.out.println("connection returned null.");
//			}
//		} catch (SQLException e) {
//			System.out.println("Connection failed : " + e.getMessage());
//
//		}

		// cerate an employee object - no id will be given

//		Employee emp1 = new Employee("Priya sharma", "priya@gmail.com", true, new BigDecimal(55000.00),
//				LocalDate.of(2025, 9, 10));

		// object of EmployeeDAO Class
		EmployeeDAO emp_dao = new EmployeeDAO();

		// emp_dao.addEmployee(emp1);

//		Employee up_emp = new Employee("Aryan gupta", "aryang@gmail.com", false, new BigDecimal("55000.00"),
//				LocalDate.of(2025, 8, 20));
//		up_emp.setId(3);
//		emp_dao.updateEmployee(up_emp);

//		emp_dao.deleteEmployee(3);

//		List<Employee> emp = emp_dao.getAllEmployees();
//		for (Employee e : emp) {
//			System.out.println(e);
//		}
		
		//fetch employee by id
//		System.out.println("enter employee id to fetch");
//		Scanner sc = new Scanner(System.in);
//		int id = sc.nextInt();
//		Employee empId = emp_dao.getEmployeeById(id);
//		if (empId != null) {
//			System.out.println("employee found : ");
//			System.out.println(empId);
//		} else {
//			System.out.println("wrong id");
//		}
//		sc.close();
		
		
		// Statement Interface
//		emp_dao.createTableDepartment();
		
//		emp_dao.adminTasks();
		
//		emp_dao.getSalarybyId(1);
//		emp_dao.getSalarybyId(8);
		
//		emp_dao.fetchEmployeesBySalaryRange(new BigDecimal("30000"), new BigDecimal("60000"));
		
//		emp_dao.fetchActiveEmployees();
		
//		emp_dao.fetchEmployeeDepartmentJoin();
		
		int empid = 1;
		String imgPath = "C:\\Users\\703440072\\Desktop\\Java Training\\Employee Management System\\img\\img1.jpg";
		LocalDateTime lastLogin = LocalDateTime.now();
		
//		emp_dao.updateProfilePicAndLastLogin(empid, imgPath, lastLogin);
		
		
		emp_dao.fetchProfilePic(empid, "C:\\Users\\703440072\\Desktop\\Java Training\\Employee Management System\\img\\img2.jpg");
		
//		sc.close();
		
		
	}
}
