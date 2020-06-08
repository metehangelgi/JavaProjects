import acm.program.*;
import acm.util.ErrorException;

import java.io.*;
import java.util.*;

public class SpellCheck extends ConsoleProgram {

    private final String dictionaryFile = "words";
    private HashMap<String,Boolean> dictionary;

    public void run() {
	println("Reading the dictionary file " + dictionaryFile);
	readDictionary();
	println("Read " + dictionary.size() + " words from the dictionary file.");
	while(true) {
	    String line = readLine("Please enter text: ");
	    if (line.equals("")) break;
	    spellCheck(line);
	}
	println("Bye.");
    }

    private void readDictionary() {
	dictionary = new HashMap<String, Boolean>();
	// put words from the dictionaryFile into the dictionary HashMap.
	// remember to surround file I/O with try and catch.
	try {
		BufferedReader rd =new BufferedReader(new FileReader(dictionaryFile));
		while(true) {
			String word=rd.readLine();
			if(word==null) break;
			dictionary.put(word, true);
		}
	} catch (IOException ex) {
		throw new ErrorException(ex);
	}
	// Your code starts here
	
	
	
	
//	try {
//	    BufferedReader rd = new BufferedReader(new FileReader(
//								  dictionaryFile));
//	    while (true) {
//		String word = rd.readLine();
//		if (word == null)
//		    break;
//		dictionary.put(word, true);
//	    }
//	} catch (Exception e) {
//	    println("Error: " + e);
//	}
	// Your code end here
    }

    private void spellCheck(String line) {
	StringTokenizer tokenizer = new StringTokenizer(line);
	// check each word and alert the user if it is not in the dictionary.
	while(tokenizer.hasMoreTokens()) {
		String token=tokenizer.nextToken();
		
		if(dictionary.get(token)==null) {
			println(token +"is misspelled");
			
		} else {
			println("no spelling incoorrect.");
		}
	}
	
	// Your code starts here
//	while (tokenizer.hasMoreTokens()) {
//	    String token = tokenizer.nextToken();
//	    if (dictionary.get(token) == null) {
//		println(token + " is misspelled.");
//	    }
//	}
	// Your code ends here
    }
}
