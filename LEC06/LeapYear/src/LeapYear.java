/*
 * File: LeapYear.java
 * -------------------
 * This program reads in a year and determines whether it is a
 * leap year.  A year is a leap year if it is divisible by four,
 * unless it is divisible by 100.  Years divisible by 100 are
 * leap years only if divisible by 400.
 */

import acm.program.*;

public class LeapYear extends ConsoleProgram {
	public void run() {
		// Your code starts here
		println("this program helps to you to determine which years are leap years");
		
		int year= readInt("Enter year(ex. 1998): ");
		while (year>0) {
			int leap= year % 4;
			
			switch (leap) {
			case 1: case 2: case 3:
		         println(year+" is not a leap year");
		         break;
		      case 4: case 0:
		         println(year+" is a leap year");
		         break;
		      default:
		         println(" Error");
		         break;

			}
		}
		println("please enter valid year number ");
		
		//The year can be evenly divided by 4;
		//If the year can be evenly divided by 100, it is NOT a leap year, unless;
		//The year is also evenly divisible by 400. Then it is a leap year
		
		
		// Your code ends here
	}
}
