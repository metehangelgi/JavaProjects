/*File: DaysInMonths.java*/

import acm.program.*;

public class DaysInMonths extends ConsoleProgram{
	public void run() {
		// Your code starts here
		println("This program shows the number of days in a month");
		int month= readInt("Enter numeric month(Jan=1)(0 to exit)");
		
		while (month !=0) {
			//display the correct season using switch
			switch (month) {
			case 12: case 1 :case 2:
				println("Winter"); break;
			case 3: case 4 :case 5:
				println("Spring"); break;
			case 6: case 7 :case 8:
				println("Winter"); break;
			case 9: case 10 :case 11:
				println("Winter"); break;
			}
		}
		// Your code ends here
	}
}
