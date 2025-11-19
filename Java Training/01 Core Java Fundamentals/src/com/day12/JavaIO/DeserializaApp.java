package com.day12.JavaIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializaApp {
	public static void main(String[] args) {

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				"C:\\Users\\703440072\\Desktop\\Java Training\\1 Core Java Fundamentals\\emp.ser.txt"))) {
			Employee emp = (Employee) ois.readObject();
			System.out.println(emp.empid + " " + emp.name + " " + emp.salary);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
