/*
 * File: RectangleArea.java
 * ---------------------
 * This program computes the area of a rectangle.
 * 
 * Class: RectangleArea.java
 * Score: (Simple)
 * Prerequisites: ACM Task Force Commands
 */

import acm.program.*;

public class RectangleArea extends ConsoleProgram {

	public void run() {
		println("This program computes the area of a rectangle");
		double height = readDouble("Please enter height of rectangle: ");
		double width = readDouble("Please enter width of rectangle: ");
		
		double area =width *height;
		
		println("The area of rectangle is:"+area);
		
		
	}

}
