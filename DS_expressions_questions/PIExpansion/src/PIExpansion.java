import acm.program.*;

public class PIExpansion extends ConsoleProgram {

	public void run() {
		int Nterm = readInt("Enter the number of desired terms: ");

		// Your code starts here
		
		double pi=3;
		double s;
		for(int i=1;i<Nterm+1;i++) {
			
			s= (double)4/(i*2*((i*2)+1)*((i*2)+2));
			if(i%2 == 1) {
				pi+=s;
			} else {
				pi -=s;
			}
			println("\nPI after "+(i-1)+"th term is:"+pi);
		}
		
		
		int a = (int)Math.pow(10,Nterm);
		println("show our label"+a);
		
		// Your code ends here
	}
}
