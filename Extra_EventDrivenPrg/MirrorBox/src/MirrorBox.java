import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;
//Copyright: Stanford University, CS106A,February 19, 2015
public class MirrorBox extends GraphicsProgram {
	/* The radius of each circle that should be drawn. */
	private static final double RADIUS = 5.0;
	public void run() {
		drawCenterLine();
		addMouseListeners();
	}
	private void drawCenterLine() {
		double centerX = getWidth() / 2.0;
		add(new GLine(centerX, 0, centerX, getHeight()));
	}
	public void mousePressed(MouseEvent e) {
		handleMouse(e.getX(), e.getY());
	}
	public void mouseDragged(MouseEvent e) {
		handleMouse(e.getX(), e.getY());
	}
	private void handleMouse(double x, double y) {
		drawCenteredCircle(x, y);
		drawCenteredCircle(getWidth() - x, y);
	}
	private void drawCenteredCircle(double x, double y) {
		GOval circle = new GOval(x-RADIUS, y-RADIUS, 2 * RADIUS, 2 * RADIUS);
		circle.setFilled(true);
		add(circle);
	}
}