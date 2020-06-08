import acm.graphics.*;
import acm.util.RandomGenerator;

public class Pendulum extends GCompound{
	
	private double theta;
	private double length;
	
	private GOval weight;
	private GLine rope;
	private final double BALL_WIDTH = 10;
	private final double BALL_HEIGHT = 10;
	
	private final double g = 10;
			
	public Pendulum(double thet, double len) {
		theta = thet;
		length = len;
		
		double x = Math.sin(Math.toRadians(theta)) * length;
		double y = Math.cos(Math.toRadians(theta)) * length;
		
		weight = new GOval(BALL_WIDTH, BALL_HEIGHT);
		weight.setFilled(true);
		weight.setFillColor(RandomGenerator.getInstance().nextColor());
		add(weight, x - BALL_WIDTH / 2, y - BALL_HEIGHT / 2);
		rope = new GLine(0, 0, x, y);
		add(rope);
	}
	
	public void step(double t) {
		double thet = theta * Math.cos(Math.sqrt(g / length) * t);
		double x = Math.sin(Math.toRadians(thet)) * length;
		double y = Math.cos(Math.toRadians(thet)) * length;
		weight.setLocation(x - BALL_WIDTH / 2, y - BALL_HEIGHT / 2);
		rope.setEndPoint(x, y);
	}
}
