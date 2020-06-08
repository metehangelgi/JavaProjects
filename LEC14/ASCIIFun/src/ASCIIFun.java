/*
 * File: ASCIIFun.java
 * ---------------------
 * This program takes a string as input and prints ASCII code for each character.
 */

import acm.program.*;
import acm.util.RandomGenerator;

/**
 * This class takes a string as input and prints ASCII code for each character.
 */

public class ASCIIFun extends ConsoleProgram {

	/** Runs the program */
	public void run() {
		randomLetter();
		
		char newchar =randomDigit();
		if (isDigit(newchar)) {
			println("the fdghddh"+newchar);
		}
		
		println("This program takes a string as input and prints ASCII code for each character.");
		// Your code starts here
		
		char a1= '1';
		char a2= '2';
		int a3= (char)(a1+a2);
		
		
		println((char)(a1 +a2));
		println("number is: "+(char)a3);
		
		
		
		
		
		while (true) {
			String str = readLine("Enter a string: ");
			if (str.length() == 0) {
				println("end of program");
				break;
			}
			for( int i = 0; i < str.length(); i++ ) {
				char c = str.charAt(i);
				int n = (int)c;
				println("'"+c+"' : "+n);
			}
		}
		
		// Your code ends here
		
	}
	private char randomDigit() {
		// TODO Auto-generated method stub
		return (char) rgen.nextInt('1','9');
	}
	private boolean isDigit(char ch) {
		return (ch >='0' && ch<='9');
	}
	private char randomLetter() {
		String s= "A";
		String e ="Z";
		return (char)rgen.nextInt(s.charAt(0),e.charAt(0));
		
	}
	private  RandomGenerator rgen = RandomGenerator.getInstance();
}

