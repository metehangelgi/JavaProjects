/*
 * File: SquareBoardDrawer.java
 * --------------------
 * This program draws draws an empty square board 
 * that size is taken from the user
 * 
 * Class: SquareBoardDrawer.java
 * Score: (Medium)
 * Prerequisites: For Loops, ACM Task Force Graphics Commands
 */

import acm.graphics.*;
import acm.program.*;

public class SquareBoardDrawer extends GraphicsProgram {

	public void run() {
		// Your code starts here
		GCompound butun=new GCompound();
		int sayi=readInt("sayi giriniz");
		
		for(int i=0;i<sayi;i++) {
			double y=i*BLOCK_LENGTH;
			for (int j=0;j<sayi;j++) {
				double x=j*BLOCK_LENGTH;
				GRect kare =new GRect(BLOCK_LENGTH,BLOCK_LENGTH );
				butun.add(kare,x,y);
			}
		}
		add(butun,(getHeight()-butun.getHeight())/2,(getWidth()-butun.getWidth())/2);
		// Your code ends here		
	}
	

	//Global Variable Declarations
	private static final double BLOCK_LENGTH = 25;

}
