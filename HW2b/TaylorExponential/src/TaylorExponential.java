import acm.program.*;

public class TaylorExponential extends ConsoleProgram {

	private static final int N = 30;

	private double factorial(int n) {
		if (n <= 2) {
			if (n == 0) {
				return 1;
			} else {
				return n;
			}
		} else {
			double result = 1;
			for (int i = 2; i <= n; i++) {
				result *= i;
			}

			return result;

		}
	}

	private double pow(double x, int n) {
		double result = 1.;
		// Your code starts here
		for (int i = 0; i < n; i++) {
			result *= x;
		}
		
		// Your code ends here
		return result;
	}

	public void run() {
		double x = readDouble("x: ");

		double result = 1.0;

		// Your code starts here
		for(int n=1;n<N;n++) {
			result +=pow(x,n)/factorial(n);
		}

		// Your code ends here

		println("e^" + x + ": " + result);

	}

}

//   e^0/0!+e^1/1!+...