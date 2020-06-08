/* File: Quiz2 Question1

 */

import acm.program.*;

public class LeastCommonMultiple extends  ConsoleProgram {

	public void run() {
		// Your code starts here
		int a = readInt("a: ");
		int b = readInt("b: ");
		if(a == 0 || b == 0) println("a or b cannot be zero!");
		else println("LCM: "+(a*b)/gcd(a,b));
		// Your code ends here
	}

	/** Helper methods */
	// Your code starts here
	public int gcd(int a,int b){
		if(b == 0) return a;
		return gcd(b,a%b);
	}
	// Your code ends here

}
