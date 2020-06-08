/*
 * File: AverageGrades.java
 * ---------------------
 * This program asks for the midterm grades of students 
 * from the user until he/she enters a negative value then calculate the class average
 * 
 * Class: AverageGrades.java
 * Score: (Medium)
 * Prerequisites: While Loops, If-Else Statements, ACM Task Force Commands
 */

import acm.program.*;

public class AverageGrades extends ConsoleProgram {

	public void run() {

		
		
		println("Enter values, one per line, using " );
		
		int sum =0;
		
		int lastGrade=0;
		int counter=0;
		double average;
		while(lastGrade>= 0) {
			
			counter++;
			
			sum +=lastGrade;
			lastGrade = readInt("Enter a Grade:enter negative number to exit");

		}
		counter--;
		
		if(counter>0) {
			average=(double)sum/counter;
			println("Average is:" +average);
		} else {
			println("no grades are given.");
		}
	}


}
