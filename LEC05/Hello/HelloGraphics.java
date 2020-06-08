/*
 * File: HelloGraphics.java
 * ------------------------
 * This program displays the message "hello, world" and is inspired
 * by the first program "The C Programming Language" by Brian
 * Kernighan and Dennis Ritchie.  This version displays the message
 * graphically.
 */

import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

public class HelloGraphics extends GraphicsProgram {

	public void run() {
		
		
		GLabel label=new GLabel("hello world");
		label.setFont("SansSerif-50");
		label.setLocation(100, 100);
		
		GLabel label3=new GLabel("wtffghhgffgfgfhghgfhghfdgh",400,19);
		add(label3);
		pause(1000);
		label3.move(100, 500);
		
		add(label);
		GLabel label2= new GLabel("Metehan comes", 50,50);
		label2.setLocation(45, 45);
		add(label2);
		add(new GLabel ("hello again", 200,200));
		GRect square = new GRect(50,50,200,200);
		square.setFilled(true);
		square.setFillColor(Color.BLUE);
		add(square);
		label.sendToFront();
		GOval circle= new GOval(0,0,100,100);
		circle.setColor(Color.CYAN);
		circle.setFilled(true);
		circle.setFillColor(Color.RED);
		add(circle);
	}

/* Standard Java entry point */
/* This method can be eliminated in most Java environments */
/*	public static void main(String[] args) {
		new HelloGraphics().start(args);
	}*/
}
