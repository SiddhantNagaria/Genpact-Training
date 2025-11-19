package com.JDBCProject;

import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSetMetaData;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetProvider;

import java.sql.CallableStatement;

public class EmployeeDAO {

	// DAO - Data Access Object
	// CRUD operations
	// Employee - record representation
	// addEMp - query - insert, delete , ......
	// Here in DAO class,
	// define various methods to carry out CRUD operations
	// DAO class encapsulates all JDBC interaction for the employee table

	// Statement, PreparedStatement

	// add Employee
	public void addEmployee(Employee emp) {
		String sql = "INSERT INTO employee(name, email, is_active, salary, hire_date) values (?, ?, ?, ?, ?)";

		try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, emp.getName());
			ps.setString(2, emp.getEmail());
			ps.setBoolean(3, emp.isIs_Active());
			ps.setBigDecimal(4, emp.getSalary());
			ps.setDate(5, Date.valueOf(emp.getHireDate()));

			// executionUpdate() = insertion
			int rows = ps.executeUpdate(); // return how many rows affexted , ResultSet also
			if (rows > 0) {
				System.out.println("EMployee insertion successful");
			} else {
				System.out.println("Insertion failed");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void updateEmployee(Employee emp) {
		String sql_u = "UPDATE employee set name=?, email=?, is_active=?, salary=?, hire_date=? where id =?";

		try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql_u)) {

			ps.setString(1, emp.getName());
			ps.setString(2, emp.getEmail());
			ps.setBoolean(3, emp.isIs_Active());
			ps.setBigDecimal(4, emp.getSalary());
			ps.setDate(5, Date.valueOf(emp.getHireDate()));
			ps.setInt(6, emp.getId());

			// executionUpdate() = insertion
			int rows = ps.executeUpdate(); // return how many rows affexted , ResultSet also
			if (rows > 0) {
				System.out.println("Employee updation successful");
			} else {
				System.out.println("Insertion failed");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	// delete EMployee
	public void deleteEmployee(int id) {
		String sql_d = "delete from employee where id = ?";

		try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql_d)) {

			ps.setInt(1, id);

			int rows = ps.executeUpdate(); // return how many rows affexted , ResultSet also
			if (rows > 0) {
				System.out.println("Employee deletion successful");
			} else {
				System.out.println("Deletion failed");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	// show all employess - select *
	public List<Employee> getAllEmployees() {
		List<Employee> list = new ArrayList<>();
		String sql_s = "select * from Employee";
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql_s);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Employee emp = new Employee(rs.getString("name"), rs.getString("email"), rs.getBoolean("is_active"),
						rs.getBigDecimal("salary"),
						rs.getDate("hire_date") != null ? rs.getDate("hire_date").toLocalDate() : null);
				emp.setId(rs.getInt("id"));
				list.add(emp);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	// get EMployee by ID
	public Employee getEmployeeById(int id) {
		String sql_id = "select * from Employee where id = ?";
		Employee emp = null;
		try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql_id);) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				emp = new Employee(rs.getString("name"), rs.getString("email"), rs.getBoolean("is_active"),
						rs.getBigDecimal("salary"),
						rs.getDate("hire_date") != null ? rs.getDate("hire_date").toLocalDate() : null);
				emp.setId(rs.getInt("id"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return emp;
	}

	// Statement Interface
	// execute DDL - create statement
	public void createTableDepartment() {
		String sql_create = "create table if not exists Department (\n" + "dept_id int auto_increment primary key, \n"
				+ "dept_name varchar(30) not null, \n" + "dept_head varchar(30) not null \n" + ")";

		try (Connection conn = DBUtil.getConnection(); Statement stmt = conn.createStatement()) {
			stmt.execute(sql_create);
			System.out.println("create statement executed");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	// admin - maintenance DB Tasks
	// MYSQL - ANALYZE table employee
	// - optimize table employee

	public void adminTasks() {
		String sql1 = "ANALYZE table employee";
		String sql2 = "Optimize table employee";
		try (Connection conn = DBUtil.getConnection(); Statement stmt = conn.createStatement()) {
			stmt.execute(sql1);
			stmt.execute(sql2);
			System.out.println("admin maintenance tasks completed");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	// callableStatement -> call get_salary_by_id

	public BigDecimal getSalarybyId(int empId) {
		String sql_sp = "{call get_salary_by_id(?,?)}"; // IN,OUT
		BigDecimal salary = null;
		try (Connection conn = DBUtil.getConnection(); CallableStatement cs = conn.prepareCall(sql_sp)) {
			// SET IN parameter
			cs.setInt(1, empId);
			// register out parameter
			cs.registerOutParameter(2, java.sql.Types.DECIMAL);
			cs.execute();
			salary = cs.getBigDecimal(2);
			if (salary != null) {
				System.out.println("Employee id : " + empId + "has salary : " + salary);
			} else {
				System.out.println("No record founffor id : " + empId);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return salary;
	}

	// RowSet
	// CachedRowSet

	public void fetchEmployeesBySalaryRange(BigDecimal minSalary, BigDecimal maxSalary) {
		String sql_crs = "select id, name, email, salary, hire_Date fom employee where salary between ? and ?";
		try (Connection conn = DBUtil.getConnection();
				CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet()) {

			// set sql commands and parameters
			crs.setCommand(sql_crs);
			crs.setBigDecimal(1, minSalary);
			crs.setBigDecimal(2, maxSalary);

			// execute query
			// rowset connect, fetch data and then disconnect
			crs.execute();

			System.out.println("employees with salary between " + minSalary + " and " + maxSalary);

			// Iterate over the results in cachedrowset
			while (crs.next()) {
				int id = crs.getInt("id");
				String name = crs.getString("name");
				String email = crs.getString("email");
				BigDecimal salary = crs.getBigDecimal("salary");
				Date hire_date = crs.getDate("hire_date");
				System.out.println(id + " | " + name + " | " + email + " | " + salary + " | " + hire_date);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	// FilteredRowSet - can apply a filter (logical condition)

	public void fetchActiveEmployees() {
		String sql_frs = "select id, name, email, salary, is_active from employee";
		try (Connection conn = DBUtil.getConnection();
				FilteredRowSet frs = RowSetProvider.newFactory().createFilteredRowSet()) {

			// set sql commands and parameters
			frs.setUrl("jdbc:mysql://localhost:3306/ems_db");
			frs.setUsername("root");
			frs.setPassword("Genpact@123456789");

			// set sql command
			frs.setCommand(sql_frs);

			// execute command
			frs.execute();

			ActiveEmployeesFilter filter = new ActiveEmployeesFilter();
			frs.setFilter(filter);
			System.out.println("Active employees : ");
			// Iterate over the results in cachedrowset
			while (frs.next()) {
				int id = frs.getInt("id");
				String name = frs.getString("name");
				String email = frs.getString("email");
				boolean isActive = frs.getBoolean("is_active");
				System.out.println(id + " | " + name + " | " + email + " | " + isActive);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	// JoinRowSet

	// employee and department
	// employee -> dept_id added

	// sql1 = select id, name, email, dept_if from employee
	// sql2 =select dept_id, dept_name, dept_head from department

	// CachedRowSet -> sql1
	// CachedRowSet -> sql2

	// JoinRowSet
	// jrs.addRowSet(emp_rs, "dept_id")
	// jrs.addRowSet(dept_rs, "dept_id")

	// step 1
	// insert rows in department
	// create 4 departments - HR, IT, Finance, Sales

	// Step2 :
	// modify employee table - include column dept_id
	// add foreign constraint - > refer to dept_id of dept_table

	// Step 3 :
	// update rows of employee table - add dept_id for each row

	// class - department model class

	// database - tables - model class

	public void fetchEmployeeDepartmentJoin() {
		try {
			CachedRowSet empRS = RowSetProvider.newFactory().createCachedRowSet();
			CachedRowSet deptRS = RowSetProvider.newFactory().createCachedRowSet();

			// set connection
			empRS.setUrl("jdbc:mysql://localhost:3306/ems_db");
			empRS.setUsername("root");
			empRS.setPassword("Genpact@123456789");

			deptRS.setUrl("jdbc:mysql://localhost:3306/ems_db");
			deptRS.setUsername("root");
			deptRS.setPassword("Genpact@123456789");

			// set sql queries
			empRS.setCommand("select id, name, email, dept_id from employee ORDER BY id ASC");
			deptRS.setCommand("select dept_id, dept_name, dept_head from department");

			// execute these rowsets
			empRS.execute();
			deptRS.execute();

			// create join rowset
			JoinRowSet joinRS = RowSetProvider.newFactory().createJoinRowSet();

			// add both rowsets with common column to join rowset
			joinRS.addRowSet(empRS, "dept_id");
			joinRS.addRowSet(deptRS, "dept_id");

			System.out.println("employee department join : ");

			while (joinRS.next()) {
				int id = joinRS.getInt("id");
				String name = joinRS.getString("name");
				String email = joinRS.getString("email");
				int dept_id = joinRS.getInt("dept_id");
				String dept_name = joinRS.getString("dept_name");
				String dept_head = joinRS.getString("dept_head");

				System.out.println(
						id + " | " + name + " | " + email + " | " + dept_id + " | " + dept_name + " | " + dept_head);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void showEMployeeTableMetaData() {
		String sql_md = "select * from employee";
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql_md);
				ResultSet rs = ps.executeQuery()) {
			// Get metadata object
			ResultSetMetaData rsmd = rs.getMetaData();

			int colCount = rsmd.getColumnCount();
			System.out.println("Total columns :" + colCount);

			for (int i = 1; i <= colCount; i++) {
				System.out.println("Col " + i + " ");
				System.out.println("Name " + rsmd.getColumnName(i));
				System.out.println("Type " + rsmd.getColumnTypeName(i));
				System.out.println("Size" + rsmd.getColumnDisplaySize(i));
				System.out.println("Table " + rsmd.getTableName(i));
				System.out.println("Mullable " + rsmd.isNullable(i));
				System.out.println("Auto Increment " + rsmd.isAutoIncrement(i));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void showDataBaseMetaData() {
		try (Connection conn = DBUtil.getConnection()) {

			DatabaseMetaData dbmd = conn.getMetaData();

			System.out.println("Database Metadata : ");
			System.out.println("Database Product : " + dbmd.getDatabaseProductName());
			System.out.println("Database Product version : " + dbmd.getDatabaseProductVersion());
			System.out.println("Database driver name : " + dbmd.getDriverName());
			System.out.println("Database driver version : " + dbmd.getDriverVersion());
			System.out.println("Database UserName : " + dbmd.getUserName());

			// List all tables on db
			ResultSet tables = dbmd.getTables(null, null, null, null);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	// two methods

	// update profile pic and last login - id=1
	public void updateProfilePicAndLastLogin(int empid, String imagePath, LocalDateTime loginTIme) {
		String sql = "update employee set profile_pic =?, last_login=? where id=?";
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				FileInputStream fis = new FileInputStream(new File(imagePath))) {

			// set the blob data - profile pic
			ps.setBinaryStream(1, fis, (int) new File(imagePath).length());

			// set timeStamp - lastLogin
			ps.setTimestamp(2, Timestamp.valueOf(loginTIme));

			// set emp id,
			ps.setInt(3, empid);

			int rows = ps.executeUpdate();

			if (rows > 0) {
				System.out.println("Employee with id : " + empid + " updated sucessfully");
			} else {
				System.out.println("update for employee id : " + empid + " failed");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	// get the data
	public void fetchProfilePic(int empid, String outputPath) {
		String sql = "select profile_pic from employee where id=?";
		try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, empid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				//read binary stream from profile pic column
				InputStream is = rs.getBinaryStream("profile_pic");
				//check case if profilepic is null
				if (is == null) { // is==null -> when for a id, there is no profile pic
					System.out.println("no profile picture found for id : " + empid);
					return;
				}

				//store that in some path using fileoutputstream
				FileOutputStream fos = new FileOutputStream(outputPath);
				
				//read the image and store in output path
				// in chunks
				// buffer -> temp storage area i computer memory used to hold data
				// image - many bytes
				// take some bytes and store in buffer
				//write those bytes using FOS
				//read next data
				
				byte[] buffer = new byte[1024]; //byte array buffer - size 1024 bytes
				
				int bytesRead; //store how many bytes were read into buffer
				
				//reading from input stream into buffer
				while ((bytesRead = is.read(buffer)) != -1) {
					//keep on reading from input stream till -1 is not returned
					fos.write(buffer, 0, bytesRead);
				}
				is.close();
				fos.close();
				System.out.println("profile pic retreived and saved at path : " + outputPath);
			} else {
				System.out.println("Employee with id : " + "not found");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
