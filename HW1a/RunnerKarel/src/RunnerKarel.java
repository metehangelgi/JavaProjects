/*
 * File: RunnerKarel.java
 * ---------------------
 * Make Karel run 5 laps around beepers.
 */

import stanford.karel.SuperKarel;

public class RunnerKarel extends SuperKarel {

	public void run() {
		for(int i=0; i<20; i++) {
		while(frontIsClear()) {
			move();
		}
		
		turnLeft();
	}
	
	}
}

