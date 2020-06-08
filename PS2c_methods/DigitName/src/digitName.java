/*
 * File: digitName.java
 * --------------------
 * This program takes a number between 0 and 9 as input
 * and prints its equivalent name.
 */

import acm.program.*;

public class digitName extends ConsoleProgram {

	public void run() {
		//Get input number and print its name.
		
		int digitValue = readInt("Enter a digit between 0 and 9: ");
		println(getDigitName(digitValue));
	}
//Implement the helper method getDigitName() here
	private String getDigitName(int digit) {
		switch(digit) {
		case 0: return("Zero");
		case 1: return("One");
		case 2: return("two");
		case 3: return("three");
		case 4: return("four");
		case 5: return("five");
		case 6: return("six");
		case 7: return("seven");
		case 8: return("eight");
		case 9: return("Nine");
		default: return ("Error");
		}
	}
/* Translates a number into its name */


}
