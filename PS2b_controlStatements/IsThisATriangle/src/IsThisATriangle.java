import acm.program.*;

public class IsThisATriangle extends ConsoleProgram {

	public void run() {
		// Your code starts here
		println("provide edges of triangle");
		
		int a=readInt ("side 1: ");
		int b=readInt ("side 2: ");
		int c=readInt ("side 3: ");
		
		
		if (a+b >=c || a+c<=b || b+c>=a ) {
			println("it is not a triangle");
		} else {
			println("it is a triangle");
			
		}
		
        // Your code ends here
	}
}
