

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class q2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	      System.out.println("Please enter a string:");
	      String input = scanner.nextLine();

	      // get search character
	      System.out.println("Please enter a character:");
	      char searchKey = scanner.next().charAt(0);

	      // display index of first occurrence
	      System.out.printf("\nFirst '%s' occurs at index %d\n", 
	         searchKey, indexOf(input, searchKey));
	   
	      // display index of last occurrence
	      System.out.printf("Last '%s' occurs at index %d\n", 
	         searchKey, lastIndexOf(input, searchKey));
		
		
		
	}
	
	 public static int lastIndexOf(String input, char search) {
	      // loop through the characters in reverse
	      for(int i = input.length() - 1; i>= 0; i--) {
	         if (input.charAt(i) == search) {
	            return i;
	         }
	      } 
	      return -1; // if we do not find it
	   }
	
	public static int indexOf(String input, char search) {
	      // loop through the characters
	      for(int i = 0; i <input.length(); i++) {
	         if (input.charAt(i) == search) {
	            return i;
	         }
	      } 	      
	      return -1; // if we do not find it
	   }

//	public static int indexOf (String input, char search) {
//		
//		String searchNew=Character.toString(search);
//		
//		
//		Pattern expression =Pattern.compile(searchNew);
//		
//		Matcher matcher=expression.matcher(input);
//		int counter=0;
//		while(matcher.find()) {
//			counter++;
//			matcher.group();
//		}
//		
//		
//		for(int i=0;i<input.length();i++) {
//			input.indexOf(i);
//			
//		}
//		
//		return counter;
//		
//	}
//	
//	public static int lastIndexOf (String input, char search) {
//		
//		String searchNew=Character.toString(search);
//		
//		
//		Pattern expression =Pattern.compile(searchNew);
//		
//		Matcher matcher=expression.matcher(input);
//		
//		while(matcher.find()) {
//			System.out.println(matcher.group());
//			
//		}
//		
//		return input.lastIndexOf(search);
//		
//	}
	
	
	
	
}
