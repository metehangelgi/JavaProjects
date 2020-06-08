package bank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class Read {
	
	String name;
	String id;
	int money;
	
	private static Scanner x;

	public static void read() {
		try {
			x=new Scanner(new File("bank.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
		for(int i=0;i<Test.num;i++) {
			String name=x.next();
			String id=x.next();
			int money=x.nextInt();
			System.out.println(name);
			System.out.println(money);
			Accounts person= new Accounts(name,id,money);
			System.out.println(person);
		}
		
		
		x.close();
		
		
		
		
		
		
	}

}
