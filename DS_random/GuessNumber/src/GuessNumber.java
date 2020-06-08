/*File: GuessNumber.java*/

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class GuessNumber extends ConsoleProgram{
	public void run() {
	   println("This program has selected a number between 1-100, we want you " +
	   					"to guess that number with as minimum tries as you can.");
	   //Number you are trying to guess is "myNumber". We randomly created it for you.
	   int myNumber = RandomGenerator.getInstance().nextInt(1, 100);
	   
	   //TODO you should fill the rest
	}
}
