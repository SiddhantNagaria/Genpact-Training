package com.day5.Relations_And_FP.Aggregation;

public class MainAggregation {

	public static void main(String[] args) {
		
		Department d1 = new Department("CSE"); 
		Department d2 = new Department("Maths");
		
		Professor p1 = new Professor("p1", "Paul");
		Professor p2 = new Professor("p2", "Jin");
		Professor p3 = new Professor("p3", "Yoshimitsu");
		
		d1.addProfessor(p1);
		d1.addProfessor(p2);
		
		d2.addProfessor(p3);
		
		d1.printProfessors();
		
		d2.printProfessors();

	}

}
