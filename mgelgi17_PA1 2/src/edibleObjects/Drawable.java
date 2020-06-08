package edibleObjects;


public interface Drawable {

	abstract void doAction();
	abstract void draw(); //it helps create objects for drawable objects
	static int[] SpecificPoints = { 0, 50, 100, 150, 200, 250, 300, 350, 400 };// used to put object specific points
	
}
	
