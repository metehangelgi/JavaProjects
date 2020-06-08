/*
 * File: TenthPower.java
 * ---------------------
 * This program that takes an integer from the user and calculate and print 
 * its power to the 10.
 * 
 * Class: TentPower.java
 * Score: (Easy)
 * Prerequisites: For Loops, ACM Task Force Commands
 */

import acm.program.*;

public class TenthPower extends ConsoleProgram {

	public void run() {
		
		int Nterm = readInt("Enter the number of desired terms: ");
		int total =1;
		int fac=1;
		
		for(int i=0;i<10;i++) {
			
			total *=Nterm;
			
		}
		for(int a=Nterm; a>0; a--) {
			
			fac *=a;
		}
		
		
		
		
		println(Nterm+"'s tenth power is: "+ total);
		println(Nterm+"'s factoriel is: "+ fac);
		
		
		
		
		
		
		
	}

}
