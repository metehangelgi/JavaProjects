
import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class ToHexDigit extends ConsoleProgram{
	public void run(){
		int digit=readInt("Input a hex-digit value:");
		
		while(digit<16){
			println("Here is the hex digit:"+toHex(digit));
			digit=readInt("Input a hex-digit value:");
			println(randomLetter());
			
		}
		println("End of program");
	}
	
	public boolean isDigit(char ch) {
		   return (ch >= '0' && ch <= '9');
		}

	public char randomLetter() {
		   return (char) rgen.nextInt('A', 'Z');
		}

	private char toHex(int digit){
		if(digit>=0 && digit<=9){
			return (char)('0'+digit);
		}else if(digit>9 && digit<16){
			return (char)('A'+digit-10);
		}else{
			return '?';
		}
	}
	private final RandomGenerator rgen = RandomGenerator.getInstance();
}
