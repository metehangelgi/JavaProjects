import acm.program.*;

public class DigitSum extends ConsoleProgram{
	public void run() {
		// Your code starts here
			   println("This program sums the digits in an integer.");
			   int n = readInt("Enter a positive integer: ");
			   int dsum = 0;
			   while ( n > 0 ) {
			      dsum += n % 10;
			      n /= 10;
			   }
			   println("The sum of the digits is " + dsum);
			}

		
		// Your code ends here
	}


