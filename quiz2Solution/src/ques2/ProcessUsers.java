package ques2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcessUsers {

	
	
	private static String emailRegExpr="\\s+[a-zA-Z][a-zA-Z0-9]*_?[a-zA-Z0-9]*@([A-Za-z0-9]+\\.)+[A-Za-z]{2,3}";
	private static String phoneRegExpr="(0|0\\s)?5[0-9]{2}\\s[0-9]{3}\\s?[0-9]{4}";
	
	public static void processUserFile(String inputFile,String outPutFile) {
		
		Pattern phoneExpr=Pattern.compile(phoneRegExpr);
		Pattern emailExpr= Pattern.compile(emailRegExpr);
		
		
		try(Scanner input=new Scanner(Paths.get("./src/ques2/"+inputFile));
			Formatter outPut=new Formatter("./src/ques2/"+outPutFile);
			){
			while(input.hasNext()) {
				String name=input.next();
				String lastName=input.next();
				String user=input.nextLine();
				outPut.format("%s %s: %n",name,lastName);
				System.out.println(user);
				Matcher matcherPhone=phoneExpr.matcher(user);
				Matcher matcherEmail=emailExpr.matcher(user);
				
				while(matcherPhone.find()) {
					outPut.format("     mobile phone: %s%n", matcherPhone.group());
					System.out.println(matcherPhone.group());
				}
				while(matcherEmail.find()) {
					outPut.format("      valid email: %s%n", matcherEmail.group());
					System.out.println(matcherEmail.group());
				}
				outPut.format("---------%n");
				
			}
			
			
		} catch(FileNotFoundException| NoSuchFileException e) {
			System.out.println(e+": File not found");
		}
		catch(IOException e) {
			System.err.println(e);
		}
		
		
		
		
	}
	
	
	
	
}
