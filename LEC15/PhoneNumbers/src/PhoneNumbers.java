/*
 * File: PhoneNumbers.java
 * -----------------------
 * This program takes a phone number and extracts information from it.
 */

import acm.program.*;

public class PhoneNumbers extends ConsoleProgram {

	public void run() {
		// Your code starts here
		String ph=readLine("enter a number with country code:");
		int length=ph.length();
		String number =ph.substring(length-7, length);
		String areCode=ph.substring(length-10,length-7);
		String countCode =ph.substring(0,length-10);
		println(getCountryCode(countCode)+" " +areCode+" "+number);
		// Your code ends here
	}

	/** Returns country code for country calling code */
	private String getCountryCode(String countryCode) {

		if( countryCode.equals("+90") ) {
			return "TR";
		}
		else if( countryCode.equals("+1") ) {
			return "US";
		}
		else if( countryCode.equals("+44") ) {
			return "UK";
		}

		return "Unknown Country";
	}
}
