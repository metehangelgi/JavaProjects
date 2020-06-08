package edibleObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

import movingObjects.KocCat;

public class Fruit2 extends Food2 {

	
	public Fruit2() {
		super(); //super store these fields for each fruit.
		//this.setBounds(getPoint().x, getPoint().y, 50, 50);//setbounds of Fruit panel on mainPanel
		draw();//because it is drawable object draw method working to adding on Panel
		setColor(Color.BLUE);
		doAction();
		
	}
	  
	@Override
	public void draw() {
		setAge(1);
		setColor(Color.BLUE);
		int RandomX = randomPlace.nextInt(9);
		int RandomY = randomPlace.nextInt(9);
		int xPlace = SpecificPoints[RandomX];
		int yPlace = SpecificPoints[RandomY];
		this.setBounds(xPlace+5, yPlace+5, 45, 45);//setbounds of Fruit panel on mainPanel. there is also +5 because to look screen better
		this.repaint();
	}

	
	//grow method check time and make fruit older and sets the color 
	//also check if age is bigger than 10-- so will die and add new one.
	//*die for age is checking in board because to adding new fruit easy by this way
	@Override
	public void grow() {
		 
		 Timer timer = new Timer(1000,new ActionListener() {
		      public void actionPerformed(ActionEvent event) {
		    	
		    	 
		    	 setAge(getAge()+1); 
		    	 if(getAge()>=5) {
		    		 setColor(Color.GREEN);
		    		
		    	 }
		    	 if(getAge()>=10) {
		    		 setAge(1);
		    		 setColor(Color.BLUE);
		    		 draw();
		    	 }
		 		
		       }
		   } );
		 timer.start();
	}
	//it is working in board(if cat panel have collision with fruit panel)
	@Override
	public void consumed() {
		 KocCat.score+=getAge()*5;
	}
	//paint circle for fruit
    public void paintComponent(Graphics g) {
    	g.setColor(getColor());
		 g.fillOval(25-getAge()*9/4,25-getAge()*9/4, getAge()*9/2,getAge()*9/2); 
		 repaint();
    }

	@Override
	public void doAction() {
		grow();
		
	}
    

}
