/*
 * File: BlockPiler.java
 * --------------------
 * This program draws piles of blocks like a half square that 
 * width of the pile is taken from user
 * 
 * Class: BlockPiler.java
 * Score: (Medium)
 * Prerequisites: For Loops, ACM Task Force Commands
 */

import acm.graphics.*;
import acm.program.*;

public class BlockPiler extends GraphicsProgram {

	public void run() {
		// Your code starts here		
		GCompound kule =new GCompound();
		int nBricks=readInt("enter number of piles");
		for(int n=nBricks;n>0;n--) {
			double y=(n-1)*BLOCK_HEIGHT;
			for(int nline=nBricks-n;nline<nBricks;nline++) {
				double x=nline*BLOCK_WIDTH;
				GRect kare=new GRect(BLOCK_WIDTH,BLOCK_HEIGHT);
				kule.add(kare,x,y);
				
			}
		}
		add(kule,(getWidth()-kule.getWidth())/2,(getHeight()-kule.getHeight())/2);
		// Your code ends here
	}

	//Global Variable Declarations
	private static final double BLOCK_WIDTH = 25;
	private static final double BLOCK_HEIGHT = 25;
}
