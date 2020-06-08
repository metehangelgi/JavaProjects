public class Complex {
	private double real;
	private double imaginary;

	public Complex(double real) {
		// Your code starts here
		this(real, 0);
		// Your code ends here
	}

	public Complex(double real, double imaginary) {
		// Your code starts here
		this.real = real;
		this.imaginary = imaginary;
		// Your code ends here
	}

	public double getReal() {
		// Your code starts here
		return real;
		// Your code ends here
	}

	public double getImaginary() {
		// Your code starts here
		return imaginary;
		// Your code ends here
	}

	public boolean equals(Complex c) {
		// Your code starts here
		if (c.getImaginary() == imaginary && c.getReal() == real)
			return true;
		else
			return false;
		// Your code ends here
	}

	public Complex add(Complex b) {
		// Your code starts here
		return new Complex(this.real + b.getReal(), this.imaginary
				+ b.getImaginary());
		// Your code ends here
	}

	public Complex subtract(Complex b) {
		// Your code starts here
		return new Complex(this.real - b.getReal(), this.imaginary
				- b.getImaginary());
		// Your code ends here
	}

	public Complex multiply(Complex b) {
		// Your code starts here
		return new Complex(this.getReal() * b.getReal() - this.getImaginary()
				* b.getImaginary(), this.getReal() * b.getImaginary()
				+ this.getImaginary() * b.getReal());
		// Your code ends here
	}

	public String toString() {
		if (imaginary > 0)
			return "(" + real + "+" + imaginary + "i)";
		else if (imaginary < 0)
			return "(" + real + "-" + imaginary + "i)";
		else
			return real + "";
	}
}
