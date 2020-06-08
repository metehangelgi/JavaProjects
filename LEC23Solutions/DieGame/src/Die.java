import acm.util.*;

public class Die {

	private int faceValue;

	//constructor
	public Die(){
		// Your code starts here
			faceValue=1;
		// Your code ends here
	}

	//roll the die 
	public void roll(){
		// Your code starts here
		faceValue=rgen.nextInt(1,6);
		// Your code ends here		
	}

	//get the face value
	public int getFaceValue(){
		// Your code starts here
		return faceValue;
		// Your code ends here
	}	

	RandomGenerator rgen = RandomGenerator.getInstance();
}
