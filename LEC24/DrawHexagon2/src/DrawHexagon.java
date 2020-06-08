import acm.program.*;

public class DrawHexagon extends GraphicsProgram{
	
	public void run() {
        GHexagon hexagon = new GHexagon(50);
        add(hexagon, getWidth() / 2, getHeight()/2);          
    }
	
}
