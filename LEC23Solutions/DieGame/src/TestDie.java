import acm.program.*;

public class TestDie extends ConsoleProgram {
	public void run() {
		// create two Die objects
		Die die1 = new Die();
		Die die2 = new Die();

		// play the game
		die1.roll();
		println("Player 1 has " + die1.getFaceValue());
		die2.roll();
		println("Player 2 has " + die2.getFaceValue());

		// display the result

		if (die1.getFaceValue() > die2.getFaceValue()) {
			println("First player wins with " + die1.getFaceValue());
		} else if (die1.getFaceValue() < die2.getFaceValue()) {
			println("Second player wins with " + die2.getFaceValue());
		} else {
			println("Tie! Both players have " + die1.getFaceValue());
		}

	}
}
