/*
 * File: ReduceImageSize.java
 * --------------------------
 * This program down-samples an image by two, hence reduces its size, by discarding one of every two pixels,
 * in both horizontal and vertical directions.
 */

import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

public class ReduceImageSize extends GraphicsProgram {
	public void run() {
		resize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
		setBackground(Color.GRAY);
		GImage originalImage = new GImage("coder.jpg");		
		//Your code starts here
		
		//Your code ends here
	}

	/* down-samples the input image by two */
	private GImage downSampleImage(GImage image) {		
		GImage sampledImage = null;		

		//Your code starts here
		
		//Your code ends here

		return sampledImage;

	}

	/* Set the dimensions of the window */
	public static final int APPLICATION_WIDTH = 800;
	public static final int APPLICATION_HEIGHT = 400;

}
