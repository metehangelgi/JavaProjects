/*
 * File: LetterGrade.java
 * -----------------------
 * This program gets a grade score between 0 and 100, and prints the letter grade.
 * You should use the limits 90=A, 80=B, 70=C, 60=D.
 */

import acm.program.*;


public class LetterGrade extends ConsoleProgram {
	public void run() {
		// Your code starts here
		
		println("this program is showing equal LetterGrade of Your Grades");
		
		int gradeInt= readInt("Please enter your grade: ");
		while(gradeInt>=SENTINEL) {
			if (gradeInt>=90) {
				println("your Grade is A ");
				
			} else if (gradeInt>= 80 ) {
				println("your Grade is B ");
			} 
			else if (gradeInt>= 70 ) {
				println("your Grade is C ");
			} 
			else if (gradeInt>= 60 ) {
				println("your Grade is D ");
			} else {
				println("your Grade is F");
			}
			gradeInt= readInt("Please enter your grade: ");
		}
		println("napiyun aq");
		

		
        // Your code ends here
	}
	private static final int SENTINEL = 0 ;
}
