import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

public class WordLenCipher extends ConsoleProgram{
	public void run(){
		//encoder();if you like, you can try to implement also the encoder
		
		encoder();
		decoder();
		
		println("End of program");

	}
	// Your code starts here
	private String reverseString(String inStr){
		String reversed="";
		for (int i = 0; i < inStr.length(); i++) {
			reversed=inStr.charAt(i)+reversed;
		}
		return reversed;
	}
	private String addWordLen(String inStr){
		String coded="";
		for (int i = 0; i < inStr.length(); i++) {
			coded+=(char)(inStr.charAt(i)+inStr.length());
		}
		return coded;
	}
	private String subtractWordLen(String inStr){
		String coded="";
		for (int i = 0; i < inStr.length(); i++) {
			coded+=(char)(inStr.charAt(i)-inStr.length());
		}
		return coded;
	}
	private void encoder(){
		BufferedReader rd;
		PrintWriter wr;
		try {
			rd = new BufferedReader(new FileReader("original"));
			wr = new PrintWriter(new FileWriter("encoded"));
			while(true){
				String line=rd.readLine();
				if(line==null){
					rd.close();
					wr.close();
					break;
				}
				
				StringTokenizer st=new StringTokenizer(line);
				while(st.hasMoreTokens()){
					String word=st.nextToken();
					word=word.replace(".", "");//removing the . from the word
					wr.print(addWordLen(reverseString(word)));
					if(st.hasMoreTokens())
						wr.print(" ");
				}
				wr.println(".");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void decoder(){
		BufferedReader rd;
		PrintWriter wr;
		try {
			rd = new BufferedReader(new FileReader("encoded"));
			wr = new PrintWriter(new FileWriter("decoded"));
			while(true){
				String line=rd.readLine();
				if(line==null){
					rd.close();
					wr.close();
					break;
				}
				StringTokenizer st=new StringTokenizer(line);
				while(st.hasMoreTokens()){
					String word=st.nextToken();
					word=word.replace(".", "");//removing the . from the word
					wr.print(subtractWordLen(reverseString(word)));
					if(st.hasMoreTokens())
						wr.print(" ");
				}
				wr.println(".");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// Your code ends here
}
