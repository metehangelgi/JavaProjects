import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

import acm.program.ConsoleProgram;
/**
 * Read from the file 'notes' the name and grades 
 * of students in a hashmap of key:string and value:array-list
 * 
 * Print on the console list of students and their top most 3 
 * grades.
 * @author barisbozkurt
 *
 */

public class StudentGradeTable extends ConsoleProgram{
	HashMap<String, ArrayList<Integer>> notes=new HashMap<String, ArrayList<Integer>>(); 
	ArrayList<String> lines=new ArrayList<String>();
	
	public void run(){
		readFileInList("notes");
		tokenizeLines();
		printTop3Scores();
	}
	
	private void readFileInList(String file){
		//Reading each line in the file in an ArrayList of Strings
		BufferedReader rd;
		try {
			rd = new BufferedReader(new FileReader(file));
			while(true){
				String line=rd.readLine();
				if(line==null){
					rd.close();break;
				}
				if(line.length()>0)
					lines.add(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void tokenizeLines(){
		//tokenize lines and put content to hashmap
		//its advisable to put sorted list of grades to the hashmap
		// Your code starts here
		
		
		
		for (String line : lines) {
			StringTokenizer tokens=new StringTokenizer(line);
			String name=tokens.nextToken();
			ArrayList<Integer> values=new ArrayList<Integer>();
			while(tokens.hasMoreTokens()){
				values.add(Integer.parseInt(tokens.nextToken()));
			}
			Collections.sort(values);
			notes.put(name, values);
		}
		// Your code ends here
	}
	private void printTop3Scores(){
		
		// Your code starts here
		for (String name : notes.keySet()) {
			ArrayList<Integer> valuesX=notes.get(name);
			print(name);
			for (int i = valuesX.size()-1; i > valuesX.size()-4; i--) {
				print("\t"+valuesX.get(i));
			}
			println();
		}
		
		
		
		
		
		
		
//		for (String name : notes.keySet()) {
//			ArrayList<Integer> tempValues=notes.get(name);
//			print(name);
//			for (int i = tempValues.size()-1; i > tempValues.size()-4; i--) {
//				print("\t"+tempValues.get(i));
//			}
//			println();
//		}
		// Your code ends here
	}
	
}
