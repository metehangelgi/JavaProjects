/*
 * File: RightTriangle.java
 * -------------------
 * This file defines a simple class for representing right triangles.
 */

public class RightTriangle {
	private double a = 1;
	private double b = 1;

	public RightTriangle(double a, double b) {
		// Your code starts here
		setA(a);
		setB(b);
		// Your code ends here
	}

	private double hypotenuse() {
		// Your code starts here
		return Math.sqrt(getA()*getA()+getB()*getB());
		// Your code ends here
	}

	public double getA() {
		// Your code starts here
		return a;
		// Your code ends here
	}

	public void setA(double a) {
		// Your code starts here
		if(a<=0) 
			this.a=1;
		else {
			this.a=a;
		}
		// Your code ends here
	}

	public double getB() {
		// Your code starts here
		return b;
		// Your code ends here
	}

	public void setB(double b) {
		// Your code starts here
		if(b<=0) 
			this.b=1;
		else {
			this.b=b;
		}
		// Your code ends here
	}

	public double perimeter() {
		// Your code starts here
		return hypotenuse()+getA()+getB();
		// Your code ends here
	}

	public double area() {
		// Your code starts here
		return getA()*getB()*0.5;
		// Your code ends here
	}

}
