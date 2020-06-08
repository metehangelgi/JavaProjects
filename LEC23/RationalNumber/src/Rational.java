/*
 * File: Rational.java
 * -------------------
 * This file defines a simple class for representing rational numbers.
 */

/**
 * The Rational class is used to represent rational numbers, which
 * are defined to be the quotient of two integers.
 */
public class Rational {

	/* Private instance variables */

	private int num;	 /* The numerator of this Rational   */
	private int den;	 /* The denominator of this Rational */

	/**
	 * Creates a new Rational initialized to zero.
	 */
	public Rational() {
		// Your code starts here
		
		// Your code ends here
	}

	/**
	 * Creates a new Rational from the integer argument.
	 * @param n The initial value
	 */
	public Rational(int n) {
		// Your code starts here
		
		// Your code ends here
	}

	/**
	 * Creates a new Rational with the value x / y.
	 * @param x The numerator of the rational number
	 * @param y The denominator of the rational number
	 */
	public Rational(int x, int y) {
		// Your code starts here
		
		// Your code ends here
	}

	/**
	 * Adds the rational number r to this one and returns the sum.
	 * @param r The rational number to be added
	 * @return The sum of the current number and r
	 */
	public Rational add(Rational r) {
		// Your code starts here
		
		// Your code ends here
	}

	/**
	 * Subtracts the rational number r from this one.
	 * @param r The rational number to be subtracted
	 * @return The result of subtracting r from the current number
	 */
	public Rational subtract(Rational r) {
		// Your code starts here
		
		// Your code ends here
	}

	/**
	 * Multiplies this number by the rational number r.
	 * @param r The rational number used as a multiplier
	 * @return The result of multiplying the current number by r
	 */
	public Rational multiply(Rational r) {
		// Your code starts here
		
		// Your code ends here
	}

	/**
	 * Divides this number by the rational number r.
	 * @param r The rational number used as a divisor
	 * @return The result of dividing the current number by r
	 */
	public Rational divide(Rational r) {
		// Your code starts here
		
		// Your code ends here
	}

	/**
	 * Creates a string representation of this rational number.
	 * @return The string representation of this rational number
	 */
	public String toString() {
		if (den == 1) {
			return "" + num;
		} else {
			return num + "/" + den;
		}
	}

	/**
	 * Calculates the greatest common divisor using Euclid's algorithm.
	 * @param x First integer
	 * @param y Second integer
	 * @return The greatest common divisor of x and y
	 */
	private int gcd(int x, int y) {
		int r = x % y;
		while (r != 0) {
			x = y;
			y = r;
			r = x % y;
		}
		return y;
	}

}
