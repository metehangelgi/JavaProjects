/* File: Quiz3 Question2

 */

import acm.program.*;
import acm.util.RandomGenerator;

public class Question2 extends  ConsoleProgram {

	RandomGenerator rgen = RandomGenerator.getInstance();

	/*
	 * Run method. 
	 * It is given to you. 
	 * Do not change it.
	 */
	public void run() {
		welcomeMessage();
		askQuestion();
	}
	
	/*
	 * Welcome message for users
	 * It is given to you.
	 * You can change it or leave it same.
	 */
	public void welcomeMessage(){
		println("Welcome to Math Quiz Program");
		println("Quiz will continue until user enters a wrong answer");
		println("Good luck!");
		println();
	}
	
	/*
	 * Choose a random mathematical operation for next question. 
	 */
	public int chooseOperation(){
		int operation = 0;
		// Your code starts here	
		operation =rgen.nextInt(4);
		// Your code ends here
		return operation;
	}
	
	/*
	 * Given both correct and user answers, determine whether result is true or not.
	 */
	public boolean compareResults(int correctAnswer, int userAnswer){
		boolean result = false;
		// Your code starts here
		if(correctAnswer==userAnswer) {
			result =true;
		}
		// Your code ends here
		return result;
	}
	
	/*
	 * Ask randomly generated question to user.
	 * Take user's answer as input and compare it with correct result.
	 * Continue asking new questions until user fails to answer a question.
	 * Report total number of correct answers at the end.
	 */
	public void askQuestion()
	{
		// Your code starts here
		int correctAnswer=0;
		int userAnswer=0;
		int numberOfCorrect=0;
		boolean isCorrect =true;
		while(isCorrect) {
			int x =rgen.nextInt(100);
			int y= rgen.nextInt(100);
			int operation = chooseOperation();
			
			if(operation==0) {
				userAnswer =readInt(x + " + " + y+" = ");
				correctAnswer = x + y;
			}
			if(operation==1) {
				userAnswer =readInt(x + " - " + y+" = ");
				correctAnswer = x - y;
			}
			else {
				userAnswer =readInt(x + " * " + y+" = ");
				correctAnswer = x * y;
			}
			isCorrect = compareResults(correctAnswer,userAnswer);
			
			if (isCorrect == true) numberOfCorrect++;
		}
		println("Number of Correct answers: "+ numberOfCorrect);
		// Your code ends here
		
	}
}

