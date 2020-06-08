/*
 * File: NoVowels.java
 * ---------------------
 * This program takes a string as input and removes vowels in it.
 */

import acm.program.*;

/**
 * This class takes string as input and removes vowels in it.
 */

public class NoVowels extends ConsoleProgram {

	/** Runs the program */
	public void run() {
		println("This program takes a string as input and removes vowels in it.");
		// Your code starts here
		String str =readLine("plaese enter a string");
		
		for (int i=0;i< str.length();i++ ) {
			
			Character x= str.charAt(i);
			int point=vowels.indexOf(x);
			if(point!=-1) {
				String sub=str.substring(point-1, point);
				str=str.replace(sub, " ");
			}

			
		}
		print(str);
		
		// Your code ends here
	}
	
	private static final String vowels = "aeiouAEIOU";
}

