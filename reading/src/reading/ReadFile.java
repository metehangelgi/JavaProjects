package reading;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {

	private Scanner x;
	
	public void close() {
		x.close();
	}
	
	
	public void openFile() throws FileNotFoundException {
		
		
			x=new Scanner (new File ("/Users/metehangelgi/eclipse-workspace/reading/metehan.txt"));
			
		
	} 
	public void Read() {
		while(x.hasNext()) {
			String a= x.next();
			String b=x.next();
			String C=x.next();
			int c=Integer.parseInt(C);
			a=a.concat(",");
			b=b.concat(",");
			
			
			
			System.out.printf("%s %s %d %n",a,b,c);
			String concat=a.concat(b).concat(C);
			concat.split(",\\s*");
			System.out.println(concat);
		}
	}
	
	
	//fileSystem
	//forward slash

}
