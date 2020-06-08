import acm.program.ConsoleProgram;
import acm.util.*;
import java.io.*;
import java.util.ArrayList;


public class Comp130_Quiz4_F18 extends ConsoleProgram{
	//instance variable;
	private final String inputFile = "input.txt";
	private final String outputFile = "output.txt";
	ArrayList<String> sentences = null; 	// stores the sentences in the file
	
	/* Additional Instance variables*/
	// Feel free to add additional instance variables
	// Your code starts here
	ArrayList<Character> chars = null;	//stores the chars provide by the user
	ArrayList<Integer> indexList = null;	//stores the index number of the chars found in the sentence
	PrintWriter wr= null;
	// Your code end here
	
	public void run(){
		// Your code starts here
		try {
			wr= new PrintWriter (new FileWriter(outputFile));
		}catch (IOException ex) {
			throw new ErrorException(ex);
		}
		
		readFile(); // read the input.txt file
		askUserInputAndFindChar(); // ask user input
		wr.close();
		// Your code end here
		
		
	}
	/**
	 * This method reads sentences from the input.txt file and 
	 * stores them in an array list.
	 */
	public void readFile () {
		sentences = new ArrayList<String>();
		// Your code starts here
		
		
		try {
			BufferedReader rd = new BufferedReader (new FileReader(inputFile));
			while (true) {
				String word = rd.readLine();
				if (word == null) break;
				sentences.add(word);			
			}
			rd.close();
		}catch (IOException ex) {
			throw new ErrorException(ex);
		}
		// Your code end here
	}
	/**
	 * This method asks the user to provide a set of characters that will be
	 * searched in the sentence.
	 * It finds the characters in the sentence if it exists and
	 * prints the index number of the character
	 */
	public void askUserInputAndFindChar () {
		chars = new ArrayList<Character>();
		char ch='a';
		// Your code starts here
		
		
		for (String sentence : sentences) {
			println(sentence);
			println("-----------------------------------------------------------");	
			wr.println(sentence);
			wr.println("-----------------------------------------------------------");	
			String line = readLine("Which character are you searching? ");
			//println("entered " + line);
;			while (!line.equals("")) {
				ch = line.charAt(0);
				chars.add(ch);
				line = readLine("Which character are you searching? ");
			}
	
			findCharacters(sentence);
			chars.clear();
		}
		// Your code end here
		
	}
	/**
	 * This method find the characters provided by the user in the
	 * sentence read from the input.tct
	 * @param st - sentence read from the input.txt
	 */
	public void findCharacters(String st){
		//Your code starts here
		//println("The sentence: "+ st);
		st=st.toLowerCase();
		indexList=new ArrayList<Integer>();
		for(int j=0; j<chars.size(); j++){
			for(int i=0;i<st.length();i++){
				if(st.charAt(i)==chars.get(j)) 
						indexList.add(i);
			}
			if(indexList.size()>0){
				println("The character '"+chars.get(j)+ "' is located in the indexes: "+indexList);
				wr.println("The character '"+chars.get(j)+ "' is located in the indexes: "+indexList);
			}else{
				println("The character '"+ chars.get(j)+ "' is not available in the sentence.");
			}	
			indexList.clear();
		}
		//Your code ends here
	}
}


