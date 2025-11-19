package com.day5.Relations_And_FP;

public class RelationsConcepts {

	public static void main(String[] args) {
		
		// Association
		// - has-a' relationship where objects are aware of each other and they can interact
		// - but neither owns the other object
		// - Student can enroll in some course
		// - Each object can exist independently
		// - Student (enroll)  Course 
		// - Loose coupling (related but independently)
		// - BankAcc - you can have many accs
		// - Person 
		
		// Aggregation
		// - special form os association
		// - represent a whole-part relationship
		// - part can exist independently of the whole
		// - whole has reference to parts but it does not own them
		// - Department(whole) - Professor (part)
		// - Weak ownership
		
		// Composition
	    // - strong form of aggregation
		// - whole owns the parts
		// - whole is responsible for the lifecycle of the parts
		// - strong ownership
		// House -> Rooms
		// Smartphone -> sim card
		
		// - Car(whole) - Engine(part) -> Composition
		// 
	}

}
