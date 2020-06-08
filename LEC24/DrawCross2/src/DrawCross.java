import acm.program.*;
import java.awt.Color;


public class DrawCross extends GraphicsProgram{

	public void run() {
		GCross cross = new GCross(100);
		cross.setFilled(true);
		cross.setColor(Color.RED);
		add(cross, getWidth() / 2, getHeight() / 2);
	}


}
