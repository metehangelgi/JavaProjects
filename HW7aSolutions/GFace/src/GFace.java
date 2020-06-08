import acm.graphics.*;

public class GFace extends GCompound{

	private static final double EYE_WIDTH    			= 0.15;
	private static final double EYE_HEIGHT   			= 0.15;
	private static final double LEFT_EYE_ORIGIN_WIDTH 	= 0.25;
	private static final double LEFT_EYE_ORIGIN_HEIGHT 	= 0.25;
	private static final double RIGHT_EYE_ORIGIN_WIDTH 	= 0.75;
	private static final double RIGHT_EYE_ORIGIN_HEIGHT	= 0.25;
	private static final double NOSE_WIDTH   			= 0.15;
	private static final double NOSE_HEIGHT  			= 0.10;
	private static final double NOSE_ORIGIN_WIDTH 		= 0.50;
	private static final double NOSE_ORIGIN_HEIGHT		= 0.50;
	private static final double MOUTH_WIDTH  			= 0.50;
	private static final double MOUTH_HEIGHT 			= 0.03;
	private static final double MOUTH_ORIGIN_WIDTH 		= 0.50;
	private static final double MOUTH_ORIGIN_HEIGHT		= 0.75;

	private GOval head;
	private GOval leftEye, rightEye;
	private GPolygon nose;
	private GRect mouth;

	public GFace(double width, double height) {
		// Your code starts here
		head = new GOval(width, height);
		leftEye = new GOval(EYE_WIDTH * width, EYE_HEIGHT * height);
		rightEye = new GOval(EYE_WIDTH * width, EYE_HEIGHT * height);
		nose = createNosePolygon(NOSE_WIDTH * width, NOSE_HEIGHT * height);
		mouth = new GRect(MOUTH_WIDTH * width, MOUTH_HEIGHT * height);
		add(head, 0, 0);
		add(leftEye, LEFT_EYE_ORIGIN_WIDTH * width - EYE_WIDTH * width / 2,
				LEFT_EYE_ORIGIN_HEIGHT * height - EYE_HEIGHT * height / 2);
		add(rightEye, RIGHT_EYE_ORIGIN_WIDTH * width - EYE_WIDTH * width / 2,
				RIGHT_EYE_ORIGIN_HEIGHT * height - EYE_HEIGHT * height / 2);
		add(nose, NOSE_ORIGIN_WIDTH * width, NOSE_ORIGIN_HEIGHT * height);
		add(mouth, MOUTH_ORIGIN_WIDTH * width - MOUTH_WIDTH * width / 2,
				MOUTH_ORIGIN_HEIGHT * height - MOUTH_HEIGHT * height / 2);
		// Your code ends here
	}

	private GPolygon createNosePolygon(double width, double height) {
		GPolygon poly = new GPolygon();
		// Your code starts here
		poly.addVertex(0, -height / 2);
		poly.addVertex(width / 2, height / 2);
		poly.addVertex(-width / 2, height / 2);
		// Your code ends here
		return poly;
	}
}
