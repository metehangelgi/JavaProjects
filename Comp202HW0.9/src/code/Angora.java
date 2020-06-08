package code;

/* Modify this file using the following info
 * - Angora is a Cat breed  
 * - Angora is not considered a wild cat
 * - Angora moves with 15 units of speed
 * - Angora makes a "meow" sound
 * - Angora cats may have differently colored eyes  (Hint: add this to its description)
 * 
 * */

public class Angora extends Cat{

	
	public Angora() {
		super("Angora", "meow");
		super.moveSpeed=15;
	}

	@Override 
	public void description()
	{
		super.description();
		System.out.println(breed +" cats may have differently colored eyes");
	}
	
}
