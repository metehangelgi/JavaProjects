/* /*
 * File: EarthquakeRepairKarel.java
 * --------------------------
 * Karel repairs damage done in 
 * in the earthquake
 */
import stanford.karel.*;

public class EarthquakeRepair extends SuperKarel {

	public void run() {
		// Your code starts here
		
		fillLine();
		goBack();
		
		while(frontIsClear()) {
			
			for(int i=0; i<4;i++) {
				move();
			}
			fillLine();
			goBack();
		}
		
		
		
		
		// Your code ends here
	}

	/** Helper methods */

	// Your code starts here
	private void fillLine() {
		turnLeft();
		if(beepersPresent()) {
			pickBeeper();
		}
		while(frontIsClear()) {
			move();
			if(beepersPresent()) {
				pickBeeper();
			}
		}
		
		
	}
	private void goBack() {
		turnAround();
		putBeeper();
		while(frontIsClear()) {
			move();
			putBeeper();
		}
		
		turnLeft();
	}
	
	// Your code ends here
}
