import java.io.*;
import acm.program.*;

public class LongestLine extends  ConsoleProgram{
	public void run(){
		
		try {
			BufferedReader rd = new BufferedReader(new FileReader("line.txt"));
			int maxLength = 0;
			// Your code starts here
			while(true) {
				String line=rd.readLine();
				if(line==null) break;
				maxLength=Math.max(maxLength, line.length());
			}
			
			// Your code ends here
			println("Longest line has length of: " + maxLength);
		} catch (IOException e) {
			println("Got error: " + e);
		}
		
		
	}
}

//		try {
//			BufferedReader rd = new BufferedReader(new FileReader("line.txt"));
//			int maxLength = 0;
//			// Your code starts here
//			while (true) {
//				String line = rd.readLine();
//				if (line == null) break;
//				maxLength = Math.max(maxLength, line.length());
//			}
//			// Your code ends here
//			println("Longest line has length of: " + maxLength);
//		} catch (IOException e) {
//			println("Got error: " + e);
//		}
//	}
//}


