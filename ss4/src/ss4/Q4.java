package ss4;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Q4 {

	
	public static Set<String> actorSet;
	public static Map<String,Integer> movies;
	
	public static void main(String[] args) {
		actorSet=new HashSet<>();
		movies=new HashMap<>();
		String yearRegex="\\d{4}";
		String nameSurnameReg="\\/.*\\/";
		String movieNameReg=".*\\(";
		
		Pattern YearPattern=Pattern.compile(yearRegex);
		Pattern nameSurname=Pattern.compile(nameSurnameReg);
		Pattern movieName=Pattern.compile(movieNameReg);
		//Pattern namePattern=Pattern.compile("")
		
		
		
		try(Scanner input=new Scanner(Paths.get("./ss4.movies.txt"))) {
			String line;
			int year = 0;
			String NameOfMovie;
			
			
			
			while(input.hasNextLine()) {
				line=input.nextLine();
				
				Matcher YearMatcher=YearPattern.matcher(line);
				Matcher nameMatcher=nameSurname.matcher(line);
				Matcher movieMatcher=movieName.matcher(line);
				
				if(YearMatcher.find()) {
					year=Integer.parseInt(YearMatcher.group());
				}
				if(movieMatcher.find()) {
					NameOfMovie=movieMatcher.group();
					movies.put(NameOfMovie, year);
				}
				while(nameMatcher.find()) {
					String temp=nameMatcher.group();
					
					
					//Matcher nameMatcher=
				}
				
				
				
				
				
			}
					
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
