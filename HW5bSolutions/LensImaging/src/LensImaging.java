/*
 * File: LensImaging.java
 * ----------------------
 * This program illustrates how a convex lens casts an image.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class LensImaging extends GraphicsProgram {

	public void run() {
		this.resize(400,300);
		GPolygon lens = createLens(LENS_WIDTH, LENS_HEIGHT);
		add(lens, getWidth() / 2, getHeight() / 2);
		GImage objective = new GImage("Candle.gif");
		GImage image = flipVertical(objective);
		rescaleImage(objective, image, lens);
		addObjective(objective, lens);
		addImage(image, lens);
		double hObjective = objective.getHeight();
		double dy = hObjective / (N_RAYS - 1);
		for (int i = 0; i < N_RAYS; i++) {
			double y = hObjective / 2 - i * dy;
			addRay(lens, y);
		}
	}

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

	private void addObjective(GImage objective, GPolygon lens) {
		double x = lens.getX() + OBJECTIVE_DISTANCE + RAY_MARGIN;
		double y = lens.getY() - objective.getHeight() / 2;
		add(objective, x, y);
	}

	private void addImage(GImage image, GPolygon lens) {
		// Your code starts here
		double x = lens.getX() - IMAGE_DISTANCE - RAY_MARGIN - image.getWidth();
		double y = lens.getY() - image.getHeight() / 2;
		add(image, x, y);
		// Your code ends here
	}

	private void rescaleImage(GImage objective, GImage image, GPolygon lens) {
		// Your code starts here
		double f = FOCAL_LENGTH;
		double sf = IMAGE_DISTANCE / f - 1;
		image.scale(sf);
		// Your code ends here
	}

	private void addRay(GPolygon lens, double y) {
		// Your code starts here
		double x0 = lens.getX() + OBJECTIVE_DISTANCE;
		double y0 = lens.getY() + y;
		double x1 = lens.getX();
		double y1 = y0;
		double f = FOCAL_LENGTH;
		double x2 = lens.getX() - IMAGE_DISTANCE;
		double y2 = lens.getY() - (y * IMAGE_DISTANCE / f - y);
		GLine ray = new GLine(x0, y0, x1, y1);
		ray.setColor(Color.GRAY);
		add(ray);
		ray = new GLine(x1, y1, x2, y2);
		ray.setColor(Color.GRAY);
		add(ray);
		// Your code ends here
	}

	public GPolygon createLens(double width, double height) {
		GPolygon l = new GPolygon();
		double r = (height * height + width * width) / (4 * width);
		double theta = GMath.angle(r - width / 2, -height / 2);
		l.addVertex(0, height / 2);
		l.addArc(2 * r, 2 * r, -theta, 2 * theta);
		l.addArc(2 * r, 2 * r, 180 - theta, 2 * theta);
		l.setFilled(true);
		l.setFillColor(LENS_COLOR);
		return l;
	}


	/* Private constants */
	private static final double LENS_WIDTH = 35;
	private static final double LENS_HEIGHT = 120;
	private static final double FOCAL_LENGTH = 70;
	private static final double OBJECTIVE_DISTANCE = 120;
	private static final double IMAGE_DISTANCE = 120;
	private static final double RAY_MARGIN = 5;
	private static final double N_RAYS = 7;
	private static final Color LENS_COLOR = new Color(220, 220, 220);

}
