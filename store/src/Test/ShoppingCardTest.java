package Test;

import shopping.ShoppingCart;
import store.Book;
import store.Ebook;
import store.HardCopy;



public class ShoppingCardTest {

	

	public static void main(String[] args) {
		
		ShoppingCart cart =new ShoppingCart();
		
		
		Book mete=new Book("mete",100,"1234567899");
		Book love=new Book("love",200,"1234567898");
		Book loveme=new Ebook("loveme",300,"1234567889",100,"pdf",10);
		Book loveyou=new HardCopy("loveyou",400,"1234567789",50,200);
		Book sen=new Book("sen",100,"0234567899");
		Book ben=new Book("ben",200,"0234567898");
		Book o=new Ebook("o",300,"0234567889",100,"pdf",10);
		Book biz=new HardCopy("biz",400,"0234567789",50,200);
		
		
		
		
		cart.addBook(mete);
		cart.addBook(love);
		cart.addBook(loveme);
		cart.addBook(loveyou);
		cart.addBook(sen);
		cart.addBook(ben);
		cart.addBook(o);
		cart.addBook(biz);
		
		System.out.println(cart);
		
	}
	
	
	

}
