/*
 * File: PasswordMaker.java
 * ---------------------
 * This program generates a password for the user.
 */

import acm.program.*;

/**
 * This class takes user's name and age and generates a password.
 */

public class PasswordMaker extends ConsoleProgram {

	/** Runs the program */
	public void run() {
		println("This program takes user's name and age and generates a password.");

		// Your code starts here
		String name=readLine("give your name");
		String surname=readLine("give your surname");
		int age=readInt("give your age ");
		Integer age1=readInt("give your age ");
		String password=name.substring(0, 2).toLowerCase()+surname.substring(0, 2).toLowerCase()+age;
		password+=age1.toString();
		
		println(password);
		// Your code ends here
	}
}

