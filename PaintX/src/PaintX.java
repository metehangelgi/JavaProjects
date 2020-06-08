import stanford.karel.*;

public class PaintX extends SuperKarel {
	

	public void run() {
		// Your code starts here
		faceEast();
		paintDiagonal();
		turnAround();
		goStraight();
		faceSouth();
		paintDiagonal();
		faceEast();
		// Your code ends here
	}
	
	/* You can use this method to make Karel to face towards east */
	private void faceEast() {
		while (notFacingEast()) {
			turnLeft();
		}
	}
	
	/*Use helper methods to decompose the problem into subtasks, wherever appropriate.*/

	// Your code starts here
	private void goStraight() {
		while (frontIsClear()) {
			move();
		}
	}

	private void paintDiagonal() {
		paintRandomly();
		while (frontIsClear()) {
			move_upper_right();
			paintRandomly();
		}
	}


	private void faceSouth() {
		while (notFacingSouth()) {
			turnLeft();
		}
	}

	private void move_upper_right() {
		turnLeft();
		move();
		turnRight();
		move();
	}

	private void paintRandomly() {
		if (random(0.33)) {
			paintCorner(BLUE);
		} else {
			if (random(0.5)) {
				paintCorner(GREEN);
			} else {
				paintCorner(RED);
			}
		}
	}
	// Your code ends here
}