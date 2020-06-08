/*
 * (**) Fill the method nStar that takes an integer N and an integer R,
 * then returns a GPolygon shaped as a star with N outer edges, and R is
 * the distance form GPolygon origin to an outer edge. Let distance to
 * the inner edges be R / 2. For example nStar called with N = 5 should
 * return a regular star of the Turkish flag.
 */

import acm.graphics.*;
import acm.program.*;

public class Stars extends GraphicsProgram{

	public void run() {
		double x = getWidth() / 2;
		double y = getHeight() / 2;
		GPolygon star5 = nStar(5, 20);
		add(star5, x, y);
		GPolygon star10 = nStar(10, 40);
		add(star10, x, y);
		GPolygon star20 = nStar(20, 80);
		add(star20, x, y);
	}

	private GPolygon nStar(int N, int R) {
		GPolygon star = new GPolygon();
		// Your code starts here
		double current_angle =60;
		double half_angle =(360.0/N)/2;
		for (int i = 0; i < N; i++) {
			double rad = Math.toRadians(current_angle);
			star.addVertex(R * Math.cos(rad), R * Math.sin(rad));
			current_angle += half_angle;
			rad = Math.toRadians(current_angle);
			star.addVertex((R / 2) * Math.cos(rad), (R / 2) * Math.sin(rad));
			current_angle += half_angle;
		}
		
		// Your code ends here
		return star;
	}
}
