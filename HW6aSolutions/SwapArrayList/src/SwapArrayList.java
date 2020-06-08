/*
 * File: SwapArrayList.java
 * ----------------------
 * reverses the contents of an ArrayList. The program is 
 * supposed to fill the ArrayList with values from 0 
 * to a pre-defined constant and display the contents 
 * of the ArrayList. Then it should call a function which 
 * reverses the contents of this array list and displays it again. 
 */

import acm.program.*;
import java.util.*;

/**
 * This program reverses the contents of an arraylist
 */
public class SwapArrayList extends ConsoleProgram {

	public void run() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		//Add elements to Arraylist
		for(int i=0;i<SIZE;i++)
			arrayList.add(i);

		println("Before reversing, ArrayList contains : " + arrayList);
		reverse(arrayList);
		Collections.reverse(arrayList);
		println("After reversing, ArrayList contains : " + arrayList);

	}
	//this function does the swapping
	private void reverse(ArrayList<Integer> al) {
		// Your code starts here
		for(int i=0; i<(al.size()/2);i++) {
			Collections.swap(al, i, al.size()-i-1);
		}
		// Your code ends here
	}
	//the predefined constant for the size of the arraylist
	private static final int SIZE = 10;
}
