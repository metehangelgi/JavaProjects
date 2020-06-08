import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;



public class Q1 {

	
	
	
	
	
	
	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		Set<String> inputSet=new HashSet<String>();
		
		String inputString=input.nextLine();
		boolean checkDot=true;
		if(inputString.equals(".")) checkDot=false; 
		do {
			String[] words=inputString.split(" ");
			for (String oneWord : words) {
				
				
				if(inputSet.contains(oneWord)) {
					System.out.printf("Dublicate detected: %s\n",oneWord);
				} else {
					inputSet.add(oneWord);
				}
			}
			
			
			 inputString=input.nextLine();
			if(inputString.equals(".")) checkDot=false;
		}while(checkDot);
		
		
		System.out.printf("%d distinct words \n %s",inputSet.size(),inputSet);
		
	}
}
