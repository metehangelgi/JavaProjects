/*
 * File: ColorNegative.java
 * ------------------------
 * This program creates a color negative.
 */

import acm.graphics.*;
import acm.program.*;

/**
 * This class tests the colorNegative method, which creates a
 * negative of a color image.
 */
public class ColorNegative extends GraphicsProgram {

	public void run() {
		GImage original = new GImage("StarryNight.gif");
		GImage image = colorNegative(original);
		add(original, 0, 0);
		
		add(image, original.getWidth() + 10, 0);
	}

	/*
	 * Creates a negative of a color image.  Each pixel in the new
	 * image is recomputed so that the red, green, and blue components
	 * are inverted in intensity.  More specifically, if the old value
	 * of one of the pixel components is x, the new value will be
	 * 256 - x.
	 */
	private GImage colorNegative(GImage image) {
		
		int[][] pixels = image.getPixelArray();
		// Your code starts here
		int height = pixels.length;
		int width = pixels[0].length;
		resize(2*width+10,height);
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {				
				pixels[i][j] = invertPixel(pixels[i][j]);			
			}
		}
		// Your code ends here
		return new GImage(pixels);
	}

	/* Inverts a single pixel value */
	private int invertPixel(int pixel) {
		int answer = 0;
		// Your code starts here
		int red = GImage.getRed(pixel);
		int green = GImage.getGreen(pixel);
		int blue = GImage.getBlue(pixel);		
		answer = GImage.createRGBPixel(256-red, 256-green, 256-blue);
		// Your code ends here
		return answer;		
	}

}
