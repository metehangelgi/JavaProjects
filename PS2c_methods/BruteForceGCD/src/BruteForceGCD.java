/*
 * File: BruteForceGCD.java
 * ------------------------
 * This program uses a brute force approach to compute the
 * greatest common divisor of two integers.
 */

import acm.program.*;

public class BruteForceGCD extends ConsoleProgram {

	public void run() {
		println("This program computes the gcd of x and y.");
		int x = readInt("Enter x: ");
		int y = readInt("Enter y: ");
		println("gcd(" + x + ", " + y + ") = " + abd(x,y));
	}

//Implement the helper method gcd() here
	private int gcd(int x,int y) {
		int guess = Math.min(x,y);
		
		
		while(x % guess != 0 || y % guess !=0) {
			guess--;
		}
		return guess;
		
	
	}
	private double abd(int x,int y) {
		if(y == 0) return x;
		return abd(y,x%y);
	}
	
}
