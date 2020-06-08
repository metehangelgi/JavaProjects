package com.home.simplexmethod;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	SimplexMethodWrapper wrapper;
	JPanel constraintsPanel;
	SimplexMethodParser parser;
	ArrayList<JTextField> constraints = new ArrayList<JTextField>();
	
    public MainWindow() {
        initUI();
        wrapper = new SimplexMethodWrapper(this);
        parser = new SimplexMethodParser();
    }
    
    public void showNotification(String message) {
    	JOptionPane.showMessageDialog(null, message);
    }
    
    public void addComponentsToPane(Container pane) {

	    JButton button;
	    pane.setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();
	    c.fill = GridBagConstraints.HORIZONTAL;
	    
	    JLabel labelTop = new JLabel("Revised Simplex Method");
	    labelTop.setFont(new Font("Serif", Font.PLAIN, 18));
	    c.gridwidth = 2;
	    c.gridx = 0;
	    c.gridy = 0;
	    c.insets = new Insets(0, 10, 20 , 10);
	    pane.add(labelTop,c);
	    
	    JLabel labelZ = new JLabel("LP maximizing problem:");
	    c.gridwidth = 1;
	    c.gridx = 0;
	    c.gridy = 1;
	    c.insets = new Insets(0, 10, 0 , 10);
	    pane.add(labelZ,c);
	    
	    final JTextField z = new JTextField("x1+3x2+x3+4x4");
	    c.gridwidth = 3;
	    c.gridx = 0;
	    c.gridy = 2;
	    pane.add(z,c);
	    
	    JLabel labelConstraints = new JLabel("Constraints:");
	    c.gridwidth = 1;
	    c.gridx = 0;
	    c.gridy = 3;
	    pane.add(labelConstraints,c);
	    
	    constraintsPanel = new JPanel();
	    c.gridwidth = 2;
	    c.gridx = 0;
	    c.gridy = 4;
	    constraintsPanel.setLayout(new BoxLayout(constraintsPanel, BoxLayout.Y_AXIS));
	    final JTextField constr = new JTextField("x1+x2+x3+x4<=40");
	    constraintsPanel.add(constr);
	    constraints.add(constr);
	    final JTextField constr1 = new JTextField("(-)2x1+(-)x2+x3+x4<=10");
	    constraintsPanel.add(constr1);
	    constraints.add(constr1);
	    final JTextField constr2 = new JTextField("x2+(-)x4<=10");
	    constraintsPanel.add(constr2);
	    constraints.add(constr2);
	    pane.add(constraintsPanel,c);
	    
	    JButton addNewBtn = new JButton("Add new constraint");
	    c.gridwidth = 1;
	    c.gridx = 0;
	    c.gridy = 5;
	    c.insets = new Insets(10,10,10,10);
	    pane.add(addNewBtn,c);
	    addNewBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				JTextField constr = new JTextField("Enter constraint");
				constraintsPanel.add(constr);
				constraints.add(constr);
				constraintsPanel.revalidate();
			}
	    	
	    });
	    
	    JRadioButton radioButton = new JRadioButton("MPF",true);
	    c.weightx = 0.5;
	    c.insets = new Insets(0,0,0,0);
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridwidth = 1;
	    c.gridx = 0;
	    c.gridy = 6;
	    pane.add(radioButton, c);
	    
	    radioButton = new JRadioButton("NPF",false);
	    c.weightx = 0.5;
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridwidth = 1;
	    c.gridx = 0;
	    c.gridy = 7;
	    pane.add(radioButton, c);
	    
	    radioButton = new JRadioButton("Forrest-Tomlin",false);
	    c.weightx = 0.5;
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridwidth = 1;
	    c.gridx = 0;
	    c.gridy = 8;
	    pane.add(radioButton, c);
	 
	    button = new JButton("Start Work");
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.weighty = 1.0;
	    c.weightx = 0.4;
	    c.anchor = GridBagConstraints.PAGE_END; 
	    c.insets = new Insets(10,0,10,10);  
	    c.gridx = 0;      
	    c.gridwidth = 1;   
	    c.gridy = 10; 
	    button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				parser.clear();
				parser.parseZ(z.getText());
				for(int i=0;i<constraints.size();i++) {
					parser.parseConstraint(constraints.get(i).getText());
				}
				parser.writeToFile();
				wrapper.startWork();
			}
	    });
	    pane.add(button, c);
	 
	    button = new JButton("Exit");
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.weighty = 1.0;
	    c.weightx = 0.4;
	    c.anchor = GridBagConstraints.PAGE_END; 
	    c.insets = new Insets(10,0,10,10);  
	    c.gridx = 1;      
	    c.gridwidth = 1;   
	    c.gridy = 10;  
	    button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
	    });
	    pane.add(button, c);
    }
    public final void initUI() {
       JPanel panel = new JPanel();
       getContentPane().add(panel);
       this.addComponentsToPane(panel);
       setTitle("Revised Simplex Method");
       setSize(500, 400);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
