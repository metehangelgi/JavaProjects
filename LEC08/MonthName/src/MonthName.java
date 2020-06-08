/*
 * File: MonthName.java
 * --------------------
 * This program tests the monthName method.
 */

import acm.program.*;

public class MonthName extends ConsoleProgram {

	public void run() {
		int month = readInt("Enter month : ");
		int day = readInt("Enter day : ");
		int year = readInt("Enter year : ");
		println(monthName(month) + " " + day + ", " + year);
	}

	/* Translates a numeric month into a string */
	private String monthName(int month) {
		String name = null;
		// Your code starts here
		switch (month) {
	     case 0: return "January";
	     case 1: return "February";
	     case 2: return "March";
	     case 3: return "April";
	     case 4: return "May";
	     case 5: return "June";
	     case 6: return "July";
	     case 7: return "August";
	     case 8: return "September";
	     case 9: return "November";
	     case 10: return "October";
	     case 11: return "December";
	    
	     default: return "Illegal Month Number";
		}
		// Your code ends here
	} 

}
