import acm.graphics.*;
import acm.util.*;
import java.awt.*;

public class Die extends GCompound {

	private GRect frame;
	private GLabel face;
	private RandomGenerator rgen;
	private boolean rolled;

	public Die() {
		this(Color.RED);
	}

	public Die(Color c) {
		rgen = new RandomGenerator();
		rolled = false;
		frame = new GRect(50, 50);
		face = new GLabel("1");
		face.setFont("SansSerif-BOLD-40");

		frame.setColor(c);
		frame.setFilled(true);
		add(frame, 50, 100);
		add(face, 62, 140);

	}

	public void roll() {
		face.setLabel(new Integer(rgen.nextInt(1,6)).toString());
	}

	public int getFace() {
		return Integer.parseInt(face.getLabel());
	}

	public void setFace(int f) {
		face.setLabel(new Integer(f).toString());
		face.setLabel(Integer.toString(f));
	}

	public void reset() {
		rolled = false;
		setFace(1);
	}

	public boolean isRolled() {
		return rolled;
	}
}