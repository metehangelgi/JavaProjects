/*
 * File: Acronym.java
 * -------------------
 * Example from the textbook section 8.4
 * This program prints the acronym for a text read from the user.
 */

import acm.program.ConsoleProgram;

public class Acronym extends ConsoleProgram{
	public void run(){
		String str=readLine("Input text including spaces: ");
		println("Acronym for that input is: "+acronym(str));
	}
	private String acronym(String str){
		String result=str.substring(0, 1);//get the first character
		// Your code starts here
		str=str.replace("of ", "");
		int ind=str.indexOf(" ");
		while(ind!=-1){
			result+=str.substring(ind+1, ind+2);
			ind=str.indexOf(" ", ind+1);
		}
		// Your code ends here
		return result.toUpperCase();
	}
}
