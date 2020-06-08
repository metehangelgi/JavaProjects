/*
 * File: DistanceConverter.java
 * -------------------------------------
 * This program converts a distance measured in inches
 * to the equivalent distance in centimeters.
 * 
 * Class: DistanceConverter
 * Difficulty: (Easy)
 * Prerequisites: Variables and Arithmetic, ConsoleProgram (readInt, println)
 */

import acm.program.*;

public class DistanceConverter extends ConsoleProgram {

	//Main System Function
	public void run() {
		// Your code starts here
		
		println("this program converts inches to centimeters");
		
		
		//declare my variables
		int inches =readInt("Enter number of inches:");
		double cmValue = inches *  CENTIMETERS_PER_INCH;
		
		println(inches +"inches=" + cmValue + "cm.");
	
		double fValue;
		int userValue = readInt("Enter number of inches");
		fValue = userValue * CENTIMETERS_PER_INCH;
		// Your code ends here
		println(userValue+"inches="+fValue+"cm.");
	}
	
	//Variable Declaration
	private static final double CENTIMETERS_PER_INCH = 2.54;
}

