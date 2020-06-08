/*
 * File: Rainbow.java
 * ------------------
 * This program is a stub for the Rainbow problem, which displays
 * a rainbow by adding consecutively smaller circles to the canvas.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;

import java.awt.*;

public class Rainbow extends GraphicsProgram {

	public void run() { 
		GRect background = new GRect(0,0,getWidth(), getHeight());
		background.setColor(Color.CYAN);
		background.setFillColor(Color.CYAN);
		background.setFilled(true);
		add(background);
		GOval aaa =new GOval(-getWidth()/2,10+(8*10), getWidth()*6, getHeight()*2);
		add(aaa);
		for (int i = 0; i < 7; i++)
		{
			// Your code starts here
			
			GOval circle =new GOval(-getWidth()/2,10+(i*10), getWidth()*2, getHeight()*2);
			add(circle);
			circle.setFilled(true);
			circle.setFillColor(rgen.nextColor());
			
			// Your code ends here
		}
		
		GOval circle =new GOval(-getWidth()/2,10+(7*10), getWidth()*2, getHeight()*2);
		add(circle);
		circle.setFilled(true);
		circle.setFillColor(Color.CYAN);
		
	}
	private RandomGenerator rgen = RandomGenerator.getInstance();
}