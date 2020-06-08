
import java.awt.Color;

import acm.graphics.GCompound;
import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GPolygon;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Question2 extends GraphicsProgram {
	
	public void run() {
		// Your code starts here
		GCompound bird =createBird(10);
		add(bird,0, getHeight()-GRASS_HEIGHT-bird.getHeight());
		pause(500);
		for(int i= -Dy_MAX; i<=Dy_MAX;i++) {
			bird.move(Dx, i);
			pause(PAUSE_TIME);
		}
		// Your code ends here
	}
	// Your code starts here
	private GCompound createBird(int n) {

		GCompound c= new GCompound();
		GPolygon p= new GPolygon();
		p.addVertex(0,0);
		p.addEdge(0, 3*n);
		p.addEdge(8*n, 0);
		p.setFillColor(Color.RED);
		p.setFilled(true);
		
		
		GOval eye2 = new GOval (n,n);
		eye2.setFillColor(Color.WHITE);
		eye2.setFilled(true);
		
		
		GOval eye = new GOval (n/2,n/2);
		eye.setFillColor(Color.BLACK);
		eye.setFilled(true);
		
		
		
		
		c.add(p,0,0);
		c.add(eye2,0,0);
		c.add(eye,0,0);
		

		return c;
	}
	
	
	// Your code ends here
	
	/* Private constants */
	private static final int PAUSE_TIME = 10;
	private static final int Dy_MAX = 70;
	private static final int Dx = 2;
	private static final int GRASS_HEIGHT = 20;
	
	/* 
	 * Provides the environment.
	 * Do not change.
	*/
	public void init() {
		setSize(500, 500);
		this.setBackground(Color.BLUE);
		GOval sun = new GOval(50,50);
		sun.setFillColor(Color.ORANGE);
		sun.setFilled(true);
		add(sun, this.getWidth()-sun.getWidth()-10, 10);
		GRect grass = new GRect(getWidth(),GRASS_HEIGHT);
		grass.setFillColor(Color.GREEN);
		grass.setFilled(true);
		add(grass, 0,this.getHeight()-grass.getHeight());
		GLine rope = new GLine(0,
				getHeight()-grass.getHeight()-Dy_MAX*(Dy_MAX+1)/2,
				getWidth(),
				getHeight()-grass.getHeight()-Dy_MAX*(Dy_MAX+1)/2);
		add(rope);
	}
}
