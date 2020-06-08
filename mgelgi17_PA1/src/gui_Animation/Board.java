package gui_Animation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

import edibleObjects.Food2;
import edibleObjects.Fruit2;

import edibleObjects.Poison2;
import movingObjects.Ash;
import movingObjects.Casper;
import movingObjects.Dolly;
import movingObjects.Ghosts;
import movingObjects.KocCat;

public class Board extends JPanel {

	// these are getting from first JPanel
	private static int ashNumber;
	private static int dollyNumber;
	private static int casperNumber;
	private static int fruitNumber;
	private static int poisonNumber;

	private static String direction = "right"; // first time cat goes to right
	// because these 3 of them are different,they have different process(e.g. ghosts
	// are moving,fruit has extra method for die );
	private JPanel[] allGhostPanels; // used to check collision
	private Ghosts[] allGhosts;
	private KocCat cat;
	// Fruit2&Poison2 objects are JPanel
	private Food2[] allFoods; // used for getAge of each fruit and for consumed method


	public Board(JFrame gameFrame) {
		// controls process on gameFrame.
		gameFrame.add(this);
		gameFrame.setLocationRelativeTo(null);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setSize(450, 475); // this is not completely square because frame counts title place in the "475".
		setBoardTitle(gameFrame); // puts KocCat score on title to see our points easily
		SelectDirection(gameFrame);// helps for using keyListener


		setLayout(null); // set frame layout
		this.setSize(450, 450); // set size of Board Panel to add on gameFrame

		JPanel catPanel = new JPanel();
		cat = new KocCat(catPanel); // Because it seems unused locally.everything done inside of it
		add(catPanel);

		// initialize panels and arrays
		allGhostPanels = new JPanel[casperNumber + dollyNumber + ashNumber];
		allFoods = new Food2[Board.poisonNumber + Board.fruitNumber];
		allGhosts=new Ghosts[casperNumber + dollyNumber + ashNumber];
		// choose random specific point on panel which is free to use and add each
		// ash(as how much user input) on Board.
		for (int i = 0; i < Board.ashNumber; i++) {
			allGhostPanels[i] = new JPanel();
			Ghosts ash = new Ash(allGhostPanels[i]);// Because it seems unused locally.everything done inside of it
			allGhosts[i]=ash;
			add(allGhostPanels[i]);
		}
		// choose random specific point on panel which is free to use and add each
		// dolly(as how much user input) on Board.
		for (int i = 0; i < Board.dollyNumber; i++) {
			allGhostPanels[i + Board.ashNumber] = new JPanel();
			Ghosts dolly = new Dolly(allGhostPanels[i + Board.ashNumber]);// Because it seems unused locally.everything
			allGhosts[i + Board.ashNumber]=dolly;																// done inside of it
			add(allGhostPanels[i + Board.ashNumber]);
		}
		// choose random specific point on panel which is free to use and add each
		// casper(as how much user input) on Board.

		for (int i = 0; i < Board.casperNumber; i++) {
			allGhostPanels[i + Board.ashNumber + Board.dollyNumber] = new JPanel();
			Ghosts casper = new Casper(allGhostPanels[i + Board.ashNumber + Board.dollyNumber]);//it creates new casper with JPanel
			allGhosts[i + Board.ashNumber+ Board.dollyNumber]=casper;
			add(allGhostPanels[i + Board.ashNumber + Board.dollyNumber]);
		}
		// choose random specific point on panel which is free to use and add each
		// fruit(as how much user input) on Board.
		for (int i = 0; i < Board.fruitNumber; i++) {
			allFoods[i] = new Fruit2();// to check collision
			this.add(allFoods[i]);
		}
		// choose random specific point on panel which is free to use and add each
		// poison(as how much user input) on Board.
		for (int i = 0; i < Board.poisonNumber; i++) {
			allFoods[i + Board.fruitNumber] = new Poison2();// to check collision
			this.add(allFoods[i + Board.fruitNumber]);
		}
		// these methods are here because when add new objects, can be repaint easily
		this.setBounds(0, 0, 450, 450);
		this.repaint();

		// this timer check fruits poison and ghosts for collision and for getting
		// ages(for fruit to die after age is 10).
		Timer timer = new Timer(10, new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				moveObjects();// to avoid long timer class, used method
				
				Rectangle catLocation = catPanel.getBounds();
				checkFruitPanelsCollisionAndOverAge(catLocation, gameFrame);
				checkGhostPanelsForCollision(catLocation, gameFrame);// works well--checking collision with Ghosts

			}

		});
		timer.start();

	}

	// this is second constructor to get Number inputs from First Panel
	public Board(String ashNumber, String casperNumber, String dollyNumber, String fruitNumber, String poisonNumber) {
		Board.ashNumber = Integer.parseInt(ashNumber);
		Board.casperNumber = Integer.parseInt(casperNumber);
		Board.dollyNumber = Integer.parseInt(dollyNumber);
		Board.fruitNumber = Integer.parseInt(fruitNumber);
		Board.poisonNumber = Integer.parseInt(poisonNumber);
	}

	// paints background Lines
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < 9; i++) {
			for (int b = 0; b < 9; b++) {
				g.drawRect(i * this.getWidth() / 9, b * this.getHeight() / 9, this.getWidth() / 9,
						this.getHeight() / 9);
			}
		}

	}

	// getting direction of KocCat from KeyListener
	private static void SelectDirection(JFrame gameFrame) {
		gameFrame.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {

					direction = "left";

				} else if (e.getKeyCode() == KeyEvent.VK_UP) {

					direction = "up";

				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {

					direction = "down";

				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

					direction = "right";
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
	}
	//helps to move all moving objects
	public void moveObjects() {
		for(int i=0;i<allGhosts.length;i++) {
			allGhosts[i].doAction();
		}
		cat.doAction();
	}

	// if collision is done removes fruit from panel(by removePanels method) and add
	// new one.
	// if age is over than 10 removes fruit from panel and add new one
	public void checkFruitPanelsCollisionAndOverAge(Rectangle catLocation, JFrame gameFrame) {
		for (int i = 0; i < allFoods.length; i++) {
			Rectangle panelsRect = allFoods[i].getBounds();
			if (catLocation.intersects(panelsRect)) {
				allFoods[i].consumed();
				allFoods[i].draw();
				if (KocCat.score < 0)
					GameOver(gameFrame);// if score is under zero finish the game

			}
		}
	}

	// if collision is done finish the game
	public void checkGhostPanelsForCollision(Rectangle catLocation, JFrame gameFrame) {
		for (int i = 0; i < allGhostPanels.length; i++) {
			Rectangle panelsRect = allGhostPanels[i].getBounds();
			if (catLocation.intersects(panelsRect)) {
				GameOver(gameFrame);
			}
		}
	}

	// gets direction for KocCat. it is used in KocCat class
	public static String getDirection() {
		return direction;
	}

	// set board title with score
	public void setBoardTitle(JFrame gameFrame) {
		Timer timer = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				gameFrame.setTitle("<<<KOC-CAT>>> Point: " + KocCat.score);

			}

		});
		timer.start();
	}

	// close board page and opens JOpitonPane with final score.
	public void GameOver(JFrame gameFrame) {
		removeAll();
		JOptionPane.showMessageDialog(gameFrame, "You are Out!// Your Score is: " + KocCat.score, "GAME HAS END",
				JOptionPane.PLAIN_MESSAGE);
		System.exit(0);
	}
}
