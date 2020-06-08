/*
 * File: Book.java
 * --------------------------
 */
import java.util.StringTokenizer;

import acm.program.*;

public class Book extends ConsoleProgram{

	/* instance data */
	private String title, author;
	private int id;

	/* constructors */
	public Book () {
		// Your code starts here
		title=author="unknown";
		id=0;
		// Your code ends here
	}

	public Book (String a, int id) {
		// Your code starts here
		title="unknown";
		author=a;
		this.id = id;
		// Your code ends here
	}

	public Book (String t, String a, int id) {
		// Your code starts here
		title=t;
		author=a;
		this.id = id;
		// Your code ends here
	}

	/* get methods */
	public String getTitle () {
		// Your code starts here
		return title;
		// Your code ends here
	}

	public String getAuthor () {
		// Your code starts here
		return author;
		// Your code ends here
	}

	public int getId () {
		// Your code starts here
		return id;
		// Your code ends here
	}

	/* set methods */
	public void setTitle (String t) {
		// Your code starts here
		title = t;
		// Your code ends here
	}

	public void setAuthor (String a) {
		// Your code starts here
		author = a;
		// Your code ends here
	}

	/* toString method that returns the current book object's information as a string,
	to be used to print book information */
	public String toString ( ) {
		// Your code starts here
		String S = "Book No: "+id;
		S = S+" entitled \""+title+"\"";
		//extract surname
		StringTokenizer tokenizer = new StringTokenizer(author);		
		String token="";
		while (tokenizer.hasMoreTokens()) {
			token = tokenizer.nextToken();   
		}		
		String surname = token;
		String initials = getInitials();	
		S = S+" written by "+initials+surname;
		return S;
		// Your code ends here
	}

	/* compareAuthor method that compare the current Book object's author surname with 
		a string argument */
	public boolean compareAuthor(String a) {		
		// Your code starts here
		boolean same = false;
		//extract surname
		StringTokenizer tokenizer = new StringTokenizer(author);		
		String token="";
		while (tokenizer.hasMoreTokens()) {
			token = tokenizer.nextToken();   
		}		
		String surname = token;
		if (surname.equals(a))
			same = true;
		return same;
		// Your code ends here
	}

	/*getInitials method that return the initials of the author
		assuming that there may be multiple names and a surname
		each seperated by a single blank */
	public String getInitials() {
		// Your code starts here
		StringTokenizer tokenizer = new StringTokenizer(author);		
		String S="";
		int nTokens = 0;
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();   
			S+=token.charAt(0)+". ";
			nTokens++;
		}		
		S = S.substring(0, 3*(nTokens-1));
		return S;
		// Your code ends here
	}
}
