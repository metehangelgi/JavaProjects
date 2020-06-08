/*
 * File: WordCount.java
 * ----------------------------
 * Read input.txt and print each line preceded by its word count.
 */

import acm.program.*;
import java.io.*;
import java.util.*;

public class WordCount extends ConsoleProgram {

	private static final String fileName = "input.txt";

	public void run() {
		// Your code starts here
		try {
			BufferedReader rd = new BufferedReader(new FileReader(fileName));
			while (true) {
				String line = rd.readLine();
				if (line == null) break;
				int nword=countWords(line);
				println(nword + " " + line);
			}
			rd.close();
		} catch (Exception ex) {
			println("Got error: " + ex);
		}
		
		
//		try {
//			BufferedReader rd = new BufferedReader(new FileReader(fileName));
//			while (true) {
//				String line = rd.readLine();
//				if (line == null) break;
//				int nword = countWords(line);
//				println(nword + " " + line);
//			}
//			rd.close();
//		} catch (Exception ex) {
//			println("Got error: " + ex);
//		}
		// Your code ends here
	}

	/** countWords(str) returns the number of words in the string str. */
	/* Hint: use StringTokenizer */
	private int countWords(String str) {
		int answer = 0;
		// Your code starts here
	StringTokenizer tok =new StringTokenizer(str);
	while(tok.hasMoreTokens()) {
		tok.nextToken();
		answer++;
	}
		// Your code ends here
		return answer;
	}
}

