package gui_Animation;


import java.awt.FlowLayout;
import java.awt.Font;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import javax.swing.JTextField;

public class FirstJPanel extends JFrame {

	private JPanel panel;
	private JTextField numAsh;
	private JTextField numDolly;
	private JTextField numCasper;
	private JTextField FruitBox;
	private JTextField PoisonBox;

	private static int NumberOfAsh;
	private static int NumberOfCasper;
	private static int NumberOfDolly;
	private static int NumberOfFruit;
	private static int NumberOfPoison;
	private JFrame gameFrame;
	public FirstJPanel(JFrame gameFrame) {
		super("KOC-CAT");
		
		this.gameFrame=gameFrame;
		JPanel LabelPanel = new JPanel();
		panel = new JPanel(new GridLayout(2, 1));// it is a general panel to group items.
		
		JPanel buttonPanel=new JPanel();
		setLayout(new FlowLayout()); // set frame layout
		this.setSize(450, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		JLabel headLabel = new JLabel("GAME PANEL");// it will shown in first panel as a BOLD Title
		LabelPanel.add(headLabel);
		headLabel.setFont(new Font("Serif", Font.BOLD, 20));//set font
		
		ChooseGhostNum();//choose ghosts
		ChooseFood();//choose foods

		
		JButton startButton = new JButton("Start Game");
		ListenForButton ButonL = new ListenForButton();
		startButton.addActionListener(ButonL);
		buttonPanel.add(startButton);
		this.add(LabelPanel);
		this.add(panel);
		this.add(buttonPanel);//button is identical from gridlayout
	}

	// if player enters zero or below raise exception.
	private void ChooseGhostNum() {
		JLabel ashL = new JLabel("#Ash");
		JLabel dollyL = new JLabel("#Dolly");
		JLabel casperL = new JLabel("#Casper");

		numAsh = new JTextField("", 5);
		numDolly = new JTextField("", 5);
		numCasper = new JTextField("", 5);

		JPanel panelGhosts = new JPanel(new GridLayout(3, 3));

		panelGhosts.add(ashL);
		panelGhosts.add(numAsh);
		numAsh.addActionListener(new ListenForButton());
		panelGhosts.add(dollyL);
		panelGhosts.add(numDolly);
		numDolly.addActionListener(new ListenForButton());
		panelGhosts.add(casperL);
		panelGhosts.add(numCasper);
		numCasper.addActionListener(new ListenForButton());
		
		//set Head of group layout
		panelGhosts.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Choosing Ghosts"));

		panel.add(panelGhosts);

	}

	private void ChooseFood() {

		JLabel fruitL = new JLabel("Fruit");
		JLabel poisonL = new JLabel("Poison");
		FruitBox = new JTextField("", 5);
		PoisonBox = new JTextField("", 5);

		JPanel panelFood = new JPanel(new GridLayout(2, 2));

		panelFood.add(fruitL);
		panelFood.add(FruitBox);
		FruitBox.addActionListener(new ListenForButton());
		panelFood.add(poisonL);
		panelFood.add(PoisonBox);
		PoisonBox.addActionListener(new ListenForButton());
		
		//set Head of group layout
		panelFood.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Choosing Foods"));

		panel.add(panelFood);

	}
	
	//when button clicked sets Frame invisible
	public void setFirstFrame() {
		this.setVisible(false);
		
	}

	// listen for button determines #ash,dolly,casper
	private class ListenForButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				NumberOfDolly = Integer.parseInt(numDolly.getText());
				NumberOfAsh = Integer.parseInt(numAsh.getText());
				NumberOfCasper = Integer.parseInt(numCasper.getText());
				NumberOfFruit = Integer.parseInt(FruitBox.getText());
				NumberOfPoison = Integer.parseInt(PoisonBox.getText());

				
				
				
				// listen for input for less than zero
				if (NumberOfDolly <= 0 | NumberOfAsh <= 0 | NumberOfCasper <= 0 | NumberOfFruit <= 0
						| NumberOfPoison <= 0)
					throw new NumberFormatException();
				Board board = new Board("" + NumberOfAsh, "" + NumberOfCasper, "" + NumberOfDolly, "" + NumberOfFruit,
						"" + NumberOfPoison);
				setFirstFrame(); //sets first frame invisible
				Board gameBoard=new Board(gameFrame);
				gameFrame.setVisible(true);
			} catch (NumberFormatException excep) {// if number is less than zero gives error page
				JOptionPane.showMessageDialog(FirstJPanel.this, "Please enter a bigger valid number than zero!",
						"Error", JOptionPane.ERROR_MESSAGE);
			}

		}

	}

}
