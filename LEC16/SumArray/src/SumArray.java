/*
 * File: SumArray.java
 * ----------------------
 * This program generates N random numbers in range(1-10) and store them in an array.
 * Then prints the sum of the array with random numbers.
 */

import acm.program.*;
import acm.util.*;

public class SumArray extends ConsoleProgram {

	public void run(){
		int num1=readInt("please enter lower bound");
		int num2=readInt("please enter lower bound");
		
		int[] array=new int[num2-num1+1];
		for(int i=0;i<array.length;i++) {
			array[i]=11*(i+1);
		}
		print("[");
		for(int i=0;i<array.length;i++) {
			print(" "+array[i]);
		}
		print("]");
	}

	
	
	

	private RandomGenerator rgen = RandomGenerator.getInstance();
}
