public class Circle {

	private double radius;
	
	public Circle(double radius){
		// Your code starts here
		setRadius(radius);
		// Your code ends here
	}
	
	public double getRadius() {
		// Your code starts here
		return radius;
		// Your code ends here
	}

	public void setRadius(double r) {
		// Your code starts here
		if (r > 0.0)
			this.radius = r;
		else
			this.radius = 1.0;
		// Your code ends here
	}


	public double perimeter() {
		// Your code starts here
		return 2 * Math.PI * getRadius();
		// Your code ends here
	}

	public double area() {
		// Your code starts here
		return Math.PI * getRadius() * getRadius();
		// Your code ends here
	}
}
