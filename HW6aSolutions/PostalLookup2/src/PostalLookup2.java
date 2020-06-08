/*
 * File: PostalLookup2.java
 * --------------------------------
 * This program displays the two-letter abbreviation corresponding to the name of a state.
 */

import java.util.*;

import acm.program.*;

public class PostalLookup2 extends ConsoleProgram {

	public void run() {
		HashMap<String,String> stateMap = new HashMap<String,String>();
		initStateMap(stateMap);
		while (true) {
			String name = readLine("Enter the name of a state: ");
			// Your code starts here
			if (name.length() == 0) break;
			String code = stateMap.get(name);
			if (code == null) {
				println(name + " is not a known state");
			} else {
				println(name + " is " + code);
			}
			// Your code ends here
		}
	}

	private void initStateMap(HashMap<String,String> map) {
		map.put("Alabama","AL");
		map.put("Alaska","AK");
		map.put("Arizona","AZ");
		map.put("Florida","FL");
		map.put("Georgia","GA");
		map.put("Hawaii","HI");
		map.put("Wisconsin","WI");
		map.put("Wyoming","WY");
	}

}