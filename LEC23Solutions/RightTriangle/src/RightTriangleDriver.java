import acm.program.*;
import acm.util.*;

/*
 * Test for RightTriangle Class
 * Creates a number of random right triangles and displays the maximum area and perimeter
 */
public class RightTriangleDriver extends ConsoleProgram {

	public void run() {

		RandomGenerator rgen = RandomGenerator.getInstance();

		double maxArea = 0.0;
		double maxPerimeter = 0.0;

		for (int i = 0; i < 100000000; i++) {
			double a = rgen.nextDouble(0.0, 50.0);
			double b = rgen.nextDouble(0.0, 50.0);

			RightTriangle r = new RightTriangle(a, b);

			if (r.area() > maxArea) maxArea = r.area();
			if (r.perimeter() > maxPerimeter) maxPerimeter = r.perimeter();
		}

		println("Maximum area = "+ maxArea);
		println("Maximum perimeter = "+ maxPerimeter);

	}
}
