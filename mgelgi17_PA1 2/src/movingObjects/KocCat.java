package movingObjects;


import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import edibleObjects.Drawable;
import gui_Animation.Board;


public class KocCat extends JLabel implements Drawable {

	
	
	private int xCenter;
	private int yCenter;
	JPanel panel;
	public static int score=0;
	
	public KocCat(JPanel panel) {
		//sets initial point as a center of board
		this.panel=panel;
		xCenter=200;
		yCenter=200;

		draw();// draw cat for each direction separately
		panel.setBounds(xCenter, yCenter, 50	, 50);
		panel.repaint();
		panel.add(this);
		
		
	}


	


	@Override
	public void draw() {
		//gets image as a icon
		//used stackoverFlow to get help for code 
		Icon catIcon=null;
		switch(Board.getDirection()) {
		case "right":catIcon= new ImageIcon(getClass().getResource("image_right.png")); break;
		case "left":catIcon= new ImageIcon(getClass().getResource("image_left.png")); break;
		case "up":catIcon= new ImageIcon(getClass().getResource("image_up.png")); break;
		case "down":catIcon= new ImageIcon(getClass().getResource("image_down.png")); break;
		}
		Image img=((ImageIcon)catIcon).getImage();
		Image cat=img.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		catIcon=new ImageIcon(cat);
		setIcon(catIcon);
		
		
		
		
	}
	//moves on the board with respect to direction from keyListener
	@Override
	public void doAction() {
		
		switch(Board.getDirection()) {
		case "right": if(xCenter<400) {xCenter+=5;}; break;
		case "left":if(xCenter>0) {	xCenter-=5;}; break;
		case "up":if(yCenter>0) { yCenter-=5;  }; break;
		case "down":if(yCenter<400) {yCenter+=5;}; break;
		}

		draw();// used because when direction is changed the picture will change
		panel.setBounds(xCenter, yCenter, 50	, 50);
		panel.repaint();
		panel.add(this);
		
	}





	

	
	


	
	

}
