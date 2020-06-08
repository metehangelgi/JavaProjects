/*
 * File: CaesarCipher.java
 * -----------------------
 * This program translates a line of text into its Caesar cipher form.
 */

import acm.program.*;

public class CaesarCipher extends ConsoleProgram {

	public void run() {
		println("This program implements a Caesar cipher.");
		// Your code starts here
		int key = readInt("Character positions to shift: ");
		String plaintext = readLine("Enter a message: ");
		String ciphertext = encodeCaesarCipher(plaintext, key);
		println("Encoded message: " + ciphertext);
		String decrypted= decryptCipher(ciphertext,key);
		println("Decrypted message: " + decrypted);
		// Your code ends here
	}

	private String decryptCipher(String ciphertext, int key) {
		if (key < 0) key = 26 - (-key % 26);
		if (key>26) key = key%26;
		String result = "";
		for (int i = 0; i < ciphertext.length(); i++) {
			char ch = ciphertext.charAt(i);
			if (Character.isLetter(ch)) {
				if (Character.isUpperCase(ch)) {
					ch = (char) ('A' + (ch - 'A' - key) % 26);
				}
				else {
					ch = (char) ('a' + (ch - 'a' - key) % 26);
				}
			}
			result += ch;
		}
		// Your code ends here
		return result;
	}

	/*
	 * Encrypts a string by adding the value of key to each character.
	 * The first line makes sure that key is always positive by
	 * converting negative keys to the equivalent positive shift.
	 */
	private String encodeCaesarCipher(String str, int key) {
		if (key < 0) key = 26 - (-key % 26);
		if (key>26) key = key%26;
		String result = "";
		// Your code starts here
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if(Character.isLetter(ch)) {
				if(Character.isUpperCase(ch)) {
					ch=((char)('A'+((ch-'A')+key) %26));
				} else {
					ch=((char)('a'+((ch-'a')+key) %26));
				}
			}
			result+=ch;
		}
		/*
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (Character.isLetter(ch)) {
				if (Character.isUpperCase(ch)) {
					ch = (char) ('A' + (ch - 'A' + key) % 26);
				}
				else {
					ch = (char) ('a' + (ch - 'a' + key) % 26);
				}
			}
			result += ch;
		}
		*/
		
		// Your code ends here
		return result;
	}

}
