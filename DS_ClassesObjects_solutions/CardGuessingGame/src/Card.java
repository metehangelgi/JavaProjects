/*
 * File: Card.java
 * -------------------
 * This file defines a simple class for representing a card 
 * with card type and card value
 */

public class Card {
	/* Private instance variables */
	private String cardType;
	private int value;
	
	/*
	 * Initializes intance with given card type and value
	 * */
	public Card(String cardType, int value){
		//Your code starts here
		this.cardType=cardType;
		this.value=value;
		//Your code ends here
	}
	
	/*
	 * Returns the type of card
	 * */
	public String getCardType(){
		//Your code starts here
		return cardType;
		//Your code ends here
	}
	
	/*
	 * Returns the value of card
	 * */
	public int getValue(){
		//Your code starts here
		return value;
		//Your code ends here
	}
	
	/*
	 * Checks given card equals current card
	 * If both cards are same type and have same value, this method must return true
	 * otherwise, this method must return false
	 * 
	 * */
	public boolean equals(Card other){
		//Your code starts here
		return this.getCardType().equals(other.getCardType()) && this.getValue()== other.getValue();
		//Your code ends here
	}

}
