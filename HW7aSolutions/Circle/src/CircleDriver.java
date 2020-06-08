import acm.program.*;
import acm.util.*;

/*
 * Test program for Circle class
 * Creates randomly a number of Circle objects and displays minimum area and perimeter
 */
public class CircleDriver extends ConsoleProgram {

	public void run() {

		double minArea = 10000.0; // set maximum possible area
		double minPerimeter = 10000.0;

		double minRadius = 0.0;

		for (int i = 0; i < 2000000; i++) {
			double r = rgen.nextDouble(0.0, 50.0);

			Circle c = new Circle(r);

			if (c.area() < minArea) {
				minArea = c.area();
				minRadius = c.getRadius();
			}
			if (c.perimeter() < minPerimeter) 
				minPerimeter = c.perimeter();

		}

		println("Minimum area = "+ minArea + " with radius " + minRadius);
		println("Minimum perimeter = "+ minPerimeter);

	}

	private RandomGenerator rgen = RandomGenerator.getInstance();

}
