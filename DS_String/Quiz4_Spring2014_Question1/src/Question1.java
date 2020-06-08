import acm.program.*;

public class Question1 extends ConsoleProgram {

	public void run() {
		// Your code starts here
		
		println("put exit(str1) for exit ");
		while(true) {
			String str1=readLine("s1> ");
			
			if(str1.equals("exit"))break;
			String str2=readLine("s2> ");
			println(str1);
			println(str2);
			println(compare(str1,str2));
			
		}
		exit();
		
		// Your code ends here
	}
	// Your code starts here
	private boolean compare(String str1,String str2) {
		
		boolean test=false;
		
			for(int i=0;i<str1.length();i++) {
				String str1a=str1.substring(0, i);	
				String str1b=str1.substring(i, str1.length());	
				str1=str1b+str1a;
				test=test(str1,str2);
				if(test==true) {
					break;
				}
			}
		return test;
		
		}
	
	
	
	
	private boolean test(String str1,String str2) {
		return str1.equals(str2);
	}
	
	
	
	
	
	
	// Your code ends here
}

