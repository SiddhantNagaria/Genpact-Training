package com.day5.Relations_And_FP.Association;

import java.util.ArrayList;
import java.util.List;

public class Course {

	private String code;
	private String c_name;
	private List<Student> students = new ArrayList<>();

	public Course(String code, String c_name) {
		super();
		this.code = code;
		this.c_name = c_name;
	}

	// addStudent
	public void addStudent(Student s) {
		if (!students.contains(s)) {
			students.add(s);
		}
	}

	// print students
	public void printStudents() {
		System.out.println(c_name + " has students : ");
		if (students.isEmpty()) {
			System.out.println("None");
			return;
		}
		for (Student s : students) {
			System.out.print(s.getName() + " ");
		}
		System.out.println();
	}
	
	//get Course Name
		public String getName() {
			return c_name;
		}
}
