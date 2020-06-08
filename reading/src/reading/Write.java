package reading;

import java.io.FileNotFoundException;
import java.util.Formatter;

public class Write {
	
	
	

	Formatter x;
	
	public void Open() {
		try {
			x=new Formatter("metehan.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	public void write(String name, String surname, int age) {
		x.format("%s%s%d%n", name,surname,age);
		
	}
	
	public void Close() {
		x.close();
	}
	

}
