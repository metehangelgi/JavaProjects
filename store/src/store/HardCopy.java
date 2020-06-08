package store;

public class HardCopy extends Book {

	private double weight;
	private double shippingCost;
	private final double defaultWeight = 10;
	private final double defaultShippingCost = 100;

	public HardCopy() {
		// TODO Auto-generated constructor stub
	}

	public HardCopy(String name, double price, String bookId, double weight, double shippingCost) {
		super(name, price, bookId);
		this.weight = weight;
		this.shippingCost = shippingCost;
		// TODO Auto-generated constructor stub
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		if (weight < 0) {
			this.weight = defaultWeight;

		} else {
			this.weight = weight;
		}

	}

	public double getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(double shippingCost) {
		if (shippingCost < 0) {
			this.shippingCost = defaultShippingCost;
		} else {
			this.shippingCost = shippingCost;
		}

	}

	@Override
	public double getTotalCost() {
		return super.getTotalCost() + this.shippingCost;
	}

//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return String.format("%s%nweight: %f%nshippingCost: %f%n ", super.toString(), weight, shippingCost);
//	}
	@Override
	public String toString() {
		String res = super.toString() +
		    "Book weight: " + this.getWeight() + "\n" +
			"Book shipping cost: " + this.getShippingCost() + "\n";
		return res;
	}
}
