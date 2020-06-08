package edibleObjects;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

import javax.swing.JPanel;



public abstract class Food2 extends JPanel implements Drawable{
	
	Random randomPlace=new Random();
	private Color color;
	private int age=1;
	//Food2 gets color, age,point and store it for its subClasses
	//mainPanel is needed for adding or removing fruit &poison on MainPanelEasily
	public Food2() {
		
		setAge(1);
		
	}
	
	//these are abstract methods which used in subclasses
	public abstract void draw();

	public  abstract  void consumed();

	public abstract void grow();
	
	//getAge is needed for changing color of poison& fruit 
	//getAge is also needed for fruit to die when it is over than 10 
	public int getAge() {
		
		return this.age;
	}
	public void setAge(int age) {
		this.age=age;
		
	}
	//set and getColor helps subClasses to setColors.
	public Color getColor() {
		
		return this.color;
	}
	
	
	public void setColor(Color color) {
		this.color=color;
		
	} 
	
}
