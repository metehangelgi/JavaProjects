/*
 * File: CircleArea.java
 * ---------------------
 * This program computes the area of a circle.
 * 
 * 
 * Class: CircleArea.java
 * Score: (Simple)
 * Prerequisites: ACM Task Force Commands
 */

import acm.program.*;
import acm.util.RandomGenerator;

public class CircleArea extends ConsoleProgram {

	public void run() {
		println("This program takes a string as input and reverses it.");
		// Your code starts here
		while (true) {
			String str= readLine("Enter a string: ");
			if (str.length() == 0) break;
			reverse2(str);
			
		
		}
		// Your code ends here
	}

	/** This method reverses a string */
	
	private void reverse2(String str) {
		for(int a=0;a<str.length();a++) {
			String c=str.substring(a,a+1);
			println(c);
		}
		for(int a=0;a<str.length();a++) {
			String partial=str.substring(a, a+2);
			println(partial);
		}
		for(int a=0;a<str.length();a++) {
			String whole=str.substring(a,a+3);
			println(whole);
		}
	}
	/*
		  output:
		a
		l
		i
		al
		li
		ali
		"ali" parçalarınca ayrıldı 

		 
		// Your code ends here
		return result;
	}
	*/

	
}
