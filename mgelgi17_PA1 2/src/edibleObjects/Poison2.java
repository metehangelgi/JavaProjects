package edibleObjects;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import movingObjects.KocCat;

public class Poison2 extends Food2 {
	

	public Poison2() {
		super();//super store these fields for each poison.
		draw(); //because it is drawable object draw method working to adding on Panel
		setColor(Color.YELLOW);
		
		doAction();
	}
	
	@Override
	public void draw() {
		setAge(1);
		setColor(Color.YELLOW);
		int RandomX = randomPlace.nextInt(9);
		int RandomY = randomPlace.nextInt(9);
		int xPlace = SpecificPoints[RandomX];
		int yPlace = SpecificPoints[RandomY];
		this.setBounds(xPlace, yPlace, 50, 50);//setbounds of Fruit panel on mainPanel
		this.repaint();
		this.repaint();
		
	}
	//grow method check time and make fruit older. and sets color of poison
	@Override
	public void grow() {
		Timer timer = new Timer(1000,new ActionListener() {
		      public void actionPerformed(ActionEvent event) {
		    	
		    	 
		    	 setAge(getAge()+1); 
		    	 if(getAge()>=10) {
		    		setColor(Color.RED);
		    		repaint();
		    	 }
		       }
		   } );
		 timer.start();
	}
	//it is working in board(if cat panel have collision with poison panel)
	@Override
	public void consumed() {
		KocCat.score-=getAge()*10;
	}
	//paint rectangle for poison
    public void paintComponent(Graphics g) {
    	g.setColor(getColor());
    	if(getAge()<10) {
    		g.fillRect(25-getAge()/2*5,25-getAge()/2*5, getAge()*5,getAge()*5); 
   		 	
	}else {
		g.fillRect(0,0, 50,50); 
	}
    	repaint();
		 
       
    }

	@Override
	public void doAction() {
		grow();
		
	}
	  

}
