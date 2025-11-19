package com.JDBCProject;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Employee {
	// corresponding to EMployee table in ems_db
	// serves as model class

	// CRUD operations - Create Read Update Delete
	// Read Update delete
	// with java application
	// insert some row in employee
	// - insertig that with Java Application
	// Class - store the records in mysql table
	// no need of providing id
	// simple pojo class - plain old java object - represents an employee record

	private int id;
	private String name;
	private String email;
	private boolean is_Active;
	private BigDecimal salary;
	private LocalDate hireDate;
	private LocalDateTime lastlogin;

	public Employee(String name, String email, boolean is_Active, BigDecimal salary, LocalDate hireDate) {
		this.name = name;
		this.email = email;
		this.is_Active = is_Active;
		this.salary = salary;
		this.hireDate = hireDate;
	}

	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isIs_Active() {
		return is_Active;
	}

	public void setIs_Active(boolean is_Active) {
		this.is_Active = is_Active;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	public LocalDateTime getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(LocalDateTime lastlogin) {
		this.lastlogin = lastlogin;
	}

	// toString
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", is_Active=" + is_Active + ", salary="
				+ salary + ", hireDate=" + hireDate + ", lastlogin=" + lastlogin + "]";
	}

}
