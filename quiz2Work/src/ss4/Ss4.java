package ss4;

public class Ss4 {

	public static void main(String[] args) {
		
		try { // throw ExceptionC 
	         throw new ExceptionC();
	      } 
	      catch (ExceptionA exception1) { // catch ExceptionA and subclasses 
	         System.err.println("First Exception subclass caught. \n");
	      } 
	      
	      try { // throw ExceptionB 
	         throw new ExceptionB();
	      }
	      catch (ExceptionA exception2) { // catch ExceptionA and subclasses 
	         System.err.println("Second Exception subclass caught. \n");
	      } 
	}
	
	
	class ExceptionA extends Exception{
		
	}
	class ExceptionB extends ExceptionA{
		
	}
	class ExceptionC extends ExceptionB{
		
	}
}





