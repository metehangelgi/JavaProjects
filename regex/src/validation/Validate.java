package validation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

	public Validate() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner =new Scanner(System.in);
		System.out.println("Telephone Number: ");
		String telephoneNumber=scanner.nextLine();
		System.out.println("please enter username: ");
		String userName=scanner.nextLine();
		System.out.println("please enter password: ");
		String password=scanner.nextLine();
		System.out.println("please enter Slug");
		String slug=scanner.nextLine();
		System.out.println("please enter email");
		String email=scanner.nextLine();
		
		
		System.out.println("\n results: ");
		
		StringBuffer user=new StringBuffer();
		
		
		try  {
			Regex.ValidateTelephone(telephoneNumber);
			System.out.println(Regex.ValidateTelephone(telephoneNumber));
			user.append(telephoneNumber);
			Regex.ValidateUserName(userName);
			user.append(userName);
			Regex.ValidatePassword(password);
			user.append(password);
			Regex.ValidateSlug(slug);
			System.out.println(Regex.ValidateSlug(slug));
			user.append(slug);
			Regex.ValidateEmail(email);
			user.append(email);
			System.out.println(user);
			
		} catch(Exception e) {
			System.out.println("there is a problem in your input. ");
		}
		
		
		Pattern expression =Pattern.compile("\\d{11}");
		
		Matcher matcher=expression.matcher(user);
		
		while(matcher.find()) {
			System.out.println(matcher.group());
		}
		
		
		
	}
	
	
	
	

}
