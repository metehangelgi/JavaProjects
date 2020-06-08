package ss4;

public class Q2 {

	public static void main(String[] args) {
		try{
			SomeMethod();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
 public static void SomeMethod() throws Exception {
	 
	 try {
		 SomeMethod2();
	 } catch(Exception exception) {
		 throw exception;
	 }
	 
	 
	 
 }
 public static void SomeMethod2() throws Exception  {
	 throw new Exception();
 }
}
