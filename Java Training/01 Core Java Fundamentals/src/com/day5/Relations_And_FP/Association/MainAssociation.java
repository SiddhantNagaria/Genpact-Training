package com.day5.Relations_And_FP.Association;

public class MainAssociation {

	public static void main(String[] args) {
		
		// creating 4 students
		Student s1 = new Student("S01","Ankit");
		Student s2 = new Student("S02","Ankita");
		Student s3 = new Student("S03","Rohit");
		Student s4 = new Student("S04","Ishita");
		
		// creating 2 course - java , python
		Course java = new Course("CJ01","Java Programming");
		Course python = new Course("CP01","Python Programming");
		
		// s1.enroll(java)
		// s1 - both 
		// s2 - 1 course
		s1.enroll(python);
		s1.enroll(java);
		s2.enroll(python);
		s3.enroll(java);
		s4.enroll(python);
		s4.enroll(java);
		
		// students - printCourses()
		s1.printCourses();
		s2.printCourses();
		s3.printCourses();
		s4.printCourses();
				
		// courses - printStudents()
		java.printStudents();
		python.printStudents();

	}

}
