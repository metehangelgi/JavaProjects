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

public class Ash extends Ghosts implements Drawable {

	private Image image;
	private int direction = 1;

	//private Random randomPlace = new Random();

	public Ash(JPanel panel) {

		super(panel);
		draw(); // gets image
		getPanel().setBounds(getGhostLocation().x, getGhostLocation().y, 50, 50);// set bounds of ash on mainPanel
		getPanel().repaint();// after setting everything repaint
		getPanel().add(this);
	}

	public void draw() {
		// gets image as a icon
		// used stackoverFlow to get help for code
		image = new ImageIcon(getClass().getResource("ash.png")).getImage().getScaledInstance(50, 50,
				java.awt.Image.SCALE_SMOOTH);
		setIcon(new ImageIcon(image));
		int xPlace = SpecificPoints[random.nextInt(9)];
		int yPlace = SpecificPoints[random.nextInt(9)];
		point = new Point(xPlace, yPlace);
		setGhostLocation(point);
	}

	public void doAction() {//called in the mainPanel<Board>
		if (direction == 1) {
			setGhostLocation(new Point(getGhostLocation().x + 5, getGhostLocation().y));// goes to right
			if (getGhostLocation().x >= 400) {
				direction = 2;// if it is edge change direction reverse
			}
		} else {
			setGhostLocation(new Point(getGhostLocation().x - 5, getGhostLocation().y));// goes to left
			if (getGhostLocation().x < 0) {
				direction = 1;// if it is edge change direction reverse
			}
		}

		getPanel().setBounds(getGhostLocation().x, getGhostLocation().y, 50, 50);// adds it on position which determined in
																			// Board
		getPanel().repaint();
		getPanel().add(this);
	}

}
