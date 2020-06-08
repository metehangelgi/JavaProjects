/*
 * File: ReverseWords.java
 * ---------------------
 * This program takes a sentence as input and reverses its word order.
 */

import acm.program.*;

/**
 * This class takes a sentence as input and reverses its word order.
 */

public class ReverseWords extends ConsoleProgram {

	/** Runs the program */
	public void run() {
		println("This program takes a sentence as input and reverses its word order.");
		// Your code starts here
		while(true) {
			String str=readLine("enter a sentence:  ");
			if (str.length()==0) break;
			String reversed =reverseWords(str);
			println(reversed);
		}
		
		// Your code ends here
	}

	/** This method reverses words in a string */
	private String reverseWords(String str) {
		String result = "";
		// Your code starts here
		while(str.lastIndexOf(" ") !=-1 ) {
			int index=str.lastIndexOf(" ");
			result += str.substring(index+1)+ " ";
			str=str.substring(0, index);
		}
		result+=str;
		// Your code ends here
		return result;
	}
}

