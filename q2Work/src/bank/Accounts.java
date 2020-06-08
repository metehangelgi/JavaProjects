package bank;

public class Accounts{
	String name;
	String id;
	int money;
	

	public Accounts() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Accounts(String name,String id,int money) {
		this.money=money;
		this.id=id;
		this.name=name;
	}
	
	
	public String toString() {
		String res=name+" ";
		res+=id+" ";
		res+=money+" ";
		return res;
	}
	
	

}
