package bank;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class Test implements Validate{
	static Formatter output;
	public static int num;

	public static void main(String[] args) {

		
		Scanner scan = new Scanner(System.in);
		System.out.println("How many accounts dou you want: ");

		String num2 = scan.nextLine();
		num = Integer.parseInt(num2);
		for (int i = 0; i < num; i++) {
			System.out.println("please enter a name: ");
			String name = scan.nextLine();
			System.out.println("please enter an Id with 3 number: ");
			String id = scan.nextLine();
			System.out.println("please enter money in this account: ");
			String money2 = scan.nextLine();
			int money = Integer.parseInt(money2);

			if (Validate.validMoney(money) != true) {
				System.out.println("please enter a valid money: ");
				money = scan.nextInt();
			}
			if (Validate.validName(name) != true) {
				System.out.println("please enter a valid name: ");
				name = scan.nextLine();
			}
			if (Validate.validId(id) != true) {
				System.out.println("please enter a valid with 3 number id: ");
				id = scan.nextLine();
			}
			Write.write(name, id, money);

		}
		

		Read.read();
		
	
	
	
	
	
	
	
	
	
	
	}

}
