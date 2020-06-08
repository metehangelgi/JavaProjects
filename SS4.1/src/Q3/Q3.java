package Q3;
import java.util.ArrayList;
import java.util.Random; 

public class Q3 {
	
	
	
	int[] items= new int[5];
	String[] poemLines= new String[4];

	public static void main(String[] args) {
		Random rand = new Random(); 
		
		String [] article = {"the", "a", "one", "some", "that"};
		String [] noun = {"boy", "girl", "love", "town", "street", "car", "cat", "table"};
		String [] verb = {"drove", "jumped", "ran", "walked", "skipped", "loved", "smiled", "waved", "hugged"};
		String [] preposition = {"to", "from", "over", "under","on"};
		String [] adverb = {"silently", "happily", "fast", "noisy", "foggy", "heavily"};
		
		
		StringBuilder song=new StringBuilder();
		for(int i=0;i<20;i++) {
			StringBuilder line=new StringBuilder();
			String firstWord= article[rand.nextInt(article.length)];
			StringBuffer buffer= new StringBuffer(firstWord);
			buffer.setCharAt(0, Character.toUpperCase(firstWord.charAt(0)));
			line.append(" ");
			line.append(buffer);
			line.append(" ");
			line.append(noun[rand.nextInt(noun.length)]);
			line.append(" ");
			line.append(verb[rand.nextInt(verb.length)]);
			line.append(" ");
			line.append(preposition[rand.nextInt(preposition.length)]);
			line.append(" ");
			line.append(adverb[rand.nextInt(adverb.length)]);
			line.append(" ");
			line.append(noun[rand.nextInt(noun.length)]);
			line.append(" ");
			line.append(adverb[rand.nextInt(adverb.length)]);
			line.append("\n ");
			song.append(line);
			if (i==8||i==18) {
				song.append(line);
				i++;}
			if (i==9) {song.append("\n");
		}
			
			
		
		
		
		
		//article,noun,verb,prepositions,article,noun,adverb;
		
		
		

	}
		System.out.println(song);
	}
}
