import acm.program.*;
import acm.util.*;

/*
 * Test program for Complex Class
 * Creates two random complex numbers; randomly adds, subtracts or multiplies them and 
 * checks the correctness of the result
 */
public class ComplexCalculator extends ConsoleProgram {

	public void run() {

		double ar = rgen.nextDouble(0,100);
		double ai = rgen.nextDouble(0,100);
		Complex a = new Complex(ar,ai);

		double br = rgen.nextDouble(0,100);
		double bi = rgen.nextDouble(0,100);
		Complex b = new Complex(br,bi);		

		int operation = rgen.nextInt(0, 2);

		Complex result = new Complex(0);

		switch (operation) {
		case 0:
			result = a.add(b);
			print(a.toString() + " + " + b.toString() + " = " + result.toString());
			if (!checkSummation(result, new Complex(ar + br, ai + bi)))
				println(" (FAILED) ");
			else
				println(" (PASSED) ");

			break;
		case 1:
			result = a.subtract(b);
			print(a.toString() + " - " + b.toString() + " = " + result.toString());
			if (!checkSubtraction(result, new Complex(ar - br, ai - bi)))
				println(" (FAILED) ");
			else
				println(" (PASSED) ");
			break;
		case 2:
			result = a.multiply(b);
			print(a.toString() + " * " + b.toString() + " = " + result.toString());
			if (!checkMultiplication(result, new Complex(-ai * bi + ar * br, ar * bi + ai * br)))
				println(" (FAILED) ");
			else
				println(" (PASSED) ");
			break;
		default:
			break;
		}


	}

	private boolean checkSubtraction(Complex result, Complex expected) {

		if (result.equals(expected)){
			return true;
		}
		else {
			return false;
		}

	}

	private boolean checkSummation(Complex result, Complex expected) {

		if (result.equals(expected))
			return true;
		else {
			return false;
		}

	}

	private boolean checkMultiplication(Complex result, Complex expected) {

		if (result.equals(expected))
			return true;
		else {
			return false;
		}

	}

	private RandomGenerator rgen = RandomGenerator.getInstance();
}
