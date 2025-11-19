package com.day3.OOPs;

public class OOPsConcepts {

	public static void main(String[] args) {

		// oops
		// -- focus on objects and class
		// class - template / blueprint for object
		// - attributes and behavior of the object
		// flats plan, blueprint = structure of the flat
		// - > actual flat is built using blueprint occupying space,resources -> object
		// - > single plan -> can built multiple flats -> multiple objects are built up

		// create objects
		// Object - instance of the class, represent real entity
		// from a single class - we can instantiate multiple object

		// OOPs - bank account

		//Private members - army dept -> cant be accessed outside of class - use getter and setter
		
		//protected -> Orgzn -

		
		// principles

		// --- encapsulation-- hiding internal details of the class using
//				    				-- private fields  ---- getter and setters

		// --- inheritance -- create a class-
		// - savingAccount - minBalance = 5000 , interestRate = 7%
		// - is bank account only
		// - accNum , Holder name, balance
		// - reuse bank account class
		// - inherit savingAccount from bankAccount
		// - bankAccountClass - base class, parent class, super class
		// - SavingsAccount - Derived class, child class, sub class

		// -- single inheritance
		// bankacc class - inherit any number of classes,
		// current acc

		// - Hierarchical inheritance - multiple subclass are inherit from single super
		// class

		// Multiple Inheritance - using interface

		// Multilevel inheritance - BA -> SA -> CA->
		// class A -> class B -> class c
		// public , private, protected
		// protected - it is available the class we using and the
		// inherited class .
		// bankacc - > protected


		// Polymorphism - poly means many, morphism means forms
		
		// function overloading - different methods with same name but different
		// parameters in same class
		
		// function overriding - child class function with same name and same parameter
		// as in parent class and use @Override in child class

		//Abstraction ->
		// -> hide the complexity from the users
		// present an simplified view of the object
		// focus on what and not on how
		// Abstract Classes ->
		//		which has at least one abstract method(declare method in a class)
		//		but we do not give the implementation of the method
		//		Can have both abstract and concrete methods
		//		use keyword abstract -for creating abstract methods
		//		Class is abstract - cannot instantiate that class 
		//			-> cannot create object of that class
		//			-> they are implemented by inheriting 
		//			-> when inherited , the subclass must override and give implementation of the method.
		
//		-> interface
		// -> define a set of abstract methods
		// -> all method are abstract only
		// -> by default they are public and abstract
		// -> interface -> contract every inherited class has to implement
		// -> for extending class - another keyword is used - implements
		// -> why? - abstraction
		// - with interface we can implement multiple inheritance as well
		// -> - polymorphism, different classes can implement same interface and we
		
		// multilevel inheritance
		
//		class a{
//			void show();
//		}
//		class b{
//			void show() {
//			}
//		}
//		class text extends a,b{
//			// test will have the two implementation of show() method
//			// ambigity - diamond problem
//			obj.show();
//		}
//		
//		interface a - show() - abstract method
//		Interface b - show() - abstract method
//		class text implement a,b{
//			show(){
//				single implementation is the overriden implementation for both the classes
//				
//			}
//		}
		
	}

}
