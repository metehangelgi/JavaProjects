/*
 * File: Doubler.java
 * -------------------------------------
 * Take an integer input from the user and ask twice of the 
 * answer every step until user gives wrong answer
 * 
 * Class: Doubler
 * Difficulty: (Medium)
 * Prerequisites: While Loops, ConsoleProgram (readInt, println)
 */

import acm.program.*;

public class Doubler extends ConsoleProgram {

	//Main System Function
	public void run() {
		// Your code starts here
		int number= readInt("Enter an integer to start doubler game: ");
		
		int twiceguess= readInt("Twice of "+number+": ");
		
		while (number*2==twiceguess) {
			number*=2;
			
			twiceguess = readInt("True Twice of "+number+" ? ");
			
		} 
		println("wrong answer  :( ");
		// Your code ends here
	}
}

