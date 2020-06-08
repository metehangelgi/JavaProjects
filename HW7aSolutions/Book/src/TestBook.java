/*
 * File: TestBook.java
 * --------------------------
 */
import java.util.*;
import acm.program.*;


public class TestBook extends ConsoleProgram{

	public void run(){

		/*get number of books to enter*/
		int numOfRecords = readInt("Enter the number of books: ");

		/*create Book array*/
		Book[] bookList= new Book[numOfRecords];
		
		String title, author;

		/*get title and author information*/
		for (int i=0;i<numOfRecords;i++){

			title = readLine("Type the title of the book: ");
			author = readLine("Type the name of the author: ");

			if (title.equals("")){
				bookList[i] = new Book(author, i);
			}
			else{
				bookList[i] = new Book(title, author, i);
			}
		}

		println("To end the search process bypass the question by typing the enter key!");

		/*ask repeatedly for an author name and display all the books by that author*/
		author = readLine("Enter the author's name to search: ");

		/*ask for a new author until user enters an empty string*/
		while (!author.equals("")){
			// Your code starts here
			/*split the author string so as to extract the surname*/
			StringTokenizer tokenizer = new StringTokenizer(author);

			String token="";
			while (tokenizer.hasMoreTokens()) {
				token = tokenizer.nextToken();   
			}

			String surname = token;

			/*compare the author with every book object's author*/
			int numberOfRecordsFound = 0;
			for (int i=0;i<numOfRecords;i++){
				if (bookList[i].compareAuthor(surname)){
					println(bookList[i].toString());
					numberOfRecordsFound++;
				}
			}

			if (numberOfRecordsFound==0)
				println("No records found...");
			// Your code ends here
			author = readLine("Enter the author's name to search: ");		
		}

		print("exiting...");
	}
}
