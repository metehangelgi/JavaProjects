import acm.program.*;
import acm.util.RandomGenerator;
public class GuessNumbers extends ConsoleProgram{
	public void run(){
		// Your code starts here
		int lowerBound, upperBound;
		lowerBound=readInt("The lower boundary for the random value=?");
		upperBound=readInt("The upper boundary for the random value=?");
		int randNum=rgen.nextInt(lowerBound, upperBound);
		println("Now you can try to guess the random number");
		int sum=0;
		int max=lowerBound, min=upperBound;
		int count=0;
		while(true){
			int guess=readInt("Make your guess:");
			sum+=guess;
			count++;
			max=Math.max(max, guess);
			min=Math.min(min, guess);
			if(guess==randNum){
				println();
				println("You found it after "+count+ " guesses");
				break;
			}else if(guess>randNum){
				println("Your guess is higher");
			}else {
				println("Your guess is lower");
			}
		}
		//Printing the statistics
		println("Your lowest guess was: "+min);
		println("Your highest guess was: "+max);
		double average=(double)sum/count;
		println("The average of all your guesses: "+average);
		
		// Your code ends here
	}
	//Helper methods
	private RandomGenerator rgen=RandomGenerator.getInstance();

}
