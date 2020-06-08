/* STUDENT NAME:Metehan Gelgi
 * File: ClearAllBeepersInLine.java
 * 
 * Karel clears all beepers on the way and goes back to her initial position.
 */

import stanford.karel.*;

public class ClearAllBeepersInLine extends Karel {

	public void run() {
		//Your code starts here
		while(frontIsClear()) {
			while (beepersPresent()) {
				pickBeeper();
			}
			move();
			
				
			}
		turnAround();
		while (beepersPresent()) {
			pickBeeper();
		}
		while(frontIsClear())
		{
			move();
		}
		turnAround();
		//Your code ends here
	}
	
	//Your helper methods go here (if needed):
	//Your code starts here
	private void turnAround() {
		turnLeft();
		turnLeft();
	}
	//Your code ends here
}