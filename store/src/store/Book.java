package store;

public class Book {

	private String name;
	private double price;
	private String bookId;
	private double defaultPrice = 0;
	private String defaultBookId = "0000000000";

	public Book() {
		// Empty costructor
	}

	public Book(String name, double price, String bookId) {
		this.name = name;
		this.price = price;
		this.bookId = bookId;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price < 0) {
			this.price = defaultPrice;
		} else {
			this.price = price;
		}

	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		if (bookId.length() < 10) {
			this.bookId = defaultBookId;
		}

		for (int i = 0; i < bookId.length(); i++) {
			if (!Character.isDigit(bookId.charAt(i))) {
				this.bookId = defaultBookId;
				return; // Exit method
			}
		}
		
		// If I am here, all characters are digits
		this.bookId = bookId;	
	}

	public void applyDiscount(double discountPercentage) {
		price = price - price * discountPercentage;

	}

	public double getTotalCost() {
		// TODO Auto-generated method stub
		return this.price;
	}

//	public String toString() {
//		return String.format("name: %s%nprice: %f%nbookId: %s%n ", name, price, bookId);
//	}
	public String toString(){
		String res = "--------------------\n" + 
	        "Book name: " + this.getName() + "\n" +
			"Book price: " + String.valueOf(this.getPrice()) + "\n" + 
			"ISBN: " + this.getBookId() + "\n";
		return res;
	}

}
