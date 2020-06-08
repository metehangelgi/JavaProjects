/* STUDENT NAME:
 * File: KarelBro.java
 * Karel goes though 8 challanges as Mario Bro.
 */
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import stanford.karel.SuperKarel;

public class KarelBro extends SuperKarel {

	public void run() {

		playThemeSong(THEME_SONG);// You can delete this line if you don't want to play the theme song.
		
		// Your code starts here.
		
		
		// Part1
		
		
		// this part includes findTheNextTree
		//also it is trimming trees
		
		trimTheTrees();
		// Part 2
		
		//first part tries to find stairs
		//MountainKarel codes were used
		
		findTheStairs();
		climbStairs();
		while(rightIsClear()) {
			down();
			
		}
		// Part 3
		//NextHole codes find the hole and jump over this hole
		//takeCoin takes coin and  whenever  it takes coin, Karel comes back to the ground  
		NextHole();
		takeCoin();
		
		// Part 4
		
		//first part turns U 
		// second part provide the Karel to go inside thruogh tunnel and takes coins 
		
		getIntoTunnel();
		passTunnel();
		
		
		// Part 5
		// first part moves until The Karel see Magenta
		//Second code provides to get all beepers to the middle 
		//Third one helps Karel to find it Way to get out from Tower
		
		findTower();
		beepersToMid();
		leavefromTower();
		
		
		// Part 6
		//first part is like findTree. This code Helps Karel to find Step
		// we don't need to generalize tsecond code because it is same for all maps
		findTheStairs();
		while (frontIsBlocked()) {
			climb();
		}
		move();
		turnRight();
		while(frontIsClear()) {
			move();
		}
		turnLeft();
		
		// Part 7
		// findTheStairs again like findTheTree
		//go to the flag helps karel to ascend on line
		//takeItDown says karel to get flag to the ground
		
		
		findTheStairs();
		goToTheFlag();
		takeItDown();

		// Part 8
		// by this last part Karel can find its way easily to finish these maps
		
		turnLeft();
		move();
		down();
		while(frontIsClear()) {
			move();	
			if(cornerColorIs(BLACK)) {
				break;
			}
			playVictorySong(VICTORY_SONG);
		} 
		
		// Your code ends here.
	}
	private void takeItDown() {
		turnLeft();
		while(noBeepersPresent()) {
			move();
		}
		turnAround();
		
		while(frontIsClear()) {
			if(beepersPresent()&&cornerColorIs(GREEN)) {
				pickBeeper();
				paintCorner(CYAN);
				move();
			}
			else if(noBeepersPresent()) {
				putBeeper();
				paintCorner(GREEN);
			}
			if(frontIsBlocked()) {
				
					putBeeper();
					paintCorner(GREEN);
					
				if(beepersPresent()) {
					pickBeeper();
					paintCorner(CYAN);
				}
			}
			
		}
		
		
	}
	private void goToTheFlag() {
		turnLeft();
		move();
		turnRight();
		move();
		move();
		
	}
	public void climb() {
		turnLeft();
		move();
		turnRight();
		move();
		
	}
	private void leavefromTower() {
		turnAround();
		move();
		turnLeft();
		
	}
	private void beepersToMid() {
		turnLeft();
		
		if(noBeepersPresent()) {
			move();
			}
		while(beepersPresent()) {
			takeBeepersOneMid();
			if(cornerColorIs(BLACK)) {
				while(frontIsClear()) {
					move();
				}
				turnAround();
			}
			takeBeepersOneMid();
			if(cornerColorIs(MAGENTA)) {
				move();
			}
		
			
		}
		
		
	}
	private void takeBeepersOneMid() {
		
		
		while(beepersPresent() && cornerColorIs(MAGENTA)) {
			
			 
			pickBeeper();
			move();
			putBeeper();
			turnAround();
			move();
			turnAround();
		}
		
	}
	private void findTower() {
		turnRight();
		move();
		turnRight();
		while(frontIsClear()) {
			move();
		}
		turnLeft();
		while(cornerColorIs(CYAN)) {
			move();
		}
	}
	private void passTunnel() {
		while(cornerColorIs(GREEN)) {
			turnRight();
			while(frontIsBlocked()) {
				turnLeft();
			}
			while(beepersPresent()) {
				pickBeeper();
			}
			move();
			
		}
	}
	private void getIntoTunnel() {
		turnLeft();
		while(rightIsBlocked()) {
			move();
		}
		for(int i=0;i<2;i++) {
			turnRight();
			move();
		}
		
		
	}
	private void findTheStairs() {
		while (frontIsClear()) {
			move();
			
		}
	}
	private void takeCoin() {
		move();
		turnLeft();
		while(cornerColorIs(CYAN)) {
			move();
			
		} 
		turnRight();
		breakwall();
		while (frontIsClear()) {
			move();
			breakwall();
		}
	}
	private void breakwall() {
		if(noBeepersPresent()) {
			if(cornerColorIs(YELLOW)) {
				paintCorner(CYAN);
			}
		} else {
			if(cornerColorIs(YELLOW)) {
				paintCorner(CYAN);
			pickBeeper();
			turnRight();
			while(frontIsClear()) {
				move();
			}
			turnLeft();
			while(frontIsClear()) {
				move();
				
			}
			}
		}
		
	}

	private void NextHole() {
		while (rightIsBlocked()) {
			move();
		}
		
	}
	private void climbStairs() {
		turnLeft();
		while (rightIsBlocked()) {
			move();
			
		}
		turnRight();
		move();
		move();
		
		
	}
	
	public void down() {
	turnRight();
	move();
	turnLeft();
	if (frontIsClear()) {
		move();
	}
	}

	private void trimTheTrees() {
		for(int i=0;i<2;i++) {
			//move to Tree
				findNextTree();
				turnLeft();
			//TrimTheTree
				
				ascendTree();
				
					turnRight();
					convertColor();
					move();
					walkOverTree();
				
				
					turnRight();
					convertColor();
					move();
					descendTree();
				
				findNextTree();
				turnLeft();
		}
		
	}

	private void walkOverTree() {
		while(rightIsBlocked()) {
			convertColor();
			move();
			}
		
	}

	
	private void convertColor() {
		if(cornerColorIs(GREEN)&&noBeepersPresent()) {
			paintCorner(CYAN);
		}else if(cornerColorIs(GREEN)&&beepersPresent()) {
			pickBeeper();
		}
	}

	/** Helper Methods */
	// Your code starts here.
	
	private void ascendTree() {
	
		while(rightIsBlocked()) {
			convertColor();
			move();

		}
		
	}
	
	private void descendTree() {

		while(rightIsBlocked() && frontIsClear()) {
			convertColor();
			move();
	
			}
		
	}

	private void findNextTree(){
		while(frontIsClear()) {
			move();
		}
		
	}
	// Your code ends here.

	/**----- Do not change anything below here. -----*/

	
	/**
	 * This method plays the given audio file (in this case Mario Theme Song) file continously in a loop.
	 * @param fileLocation Location of the audio file. 
	 */
	private void playThemeSong(String fileLocation) {
		try {
			inputStream = AudioSystem.getAudioInputStream(new File(fileLocation));
			clip = AudioSystem.getClip();
			clip.open(inputStream);
			clip.loop(Clip.LOOP_CONTINUOUSLY);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * This method closes the currently playing audio files and plays the given audio file (in this case Mario Victory Theme) for one time.
	 * @param fileLocation Location of the audio file.
	 */
	private void playVictorySong(String fileLocation) {
		try {
			clip.close();
			inputStream.close();
			inputStream = AudioSystem.getAudioInputStream(new File(fileLocation));
			clip.open(inputStream);
			clip.start();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private static final String THEME_SONG = "theme.wav";
	private static final String VICTORY_SONG = "victory.wav";

	private Clip clip;
	private AudioInputStream inputStream;

}
