import java.util.ArrayList;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;


public class CardGuessingGame extends ConsoleProgram{
	public void run(){
		ArrayList<Card> cardDeck = generateCardDeck();
		Card randomCard = cardDeck.get(rgen.nextInt(52));
		Card testCard = cardDeck.get(0);//spade 1
		
		println("Welcome to the card guessing game!\n");
		
		//Your code starts here
		while(true) {
			String cardType=readLine("Enter card Type");
			int value =readInt("Enter card number: ");
			Card myGuess=new Card(cardType,value);
			
			if(testCard.equals(myGuess)) {
				println("wonderfull you found it");
				 break;
			} else {
				println("bir dahaki sefere devam edelim mi?");
				
			}
		}
		//Your code ends here
		
	}
	
	/*
	 * Generates card deck which is an arrayList that holds all cards with all types and values.
	 * */
	public ArrayList<Card> generateCardDeck(){
		ArrayList<Card> deck = new ArrayList<Card>();
		
		String[] suits = new String[]{"spade", "heart", "diamond", "club"};
		for(String suit : suits){
			for(int i = 1; i <= 13; i++){
				deck.add(new Card(suit, i));
			}
		}
		
		return deck;
	}
	
	private static RandomGenerator rgen = RandomGenerator.getInstance();

}
