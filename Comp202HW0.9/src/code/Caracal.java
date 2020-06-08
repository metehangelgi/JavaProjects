package code;

/* Modify this file using the following info
 * - Caracal is a Cat breed  
 * - Caracal is considered a wild cat
 * - Caracal moves with 22 units of speed
 * - Caracal makes a "hiss" sound
 * - Caracal cats have longer ears (Hint: add this to its description)
 * 
 * */


public class Caracal extends Cat{
	

	
	public Caracal() {
		super("Caracal","hiss");
		super.moveSpeed=22;
	}
	
	
	@Override 
	public void description()
	{
		super.description();
		System.out.println(breed+ " cats have longer ears");
	}
	
	@Override
	public boolean isWild() {
		return true;
	}
}
