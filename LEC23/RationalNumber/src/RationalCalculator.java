import acm.program.*;

/*
 * Test for Rational Class
 */
public class RationalCalculator extends ConsoleProgram {

	public void run() {
		Rational a = new Rational(1, 2);
		Rational b = new Rational(3, 4);
		Rational c = new Rational(3, 6);

		Rational sum = a.add(b).add(c);
		println(a + " + " + b + " + " + c + " = " + sum);

	}

}
