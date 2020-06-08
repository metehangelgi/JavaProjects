package quiz2Sol;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcessUsers {

	private static String nameExpr="[A-Z][a-z]*";
	//private static String phoneExpr="(\\+90)?(0|0\\s)?5(0-9){2}(\\s)?(0-9){3}(\\s)?(0-9){2}(\\s)?(0-9){2}(\\s)?";
	private static String emailExpr="[A-Za-z]*_?-?.?[A-Za-z]*@[A-Za-z]*\\.com";
	
	private static String phoneExpr="(0|0\\s)?5[0-9]{2}\\s[0-9]{3}\\s?[0-9]{4}";
	
	
	public static void main(String[] args) {
		
		Pattern phonePat=Pattern.compile(phoneExpr);
		Pattern emailPat=Pattern.compile(emailExpr);
		Pattern NamePat=Pattern.compile(nameExpr);
		
	
		
		
		try(Scanner input=new Scanner(System.in);
		Formatter outPut=new Formatter("./src/quiz2Sol/mete");){
			
			String firstTest=input.nextLine();
			
			
			
			Matcher matchPhone=phonePat.matcher(firstTest);
			Matcher matchEmail=emailPat.matcher(firstTest);
			Matcher matchName=NamePat.matcher(firstTest);
			
			while(matchPhone.find()) {
				System.out.println(matchPhone.group());
				outPut.format("%s", matchPhone.group());
			}
			
			
			while(matchEmail.find()) {
				System.out.println(matchEmail.group());
				outPut.format("%s", matchEmail.group());
			}
				
			
			while(matchName.find()) {
				System.out.println(matchName.group());
				outPut.format("%s", matchName.group());
			}
				
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.printf(" \n\n yazma bitti artık alma zamanı\n \n ");
		try {
			Scanner getInput=new Scanner(Paths.get("./src/quiz2Sol/mete"));
			while(getInput.hasNext()) {
				
				String getString=getInput.nextLine();
				System.out.println(getString);
			}
			
			
			getInput.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	
	
}
