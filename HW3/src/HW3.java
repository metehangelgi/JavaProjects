/* Student Name: 
 * This program creates a Graphics Program which consists of 
 * 3 lanes, a car and obstacles on the lanes
 * The aim of the game here to move the car on the game map so that
 * can reach the finish line without hitting the obstacles on the lanes.
 * The obstacles are randomly generated on the lanes, and the user can navigate the
 * car using the keyboard. 
 */
import java.awt.Color;
import java.awt.event.KeyEvent;

import acm.graphics.*;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class HW3 extends GraphicsProgram {
	
	public void run() {
		addKeyListeners(); //Do not change or delete this line
		
		//You can call your helper methods here
		//YOUR CODES START HERE
		
		
		// BEFORE STARTING PROGRAM you should increase dx which is speed. Otherwise you can not finish game to test program at all. 
		//I couldn't finish it with this speed. 
		
		
		
		//output is "YOUR CAR WILL BE CHOSEN RANDOMLY  ARE YOU READY!!!" middle of screen while showing cars
		GLabel ready= new GLabel ("YOUR CAR WILL BE CHOSEN RANDOMLY  ARE YOU READY!!!");
		add(ready,getWidth()*1/6,getHeight()/4);
		ready.setFont("Arial-BOLD-30");
		//shows car 1,2,3 and removes everything
		GCompound car3 = createCar4();
		add(car3, (APPLICATION_WIDTH - car3.getWidth())/2, APPLICATION_HEIGHT - 2 * car3.getHeight()); 
	
	
		GCompound car2 = createCar3();
		add(car2, (APPLICATION_WIDTH - car2.getWidth())*2/3, APPLICATION_HEIGHT - 2 * car2.getHeight());
		
		
		GCompound car1 = createCar2();
		add(car1, (APPLICATION_WIDTH - car1.getWidth())/3, APPLICATION_HEIGHT - 2 * car1.getHeight()); 
		pause(5000);
		ready.setVisible(false);
		car1.removeAll();
		car2.removeAll();
		car3.removeAll();
		
		
		// counting to start game 
		//startRace3 is number 3,startRace2 is number 2,startRace is number 1,
		GCompound raceStart3= startRace3();
		add(raceStart3,APPLICATION_WIDTH/2-raceStart3.getWidth()/2 , APPLICATION_HEIGHT/2-raceStart3.getHeight()/2);
		pause(1000);
		raceStart3.removeAll();
		GCompound raceStart2= startRace2();
		add(raceStart2,APPLICATION_WIDTH/2-raceStart2.getWidth()/2 , APPLICATION_HEIGHT /2-raceStart2.getHeight()/2);
		pause(1000);
		raceStart2.removeAll();
		GCompound raceStart= startRace();
		add(raceStart,APPLICATION_WIDTH/2-raceStart.getWidth()/2 , APPLICATION_HEIGHT /2-raceStart.getHeight()/2);
		pause(1000);
		raceStart.removeAll();
		
		//making the gameMap
		addRoadBorders();
		addLaneSeparationLines();
		addRoadLines();
		addFinishLine();
		addRandomObstacles();
		
		
		//YOUR CODE ENDS HERE
		
		
		car = createCar(); //Do not change or delete this line
		add(car, (APPLICATION_WIDTH - car.getWidth())/2, APPLICATION_HEIGHT - 2 * car.getHeight()); 
		
		//You can add car to map, handle the movement of the map and end of the game here.
		//YOUR CODE STARTS HERE
		// if we hit any obstacles, finishGame function will be activated.
		int checkerForWin=0;
		for(int i=0;i<ROAD_HEIGHT-2*car.getHeight();i+=dy) {
			gameMap.move(0, dy);
			pause(PAUSE_TIME);
			GPoint carloc=car.getLocation();
			GPoint c=gameMap.getLocalPoint(carloc);
			GObject b= gameMap.getElementAt(c);
			if(gameMap.getAllObstacles().contains(b)) {
				setBackground(Color.WHITE);
				finishGame();
				i= (int) (ROAD_HEIGHT-2*car.getHeight());
				
				checkerForWin--;
			}
		}
		/* in this part we can finish game if we don't hit any obstacle. So output will be "Congratulations!!! 
		You Won" middle of the page 
		*/
		if(checkerForWin==0) {
			removeAll();
			GLabel win= new GLabel ("Congratulations!!! You Won ");
			win.setFont("Times-BOLD-32");
			setBackground(Color.WHITE);
			add(win,getWidth()/2-win.getWidth()/2,getHeight()/2-win.getHeight()/2);
			println("your text is" +win.getAscent());
			win.setFont("Arial-BOLD-28");
			
		}
		
		
		
		//YOUR CODE ENDS HERE
	
	}
	/*
	 * Method which draws the Road Borders on the game map
	 */
	private void addRoadBorders() {
		//YOUR CODE STARTS HERE
		for(int x=0;x<=APPLICATION_WIDTH-ROAD_BORDER_WIDTH;x+=APPLICATION_WIDTH-ROAD_BORDER_WIDTH) {
			GRect borderL=new GRect(ROAD_BORDER_WIDTH,ROAD_HEIGHT);
			borderL.setFilled(true);
			borderL.setFillColor(Color.WHITE);
			gameMap.add(borderL,x,0);
			
		}
		
		//YOUR CODE ENDS HERE
	}
	
	/*
	 * Method which draws the lines separating the lanes on the road
	 */
	private void addLaneSeparationLines(){
		//YOUR CODE STARTS HERE
		for(int y=LANE_SEPARATION_SPACE;y<ROAD_HEIGHT;y+=LANE_SEPARATION_HEIGHT+LANE_SEPARATION_SPACE) {
			for(int x=ROAD_BORDER_WIDTH+LANE_WIDTH;x<=ROAD_BORDER_WIDTH+LANE_WIDTH+LANE_SEPARATION_WIDTH+LANE_WIDTH;x+=LANE_SEPARATION_WIDTH+LANE_WIDTH) {
				GRect sLine1 =new GRect(LANE_SEPARATION_WIDTH,LANE_SEPARATION_HEIGHT);
				sLine1.setFilled(true);
				sLine1.setFillColor(Color.WHITE);
				gameMap.add(sLine1, x, y);
			}
			
			
			
		}
		//YOUR CODE ENDS HERE
	}
	
	/*
	 * Methods which draws the lines on the road
	 */
	// 
	private void addRoadLines() {
		//Road lines are a little bit different from pdf but I thought it is not important at all because there was no information about starting and finish points.
		//YOUR CODE STARTS HERE
		for(int y=0;y<ROAD_HEIGHT;y+=ROAD_LINE_HEIGHT+ROAD_LINE_SEPARATION) {
		for(int x=ROAD_BORDER_WIDTH+(LANE_WIDTH/2)-(ROAD_LINE_WIDTH/2);x<=ROAD_BORDER_WIDTH+LANE_WIDTH+LANE_SEPARATION_WIDTH+LANE_WIDTH+LANE_SEPARATION_WIDTH+(LANE_WIDTH/2)-(ROAD_LINE_WIDTH/2);
				x+=LANE_WIDTH+LANE_SEPARATION_WIDTH) {
				GRect roadL =new GRect(ROAD_LINE_WIDTH,ROAD_LINE_HEIGHT);
				gameMap.add(roadL, x, y);
				roadL.setFilled(true);
				roadL.setFillColor(Color.WHITE);
				
			}
		
			
		}
		//YOUR CODE ENDS HERE	
	}
	/*
	 * Method which draws the finish line
	 */	
	private void addFinishLine() {
		//YOUR CODE STARTS HERE
		// this part is working like chess Board
		
		for (int a = 0; a <2 ; a++) {
			for (int b = 0; b < FINISH_LINE_SQUARE_NUM; b++) {
				// Your code starts here
				double x = b*FINISH_LINE_SQUARE_SIZE+ROAD_BORDER_WIDTH;
				double y = a*FINISH_LINE_SQUARE_SIZE;
				GRect sqr =new GRect (FINISH_LINE_SQUARE_SIZE,FINISH_LINE_SQUARE_SIZE);
				
				
				sqr.setFilled(true);
				if((a+b)%2!=0) {
					sqr.setFillColor(Color.BLACK);
				} else {
					sqr.setFillColor(Color.WHITE);
				}
				
				
				gameMap.add(sqr, x, y);
			}
		}
		//YOUR CODE ENDS HERE	
	}
	/*
	 * Method which draws the rectangle obstacles randomly
	 * on the road 
	 */
	private void addRandomObstacles() {
		//YOUR CODE STARTS HERE
		int width= LANE_WIDTH;
		int height= OBSTACLE_HEIGHT;
		
		// I started the first obstacle from this point instead of LENGTH_SAFE_ZONE_START because by this way the game will be easier. 
		//Actually it still follows rule which is in pdf. (first y is bigger than LENGTH_SAFE_ZONE_START so  there is no obstacle before LENGTH_SAFE_ZONE_START)
		for(int y=ROAD_HEIGHT-2*(ROAD_LINE_SEPARATION+ROAD_LINE_HEIGHT);y>=LENGTH_SAFE_ZONE_END;y=y-2*(ROAD_LINE_SEPARATION+ROAD_LINE_HEIGHT)) {
			
				int randomX1= rgen.nextInt(0,2);
				int randomX2= rgen.nextInt(0,2);
				while (randomX1==randomX2) {
					randomX2= rgen.nextInt(0,2);
				}
				Color fillColor = rgen.nextColor();
				obstacle1= createObstacle(width,height,fillColor);
				fillColor = rgen.nextColor();
				obstacle2= createObstacle(width,height,fillColor);
				
				int positionX1=ROAD_BORDER_WIDTH+randomX1*(LANE_WIDTH+LANE_SEPARATION_WIDTH);
				int positionX2=ROAD_BORDER_WIDTH+randomX2*(LANE_WIDTH+LANE_SEPARATION_WIDTH);
				
				
				gameMap.addObstacle(obstacle1, positionX1, y);
				gameMap.addObstacle(obstacle2, positionX2, y);
				
			}
			
			

		
		//YOUR CODE ENDS HERE
	}
	
	/*
	 * Method which draws a single rectangle simulating an obstacles 
	 * on the road
	 */
	private GRect createObstacle(int width, int height, Color fillColor) {
		
		
		//YOUR CODE STARTS HERE
		GRect obstacle=new GRect(0,0,width,height);
		obstacle.setFilled(true);
		obstacle.setFillColor(fillColor);
		//YOUR CODE ENDS HERE
		
		return obstacle;
	}
	
	/**
	 * Changing this method is bonus and left to you, you can skip it or work for the bonus points
	 * We strongly encourage you to do everything else first and work on this afterwards
	 * Method which draws a GCompound simulating the car 
	 */
	
	// create car method choose 1 car in 3 cars after counting numbers. I created extra methods for cars separately again to use before starting game
	private GCompound createCar() {
		int x=rgen.nextInt(1,3);
		if (x==1) {
			GCompound car = new GCompound();
			GRect a = new GRect(40 ,50);
			a.setFilled(true);
			a.setFillColor(Color.GREEN);
			GRect b = new GRect(20 ,20);
			b.setFilled(true);
			b.setFillColor(Color.BLUE);
			GRect c = new GRect(5 ,40);
			c.setFilled(true);
			c.setFillColor(Color.GRAY);
			GRect d = new GRect(10 ,50);
			d.setFilled(true);
			d.setFillColor(Color.BLACK);
			GRect e = new GRect(10 ,50);
			e.setFilled(true);
			e.setFillColor(Color.BLACK);
			car.add(a);
			car.add(b,10,10);
			car.add(d,-10,0);
			car.add(e,40,0);
			car.add(c,17.5,-30);
			return car;
		}
		else if (x==2) {
			GCompound car = new GCompound();
			GRect a1 = new GRect(5 ,5);
			a1.setFilled(true);
			a1.setFillColor(Color.WHITE);
			GRect a2 = new GRect(5 ,5);
			a2.setFilled(true);
			a2.setFillColor(Color.WHITE);
			GRect w1 = new GRect(2 ,5);
			w1.setFilled(true);
			w1.setFillColor(Color.BLACK);
			GRect w2 = new GRect(2 ,5);
			w2.setFilled(true);
			w2.setFillColor(Color.BLACK);
			GRect w3 = new GRect(2 ,5);
			w3.setFilled(true);
			w3.setFillColor(Color.BLACK);
			GRect w4 = new GRect(2 ,5);
			w4.setFilled(true);
			w4.setFillColor(Color.BLACK);
			GRect b = new GRect(40 ,70);
			b.setFilled(true);
			b.setFillColor(Color.RED);
			GRect c = new GRect(30 ,30);
			c.setFilled(true);
			c.setFillColor(Color.BLACK);
			GRect d = new GRect(10 ,5);
			d.setFilled(true);
			d.setFillColor(Color.WHITE);
			GRect e = new GRect(30 ,5);
			e.setFilled(true);
			e.setFillColor(Color.WHITE);
			car.add(w1,-2,5);
			car.add(w2,-2,60);
			car.add(w3,40,5);
			car.add(w4,40,60);
			car.add(b);
			car.add(e,5,15);
			car.add(a1,5,25);
			car.add(a2,30,25);
			car.add(d,15,25);
			car.add(c,5,35);
			return car;
			
		} else {
			GCompound car = new GCompound();
			GRect a1 = new GRect(5 ,15);
			a1.setFilled(true);
			a1.setFillColor(Color.WHITE);
			GRect  a2= new GRect(5 ,15);
			a2.setFilled(true);
			a2.setFillColor(Color.WHITE);
			GRect a3 = new GRect(5 ,15);
			a3.setFilled(true);
			a3.setFillColor(Color.WHITE);
			GRect a4 = new GRect(5 ,15);
			a4.setFilled(true);
			a4.setFillColor(Color.WHITE);
			GRect a5 = new GRect(5 ,15);
			a5.setFilled(true);
			a5.setFillColor(Color.WHITE);
			GRect a6 = new GRect(5 ,15);
			a6.setFilled(true);
			a6.setFillColor(Color.WHITE);
			GRect b = new GRect(50 ,3);
			b.setFilled(true);
			b.setFillColor(Color.YELLOW);
			GRect c = new GRect(50 ,85);
			c.setFilled(true);
			c.setFillColor(Color.YELLOW);
			GRect d = new GRect(40 ,10);
			d.setFilled(true);
			d.setFillColor(Color.WHITE);
			GRect e = new GRect(50 ,5);
			e.setFilled(true);
			e.setFillColor(Color.YELLOW);
			GRect f = new GRect(0 ,55);
			GRect g = new GRect(0 ,55);
			GRect h = new GRect(0 ,55);
			
			car.add(e);
			car.add(c,0,5);
			car.add(d,5,10);
			car.add(a1,3,25);
			car.add(a2,3,45);
			car.add(a3,3,65);
			car.add(a4,42,25);
			car.add(a5,42,45);
			car.add(a6,42,65);
			car.add(b,0,90);
			car.add(f,20,25);
			car.add(g,25,25);
			car.add(h,30,25);
			return car;
		}
		
		
	}
	/*
	 * Method which is called when the games has finished wither by successfully
	 * traveling the road without hitting any obstacles or when completed the games when
	 * the car hits an obstacle.
	 */
	private void finishGame(){
		//YOUR CODE STARTS HERE
		removeAll();
		GLabel win= new GLabel ("Unfortunately!!! You Lost ");
		win.setFont("Times-BOLD-32");
		add(win,getWidth()/2-win.getWidth()/2,getHeight()/2-win.getHeight()/2);
		println("your text is" +win.getAscent());
		win.setFont("Arial-BOLD-28");
		pause(1000);
		//YOUR CODE ENDS HERE
	}
	
	// Feel free to write any helpers you want to here
	
	// YOUR CODE STARTS HERE
	private GCompound createCar2() {
		
		GCompound car = new GCompound();
		GRect a = new GRect(40 ,50);
		a.setFilled(true);
		a.setFillColor(Color.GREEN);
		GRect b = new GRect(20 ,20);
		b.setFilled(true);
		b.setFillColor(Color.BLUE);
		GRect c = new GRect(5 ,40);
		c.setFilled(true);
		c.setFillColor(Color.GRAY);
		GRect d = new GRect(10 ,50);
		d.setFilled(true);
		d.setFillColor(Color.BLACK);
		GRect e = new GRect(10 ,50);
		e.setFilled(true);
		e.setFillColor(Color.BLACK);
		car.add(a);
		car.add(b,10,10);
		car.add(d,-10,0);
		car.add(e,40,0);
		car.add(c,17.5,-30);
		return car;
	}
private GCompound createCar3() {
		
		GCompound car = new GCompound();
		GRect a1 = new GRect(5 ,15);
		a1.setFilled(true);
		a1.setFillColor(Color.WHITE);
		GRect  a2= new GRect(5 ,15);
		a2.setFilled(true);
		a2.setFillColor(Color.WHITE);
		GRect a3 = new GRect(5 ,15);
		a3.setFilled(true);
		a3.setFillColor(Color.WHITE);
		GRect a4 = new GRect(5 ,15);
		a4.setFilled(true);
		a4.setFillColor(Color.WHITE);
		GRect a5 = new GRect(5 ,15);
		a5.setFilled(true);
		a5.setFillColor(Color.WHITE);
		GRect a6 = new GRect(5 ,15);
		a6.setFilled(true);
		a6.setFillColor(Color.WHITE);
		GRect b = new GRect(50 ,3);
		b.setFilled(true);
		b.setFillColor(Color.YELLOW);
		GRect c = new GRect(50 ,85);
		c.setFilled(true);
		c.setFillColor(Color.YELLOW);
		GRect d = new GRect(40 ,10);
		d.setFilled(true);
		d.setFillColor(Color.WHITE);
		GRect e = new GRect(50 ,5);
		e.setFilled(true);
		e.setFillColor(Color.YELLOW);
		GLine x =new GLine(20,25,20,80);
		GRect g = new GRect(0 ,55);
		GRect h = new GRect(0 ,55);
		
		car.add(e);
		car.add(c,0,5);
		car.add(d,5,10);
		car.add(a1,3,25);
		car.add(a2,3,45);
		car.add(a3,3,65);
		car.add(a4,42,25);
		car.add(a5,42,45);
		car.add(a6,42,65);
		car.add(b,0,90);
		car.add(x);
		car.add(g,25,25);
		car.add(h,30,25);
		
		return car;
	}
private GCompound createCar4(){
	GCompound car = new GCompound();
	GRect a1 = new GRect(5 ,5);
	a1.setFilled(true);
	a1.setFillColor(Color.WHITE);
	GRect a2 = new GRect(5 ,5);
	a2.setFilled(true);
	a2.setFillColor(Color.WHITE);
	GRect w1 = new GRect(2 ,5);
	w1.setFilled(true);
	w1.setFillColor(Color.BLACK);
	GRect w2 = new GRect(2 ,5);
	w2.setFilled(true);
	w2.setFillColor(Color.BLACK);
	GRect w3 = new GRect(2 ,5);
	w3.setFilled(true);
	w3.setFillColor(Color.BLACK);
	GRect w4 = new GRect(2 ,5);
	w4.setFilled(true);
	w4.setFillColor(Color.BLACK);
	GRect b = new GRect(40 ,70);
	b.setFilled(true);
	b.setFillColor(Color.RED);
	GRect c = new GRect(30 ,30);
	c.setFilled(true);
	c.setFillColor(Color.BLACK);
	GRect d = new GRect(10 ,5);
	d.setFilled(true);
	d.setFillColor(Color.WHITE);
	GRect e = new GRect(30 ,5);
	e.setFilled(true);
	e.setFillColor(Color.WHITE);
	car.add(w1,-2,5);
	car.add(w2,-2,60);
	car.add(w3,40,5);
	car.add(w4,40,60);
	car.add(b);
	car.add(e,5,15);
	car.add(a1,5,25);
	car.add(a2,30,25);
	car.add(d,15,25);
	car.add(c,5,35);
	return car;
}
	// it gives number 1
	private GCompound startRace() {
		GCompound number = new GCompound();
		GRect a = new GRect(40 ,200);
		a.setFilled(true);
		a.setFillColor(Color.BLACK);
		GRect b = new GRect(80 ,40);
		b.setFilled(true);
		b.setFillColor(Color.BLACK);
		number.add(a);
		number.add(b,-40,0);
		return number;
	}
	//number 2
	private GCompound startRace2() {
		GCompound number = new GCompound();
		GRect a = new GRect(80,40);
		a.setFilled(true);
		a.setFillColor(Color.BLACK);
		GRect b = new GRect(40 ,80);
		b.setFilled(true);
		b.setFillColor(Color.BLACK);
		GRect c = new GRect(80 ,40);
		c.setFilled(true);
		c.setFillColor(Color.BLACK);
		GRect d = new GRect(40 ,80);
		d.setFilled(true);
		d.setFillColor(Color.BLACK);
		GRect e = new GRect(80 ,40);
		e.setFilled(true);
		e.setFillColor(Color.BLACK);
		
		number.add(a);
		number.add(b,40,0);
		number.add(c,0,80);
		number.add(d,0,80);
		number.add(e,0,160);
		
		return number;
	}
	//number 3
	private GCompound startRace3() {
		GCompound number = new GCompound();
		GRect a = new GRect(80,40);
		a.setFilled(true);
		a.setFillColor(Color.BLACK);
		GRect b = new GRect(40 ,80);
		b.setFilled(true);
		b.setFillColor(Color.BLACK);
		GRect c = new GRect(80 ,40);
		c.setFilled(true);
		c.setFillColor(Color.BLACK);
		GRect d = new GRect(40 ,80);
		d.setFilled(true);
		d.setFillColor(Color.BLACK);
		GRect e = new GRect(80 ,40);
		e.setFilled(true);
		e.setFillColor(Color.BLACK);
		
		number.add(a);
		number.add(b,40,0);
		number.add(c,0,80);
		number.add(d,40,120);
		number.add(e,0,160);
		
		return number;
	}
	// YOUR CODE ENDS HERE
	
	
	//////////// DO NOT CHANGE ANYTHING BELOW THIS LINE!!! ////////////////////
	// Declaring the class constant variables
	// These constants are explained in the pdf
	private static final int LANE_WIDTH = 360;
	private static final int ROAD_HEIGHT = 7200;
	private static final int ROAD_BORDER_WIDTH = 30;
	private static final int LANE_SEPARATION_WIDTH = 15;
	private static final int LANE_SEPARATION_HEIGHT = 40;
	private static final int LANE_SEPARATION_SPACE = 20;
	private static final int ROAD_LINE_WIDTH = 20;
	private static final int ROAD_LINE_HEIGHT = 180;
	private static final int ROAD_LINE_SEPARATION = 100;
	private static final int OBSTACLE_HEIGHT = 30;
	private static final int LENGTH_SAFE_ZONE_START = 360;
	private static final int LENGTH_SAFE_ZONE_END = 3 * ROAD_LINE_SEPARATION / 2 + ROAD_LINE_HEIGHT - OBSTACLE_HEIGHT/2;
	
	private static final int FINISH_LINE_SQUARE_NUM = 30;
	private static final int FINISH_LINE_SQUARE_SIZE = (3 * LANE_WIDTH + 2 * LANE_SEPARATION_WIDTH) / FINISH_LINE_SQUARE_NUM;
	
	private static final int APPLICATION_HEIGHT = ROAD_HEIGHT / 10;
	private static final int APPLICATION_WIDTH = 3 * LANE_WIDTH + 2 * ROAD_BORDER_WIDTH + 2 * LANE_SEPARATION_WIDTH;

	private static final int PAUSE_TIME = 20;
	
	/* Private instance variables */
	private final RandomGenerator rgen = RandomGenerator.getInstance();
	
	// declaring the global variables of the class
	int dx = 12;	
	int dy = 4; 
	private GameMap gameMap;
	private GCompound car;
	private GRect obstacle1;
	private GRect obstacle2;
	/*
	 * Method use to initialize the GameMap class 
	 * (non-Javadoc)
	 * @see acm.program.GraphicsProgram#init()
	 */
	public void init() {
		setProgramSize();
		gameMap = new GameMap(APPLICATION_WIDTH, ROAD_HEIGHT); 
		add(gameMap, 0 , - 0.9 * ROAD_HEIGHT );
		setBackground(Color.GREEN);
	}
	/*
	 * Method for adding listeners to the Key Event for left and right 
	 * navigation of the car
	 * (non-Javadoc)
	 * @see acm.program.Program#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(car.getX() > gameMap.getX())
			gameMap.move(dx, 0);
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(car.getX() + car.getWidth() < gameMap.getX() + gameMap.getWidth()) {
				gameMap.move(-dx, 0);	
			}
		}
	}
	/*
	 * Method for setting the size of the Graphics Program
	 */
	private void setProgramSize() {
		this.setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
	}
}
