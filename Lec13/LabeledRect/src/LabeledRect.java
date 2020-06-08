/*
 * File: LabeledRect.java
 * ------------------------------
 * This program creates a GCompound object that combines a rectangle with a label.
 */

import acm.program.*;
import acm.graphics.*;

public class LabeledRect extends GraphicsProgram {

	public void run() {
		
		
		/*
		GLine h1= new GLine(getWidth()/2,0,getWidth()/2,getHeight());
		add(h1);
		GLine h2 =new GLine(0,getHeight()/2,getWidth(),getHeight()/2);
		add(h2);
		h1.scale(1.5);
		h2.scale(0.1);
		GPoint p1 =h1.getStartPoint();
		println("point is"+ p1.getX() +" "+p1.getY());
		
		
		*/
		/*
		GRect rect1 = new GRect (50,50,60,60);
		add(rect1);
		pause(1000);
		rect1.scale(2);
		rect1.setSize(80, 50);
		GOval ov1 =new GOval(10,20,50,50);
		add(ov1);
		pause(1000);
		ov1.scale(0.5);
	*/
		
		
		GLabel l1= new GLabel ("Hello I am here ",50,50);
		l1.setFont("Times-BOLD-32");
		add(l1);
		println("your text is" +l1.getAscent());
		println("your text is" +l1.getDescent());
		println("your text is" +l1.getLabel());
		pause(1000);
		l1.setFont("Arial-BOLD-28");
		
		
		
		
		GCompound rect = createLabeledRect(getHeight()/2, 50, "hello");
		add(rect, 80, 50);
	}


	/** Creates a new GLabeledRect object */
	private GCompound createLabeledRect(double width, double height, String text) {
		GCompound c = new GCompound();
		// Your code starts here
		  GRect frame = new GRect(width, height);
	      c.add(frame);
	      GLabel label = new GLabel(text);
	      c.add(label);
	      pause(500);
	      double x = (frame.getWidth() - label.getWidth()) / 2;
	      double y = (frame.getHeight() + label.getAscent()) / 2;
	      label.setLocation(x, y);
		// Your code ends here
		return c;
	}

}

