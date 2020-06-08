/* File: TurningRight.java
 * 
 * As you may have noticed Karel can't turn right
 * with a single command, but it can turn left. It
 * would be acceptable having a method to turn right
 * that makes Karel face right once it is called,
 * even though it has to turn left multiple times.
 * So, write a method called turnRight that makes
 * Karel face right once it is called.
 */


import stanford.karel.*;

public class TurningRight extends Karel {

	public void run() {
		move();
		turnRight();
		move();
		turnRight();
		move();
		turnRight();
		move();
		turnRight();
	}

	private void turnRight() {
		// Your code starts here
		turnLeft();
		turnLeft();
		turnLeft();
		
		// Your code ends here
	}
}