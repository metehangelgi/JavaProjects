/*
 * File: RandomCard.java
 * ---------------------
 * This program displays the name of a card chosen at
 * random from a standard deck of 52 playing cards.
 */

import acm.program.*;
import acm.util.*;

public class RandomCard extends ConsoleProgram {

	public void run() {
		println("This program displays a randomly chosen card.");
		for(int j = 1; j<=4; j++) {
			for(int cardNu=1;cardNu<=15;cardNu++) {
				println("player"+j +"has card "+ chooseRandomCard()+"of ");
			}
		}
		println(chooseRandomCard());
	}

	/* Returns the name of a randomly chosen card */
	private String chooseRandomCard() {
		return chooseRandomRank() + " of " + chooseRandomSuit();
	}

	/* Returns the name of a randomly chosen rank (Ace to King) */
	private String chooseRandomRank() {
		// Your code starts here
		int pick=rgen.nextInt(1,13);
		switch(pick) {
		case 1:
			return "ACE";
		case 2: case 3: case 4: case 5: case 6: case 8: case 7: case 9: 
			case 10: 
			return ""+ pick;
		case 11:
			return "Jack";
		case 12:
			return "Q";
		case 13:
			return "K";
		default: return "illegal Card";
		}
		// Your code ends here
	}

	/* Returns the name of a randomly chosen suit (Clubs to Spades) */
	private String chooseRandomSuit() {
		// Your code starts here
		switch (rgen.nextInt(0, 3)) {
		case 0: return "Clubs";
		case 1: return "Diamonds";
		case 2: return "Hearts";
		case 3: return "Spades";
		default: return "Illegal suit value";
		}
		// Your code ends here
	
		
		
		// Your code ends here
	}

	/* Private instance variables */
	private RandomGenerator rgen = RandomGenerator.getInstance();

}
