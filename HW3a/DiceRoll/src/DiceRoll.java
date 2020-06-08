/*
 * File: DiceRoll.java
 * ---------------------------
 * This program performs a random experiment consisting of rolling a dice 
 * repeatedly until two consecutive observation of a desired number.
 */

import acm.program.*;
import acm.util.*;

public class DiceRoll extends ConsoleProgram {

	public void run() {
		// Your code starts here
		println("Desired Nuber is : "+DESIRED_NUMBER);
		int counter=0;
		int counter2=0;
		while(counter!=2) {
			int number=rgen.nextInt(0,6);
			println(rasgele(number)+" Rolled");
			counter2++;
			if(number==4) {
				counter++;
			} else {
				counter=0;
			}
			
		}
		println("it took "+counter2+" times to get 4 two times" );
		
		
		// Your code ends here
	}
	private String rasgele(int number) {
		// Your code starts here
		switch (number) {
	     case 0: return "1";
	     case 1: return "2";
	     case 2: return "3";
	     case 3: return "3";
	     case 4: return "4";
	     case 5: return "5";
	     case 6: return "6";
	    
	     default: return "Illegal  Number";
		}
		// Your code ends here
	}


	/* Private instance variables */
	private RandomGenerator rgen = RandomGenerator.getInstance();

	/* Private constants */
	private static final int NUMBER_REQUIRED = 2;  /* Number of consecutive successes required */
	private static final int DESIRED_NUMBER = 4;  /* The desired dice number */
}
