import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Q4 {

	public Q4() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String fileName=new String("movies.txt");
		String line = null;
		FileReader fr;
		try {
			fr = new FileReader(fileName);
			BufferedReader rd=new BufferedReader(fr);
			 while((line = rd.readLine()) != null) {
	               line.concat(line);
	            }   

	            // Always close files.
	           rd.close(); 
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		StringTokenizer st = new StringTokenizer(line,"/");  
	     while (st.hasMoreTokens()) {  
	         System.out.println(st.nextToken());
	         
	     }
		
		
		
		
		
	}

}
