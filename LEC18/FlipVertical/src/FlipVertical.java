/*
 * File: FlipVertical.java
 * -----------------------
 * This program tests the flipVertical method from Chapter 11.
 */

import acm.graphics.*;
import acm.program.*;

/**
 * This class tests the flipVertical method.
 */
public class FlipVertical extends GraphicsProgram {

	public void run() {
		GImage original = new GImage("Candle.gif");
		GImage flipped = flipVertical(original);
		double xc = getWidth() / 2;
		double yc = getHeight() / 2;
		double x0 = xc - (original.getWidth() + flipped.getWidth() + IMAGE_SEP) / 2;
		double x1 = x0 + original.getWidth() + IMAGE_SEP;
		add(original, x0, yc - original.getHeight() / 2);
		add(flipped, x1, yc - flipped.getHeight() / 2);
		double xArrow = x1 - (ARROW_LENGTH + IMAGE_SEP) / 2;
		addArrow(xArrow, yc, xArrow + ARROW_LENGTH, yc);
	}

	/*
	 * Creates a new image which consists of the bits in the original
	 * flipped vertically around the center line.
	 */
	private GImage flipVertical(GImage image) {
		int[][] array = image.getPixelArray();
		// Your code starts here
		
			   int height = array.length;
			   for (int p1 = 0; p1 < height / 2; p1++) {
			      int p2 = height - p1 - 1;
			      int[] temp = array[p1];
			      array[p1] = array[p2];
			      array[p2] = temp;
			   }
			  

		// Your code ends here
		return new GImage(array);
	}

	/*
	 * Adds an arrow to the canvas connecting the points (x0, y0)
	 * and (x1, y1).
	 */
	private void addArrow(double x0, double y0, double x1, double y1) {
		add(new GLine(x0, y0, x1, y1));
		double theta = GMath.angle(x0, y0, x1, y1);
		addPolarLine(x1, y1, ARROWHEAD_SIZE, theta + 135);
		addPolarLine(x1, y1, ARROWHEAD_SIZE, theta - 135);
	}

	/*
	 * Adds a line segment that begins at the point (x, y) and then
	 * extends r pixels in direction theta.
	 */
	private void addPolarLine(double x, double y, double r, double theta) {
		double dx = r * GMath.cosDegrees(theta);
		double dy = -r * GMath.sinDegrees(theta);
		add(new GLine(x, y, x + dx, y + dy));
	}

	/* Private constants */
	private static final double IMAGE_SEP = 50;
	private static final double ARROWHEAD_SIZE = 8;
	private static final double ARROW_LENGTH = IMAGE_SEP / 2;

}
