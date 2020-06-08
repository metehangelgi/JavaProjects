package Q2;

public class Q2 {

	public Q2() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		
		
		try {
			someMethod();
		} catch(Exception e) {
			System.err.printf("%s\n\n", e.getMessage());
	          e.printStackTrace();
		}
		
	}

	
	
	
	
	
	public static void someMethod() throws Exception {
		try {
			someMethod2();
		} catch(Exception e) {
			System.out.println("extra exception was catched");
			throw e;
		}
	}
	public static void someMethod2() throws Exception{
		  throw new Exception("Exception thrown in someMethod2");
	}
}
