/*
 * File: EmailValidation.java
 * -----------------------
 * This program takes an email address as input and validates it.
 */

import acm.program.*;

public class EmailValidation extends ConsoleProgram {

	public void run() {
		println("This program takes an email address as input and validates it.");
		// Your code starts here
		while(true) {
			String email=readLine("enter a valid email adress");
			if(email.length()==0) break;
			if(isValid(email)) {
				println("this email is valid");
			} else {
				println(" sorry this email is not valid");
			}
		}
		// Your code ends here
	}

	/*
	 * It should not contain whitespace.
	 * It should contain a '@' character.
	 * It should contain a '.' character.
	 * '@' and '.' should not be at the first position.
	 * There should be at least one character between '@' and '.'('.' should come after '@').
	 * There should be at least two characters after '.'.
	 */
	/** Checks whether an email address is valid */
	private boolean isValid(String email) {
		// Your code starts here
		int atpos= email.indexOf("@");
		int fdotpos=email.indexOf(".");
		int ldotpos=email.lastIndexOf(".");
		if(atpos <1 || fdotpos<1 || (ldotpos-atpos)<=1 || (email.length()-ldotpos)<=2
			||	email.contains(" ") || !email.contains("@") || !email.contains(".")) {
			return false;
		}
		// Your code ends here
		return true;
	}

}
