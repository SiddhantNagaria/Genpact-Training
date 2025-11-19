package com.day5.Relations_And_FP.Association;

import java.util.ArrayList;
import java.util.List;

public class Student {

	private String id;
	private String name;
	private List<Course> courses = new ArrayList<>();

	public Student(String id, String name) {
		this.id = id;
		this.name = name;
	}

	// method enroll
	public void enroll(Course c) { // methods (int a
		if (!courses.contains(c)) {
			courses.add(c); // added new course to the course list
			c.addStudent(this); // addstudent in that c course, bidirectional raltionship
		}
		System.out.println();
	}

	// printCourses()
	public void printCourses() {
		System.out.println("Enrolled in : ");
		if (courses.isEmpty()) {
			System.out.println("None");
			return;
		}
		for (Course c : courses) {
			System.out.print(c.getName() + " ");
		}
		System.out.println();
	}

	// to get the name of the student
	public String getName() {
		return name;
	}

}
