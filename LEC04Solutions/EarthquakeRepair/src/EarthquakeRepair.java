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
		repairColumn();
		while( frontIsClear() ) {
			moveToNextColumn();
			repairColumn();
		}
		// Your code ends here
	}

	/** Helper methods */

	// Your code starts here
	private void moveToNextColumn() {
		for( int i = 0; i < 4; i++ )
			move();
	}

	private void repairColumn() {
		ascendColumnRepairing();
		descendColumn();
	}



	private void ascendColumnRepairing() {
		turnLeft();
		if( noBeepersPresent() ) {
			putBeeper();
		}
		while(frontIsClear()) {
			move();
			if( noBeepersPresent() ) {
				putBeeper();
			}
		}
	}

	private void descendColumn() {
		turnAround();
		while(frontIsClear()) {
			move();
		}
		turnLeft();
	}
	// Your code ends here
}
