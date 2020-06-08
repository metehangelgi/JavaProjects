import acm.program.*;

public class CylinderCalculator extends ConsoleProgram {

	/**
	 * Returns the perimeter of circle.
	 * 
	 * radius: Radius of the circle.
	 */
	public double circlePerimeter(double radius) {
		// Your code starts here
		return 2* pi()*radius;
		// Your code ends here
	}

	/**
	 * Returns the area of circle.
	 * 
	 * radius: Radius of the circle.
	 */
	public double circleArea(double radius) {
		// Your code starts here
		return pi()* radius *radius;
		// Your code ends here
	}

	/**
	 * Returns the area of the cylinder. 
	 * Reuse circlePerimeter and circleArea functions you have implemented.
	 * 
	 * radius: Radius of the cylinder base. 
	 * height: Height of the cylinder.
	 */
	public double area(double radius, double height) {
		// Your code starts here
		return circlePerimeter(radius) * height + 2*circleArea(radius);
		// Your code ends here
	}

	/**
	 * Returns the volume of the cylinder. 
	 * Reuse circleArea functions you have implemented.
	 * 
	 * radius: Radius of the cylinder base. 
	 * height: Height of the cylinder.
	 */
	public double volume(double radius, double height) {
		// Your code starts here
		return circleArea(radius) * height;
		// Your code ends here
	}

	// Don't change anything below this line.
	public double pi() {
		return Math.PI;
	}
	
	public void run() {
		double radius = readDouble("Base radius of cylinder: ");
		double height = readDouble("Height of cylinder: ");

		println("Area of cylinder: " + area(radius, height));
		println("Volume of cylinder: " + volume(radius, height));

	}
}
