/*
 * File: CardRank.java
 * -------------------
 * This program reads in an integer between 1 and 13 and
 * writes out the appropriate symbol for a playing card
 * of that rank.
 */

import acm.program.*;

public class CardRank extends ConsoleProgram {
	public void run() {
		// Your code starts here
		println("This prgram converts integers to card ranks.");
		
		int number= readInt("Enter an integer between 1 and 13 (0 to exit.): ");
		
		while(number<=13 && number>0) {
			switch (number) {
			case 1:
				println("Ace");
			break;
			case 11:
				println("Jack");
			break;
			case 12:
				println("Queen");
			break;
			case 13:
				println("King");
			break;
			default:
				println(number);
			}
			number =readInt("Please Enter different number to check others(0 to exit): ");
		}
		
		println("Thank you so much..");
		// Your code ends here
	}

}
