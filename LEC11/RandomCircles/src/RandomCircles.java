/*
 * File: RandomCircles.java
 * ------------------------
 * This program draws a set of 10 circles with different sizes,
 * positions, and colors.  Each circle has a randomly chosen
 * color, a randomly chosen radius within a specified range,
 * and a randomly chosen position on the canvas, subject to
 * the condition that the entire circle must fit inside the
 * canvas without extending past the edge.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class RandomCircles extends GraphicsProgram {

	public void run() {
		
		for (int i = 0; i < N_CIRCLES; i++) {
			
			
			double dr= rgen.nextDouble(MIN_RADIUS, MAX_RADIUS);
			double dx= rgen.nextDouble(0,getWidth()-dr*2);
			double dy= rgen.nextDouble(0, getHeight()-dr*2);
			/*
			GOval circle1= new GOval(dx,dy,dr*2,dr*2);
			circle1.setFilled(true);
			circle1.setFillColor(rgen.nextColor());
			add(circle1);
			
			*/
			
			
			
			GOval circle =createRandomCircle();
			add(circle);
			pause(500);
			if(i%3==1) {
				G3DRect rect=create3DRect();
				add(rect);
				rect.setVisible(true);
				pause(50);
			} else {
				G3DRect rect=create3DRect();
				add(rect);
				rect.setVisible(false);
			}
			
			
			println(circle.getX()+" "+circle.getY());
			
			circle.setBounds(dx, dy, dr*2, dr*2);
		}
		for(int i=0;i<10;i++) {
			setBackground(rgen.nextColor());
			pause(500);
		
		}
	}

	/*
	 * This method creates a circle with a randomly chosen radius,
	 * position, and color, subject to the conditions that the
	 * radius must fall between MIN_RADIUS and MAX_RADIUS and that
	 * the entire circle must be visible on the window.
	 */
	private GOval createRandomCircle() {
		// Your code starts here
		double dr= rgen.nextDouble(MIN_RADIUS, MAX_RADIUS);
		double dx= rgen.nextDouble(0,getWidth()-dr*2);
		double dy= rgen.nextDouble(0, getHeight()-dr*2);
		GOval circle= new GOval(dx,dy,dr*2,dr*2);
		circle.setFilled(true);
		circle.setFillColor(rgen.nextColor());

		
		// Your code ends here
		return circle;
	}
	
	private G3DRect create3DRect() {
		double dr= rgen.nextDouble(MIN_RADIUS, MAX_RADIUS);
		double dx= rgen.nextDouble(0,getWidth()-dr*2);
		double dy= rgen.nextDouble(0, getHeight()-dr*2);
		G3DRect graph =new G3DRect(dx,dy,dr*2,dr*2);
		graph.setFilled(true);
		graph.setFillColor(rgen.nextColor());
		graph.setBounds(dx, dy, dr, dr);
		return graph;
	}

	/* Private constants */
	private static final int N_CIRCLES = 5;
	private static final double MIN_RADIUS = 20;
	private static final double MAX_RADIUS = 125;

	/* Instance variable */
	private RandomGenerator rgen = RandomGenerator.getInstance();

}
