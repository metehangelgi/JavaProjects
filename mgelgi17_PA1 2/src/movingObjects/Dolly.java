package movingObjects;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import edibleObjects.Drawable;

public class Dolly extends Ghosts implements Drawable {

	private int direction = 1;
	private Image image;
	//private Random random = new Random();
	

	public Dolly(JPanel panel) {
		super(panel);
		draw();// gets image
		getPanel().setBounds(getGhostLocation().x, getGhostLocation().y, 50, 50);// set bounds of ash on mainPanel
		getPanel().repaint();// after setting everything repaint
		getPanel().add(this);//add object to the panel
	}

	public void draw() {
		// gets image as a icon
		// used stackoverFlow to get help for code
		image = new ImageIcon(getClass().getResource("dolly.jpg")).getImage().getScaledInstance(50, 50,
				java.awt.Image.SCALE_SMOOTH);
		setIcon(new ImageIcon(image));
		int xPlace = SpecificPoints[random.nextInt(9)];
		int yPlace = SpecificPoints[random.nextInt(9)];
		point = new Point(xPlace, yPlace);
		setGhostLocation(point);
	}

	public void doAction() {//called in the mainPanel<Board>
		if (direction == 1) {
			if (!(getGhostLocation().y == 400))// if point is not edge
				setGhostLocation(new Point(getGhostLocation().x, getGhostLocation().y + 5)); // goes to the down
																								// direction
			if (getGhostLocation().y >= 400) {
				direction = 2; // if it is edge change direction reverse
			}
		} else {
			if (!(getGhostLocation().y == 0))// if point is not edge
				setGhostLocation(new Point(getGhostLocation().x, getGhostLocation().y - 5));// goes to the up direction
			if (getGhostLocation().y <= 0) {
				direction = 1;// if it is edge change direction reverse
			}
		}

		getPanel().setBounds(getGhostLocation().x, getGhostLocation().y, 50, 50);// adds it on position which determined in
																			// Board
		getPanel().repaint();
		getPanel().add(this);
	}
}