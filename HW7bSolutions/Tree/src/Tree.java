import java.awt.Color;

import acm.graphics.*;

/*
 * Tree class extends GCompound and creates a Christmas Tree for TreeGui class
 */

public class Tree extends GCompound{

    private final int width = 400;
    private final int height = 300;

    private GOval[] balls;

    public Tree(){
	GRect frame = new GRect(width,height);
	frame.setFilled(true);
	frame.setFillColor(Color.GRAY);
	add(frame,-width/2,-height/2);

	GRect root = new GRect(30,100);
	root.setFilled(true);
	root.setFillColor(new Color(165, 42, 42));
	add(root,-15,50);

	GPolygon leaf1 = new GPolygon();
	leaf1.addVertex(-100, 50);
	leaf1.addVertex(0,-50);
	leaf1.addVertex(100,50);
	leaf1.setFilled(true);
	leaf1.setFillColor(Color.green);
	add(leaf1);

	GPolygon leaf2 = new GPolygon();
	leaf2.addVertex(-50,-50);
	leaf2.addVertex(0,-100);
	leaf2.addVertex(50,-50);
	leaf2.setFilled(true);
	leaf2.setFillColor(Color.green);
	add(leaf2);

	GPolygon star = new GPolygon();
	int size = 30;
	double sinTheta = GMath.sinDegrees(18);
	double b = 0.5 * sinTheta / (1.0 + sinTheta);
	double edge = (0.5 - b) * size;
	star.addVertex(-size / 2, -b * size);
	int angle = 0;
	for (int i = 0; i < 5; i++) {
	    star.addPolarEdge(edge, angle);
	    star.addPolarEdge(edge, angle + 72);
	    angle -= 72;
	}
	star.setFilled(true);
	star.setFillColor(Color.white);
	star.setLocation(0, -105);
	add(star);

	balls = new GOval[4];

	GOval ball1 = new GOval(-120, 40, 20, 20);
	ball1.setFilled(true);
	ball1.setColor(Color.black);
	add(ball1);
	balls[0] = ball1;

	GOval ball2 = new GOval(100,40,20,20);
	ball2.setFilled(true);
	ball2.setColor(Color.black);
	add(ball2);
	balls[1] = ball2;

	GOval ball3 = new GOval(-70,-60,20,20);
	ball3.setFilled(true);
	ball3.setColor(Color.black);
	add(ball3);
	balls[2] = ball3;

	GOval ball4 = new GOval(50,-60,20,20);
	ball4.setFilled(true);
	ball4.setColor(Color.black);
	add(ball4);
	balls[3] = ball4;
    }

    public void changeColor(String color){
	Color c;
	if(color.equalsIgnoreCase("RED"))
	    c = Color.red;
	else if(color.equalsIgnoreCase("BLUE")){
	    c = Color.blue;
	}
	else
	    c = Color.yellow;

	for(int i = 0; i < balls.length; i++){
	    balls[i].setFillColor(c);
	}
    }
}

