import acm.program.*;

import java.io.*;
import java.util.*;

public class BookStore extends ConsoleProgram {

    private HashMap<Integer,String> titles;
    private HashMap<Integer,String> authors;
    
    public void run() {
	// Read the book records form the file
	readBooks("books.txt");
	println("Read " + titles.size() + " book records from the file.\n");

	// Asks user repeatedly for a book id and then display the related information
	while(true) {
	    String line = readLine("Please enter a book id: ");
	    // Your code starts here
	  if(line==null) break;
	  int id=Integer.parseInt(line);
	  
	  if(!titles.containsKey(id)) println("are you joking");
	  else {
		  String title=titles.get(id);
		  String author=authors.get(id);
		  println("you are looking for: ");
		  println(title+" by "+author);
	  }
	  
	  
	    // Your code ends here
	}
	println("Bye.");
    }

    private void readBooks(String bookFile) {
	titles = new HashMap<Integer, String>();
	authors = new HashMap<Integer, String>();
	
	try {
		 BufferedReader rd = new BufferedReader(new FileReader(bookFile));
	    while (true) {
		String line = rd.readLine();
		if (line == null) break;
		StringTokenizer tokenizer = new StringTokenizer(line,"/");
		// Your code starts here
		String token=tokenizer.nextToken();
		int id=Integer.parseInt(token);
		String title=tokenizer.nextToken();
		titles.put(id, title);
		String author=tokenizer.nextToken();
		authors.put(id, author);
		// Your code ends here
	    }
	} catch (Exception e) {
	    println("Error: " + e);
	}
    }
}
