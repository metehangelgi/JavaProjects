import java.util.*;
import java.io.*;
import acm.program.*;
import acm.util.RandomGenerator;

//This program reads even lines of a file and adds them to an ArrayList.
//Then it prints them out.

public class FileEvenLines extends ConsoleProgram {
	public void run() {
		// Your code starts here
		int count= 0;
		ArrayList<String> fileList = new ArrayList<String>();

		try {
			BufferedReader rd = new BufferedReader(new FileReader("BestPictures.txt"));
			while (true) {
				String line = rd.readLine();
				if (line == null) break;
				if(count%2==1)
					fileList.add(line);
				count++;
			}

		} catch (IOException e) {
			println("Could not read file");
			exit();
		} 
		int num=readInt("how many of them you want?");
		int counter=0;
		while(true) {
			int id=(rgen.nextInt(0,fileList.size()));
			String line=fileList.get(id);
			if(!printed.containsKey(id)) {
				println(line);
				printed.put(id, line);
				counter++;
				if(counter==num) break;
			} else {
				
			}
			
			
			
			
		}
		
		// Your code ends here
	}
	private RandomGenerator rgen = RandomGenerator.getInstance();
	private HashMap<Integer,String>  printed=new HashMap<Integer,String>();
}
