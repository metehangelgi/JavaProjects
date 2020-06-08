/** DrawDiamond.java:
 * Draw a filled diamond shape (using GPolygon) at the center of the window.
 * Try to do it with both addVertex and addEdge.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.Color;


public class DrawDiamond extends GraphicsProgram{

	public void run() {
		GPolygon diamond = createDiamond2(100, 75);
		GPolygon hex = createHexagon(50);
		diamond.setFilled(true);
		diamond.setFillColor(Color.MAGENTA);
		add(diamond, getWidth() / 2, getHeight() / 2);
		hex.setFilled(true);
		hex.setFillColor(Color.BLACK);
		add(hex, getWidth() / 2, getHeight() / 2);
		GLine hor =new GLine(0, getHeight()/2, getWidth(), getHeight()/2);
		add(hor);
		
	}

	private GPolygon createHexagon(double side) {
		   GPolygon hex = new GPolygon();
		   hex.addVertex(-side/2, -side*Math.sqrt(3.0)/2);
		   int angle = 0;
		   for (int i = 0; i < 6; i++) {
		      hex.addPolarEdge(side, angle);
		      angle -= 60;
		   }
		   return hex;
		}


	private GPolygon createDiamond(double width, double height) {
		GPolygon diamond = new GPolygon();
		// Your code starts here
		   diamond.addVertex(-width / 2, 0);
		   diamond.addVertex(0, -height / 2);
		   diamond.addVertex(width / 2, 0);
		   diamond.addVertex(0, height / 2);

		// Your code ends here
		return diamond;
	}
	
	private GPolygon createDiamond2(double width, double height) {
		GPolygon diamond = new GPolygon();
		// Your code starts here
		   diamond.addVertex(-width / 2, 0);
		   diamond.addEdge(width / 2, -height / 2);
		   diamond.addEdge(width / 2, height / 2);
		   diamond.addEdge(-width / 2, height / 2);
		   diamond.addEdge(-width / 2, -height / 2);


		// Your code ends here
		return diamond;
	}

	private GPolygon createDiamond3(double width, double height) {
		GPolygon diamond = new GPolygon();
		// Your code starts here
		   diamond.addVertex(-width / 2, 0);
		   diamond.addEdge(width / 2, -height / 2);
		   diamond.addEdge(width / 2, height / 2);
		   diamond.addEdge(-width / 2, height / 2);
		   diamond.addEdge(-width / 2, -height / 2);


		// Your code ends here
		return diamond;
	}
	private GPolygon createDiamond4(double width,double height) {
		GPolygon diamond =new GPolygon();
		diamond.addVertex(-width/2, 0);
		diamond.addPolarEdge(Math.sqrt((width/2)*(width/2)+((height/2)*(height/2))), -Math.tanh(height/width));
		diamond.addPolarEdge(Math.sqrt((width/2)*(width/2)+((height/2)*(height/2))), Math.tanh(height/width));
		diamond.addPolarEdge(Math.sqrt((width/2)*(width/2)+((height/2)*(height/2))), -Math.tanh(width/height));
		
		diamond.addPolarEdge(Math.sqrt((width/2)*(width/2)+((height/2)*(height/2))), Math.tanh(height/width));
		return null;
	}
	
}
