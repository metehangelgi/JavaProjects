/*
 * File: CreateGrayscale.java
 * --------------------------
 * This program converts a color image to grayscale.
 */

import acm.graphics.*;
import acm.program.*;

public class GrayScale extends GraphicsProgram {
	public void run() {
		setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
		GImage colorImage = new GImage("Candle.gif");
		GImage colorImage2 = new GImage("Vermeer.gif");
		GImage colorImage3 = new GImage("Ekran Resmi 2018-07-24 23.59.09.png");
		GImage grayscaleImage = createGrayscaleImage(colorImage3);
		//location of original one
		double xLeft = (getWidth() - 2 * colorImage3.getWidth()) / 3;
		//location of the changed one 
		double xRight = getWidth() - colorImage3.getWidth() - xLeft;
		//put in the middle 
		double y = (getHeight() - colorImage3.getHeight()) / 2;
		add(colorImage3, xLeft, y);
		add(grayscaleImage, xRight, y);
	}

	private GImage createGrayscaleImage(GImage image) {
		int[][] array = image.getPixelArray();
		// Your code starts here
		int height = array.length;
		   int width = array[0].length;
		   for (int i = 0; i < height; i++) {
		      for (int j = 0; j < width; j++) {
		         int pixel = array[i][j]; 
		         int r = GImage.getRed(pixel);
		         int g = GImage.getGreen(pixel);
		         int b = GImage.getBlue(pixel);
		         int xx = computeLuminosity(r, g, b);
		         array[i][j] = GImage.createRGBPixel(xx,xx,xx);
		      }
		   }
		   

		// Your code ends here
		return new GImage(array);
	}

	private int computeLuminosity(int r, int g, int b) {
		return GMath.round(0.299 * r + 0.587 * g + 0.114 * b);
	}

	/* Set the dimensions of the window */
	public static final int APPLICATION_WIDTH = 800;
	public static final int APPLICATION_HEIGHT = 475;

}
