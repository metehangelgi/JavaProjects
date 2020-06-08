import java.util.*;

import acm.program.*;


public class CharFrequency extends ConsoleProgram {
	public void run(){
		String inStr = readLine("Please enter a string: ");
		println ( "The string is : " + inStr);
		// Your code starts here
		HashMap <Character, Integer> map = new HashMap <Character,Integer>();
		for(int i=0;i<inStr.length();i++) {
			char ch=inStr.charAt(i);
			
			if(Character.isLetter(ch)) {
				Character.toLowerCase(ch);
				if(map.get(ch)==null) {
					map.put(ch, 1);
				} else {
					map.put(ch, map.get(ch)+1);
				
			}
			}		
			
		}
		for(char key:map.keySet()) {
			println("the frequency of "+key+": "+map.get(key));
	}
		
		
//		HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
//		for(int i=0;i<inStr.length();i++){
//			char ch = inStr.charAt(i);
//			if (charMap.get(ch) == null)
//				charMap.put(ch, 1);
//			else 
//				charMap.put(ch, charMap.get(ch)+1);
//		}
//		for(Character key : charMap.keySet() ){
//			println("The frequency of character '"+key+"' is :" +charMap.get(key));
//		}
		// Your code ends here
	}
}