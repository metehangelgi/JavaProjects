package movingObjects;

import java.awt.Point;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

import edibleObjects.Drawable;

public  class Ghosts extends JLabel implements Drawable {

	
	public Point point;
	 Random random=new Random();
	private JPanel panel;
	
	public Ghosts(JPanel panel) {//stores panel of ghosts and their own point individually
		setPanel(panel);
		
	}
	
	
	//method for subclasses(as a drawable objects)
	@Override
	public  void draw() {
	}
	
	public void setPanel(JPanel panel) {
		this.panel=panel;
	}
	public JPanel getPanel() {
		return this.panel;
	}
	
	//set and get ghost Location
	public void setGhostLocation(Point point) {
		this.point=point;
	}
	public Point getGhostLocation() {
		return this.point;
	}


	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
