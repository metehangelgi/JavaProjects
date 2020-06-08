/*
 * File: Add2Integers.java
 * -----------------------
 * This program displays the message "This program add two integers" and 
 * creates two int variables. It assigns 1 and 2 to the numbers.
 * It adds two number and displays the total in a message
 * 
 * Class: AddNIntegers
 * Difficulty: (Easy)
 * Prerequisites: For Loops, Variables and Arithmetic, ConsoleProgram (readInt, println)
 */

import acm.program.*;

public class Add2Integers extends ConsoleProgram {

	public void run() {
		// your code start here
	
		println("this program adds two numbers.");
		int n1= readInt ("Enter Number 1:");
		int n2= readInt ("Enter Number 2:");
		int total =n1+n2;
		println("The total is="+ total +".");
	


		// your code ends here
	}
	}
