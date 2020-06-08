package deneme1;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;



public class Panel extends JPanel {
	Random random=new Random();
	
	
	
	public Panel() {
		this.setLocation(50, 50);
	}
	
	 @Override
	    public void paintComponent(Graphics g) {
		 for(int i=0;i<2;i++) {
			 
			int x= random.nextInt(500);
			int y=random.nextInt(500);
			 g.drawOval(0,0, x,y); 
		        g.drawOval(500,0, 0,500); 
			}
	       
	    }
	
	
	
	
	
}
