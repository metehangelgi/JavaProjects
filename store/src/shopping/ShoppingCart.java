package shopping;

import store.Book;

public class ShoppingCart {

	private int numEntriesInCart;
	private int n=1;
	Book ShoppingCart[];

	public ShoppingCart() {
		this.ShoppingCart = new Book[10];
		this.numEntriesInCart = 0;
	}
	
	public Book[] getcontents() {
		return this.ShoppingCart;
	}

	

	public boolean addBook(Book book) {
		if (getNumEntriesInCart() < 10) {
			this.ShoppingCart[numEntriesInCart] = book;
			numEntriesInCart++;
			return true;

		} else {
			System.out.println("the list is full");
			return false;

		}
	}
	
	public boolean removeLastBook() {
		if(getNumEntriesInCart()>0) {
			this.ShoppingCart[getNumEntriesInCart()-1]=null;
			this.numEntriesInCart--;
			return true;
		} else {
			System.out.println("the cart is empty");
			return false;
		}
	}

	public int getNumEntriesInCart() {
		return this.numEntriesInCart;
	}

	
	public String toString() {
		String res = "==========================\n" + 
				"This cart has " + numEntriesInCart + " books. \n";
		
		double totalPrice = 0.0;
		double totalCost = 0.0;
		for (int i = 0; i < numEntriesInCart; i++) {
			res += ShoppingCart[i].toString() + "\n";
			totalPrice += ShoppingCart[i].getPrice();
			totalCost += ShoppingCart[i].getTotalCost();
		}
		res += "Total price of the books in the cart: " + totalPrice + "\n" +
			"Total cost of the books in the cart: " + totalCost + ". \n";
		return res;
	}
	
//	public String toString(){
//		String ans="===================/n"+"This cart has " + numEntriesInCart + " books. \n";
//		
//		double totalPrice=0.0;
//		double totalCost=0.0;
//		for(int i=0;i<numEntriesInCart;i++) {
//			ans+=ShoppingCart.toString() +"/n";
//			totalPrice=ShoppingCart[i].getPrice();
//			totalCost=ShoppingCart[i].getTotalCost();
//		}
//		ans+="Total price of the books in the cart: " + totalPrice + "\n" +
//				"Total cost of the books in the cart: " + totalCost + ". \n";
//		return ans;
//	}
	
	
	
}
