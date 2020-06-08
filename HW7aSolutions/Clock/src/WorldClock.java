
import acm.program.*;

public class WorldClock extends GraphicsProgram{

	public void run() {
		// Your code starts here
		Clock istanbul = new Clock();
		istanbul.setTime(10, 45);
		istanbul.setCity("Istanbul");
		istanbul.drawClock();
		istanbul.setLocation(25, 75);
		add(istanbul);
		
		Clock london = new Clock();
		london.setTime(5,45);
		london.setCity("London");
		london.drawClock();
		london.setLocation(istanbul.getX()+istanbul.getWidth()+25, 75);
		add(london);
		
		Clock tokyo = new Clock();
		tokyo.setTime(1,45);
		tokyo.setCity("Tokyo");
		tokyo.drawClock();
		tokyo.setLocation(london.getX()+london.getWidth()+25,75);
		add(tokyo);
		// Your code ends here
	}
}
