/*
 * File: BottlesOfBeer.java
 * ------------------------
 * This program prints out the lyrics to the song
 * "99 Bottles of Beer on the Wall."  For testing
 * purposes, the constant should be reduced to a
 * smaller value.
 */

import acm.program.*;

public class BottlesOfBeer extends ConsoleProgram {

	public void run() {
		// Your code starts here
		int i=99;
		while (i> 0){
			
			println(i+" Beers of bottle on the wall.");
			println(i+" bottles of beer.");
			println(" you can take down, pass it around");
			
			i--;
			println(i+" bottles of beer on the wall");
		} 
		
			println(" No more bottles of beer on the wall");
		
		// Your code ends here
	}

	/* Private constants */
	private static final int MAX_BOTTLES =99;

}
