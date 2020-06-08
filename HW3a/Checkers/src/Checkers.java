/*
 * File: Checkers.java
 * -------------------
 * This program expands on the Checkerboard program from
 * the text so that it centers the checkerboard in the
 * window and adds red and black checkers in the appropriate
 * starting configuration.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Checkers extends GraphicsProgram {

	public void run() {
		// Your code starts here
		GCompound satranc=new GCompound();
		double sqSize= (double)getHeight()/NROWS;
		
		for(int i=0;i<NROWS;i++) {
		for (int j = 0; j < NCOLUMNS; j++) {
			// Your code starts here
			double x = j*sqSize;
			double y = i*sqSize;
			GRect sq =new GRect (x,y,sqSize,sqSize);
			GOval red1=new GOval(getHeight()/NROWS*0.8,getHeight()/NROWS*0.8);
			satranc.add(sq);
			satranc.add(red1,x+((sqSize-getHeight()/NROWS*0.8)/2),y+(sqSize-getHeight()/NROWS*0.8)/2);
			red(satranc);
			add(satranc); 
			satranc.setLocation(getWidth()/2-satranc.getWidth()/2,0);
			sq.setFilled((i+j)%2!=0);
			sq.setFillColor(Color.BLACK);
			
			
			
			
			
		}
	}
		// Your code ends here
	}
	private void red(GCompound satranc) {
		GOval red1=new GOval(getHeight()/NROWS*0.8,getHeight()/NROWS*0.8);
		red1.setFillColor(Color.RED);
		red1.setFilled(true);
		satranc.add(red1);
		
	}
	private void black() {
		GOval black1=new GOval(getHeight()/NROWS*0.8,getHeight()/NROWS*0.8);
		black1.setFillColor(Color.BLACK);
		black1.setFilled(true);
		
	}

	/* Private constants */
	private static final int NROWS = 8;
	private static final int NCOLUMNS = 8;
	private static final double CHECKER_FRACTION = 0.8;

}
