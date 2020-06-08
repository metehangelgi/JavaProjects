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
		
	protected static String breed="Caracal";
	protected static String sound="hiss";
	private int moveSpeed;
	
	public Caracal() {
		super(breed,sound);
		this.moveSpeed=22;
	}
	
	
	@Override 
	public void description()
	{
		super.description();
		System.out.println(breed + "cats have longer ears");
	}
	
	@Override
	public boolean isWild() {
		return true;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Running with" + this.moveSpeed + "speed");
	}
	
	public int getmoveSpeed() {
		return this.moveSpeed;
	}
	
	
}
