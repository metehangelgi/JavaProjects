import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;


public class LotterySimulator extends ConsoleProgram{
	public void run(){
		//Your code starts here
		int numDigit=readInt("how many number do you want in ticket: ");
		int numChars=readInt("how many Character do you want in ticket: ");
		int numTickets=readInt("How many codes do you need?");
		println("------------------------------");
		for(int i=0;i<numTickets;i++) {
			print("Ticket #"+i+": ");
			int firstDigit=printTicket(numDigit,numChars);
			if(firstDigit==5) {
				println("This ticket pays for itself");
				
			}
			
		}
		
		
		
		//Your code ends here
	}
	//Helper methods
	//Your code starts here
	private int printTicket(int numDigit,int numChars) {
		int firstDigit = -1;
		
		for(int i=0; i<numDigit;i++) {
			int currentDigit =rgen.nextInt(10);
			print(currentDigit);
			if (i==0) firstDigit = currentDigit;
		}
		for (int i=0;i<numChars;i++) {
			int k = rgen.nextInt(5);
			switch(k) {
			case 0:
				print("A");
				break;
			case 1:
				print("B");
				break;
			case 2:
				print("C");
				break;
			case 3:
				print("D");
				break;
			case 4:
				print("E");
				break;
			default:
				print("");
				break;
			}
			
			
		}
		println();
		return firstDigit;
	}
	//Your code ends here
	private RandomGenerator rgen=RandomGenerator.getInstance();
}
