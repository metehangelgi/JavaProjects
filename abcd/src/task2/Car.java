package task2;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Car extends JPanel {
    private int xCenter;
    private int yCenter;
    int w = 20;
    int h = 20;
	
    public Car () {
		xCenter = 0;
		yCenter = 152;
	}
	
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (xCenter >getWidth()) {
			xCenter = 0;
		}
		
		xCenter += 5;
		g.setColor(Color.green);
		g.drawRect(xCenter, yCenter, w, h);
		g.fillRect(xCenter,yCenter-50, w, h);
		
	}
	
}