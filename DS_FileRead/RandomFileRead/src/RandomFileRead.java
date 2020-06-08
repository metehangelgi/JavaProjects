import java.util.*;
import java.io.*;
import acm.program.*;
import acm.util.RandomGenerator;

public class RandomFileRead extends ConsoleProgram {

	private RandomGenerator rgen = RandomGenerator.getInstance();
	private final String fileName = "BestPictures.txt";

	public void run() {
		// Your code starts here
		ArrayList<String> fileList =new  ArrayList<String>();
		
		try {
			BufferedReader rd= new BufferedReader (new FileReader(fileName));
			
			while(true) {
				String line=rd.readLine();
				if(line==null) break;
				fileList.add(line);
				
			}
			rd.close();
		} catch (IOException ex) {
			println("Couldn't read "+ fileName +"; "+ex );
		}
		
		for(int i=0;i<20;i++) {
			String metehan=((i+1)+ " : "+ fileList.get(rgen.nextInt(fileList.size()-1)));
			println(metehan);
//			PrintWriter wr = new PrintWriter(new FileWriter(banayaz.txt));
//			for (int i = 0; i < lines.size(); i++) {
//				wr.println(lines.get(i));
//			}
		}
		// Your code ends here
	}
}
