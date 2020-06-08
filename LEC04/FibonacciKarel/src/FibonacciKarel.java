/*
 * File: FibonacciKarel.java
 * ---------------------
 * Karel starts at (2, 1) facing East and puts 
 * a number of beepers while moving along a street.
 * The number is determined by Fibonacci sequence.
 */

import stanford.karel.SuperKarel;

public class FibonacciKarel extends SuperKarel {

	public void run() {
		// Your code starts here
		while( frontIsClear() ) {
			while( beepersPresent() )
			{
				carryBeeperNorth();
				goEast();
				putBeeper();
				goWest();
			}
			goWest();

			while( beepersPresent() )
			{
				carryBeeperNorth();
				goEast();
				goEast();
				putBeeper();
				goWest();
				goWest();
			}

			carryBeepersSouth();
			goEast();
			carryBeepersSouth();
			goEast();
		}
		// Your code ends here
	}

	/** Helper methods */

	// Your code starts here
	private void carryBeeperNorth() {
		pickBeeper();
		goNorth();
		putBeeper();
		goSouth();
	}

	private void carryBeepersSouth() {
		goNorth();
		while( beepersPresent() )
		{
			pickBeeper();
			goSouth();
			putBeeper();
			goNorth();
		}
		goSouth();
	}

	private void faceNorth() {
		while( notFacingNorth() ) {
			turnLeft();
		}
	}

	private void faceEast() {
		while( notFacingEast() ) {
			turnLeft();
		}
	}

	private void faceSouth() {
		while( notFacingSouth() ) {
			turnLeft();
		}
	}

	private void faceWest() {
		while( notFacingWest() ) {
			turnLeft();
		}
	}

	private void goNorth() {
		faceNorth();
		move();
	}

	private void goSouth() {
		faceSouth();
		move();
	}

	private void goWest() {
		faceWest();
		move();
	}

	private void goEast() {
		faceEast();
		move();
	}
	// Your code ends here
}