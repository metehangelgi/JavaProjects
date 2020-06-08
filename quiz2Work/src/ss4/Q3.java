package ss4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class Q3 {
	
	
	
	
public static void main(String[] args) {
	
	try(Formatter output=new Formatter("Metehan.txt")){
		
	 
	String[] article= {"the","a","one","some","that"};
	String[] noun= {"boy","girl","love","town","street","car","cat","table"};
	String[] verb= {"drove","jumped","ran","walked","skipped","loved","smiled","waved","hugged"};
	String [] preposition = {"to", "from", "over", "under","on"};
	String [] adverb = {"silently", "happily", "fast", "noisy", "foggy", "heavily"};
	Random random=new Random();
	StringBuilder song =  new StringBuilder();
	for (int i =0; i<20; i++) {
		StringBuilder line = new StringBuilder ();
		String firstWord = article[random.nextInt(article.length)];
		StringBuffer buffer = new StringBuffer(firstWord);
        buffer.setCharAt(0, Character.toUpperCase(firstWord.charAt(0)));
		line.append(buffer);
		line.append(" ");
		line.append(noun[random.nextInt(noun.length)]);
		line.append(" ");
		line.append(verb[random.nextInt(verb.length)]);
		line.append(" ");
		line.append(preposition[random.nextInt(preposition.length)]);
		line.append(" ");
		line.append(article[random.nextInt(article.length)]);
		line.append(" ");
		line.append(noun[random.nextInt(noun.length)]);
		line.append(" ");
		line.append(adverb[random.nextInt(adverb.length)]);
		line.append("\n");
		song.append(line);
		output.format("%s%n", line);
		if (i==8||i==18) {
			song.append(line);
			output.format("%s%n", line);
			i++;}
		if (i==9) {song.append("\n");
		output.format("\n");}
	}
	System.out.println(song);
	
	
	}
	catch(SecurityException | FileNotFoundException | FormatterClosedException e){
		e.printStackTrace();
        System.exit(1); // terminate the program
	}
	
	
	try(Scanner input = new Scanner(Paths.get("Metehan.txt"))) {
        System.out.printf("%n%s%n","poem from Metehan.txt");

        // read record from file
        while (input.hasNext()) { // while there is more to read
           // display record contents                     
           System.out.printf("%s%n",input.nextLine());          
        }       
     } 
     catch (IOException | NoSuchElementException | 
        IllegalStateException e) {
        e.printStackTrace();
     }
	
	
	
	
}






}
