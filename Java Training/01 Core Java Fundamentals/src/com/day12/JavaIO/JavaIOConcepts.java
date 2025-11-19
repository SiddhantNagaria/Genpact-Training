package com.day12.JavaIO;

public class JavaIOConcepts {
	
	// java IO
		// - Java io - stream
		// - file i/o and console i/o
		// - serialization and desereialization
		// JDBC Arch and Drivers
		
		// Java I/O 
		// - mechanism thro which java applications read data from sources - like files, keyboard, network socket
		// - write data to destination - like files, console
		
		// Streams
		// - stream represents a sequence of data
		// byte stream -> handle binary data (images, audio, pdf) 
		//             -> Classes -> InputStream - used for reading data
		//                        -> OutputStream - used for writing data
		//                        -> FileInputStream - used to read from file - image
		//                        -> FileOutputStream
		
		// Character stream -> handles textual data -> Classes -> Reader, Writer, FileReader, FileWriter
		
		// File I/O
		// - read from and write to files using stream
		
		// Serialization and desereialization
		
		// Serialization - process of converting an object into a byte stream 
		//               - Employee -> some object 
		//  -> send it over a network 
		//  -> save object state in some db / file
		
		// DeSerialization - reverse process -> byte stream (Employee byte stream)
		// - process of recontructing the object from the byte stream
		// over a n/w -> send employee object using byte stream 
		// recieved -> back to object
		
		// java io -> interface Serializable
	
}
