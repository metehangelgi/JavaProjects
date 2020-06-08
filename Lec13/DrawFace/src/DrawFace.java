/*
 * File: DrawFace.java
 * -------------------
 * This program draws a face by defining a createFace method that
 * uses GCompound.
 */

import acm.graphics.*;
import acm.program.*;

public class DrawFace extends GraphicsProgram {

	public void run() {
        // Your code starts here
		GCompound face = createFace(FACE_WIDTH, FACE_HEIGHT);
		double x = (getWidth() - FACE_WIDTH) / 2;
		double y = (getHeight() - FACE_HEIGHT) / 2;
		add(face, x, y);
		println(face.getX()+" - " +face.getY());
		pause(1000);
		for(int i=0;i<10000;i++) {
			face.scale(0.5);
			println(face.getX()+" - " +face.getY());
			face.move(10, 10);
			face.movePolar(5, 45);
			pause(1000);
		}
        // Your code ends here
	}

	/** Construct a new GCompound face object with the specified width and height. */
	private GCompound createFace(double width, double height) {
		GCompound c = new GCompound();
		GOval head = new GOval(width, height);
		GOval leftEye = new GOval(EYE_WIDTH * width,  EYE_HEIGHT * height);
		GOval rightEye = new GOval(EYE_WIDTH * width, EYE_HEIGHT * height);
		GPolygon nose = createNosePolygon(NOSE_WIDTH * width, NOSE_HEIGHT * height);
		GRect mouth = new GRect(MOUTH_WIDTH * width, MOUTH_HEIGHT * height);
		c.add(head, 0, 0);
		c.add(leftEye, 0.25 * width - EYE_WIDTH * width / 2,
		             0.25 * height - EYE_HEIGHT * height / 2);
		c.add(rightEye, 0.75 * width - EYE_WIDTH * width / 2,
		              0.25 * height - EYE_HEIGHT * height / 2);
		c.add(nose, 0.50 * width, 0.50 * height);
		c.add(mouth, 0.50 * width - MOUTH_WIDTH * width / 2,
		           0.75 * height - MOUTH_HEIGHT * height / 2);
		
		return c;
	}

/* Creates a triangle for the nose */
	private GPolygon createNosePolygon(double width, double height) {
		GPolygon poly = new GPolygon();
		poly.addVertex(0, -height / 2);
		poly.addVertex(width / 2, height / 2);
		poly.addVertex(-width / 2, height / 2);
		return poly;
	}

/* Constants specifying feature size as a fraction of the head size */
	private static final double EYE_WIDTH    = 0.15;
	private static final double EYE_HEIGHT   = 0.15;
	private static final double NOSE_WIDTH   = 0.15;
	private static final double NOSE_HEIGHT  = 0.10;
	private static final double MOUTH_WIDTH  = 0.50;
	private static final double MOUTH_HEIGHT = 0.03;


/* Private constants */
	private static final double FACE_WIDTH = 200;   /* Width of the face  */
	private static final double FACE_HEIGHT = 300;  /* Height of the face */
}
