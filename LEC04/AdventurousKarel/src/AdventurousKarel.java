/*
 * File: AdventurousKarel.java
 * ---------------------------
 * Karel starts at (1,1) and takes a trip
 * to the center of the world. 
 * Your program must be able to work correctly on both worlds provided.
 */

import stanford.karel.*;

public class AdventurousKarel extends SuperKarel{

	public void run() {
		// Your code starts here
		while(true) {
			moveToObstacle();
			turnLeft();
			
			if(beepersPresent()) {
				pickBeeper();
				turnLeft();
				break;
			}
		}
		while(noBeepersPresent()) {
			moveToObstacle();
			turnRight();
		}
		
		
		// Your code ends here
	}
    // Your code starts here
    private void moveToObstacle() {
    	while(frontIsClear()) {
    		move();
    	}
    }
    // Your code ends here

}
















//public void run() {
//	// Your code starts here
//	while(noBeepersPresent())
//		walkALine();
//	// Your code ends here
//}
//
//private void walkALine(){
//	while(frontIsClear())
//		move();
//	turnLeft();
//}