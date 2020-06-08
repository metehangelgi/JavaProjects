import java.util.*;
import java.io.*;
import acm.program.*;
import acm.util.RandomGenerator;

public class RandomFileRead extends ConsoleProgram {

	private RandomGenerator rgen = RandomGenerator.getInstance();
	private final String fileName = "BestPictures.txt";

	public void run() {
		// Your code starts here
		ArrayList<String> fileList = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			while (true) {
				String line = reader.readLine();
				if (line == null) break;
				fileList.add(line);
			}
			reader.close();
		} catch (IOException e) {
			println("Could not read " + fileName);
			exit();
		} 

		int repeats = 10;

		for (int i = 0; i < repeats; i++) {
			println(i+1 + "\t: " +  fileList.get(rgen.nextInt(fileList.size() - 1)));
		}
		// Your code ends here
	}
}
