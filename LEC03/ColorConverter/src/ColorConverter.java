import stanford.karel.SuperKarel;

public class ColorConverter extends SuperKarel{

	public void run() {
		paintStreet();
		while (leftIsClear()) {
			repositionForRowToWest();
			paintStreet();
			if (rightIsClear()) {
				repositionForRowToEast();
				paintStreet();
			} else {
				turnAround();
			} 
		}
	}

	// Only fill this method
	private void ConvertColors(){
		// Your code starts here
		if(noBeepersPresent()) {
			if(cornerColorIs(RED)) {
				paintCorner(BLUE);
			} else {
				if(cornerColorIs(BLUE)) {
					paintCorner(YELLOW);
			} else {
				paintCorner(RED);
			}
				
			}
			//rules with no beepers
		} else {
			//rules with the beepers
				if(cornerColorIs(RED)) {
					paintCorner(YELLOW);
				} else {
					if(cornerColorIs(BLUE)) {
						paintCorner(RED);
				} else {
					paintCorner(BLUE);
				}
					
				}
		}
		// Your code ends here	
	}

	private void paintStreet() {
		ConvertColors();
		while (frontIsClear()) {
			move();
			ConvertColors();
		}
	}

	/* Reposition Karel at far East wall to face West on next row */ 
	private void repositionForRowToWest() {
		turnLeft();
		move();
		turnLeft();
	}

	/* Reposition Karel at far West wall to face East on next row */ 
	private void repositionForRowToEast() {
		turnRight();
		move();
		turnRight();
	} 
}
