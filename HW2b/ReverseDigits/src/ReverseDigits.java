/*
 * File: ReverseDigits.java
 * ------------------------
 * This program reverses the digits in a positive integer.
 */

import acm.program.*;

public class ReverseDigits extends ConsoleProgram {

	public void run() {
		
		println("This program reverses the digits in an integer.");
		int n = readInt("Enter a positive integer: ");
		int reversed = reverseNumber(n);	
		println("The reversed number is " + reversed);
		
	}
	
	/* This method reverses the digits of the input integer */
	private int reverseNumber(int n){
		int reversed = 0;
		// Your code starts here
		
		
			while(n>0) {
				reversed *=10;
				reversed += n%10;
				
				n /=10;
			}
		// Your code ends here
		return reversed;
	}

}
//12345
