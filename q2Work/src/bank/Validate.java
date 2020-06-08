package bank;

public interface Validate{

	
	public static boolean validName(String name) {
		return name.matches("[a-zA-Z]*");
	}
	public static boolean validId(String id) {
		return id.matches("[\\d]{3}");
	}
	public static boolean validMoney(int money) {
		if(money<0) return false;
		return true; 
	}

}
