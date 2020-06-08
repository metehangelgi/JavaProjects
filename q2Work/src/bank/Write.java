package bank;

import java.io.FileNotFoundException;
import java.util.Formatter;


public class Write {
	static Formatter output;
	{
	
	

	
	
	
	
	

}
	
	public static void write(String name,String id,int money){
		try {
			 output = new Formatter("bank.txt");

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		output.format("%s %s %d %n", name, id, money);
		output.close();
	}
}

