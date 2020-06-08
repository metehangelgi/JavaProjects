/*
 * File: InterestCalculator.java
 * -------------------------------------
 * This program calculates the interest added to an account
 * during each of ten years and prints the balance at each year.
 * 
 * Class: InterestCalculator
 * Difficulty: (Medium)
 * Prerequisites: For Loops, Variables and Arithmetic, ConsoleProgram (readDouble, println)
 */

import acm.program.*;

public class InterestCalculator extends ConsoleProgram {

	//Main System Function
	public void run() {
		// Your code starts here
		println("interest calculator.");
		
		//declare variables 
		double balance = readDouble("Enter Starting Balance:");
		double annualRate = readDouble("Enter annual interest Rate")/100;
		for(int i=0; i<10;i++) {
			balance =+ annualRate *balance ;
			println("balance after " +(i)+"years"+ balance);
			
		}
		
		// Your code ends here
	}
	
}

