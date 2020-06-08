import acm.program.*;

public class TriangleTable extends ConsoleProgram {

	public void run() {
		// Your code starts here
		for (int n = 1; n <= MAX_VALUE; n++) {
			int total = 0;
			for (int i = 1; i <= n; i++) {
				if (i > 1) 	print(" + ");
				print(i);
				total += i;
			}
			println(" = " + total);
		}
		// Your code ends here
	}

	/* Private constants */
	private static final int MAX_VALUE = 10;

}
