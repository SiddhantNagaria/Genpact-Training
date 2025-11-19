package com.day5.Relations_And_FP.Aggregation;

import java.util.ArrayList;
import java.util.List;

public class Department {

	public Department(String d_name) {
		this.d_name = d_name;
	}

	private String d_name;
	private List<Professor> professors = new ArrayList<>();

	// add Professor to dept
	public void addProfessor(Professor p) {
		if (!professors.contains(p)) {
			professors.add(p);
		}
	}

	public void printProfessors() {
		System.out.println("Department " + d_name + " professors");
		if (professors.isEmpty()) {
			System.out.println("None");
			return;
		}
		for (Professor p : professors) {
			System.out.println(p.getName());
		}
		System.out.println();

	}
}
