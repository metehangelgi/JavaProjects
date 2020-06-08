package validation;

public class Regex {

	
	public static boolean ValidateTelephone(String number) {
		return number.matches("\\d{11}");
	}
	public static boolean ValidateUserName(String name) {
		return name.matches("[a-z\\d]{5,12}");
	}
	public static boolean ValidatePassword(String password) {
		return password.matches("[a-z\\d]{5,12}");
	}
	
	public static boolean ValidateSlug(String slug) {
		return slug.matches("[a-z\\d-]{8,20}");
	}
	
	public static boolean ValidateEmail(String email) {
		return email.matches("([a-z\\d\\.-]+)@([a-z\\d-]+)\\.([a-z]{2,8})(\\.[a-z]{2,8})?");
	}
	
	
	
	
		
	
	
	

}
