package com.day12.JavaIO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeApp {
	public static void main(String[] args) {
		Employee emp = new Employee(101, "Aniket Goyal", 75000.00);

		// ObjectOutputStream = convert object into a byte stream.
		// store it in some file -> employee.ser

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				"C:\\Users\\703440072\\Desktop\\Java Training\\1 Core Java Fundamentals\\emp.ser.txt"))) {
			oos.writeObject(emp);
			System.out.println("Serialization successful.z");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
