/*
 * (*) Use the createFace method you implemented and write a program that when
 * you press the left mouse button a randomly sized face appears and follows the
 * cursor as long as left button is not released. Once released the face
 * remains still.
 */


import acm.program.*;
import acm.graphics.*;
import acm.util.RandomGenerator;
import java.awt.event.MouseEvent;

public class GFaceFollows extends GraphicsProgram{


	public static void main(String[] args) {
		new GFaceFollows().start(args);
	}

	public void run() {
		
		addMouseListeners();
	}

	public void mousePressed(MouseEvent e) {
		// Your code starts here
		int width = rgen.nextInt(MINWIDTH, MAXWIDTH);
		int height = rgen.nextInt(MINHEIGHT, MAXHEIGHT);
		face = createFace(width, height);
		face.setLocation(e.getX() - face.getWidth() / 2, e.getY() - face.getHeight() / 2);	
		add(face);
		// Your code ends here
	}

	public void mouseDragged(MouseEvent e) {
		// Your code starts here
		face.setLocation(e.getX() - face.getWidth() / 2, e.getY() - face.getHeight() / 2);
		// Your code ends here
	}

	/** Construct a new GCompound face object with the specified width and height. */
	private GCompound createFace(double width, double height) {
		GCompound c = new GCompound();
		head = new GOval(width, height);
		leftEye = new GOval(EYE_WIDTH * width, EYE_HEIGHT * height);
		rightEye = new GOval(EYE_WIDTH * width, EYE_HEIGHT * height);
		nose = createNosePolygon(NOSE_WIDTH * width, NOSE_HEIGHT * height);
		mouth = new GRect(MOUTH_WIDTH * width, MOUTH_HEIGHT * height);
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

	/* Private instance variables */
	private GCompound face;
	private GOval head;
	private GOval leftEye, rightEye;
	private GPolygon nose;
	private GRect mouth;

	/* Private constants */
	private static final int MINWIDTH = 50;
	private static final int MAXWIDTH = 150;
	private static final int MINHEIGHT = 50;
	private static final int MAXHEIGHT = 150;

	/* Random number generator */
	private RandomGenerator rgen = RandomGenerator.getInstance();

}
