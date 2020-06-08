/*
 * File: PostalLookup.java
 * --------------------------------
 * This program displays the name of a state given its two-letter postal abbreviation.
 */

import java.util.*;

import acm.program.*;

/**
 * This program finds the name corresponding to a two-letter
 * abbreviation of a state.
 */
public class PostalLookup extends ConsoleProgram {

	public void run() {
		HashMap<String,String> HashTable=new HashMap<String,String>();
		initStateMap(HashTable);
		while(true) {
			String code=readLine("please enter code of state");
			if(code.length()==0) {
				break;
				
			}
			
			String state=HashTable.get(code);
			if(state==null) {
				println(code+" is not avaible");
			} else {
				println(code+ " is "+state);
			}
		}
		exit();
			// Your code ends here
		}
	

	private void initStateMap(HashMap<String,String> map) {
		map.put("AL", "Alabama");
		map.put("AK", "Alaska");
		map.put("AZ", "Arizona");
		map.put("FL", "Florida");
		map.put("GA", "Georgia");
		map.put("HI", "Hawaii");
		map.put("WI", "Wisconsin");
		map.put("WY", "Wyoming");
	}

}