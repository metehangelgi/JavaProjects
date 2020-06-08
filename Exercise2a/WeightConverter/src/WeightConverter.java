/*
 * File: WeightConverter.java
 * ---------------------------------
 * This program converts a weight in kilograms to its
 * English equivalent in pounds and ounces.
 * 
 * Class: WeightConverter.java
 * Score: (Simple)
 * Prerequisites: ACM Task Force Commands
 */

import acm.program.*;

public class WeightConverter extends ConsoleProgram {

	public void run() {
		println("This program converts kilos to pounds and ounces.");
		
		double kg=readDouble("enter the weight as a kg:  ");
		
		double converted= kg*POUNDS_PER_KILO;
		int pounds=(int) converted;
		double ounches= OUNCES_PER_POUND*(converted -pounds);
		println(kg+" kg equals to "+pounds+" pounds "+ounches+" ounches. ");
	}

	/* Private constants */
	private static final double POUNDS_PER_KILO = 2.2;
	private static final int OUNCES_PER_POUND = 16;

}
