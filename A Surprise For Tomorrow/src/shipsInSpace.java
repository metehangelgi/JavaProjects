
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;

import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;


public class shipsInSpace extends GraphicsProgram {

	//Ships
	GImage ship1;
	GImage ship2;
	
	//Projectiles
	GObject projectile1;
	GObject projectile2;
	int projectile1Ticks = 0;
	int projectile2Ticks = 0;
	
	//Velocity
	double v1x = 0.0; //Horizontal Velocity of Player 1 
	double v1y = 0.0; //Vertical Velocity of Player 1 
	double v2x = 0.0; //Horizontal Velocity of Player 2
	double v2y = 0.0; //Vertical Velocity of Player 2
	
	//HP
	double hp1 = 100.0;
	double hp2 = 100.0;
	
	//UI
	GRect HPBar1Empty;
	GRect HPBar1Full;
	GRect HPBar2Empty;
	GRect HPBar2Full;
	
	//Debug Text
	GLabel debugger;
	
	public void run() {
	//TODO: Add everything
		player1Initialization();
		player2Initialization();
		initializeScene();
		mainLoop();
	}
	
	private void initializeScene() {
		
		//Add Background
		//Set Run Configurations->Parameters to 720,350
		add(new GImage("SpaceBackground.png"));
		
		//Add UI
		

	    HPBar1Empty = new GRect(0,32,getWidth()/2-30,32);
		HPBar1Full = new GRect(0,32,getWidth()/2-30,32);;
		HPBar2Empty = new GRect(getWidth()/2+30,32,getWidth(),32);
		HPBar2Full = new GRect(getWidth()/2+30,32,getWidth(),32);
		
		add(HPBar1Empty);
		add(HPBar1Full);
		add(HPBar2Empty);
		add(HPBar2Full);
		
		
		HPBar1Empty.setColor(Color.RED);
		HPBar1Full.setColor(Color.GREEN);
		HPBar2Empty.setColor(Color.RED);
		HPBar2Full.setColor(Color.GREEN);
		
		HPBar1Empty.setFilled(true);
		HPBar1Full.setFilled(true);
		HPBar2Empty.setFilled(true);
		HPBar2Full.setFilled(true);
		
		
		//TODO: Pick a Theme Song
		playThemeSong(THEME_SONG);

		

		//Add Ships
		add(ship1,64,32);
		add(ship2,getWidth()-100,32);
		
		//Projectiles
		projectile1 = new GRect(0,0,16,16);
		projectile2 = new GRect(0,0,16,16);

		//Read Key Input
		addKeyListeners();
		
		//Debugger
		debugger = new GLabel("Hey... Feel free to edit me for debugging!");
		debugger.setColor(Color.WHITE);
		add(debugger,100,30);
		
		
	}
	
	private void mainLoop() {
		while(true) {
			//debugger.setLabel(String.valueOf(v1x) + "," + String.valueOf(v1y));
			//debugger.setLabel(String.valueOf(getWidth()));
			
			ship1.move(v1x, v1y);
			v1x-=player1Friction(v1x,"horizontal");
			v1y-=player1Friction(v1y,"vertical");
			if(ship1.contains(projectile2.getX()+projectile2.getWidth()/2,projectile2.getY()+projectile2.getHeight()/2 ))player1Damage(1);
			if(hp1 <= 0) {victory2(); break;}
			
			ship2.move(v2x, v2y);
			v2x-=player2Friction(v2x,"horizontal");
			v2y-=player2Friction(v2y,"vertical");
			if(ship2.contains(projectile1.getX()+projectile1.getWidth()/2,projectile1.getY()+projectile1.getHeight()/2 ))player2Damage(1);
			if(hp2 <= 0) {victory1(); break;}
			
			player1AttackBehaviour();
			player2AttackBehaviour();
			
			pause(PAUSE_TIME);
		}
	}
	
	private void victory1() {
		remove(ship2);
		playVictorySong(VICTORY_SONG1);
	}
	
	private void victory2() {
		remove(ship1);
		playVictorySong(VICTORY_SONG2);
	}
	
	
	private void player1Initialization() {
		//TODO: Pick a Ship
		ship1 = new GImage("ship1.png");
		//TODO: Adjust Ship
		ship1.scale(1.0/24, 1.0/12);
		//TODO: Adjust Controls
		//TODO: Adjust Physics
		//(Customize Motion and make sure the ship stays on screen and within its side)
		
		//TODO: Add Weapon
		//TODO: Pick a Victory Theme
		;
	}
	
	private void player2Initialization() {
		//TODO: Pick a Ship
		ship2 = new GImage("ship2.png");
		//TODO: Adjust Ship
		ship2.scale(1.0/24, 1.0/24);
		//TODO: Adjust Controls
		//TODO: Adjust Physics
		//(Customize Motion and make sure the ship stays on screen and within its side)
		
		//TODO: Add Weapon
		//TODO: Pick a Victory Theme
		;
	}
	
	/**
	 * @param Force a numeric representation of the "Force" applied on the ship.
	 * @param mass Force a numeric representation of the ship's "mass".
	 */
	private double player1Acceleration(double Force, double mass) {
		return Force/mass;
	}
	
	/**
	 * @param velocity either horizontal or vertical velocity
	 * @param direction indicates whether the direction is horizontal or vertical
	 */
	private double player1Friction(double velocity, String direction) {
		return  velocity/20;
	}
	
	private void player1Damage(double rate) {
		hp1 -= rate;
		HPBar1Full.setBounds(0, 32, (hp1/100)*(getWidth()/2) - 30, 32);
	}
	
	private void player1Attack() {
		projectile1 = new GRect(0,0,4,4);
		projectile1.setColor(Color.BLACK);
		((GRect) projectile1).setFilled(true);
		projectile1Ticks = 100;
		add(projectile1,ship1.getX()+ship1.getWidth()/2,ship1.getY()+ship1.getHeight()/2);
	}
	
	private void player1AttackBehaviour() {
		if(projectile1Ticks>0) {
			projectile1.move(40, 0);
		}
		projectile1Ticks--;
		if(projectile1Ticks<=0) {
			remove(projectile1);
		}
	}
	
	/**
	 * @param Force a numeric representation of the "Force" applied on the ship.
	 * @param mass Force a numeric representation of the ship's "mass".
	 */
	private double player2Acceleration(double Force, double mass) {
		return Force/mass;
	}
	
	/**
	 * @param velocity either horizontal or vertical velocity
	 * @param direction indicates whether the direction is horizontal or vertical
	 */
	private double player2Friction(double velocity, String direction) {
		return  velocity/20;
	}
	
	private void player2Damage(double rate) {
		hp2 -= rate;
		HPBar2Full.setBounds( 30 + getWidth()/2 + ((100-hp2)/100)*(getWidth()/2) ,32,getWidth(),32);
	}
	
	private void player2Attack() {
		projectile2 = new GRect(0,0,4,4);
		projectile2.setColor(Color.RED);
		((GRect) projectile2).setFilled(true);
		projectile2Ticks = 100;
		add(projectile2,ship2.getX(),ship2.getY());
	}
	
	private void player2AttackBehaviour() {
		if(projectile2Ticks>0) {
			projectile2.move(-40, 0);
		}
		projectile2Ticks--;
		if(projectile2Ticks<=0) {
			remove(projectile2);
		}
	}
	
	
	
	
	//Player 1 Controls
	private void APressed() {
		v1x-=player1Acceleration(10,3);
		
	}
	private void DPressed() {
		v1x+=player1Acceleration(10,3);

	}
	private void SPressed() {
		v1y+=player1Acceleration(10,3);
	}
	private void WPressed() {
		v1y-=player1Acceleration(10,3);
	}
	private void spacePressed() {
		player1Attack();
	}
	
	//Player 2 Controls
	private void leftPressed() {
		v2x-=player2Acceleration(10,3);
		
	}
	private void rightPressed() {
		v2x+=player2Acceleration(10,3);

	}
	private void downPressed() {
		v2y+=player2Acceleration(10,3);
	}
	private void upPressed() {
		v2y-=player2Acceleration(10,3);
	}
	private void shiftPressed() {
		player2Attack();
	}
	
	
	
	//Predefined
	
	//DO NOT TOUCH
	
	public void keyPressed(KeyEvent e){
		
		//Player 1
		if(e.getKeyCode() == KeyEvent.VK_A) {
			APressed();
			//return;
		}
		
	    if(e.getKeyCode() == KeyEvent.VK_D) {
			DPressed();
			//return;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			SPressed();
			//return;
		}
		if(e.getKeyCode() == KeyEvent.VK_W) {
			WPressed();
			//return;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			spacePressed();
			//return;
		}
		
		//Player 2
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			leftPressed();
			//return;
		}
		
	    if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rightPressed();
			//return;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			downPressed();
			//return;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			upPressed();
			//return;
		}
		if(e.getKeyCode() == KeyEvent.VK_SHIFT) {
			shiftPressed();
			//return;
		}
		
	}
		
	/**
	 * This method (shamelessly stolen from the Mario homework) plays the given audio file continuously in a loop.
	 * @param fileLocation Location of the audio file. 
	 */
	private void playThemeSong(String fileLocation) {
		
		try {
			inputStream = AudioSystem.getAudioInputStream(new File(fileLocation));
			clip = AudioSystem.getClip();
			clip.open(inputStream);
			clip.loop(Clip.LOOP_CONTINUOUSLY);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * This method (shamelessly stolen from the Mario homework) closes the currently playing audio files and plays the given audio file 
	 * @param fileLocation Location of the audio file.
	 */
	private void playVictorySong(String fileLocation) {
		try {
			clip.close();
			inputStream.close();
			inputStream = AudioSystem.getAudioInputStream(new File(fileLocation));
			clip.open(inputStream);
			clip.start();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	private static final String THEME_SONG = "mainTheme.wav";
	private static final String VICTORY_SONG1 = "victory1.wav";
	private static final String VICTORY_SONG2 = "victory2.wav";
	private static final int PAUSE_TIME = 16;

	private Clip clip;
	private AudioInputStream inputStream;
	
}

