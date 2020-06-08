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

public class Casper extends Ghosts implements Drawable {

	int direction = 1;
	private Image image;
	//private Random random = new Random();

	public Casper(JPanel panel) {

		super(panel);
		draw();// gets image
		panel.setBounds(getGhostLocation().x, getGhostLocation().y, 50, 50);// set bounds of ash on mainPanel
		panel.repaint();// after setting everything repaint
		panel.add(this);
	}

	public void draw() {
		// gets image as a icon
		// used stackoverFlow to get help for code
		image = new ImageIcon(getClass().getResource("casper.png")).getImage().getScaledInstance(50, 50,
				java.awt.Image.SCALE_SMOOTH);
		setIcon(new ImageIcon(image));
		int xPlace = SpecificPoints[random.nextInt(9)];
		int yPlace = SpecificPoints[random.nextInt(9)];
		point = new Point(xPlace, yPlace);
		setGhostLocation(point);
	}

	int count = 0;
	int way2 = 0;

	// casper choose any direction each time(0.1s) to go.
	public void doAction() {//called in the mainPanel<Board>

		if (count % 10 == 0)
			way2 = random.nextInt(4);
		switch (way2) {
		case 0:
			if (getGhostLocation().x < 400)
				setGhostLocation(new Point(getGhostLocation().x + 5, getGhostLocation().y));
			count++;
			break;
		case 1:
			if (getGhostLocation().x > 0)
				setGhostLocation(new Point(getGhostLocation().x - 5, getGhostLocation().y));
			count++;
			break;
		case 2:
			if (getGhostLocation().y > 0)
				setGhostLocation(new Point(getGhostLocation().x, getGhostLocation().y - 5));
			count++;
			break;
		case 3:
			if (getGhostLocation().y < 400)
				setGhostLocation(new Point(getGhostLocation().x, getGhostLocation().y + 5));
			count++;
			break;
		}

		getPanel().setBounds(getGhostLocation().x, getGhostLocation().y, 50, 50);// adds it on position which determined in
																			// Board
		getPanel().repaint();
		getPanel().add(this);
	}


}
