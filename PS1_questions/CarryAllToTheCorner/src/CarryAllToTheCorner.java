/* File: CarryAllToTheCorner.java
 * 
 * Carry all beepers on the way to the right corner 
 */

import stanford.karel.*;

public class CarryAllToTheCorner extends Karel {

	public void run() {
		//Your code starts here
		while(frontIsClear()) {
			while (beepersPresent()) {
				pickBeeper();
			}
			move();
			
				
			}
		for (int i=0;i<16;i++) {
			putBeeper();
		}
		
		//Your code ends here
	}
	//Helper method implementations here
	//Your code starts here
	
	//Your code ends here

}