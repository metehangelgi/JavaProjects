/*
 * File: DrawTrain.java
 * --------------------
 * This program draws a three-car train consisting on an engine,
 * a boxcar, and a caboose.  Its primary purpose is to serve
 * as an illustration of stepwise refinement.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class DrawTrain extends GraphicsProgram {

	public void run() {
		for(int i=getWidth()/7;i<6*getWidth()/7;i+=getWidth()/7 ) {
		drawWheel(i,getHeight()-WHEEL_RADIUS*2);
		}
		GLine kesici=new GLine(getWidth()/7,getHeight()-WHEEL_RADIUS*1.5,6*getWidth()/7+(WHEEL_RADIUS*2),getHeight()-WHEEL_RADIUS*1.5);
		add(kesici);
	}

/* Draws an engine whose origin is at (x, y) */
	private void drawEngine(double x, double y) {

	}

/* Draws the smokestack */
	private void drawSmokestack(double x, double y) {

	}

/* Draws the engine cab */
	private void drawEngineCab(double x, double y) {

	}

/* Draws the cowcatcher in the front of the engine */
	private void drawCowcatcher(double x, double y) {

	}

/* Draws a boxcar in the specified color */
	private void drawBoxcar(double x, double y, Color color) {

	}

/* Draws a red caboose */
	private void drawCaboose(double x, double y) {

	}

/* Draws the common part of a train car */
	private void drawCarFrame(double x, double y, Color color) {

	}

/* Draws a wheel centered at (x, y) */
	private void drawWheel(double x, double y) {
		GOval wheel=new GOval(WHEEL_RADIUS,WHEEL_RADIUS);
			add(wheel,x,y);
			wheel.setFilled(true);
			wheel.setFillColor(Color.BLACK);
		
	}

/* Private constants */

/* Dimensions of the frame of a train car */
	private static final double CAR_WIDTH = 75;
	private static final double CAR_HEIGHT = 36;

/* Distance from the bottom of a train car to the track below it */
	private static final double CAR_BASELINE = 10;

/* Width of the connector, which overlaps between successive cars */
	private static final double CONNECTOR = 6;

/* Radius of the wheels on each car */
	private static final double WHEEL_RADIUS = 8;

/* Distance from the edge of the frame to the center of the wheel */
	private static final double WHEEL_INSET = 16;

/* Dimensions of the cab on the engine */
	private static final double CAB_WIDTH = 35;
	private static final double CAB_HEIGHT = 8;

/* Dimensions of the smokestack and its distance from the front */
	private static final double SMOKESTACK_WIDTH = 8;
	private static final double SMOKESTACK_HEIGHT = 8;
	private static final double SMOKESTACK_INSET = 8;

/* Dimensions of the door panels on the boxcar */
	private static final double DOOR_WIDTH = 18;
	private static final double DOOR_HEIGHT = 32;

/* Dimensions of the cupola on the caboose */
	private static final double CUPOLA_WIDTH = 35;
	private static final double CUPOLA_HEIGHT = 8;

}
