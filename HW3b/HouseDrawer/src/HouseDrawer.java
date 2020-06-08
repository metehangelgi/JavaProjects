/*
 * File: HouseDrawer.java
 * --------------------
 * This program draws a simple frame house.  This version updates the
 * exercise from Chapter 2 so that it uses named constants to define
 * the parameters of the  picture.
 * 
 * Class: HouseDrawer.java
 * Score: (Easy)
 * Prerequisites: ACM Task Force Graphics Commands
 */

import acm.graphics.*;
import acm.program.*;

public class HouseDrawer extends GraphicsProgram {

	public void run() {
		// Your code starts here
		GCompound ev=new GCompound();
		GRect kapi =new GRect(DOOR_WIDTH*WINDOW_Y_FRACTION,DOOR_HEIGHT*WINDOW_Y_FRACTION);
		GRect window=new GRect(WINDOW_SIZE*WINDOW_Y_FRACTION,WINDOW_SIZE*WINDOW_Y_FRACTION);
		GOval knob=new GOval(KNOB_RADIUS*KNOB_X_FRACTION,KNOB_RADIUS*KNOB_Y_FRACTION);
		GPolygon cati=new GPolygon();
		cati.addVertex(0, 0);
		cati.addEdge(HOUSE_WIDTH, 0);
		cati.addEdge(HOUSE_WIDTH, -ROOF_HEIGHT);
		
		
		// Your code ends here
	}

	//Variable Declarations
	private static final double HOUSE_WIDTH = 150;
	private static final double HOUSE_HEIGHT = 75;
	private static final double ROOF_HEIGHT = 35;
	private static final double DOOR_WIDTH = 30;
	private static final double DOOR_HEIGHT = 50;
	private static final double WINDOW_SIZE = 30;
	private static final double WINDOW_Y_FRACTION = 0.35;
	private static final double KNOB_RADIUS = 2.5;
	private static final double KNOB_X_FRACTION = 0.8;
	private static final double KNOB_Y_FRACTION = 0.5;

}
