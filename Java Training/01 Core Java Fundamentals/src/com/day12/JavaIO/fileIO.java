package com.day12.JavaIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class fileIO {
	public static void main(String[] args) {
//		try (FileInputStream fis = new FileInputStream(
//				"C:\\Users\\703440072\\Desktop\\Java Training\\3 JDBC Employee Management System\\img\\img1.jpg")) {
//			
			// assume file in default workspace
//			// FIS -> read bytes from a file
//			// read() -> return one byte at a time
//			// -1 -> indicates end of the file
//
//			int i;
//			while ((i = fis.read()) != -1) {
//				System.out.print((char) i);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

//		String data = "I am learning java fsd";
//		try (FileOutputStream fos = new FileOutputStream(
//				"C:\\Users\\703440072\\Desktop\\Java Training\\3 JDBC Employee Management System\\img\\data.txt")) {
//			fos.write(data.getBytes());
//			System.out.println("data written successfully");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
		// read and write using character stream
		try (FileWriter fw = new FileWriter(
				"C:\\Users\\703440072\\Desktop\\Java Training\\3 JDBC Employee Management System\\img\\data.txt", true)) {
			fw.write("Learning file writing using character stream. I am using Java");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// read content and print in console
		try (FileReader fr = new FileReader(
				"C:\\Users\\703440072\\Desktop\\Java Training\\3 JDBC Employee Management System\\img\\data.txt")) {
			int ch;
			while ((ch = fr.read()) != -1) {
				System.out.print((char) ch);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
