/* File: CheckerBoard.java
 *
 * Write a method called putAndMoveOnce and
 * putAndMoveTwice that makes Karel put a 
 * beeper on the ground and move once and
 * twice, respectively. Use these methods to
 * build a checker board pattern.
 */

import stanford.karel.*;

public class CheckerBoard extends Karel {

	public void run() {
        //Your code starts here
		putAndMoveTwice();
		putAndMoveOnce();
		turnLeft();
		move();
		turnLeft();
		putAndMoveTwice();
		putAndMoveOnce();
		turnRight();
		move();
		turnRight();
		putAndMoveTwice();
		putAndMoveOnce();
		turnLeft();
		move();
		turnLeft();
		putAndMoveTwice();
		putAndMoveOnce();
		
        //Your code ends here
	}
	private void putAndMoveOnce(){
		putBeeper();
		move();
	}
	private void putAndMoveTwice() {
		putBeeper();
		move();
		move();
	}
	private void turnRight() {
		turnLeft();
		turnLeft();
		turnLeft();
	}
}