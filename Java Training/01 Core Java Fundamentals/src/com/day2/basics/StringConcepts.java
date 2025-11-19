package com.day2.basics;

public class StringConcepts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// String - sequence of characters
		// - non-primitive data type

		// declare and initialize strings
		String str1 = "Siddhant Nagaria"; // string literal
		String str2 = new String("Siddhant Nagaria"); // Use constructor
		String str3 = "Siddhant Nagaria"; // string literal

		// string pool - literal goes to string pool, and stored in string pool
		// Heap Memory - separate memory is allocated to string str2
		// str3 - will not be created separately

		// create string literals - string pool - is same is already there
		// then variable is referring to same already created literal

		// strings are also immutable - cannot be modified once created
		// improved security , saves memory (string pool), ensures thread safety

		// many methods associated with strings

		String firstName = "Siddhant";
		String lastName = "Nagaria";
		String fullName = firstName + " " + lastName;
		System.out.println("Full name : " + fullName);

		// string length
		System.out.println("length of fullname is : " + fullName.length());

		// fetch character at specific position - charAt
		System.out.println("character at position 3 is : " + fullName.charAt(2));

		// fetch substring - substring(start idx, end idx)
		System.out.println("substring of fullname from idx 2 is : " + fullName.substring(2, 8)); // 8-1=7 -> till idx 7
																									// it will go -
																									// idx-1

		// equals , equalsIgnoreCase
		// -> equalsIgnoreCase - it ignore the lowercase and uppercase -> it directly
		// compare the strings
		System.out.println("compare fullName with 'Siddhant Nagaria' : " + fullName.equals("Siddhant Nagaria"));
		System.out
				.println("compare fullName with 'Siddhant Nagaria' : " + fullName.equalsIgnoreCase("siDdhant nagaria"));
		System.out.println("compare fullName with str2 : " + fullName.equals(str2));
		System.out.println("compare fullName with str3 : " + fullName.equals(str3));
		System.out.println("compare str1 with str2 : " + (str1 == str2));
		System.out.println("compare str1 with str3 : " + (str1 == str3));
		System.out.println("compare str2 with str3 : " + (str2 == str3));

		// contains
		System.out.println("does fullname contains Nagaria : " + fullName.contains("Nagaria"));

		// immutable
		String str = "java";
		System.out.println("original value of str " + str);

		// concat
		str.concat("programming"); // does not change str
		System.out.println("value of str : " + str);
		
		//actually concat with programming
		str = str.concat("Programming");
		System.out.println("value of str :" + str);
		// update str reference -> Java programming

		
		//string builder and string buffer
		//Applications - frequent - file operations - insert, replace, delete
		//both are mutable sequence of characters
		//unlike string, it can be modified without creating new objects
		//Synchronization -:
		//StringBuilder (not synchronized, not thread safe class), faster than stringBuffer
		//StringBuffer - thread safe(synchronized), slightly slower than stringBuilder
		
		
		// String Builder
		StringBuilder sb = new StringBuilder("Java");
		System.out.println("original sb : " + sb);
		sb.append("Programming"); // modified original sb
		System.out.println("value of sb : " + sb);
		sb.insert(4, ",");
		System.out.println("value of sb : " + sb);
		sb.replace(0, 4, "Python");
		System.out.println("value of sb : " + sb);
		sb.delete(6, 8);
		System.out.println("value of sb : " + sb);
		sb.reverse();
		System.out.println("value of sb : " + sb);
		
		//String Buffer
		StringBuffer stb = new StringBuffer("Java Training");
		System.out.println("valur of stb : " + stb);
		stb.append(" class");
		System.out.println("valur of stb : " + stb);
		stb.insert(0, "New ");
		System.out.println("valur of stb : " + stb);
		
		System.out.println("valur of stb : " + stb);
		
	}

}
