/*
 * File: CharStats.java
 * ---------------------
 * This program takes a string as input and counts uppercase and lowercase letters.
 */

import acm.program.*;

/**
 * This class takes a string as input and counts uppercase and lowercase letters.
 */

public class CharStats extends ConsoleProgram {

	/** Runs the program */
	public void run() {

		println("This program takes a string as input and counts uppercase and lowercase letters.");

		// Your code starts here
		while (true) {
			String str = readLine("Enter a string: ");
			if (str.length() == 0) break;
			
			Character s1= new Character('A');
			char s2='A';
			println(s1.compareTo(s2));


			int upCount = 0;
			int lowCount = 0;
			int nonCount = 0;

			for( int i = 0; i < str.length(); i++ ) {
				char c = str.charAt(i);
				if( Character.isUpperCase(c) ) {
					upCount++;
				}
				else if( Character.isLowerCase(c) ) {
					lowCount++;
				}
				else {
					nonCount++;
				}	
			}
			println("That string contains "+upCount+" uppercase, "+lowCount+" lowercase and " +
					""+nonCount+" non-alphabetic characters.");
			char c='a';
			println(str.concat(Character.toString(c)));
			println(str +"oğuz");
		}	
		// Your code ends here
	}

}