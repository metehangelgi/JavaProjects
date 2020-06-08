/* File: FlyingMountain.java
 * 
 * Karel is in space and should put beepers on a flying mountain
 */

import stanford.karel.*;

public class FlyingMountain extends SuperKarel {

	public void run() {
		//Your code starts here
		move();
		while(noBeepersPresent()) {
			turnLeft();
			while(frontIsBlocked()) {
				turnRight();
				
			}
			paintCorner(YELLOW);
			move();
			if(frontIsClear() && leftIsBlocked()) {
				putBeeper();
				paintCorner(YELLOW);
				move();
		}
			if  (cornerColorIs(YELLOW)) {
			break;	
			}
		} 
		//Your code ends here
	}
	//Helper method implementations here
	//Your code starts here
	
	//Your code ends here
}