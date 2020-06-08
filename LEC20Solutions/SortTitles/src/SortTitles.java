/*
 * File: SortTitles.java
 * ---------------------
 * This program sorts a file consisting of titles.
 */

import acm.program.*;
import acm.util.*;
import java.io.*;
import java.util.*;

public class SortTitles extends ConsoleProgram{ 

	public void run() {
		String inFileName = "BestPictures.orig";
		String outFileName = "BestPictures.txt";
		sortTitles(inFileName,outFileName);
		println("Finished");
	}

	/*
	 * Reads in the lines from the file, sorts them as titles, and then
	 * rewrites the file.  Hints:
	 * BufferedReader rd = new BufferedReader(new FileReader(fileName));
	 *   opens a file for reading with rd.readLine();
	 * PrintWriter wr = new PrintWriter(new FileWriter(fileName));
	 *   opens a file for writing with wr.println(str);
	 * Collections.sort(lines);
	 *   sorts an ArrayList.
	 */
	private void sortTitles(String inFileName,String outFileName) {
		// Your code starts here
		try {
			BufferedReader rd = new BufferedReader(new FileReader(inFileName));
			ArrayList<String> lines = readLineList(rd);
			Collections.sort(lines);
			Collections.reverse(lines);
			PrintWriter wr = new PrintWriter(new FileWriter(outFileName));
			for (int i = 0; i < lines.size(); i++) {
				wr.println(lines.get(i));
			}
			wr.close();
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
		// Your code ends here
	}

	/*
	 * Reads all the lines from the specified reader and returns an ArrayList<String>
	 * containing those lines.  The method closes the reader at the end of the file.
	 */
	private ArrayList<String> readLineList(BufferedReader rd) {
		ArrayList<String> list = new ArrayList<String>();
		// Your code starts here
		try {
			while(true) {
				String line=rd.readLine();
				if(line==null) break;
				list.add(line);
			}
			
			rd.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Your code ends here
		return list;
	}
}
