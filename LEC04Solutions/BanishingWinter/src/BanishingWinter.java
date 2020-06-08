/*
 * File: BanishingWinter.java
 * -----------------------
 * Karel decorates barren tree trunks with flowers.
 * Trunks are of arbitrary height and placement.
 */

import stanford.karel.*;

public class BanishingWinter extends SuperKarel {

	public void run() {
		// Your code starts here
		while( beepersInBag() ) {
			findNextTrunk();
			adornTrunk();		
		}
		// Your code ends here
	}

	/** Helper methods. */

	// Your code starts here
	private void findNextTrunk() {
		while (frontIsClear()) {
			move();
		}
	}

	private void adornTrunk() {
		ascendTrunk();
		putLeaves();
		descendTrunk();
	}

	private void ascendTrunk() {
		turnLeft();
		while (rightIsBlocked()) {
			move();
		}
	}

	private void putLeaves() {
		putBeeper();
		move();
		putBeeper();
		turnRight();
		move();
		putBeeper();
		turnRight();
		move();
		putBeeper();
	}

	private void descendTrunk() {
		while (frontIsClear()) {
			move();
		}
		turnLeft();
	}
	// Your code ends here
}