
import java.awt.Color;

import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;


public class MovingBall extends GraphicsProgram {

	public void run() {
		setSize(500, 500);
		
		// Your code starts here
		double x=rgen.nextDouble(0,500);
		double y=rgen.nextDouble(0,500);
		double x2=rgen.nextDouble(x,500);
		double y2=rgen.nextDouble(y,500);
		GLine line=new GLine(x,y,x2,y2);
		add(line);
		
		GOval daire=createCircle();
		add(daire,x-daire.getWidth()/2,y-daire.getHeight()/2);
		
		
		double dx=(x2-x)/NUM_OF_STEPS;
		double dy=(y2-y)/NUM_OF_STEPS;
		while(daire.getX()<x2-daire.getWidth()/2) {
			daire.move(dx, dy);
			pause(PAUSE_TIME);
		}
		
		// Your code ends here
	}
	
	private GOval createCircle() {
		// Your code starts here
		GOval daire =new GOval(CIRCLE_RADIUS,CIRCLE_RADIUS);
		daire.setFillColor(CIRCLE_COLOR);
		daire.setFilled(true);
		return daire;
		// Your code ends here
	}
	
	/* Private constants */
	private static final Color CIRCLE_COLOR = Color.RED;
	private static final int CIRCLE_RADIUS = 15;
	private static final double NUM_OF_STEPS = 100;
	private static final double PAUSE_TIME = 10;
	
	private RandomGenerator rgen = RandomGenerator.getInstance();
}
