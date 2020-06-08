/*
 * File: RevealTheMystery.java
 * ---------------------------
 * This program reveals the truth behind the mystery image.
 */

import acm.graphics.*;
import acm.program.*;

public class RevealTheMystery extends GraphicsProgram{
	public void run() {
		GImage mystery = new GImage("mystery.png");
		add(mystery,0 ,0);
		
		GImage trueImage = reveal(mystery);
		add(trueImage, mystery.getWidth() + 1, 0);
		
		resize((int)mystery.getWidth() * 2 + 1, (int)mystery.getHeight() + 22);
	}
	
	private GImage reveal(GImage image) {
		int[][] pixels = image.getPixelArray();
		// Your code start here
		
		for (int i = 0; i < pixels.length; i++)
			for (int j = 0; j < pixels[0].length; j++)
				pixels[i][j] = GImage.createRGBPixel(0, GImage.getGreen(pixels[i][j]) * 10, GImage.getBlue(pixels[i][j]) * 10);
		
		// Your code ends here
		return new GImage(pixels);
	}

}
