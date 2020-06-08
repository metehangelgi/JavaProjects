import java.awt.Color;

import acm.graphics.*;

/*!!!!!!!!!!!!!!!!!!!!!!!Do not add or remove anything from this class!!!!!!!!!!!!!!!!!!!!!!!!!!!*/

public class Clock extends GCompound{
	
	//global variables of the class Clock
	private int hour;
	private int minute;
	private String city;
	
	//constructor; by default hour and minute are set to 0 and city is set to N/A(not available)
	public Clock(){
		this.hour = 0;
		this.minute = 0;
		this.city = "N/A";
	}
	
	//draws a complete clock figure 
	public void drawClock(){
		GOval circle = new GOval(200,200);
		add(circle,0,0);
		GOval littleCircle = new GOval(6,6);
		littleCircle.setFillColor(Color.BLACK);
		littleCircle.setFilled(true);
		add(littleCircle,getWidth()/2-3,getHeight()/2-3);
		
		double xStart,yStart,xFinish,yFinish;
		double size = 0;
		for(int i=0; i < 360; i += 6){
			if(i%30 == 0){
				size = 20;
			}
			else{
				size = 10;
			}
			xStart = 100+100*Math.sin((i*Math.PI)/180);
			yStart = 100-(100*Math.cos((i*Math.PI)/180));
			xFinish = xStart-size*Math.sin((i*Math.PI)/180);
			yFinish = yStart + (size*Math.cos((i*Math.PI)/180));
			add(new GLine(xStart, yStart, xFinish, yFinish));
		}
		 
		add(new GLabel("12",10,10),93,32);
		add(new GLabel("3",10,10),170,105);
		add(new GLabel("6",10,10),97,178);
		add(new GLabel("9",10,10),22,104);
		
		//draw minute and hour hand of the clock
		size = 65;
		xFinish = 100+(size*Math.sin((minute*6*Math.PI)/180));
		yFinish = 100-(size*Math.cos((minute*6*Math.PI)/180));
		add(new GLine(100, 100, xFinish, yFinish));
		
		size = 40;
		xFinish = 100+(size*Math.sin((((minute/2)+(hour*30))*Math.PI)/180));
		yFinish = 100-(size*Math.cos((((minute/2)+(hour*30))*Math.PI)/180));
		add(new GLine(100, 100, xFinish, yFinish));
		setLabel();
	}
	
	//sets hour and the minute of the clock
	public void setTime(int hour,int minute){
		if(hour < 0 || hour > 24 || minute < 0 || minute > 60){
			this.hour = 0;
			this.minute = 0;
		}
		this.hour = hour%12;
		this.minute = minute%60;
	}
	
	//sets city of the clock
	public void setCity(String city){
		this.city = city;
	}
	
	//using String city variable, adds label to the bottom of the clock
	public void setLabel(){
		//city label
		GLabel l_city = new GLabel(city);
		l_city.setFont("SansSerif-36");
		if(l_city.getWidth() < getWidth()){
			add(l_city,(getWidth()/2)-(l_city.getWidth()/2), 220+l_city.getHeight()/2);
		}
		else{
			setLocation((l_city.getWidth()/2)-(getWidth()/2), getY());
			add(l_city,0,220+l_city.getHeight()/2);
		}
	}
	
}
