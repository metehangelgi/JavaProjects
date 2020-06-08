package q1;

public class ExceptionC extends ExceptionB{

	public ExceptionC() {
		try {
			method3();
		} catch(Exception e) {
			e.getMessage();
		}
	}

	
	
	
	
	public static void method3() throws Exception{
		method2();
	}
}
