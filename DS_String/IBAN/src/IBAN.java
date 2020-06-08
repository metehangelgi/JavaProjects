/*
 * File: IBAN.java
 * -----------------------
 * This program takes an IBAN and extracts information from it.
 */

import acm.program.*;

public class IBAN extends ConsoleProgram {

    public void run() {
	// Your code starts here
    	while(true ) {
    		
    		
    		String IBAN=readLine("Enter your Iban");
    		int length= IBAN.length();
    		if(length!=26) {
    			println("Invalid Iban");
    			IBAN=readLine("Enter your Iban");
    		}
    		String countryCode= IBAN.substring(0, 2);
    		if(countryCode.equals("TR")) {
    			println("Country Code: "+countryCode);
    		} else {
    			println("this is not turkish IBAN");
    			break;
    		}
    		String controlCode =IBAN.substring(2,4);
    		char a =controlCode.charAt(0);
    		char b =controlCode.charAt(1);
    		if(Character.isDigit(a) && Character.isDigit(b)) {
    			println("Control Code:"+ controlCode);
    			
    		} else {
    			println("this is not valid control code");
    			break;
    		}
    		String bankCode=IBAN.substring(4,9);
    		boolean check =true;
    		 char d;
    			 for(int x=0;x<bankCode.length();x++) {
    				 d=bankCode.charAt(x);
    				 if(!Character.isDigit(d)) {
    					 check =false;
    					 println("it is not bank code");
    					 
    					 break; 
    				 }
    			 }
    		if(check) {
    			println("Bank Code: "+ bankCode);
    		
    	}
	
    		String accountNumber =IBAN.substring(IBAN.length()-16);
    		 for(int x=0;x<accountNumber.length();x++) {
				 char c=accountNumber.charAt(x);
				 if(!Character.isDigit(c)) {
					 check =false;
					 println("it is not account number");
					 break; 
				 }
			 }
    		 if(check) {
    			 println("Account Number: "+ accountNumber);
    		 }
    // Your code ends here
	}
    }
}
