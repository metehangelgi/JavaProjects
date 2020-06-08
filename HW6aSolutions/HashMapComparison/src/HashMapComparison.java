/*
 * File: HashMapComparison.java
 * ----------------------
 * This program finds the duplicates among two Hash-Maps.
 * abbreviation and state code of USA and Turkey is defined
 * The program constructs a hash-map of these data for
 * each country and performs the comparison among them.
 */

import acm.program.*;
import java.util.*;

/**
 * This program finds the duplicates among two Hash-Maps
 */
public class HashMapComparison extends ConsoleProgram {

	public void run() {
		HashMap<String,String> stateMap_us = new HashMap<String,String>();
		HashMap<String,String> stateMap_tr = new HashMap<String,String>();		
		for (int i = 0; i < STATE_CODES_TR.length; i++) {
			stateMap_tr.put(STATE_CODES_TR[i], STATE_NAMES_TR[i]);
		}
		for (int i = 0; i < STATE_CODES_US.length; i++) {
			stateMap_us.put(STATE_CODES_US[i], STATE_NAMES_US[i]);
		}
		printDuplicates(stateMap_tr,stateMap_us);
	}

	/* Lists the duplications */
	private void printDuplicates(HashMap<String,String> map1,HashMap<String,String> map2) {
		// Your code starts here
		for (String me : map1.keySet()) // assuming your map is Map<String, String>  
			if(map2.containsKey(me))  
				println("Found Duplicate -> " + me + " ("+map1.get(me)+","+map2.get(me)+")");  		
		// Your code ends here
	}

	/* Define the abbreviation and state arrays */
	private static final String[] STATE_CODES_US = {
		"AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DC", "DE",
		"FL", "GA", "HI", "IA", "ID", "IL", "IN", "KS", "KY",
		"LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT",
		"NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH",
		"OK", "OR", "PA", "PR", "RI", "SC", "SD", "TN", "TX",
		"UT", "VA", "VT", "WA", "WI", "WV", "WY"
	};

	private static final String[] STATE_CODES_TR = {
		"AD", "AI", "AF", "AG", "AM",
		"AN", "AT","AK","AR", "AV",
		"AY","BA","BR","BT","BY",
		"BI", "BN", "BT", "BO", "BU",
		"BS","CA", "CK", "CO", "DE", 
		"DI","DU","ED", "EL", "ER",
		"EZ","ES", "GA", "GI", 
		"GU","HA", "HY", "IP", "ME",
		"IG","IS", "IZ","KA","KR", "KS",
		"KM","KY","KI","KK", "KE", 
		"KH", "KO", "KN","KU", "MA", 
		"MN","KX","MA","MU","MS","NE", 
		"NI","OS", "OR", "RZ", "SA","SM","SI",
		"SP", "SV", "TE", "TO","TR","TU",
		"SU","SK","US","VA","YA","YO","ZO",
	};
	private static final String[] STATE_NAMES_US = {
		"Alaska", "Alabama", "Arkansas", "Arizona", "California",
		"Colorado", "Connecticut", "District of Columbia",
		"Delaware", "Florida", "Georgia", "Hawaii", "Iowa",
		"Idaho", "Illinois", "Indiana", "Kansas", "Kentucky",
		"Louisiana", "Massachusetts", "Maryland", "Maine",
		"Michigan", "Minnesota", "Missouri", "Mississippi",
		"Montana", "North Carolina", "North Dakota", "Nebraska",
		"New Hampshire", "New Jersey", "New Mexico", "Nevada",
		"New York", "Ohio", "Oklahoma", "Oregon", "Pennsylvania",
		"Puerto Rico", "Rhode Island", "South Carolina",
		"South Dakota", "Tennessee", "Texas", "Utah", "Virginia",
		"Vermont", "Washington", "Wisconsin", "West Virginia",
		"Wyoming"
	};
	private static final String[] STATE_NAMES_TR = {
		"Adana", "Adiyaman", "Afyon", "Agr�", "Amasya",
		"Ankara", "Antalya","Aksaray","Ardahan", "Artvin",
		"Aydin","Balikesir","Bartin","Batman","Bayburt",
		"Bilecik", "Bingol", "Bitlis", "Bolu", "Burdur",
		"Bursa","canakkale", "cankiri", "corum", "Denizli", 
		"Diyarbakir","Duzce","Edirne", "Elazig", "Erzincan",
		"Erzurum","Eskisehir", "Gaziantep", "Giresun", 
		"Gumushane","Hakkari", "Hatay", "Isparta", "Mersin",
		"Igdir","Istanbul", "Izmir","Karabuk","Karaman", "Kars",
		"Kastamonu","Kayseri","Kilis","Kirikkale", "Kirklareli", 
		"Kirsehir", "Kocaeli", "Konya","Kutahya", "Malatya", 
		"Manisa","Kahramanmaras","Mardin","Mugla","Mus","Nevsehir", 
		"Nigde","Osmaniye", "Ordu", "Rize", "Sakarya","Samsun","Siirt",
		"Sinop", "Sivas", "Tekirdag", "Tokat","Trabzon","Tunceli",
		"Sanliurfa","Sirnak","Usak","Van","Yalova","Yozgat","Zonguldak",
	};
}
