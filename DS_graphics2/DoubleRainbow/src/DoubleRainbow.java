/*
 * (**) Using GArc, draw a double rainbow. Rainbow's colors in order are:
 * RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO and VIOLET. INDIGO and VIOLET
 * are not defined in Color (means that Color.INDIGO does not exist) so
 * instead use new Color(75, 0, 130) for INDIGO and new Color(238, 130,
 * 238) for VIOLET. Your output should look like the one in here, but not
 * necessarily be exactly same (differences in sizes are fine).
 */

import java.awt.Color;

import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;

public class DoubleRainbow extends GraphicsProgram{
	
	public void run() {
		//bu taslakta dikdörtgenleri kullanarak ve ona açı vererek bir daire oluşturman gerekli
		GCompound daire=new GCompound();
		double x=20;
		double y=10;
		
		double alfa =0;
	
		while(alfa<360) {
			GPolygon kare=karem(x,y,alfa);
			kare.setFilled(true);
			kare.setFillColor(rgen.nextColor());
			double rad = Math.toRadians(alfa);
			daire.add(kare,q,w);
			q+=x*Math.cos(rad);
			w-=x*Math.sin(rad);	
			alfa+=15;
			
		}
		
		add(daire,getWidth()/2,getHeight()/2);
		daire.setLocation((getHeight()+daire.getHeight())/2, (getWidth()+daire.getWidth())/2);
		
	}
	private GPolygon karem(double x,double y, double aci) {
		
		GPolygon kare=new GPolygon();
		kare.addVertex(0, 0);
		kare.addPolarEdge(x, aci);
		kare.addPolarEdge(y, aci-90);
		kare.addPolarEdge(-x, aci);
		
		
		
		return kare;
	}
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
	double q=0;
	double w=0;
	}

