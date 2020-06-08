/*
 * File: BeatingHeart.java
 * -------------------------
 * Write a program that draws a ball (whichever colour you want) 
 * centered in the applet screen with an initial radius of 10. 
 * Then, continuously enlarge your ball�s radius until it reaches 
 * the walls (bounds) of your screen. Once it touches the walls, 
 * then, continuously shrink your ball to the original size. 
 * Continue to do so infinitely.
 */

import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

public class BeatingHeart extends GraphicsProgram {
	public void run() {
		// Your code starts here
		println(getHeight());
		GOval daire=createCircle(r0);
		changing(daire);
		// Your code ends here
	}


	private void changing(GOval daire) {
		add(daire,getWidth()/2,getHeight()/2);
	while(daire.getX()>0) {
		daire.scale(1.1);
		daire.setLocation((getWidth()-daire.getWidth())/2,(getHeight()-daire.getHeight())/2 );
		pause(PAUSE_TIME);
	}
	while(daire.getHeight()>20) {
		daire.scale(0.9);
		daire.setLocation((getWidth()-daire.getWidth())/2,(getHeight()-daire.getHeight())/2 );
		pause(PAUSE_TIME);
	}
	}


	private GOval createCircle(double r0) {
		GOval daire=new GOval(r0,r0);
		pause(1000);
		daire.setFillColor(Color.RED);
		daire.setFilled(true);
		pause(1000);
		return daire;
		
	}


	/* Private constants */
	private static final int PAUSE_TIME = 100;
	private static final double r0 = 10;

}
