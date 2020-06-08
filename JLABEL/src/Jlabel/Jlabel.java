package Jlabel;

import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.*;

public class Jlabel extends JFrame {

	
	
	
	public Jlabel() {
		super("Testing JTextField and JPasswordField");
	     // this.setTitle("bu başlık mı?");
	      setLayout(new FlowLayout());
	      
	      Image image=new ImageIcon("/Users/metehangelgi/eclipse-workspace/JLABEL/src/Jlabel/casper.png").getImage();
	      JPanel panelim =new JPanel();
			JLabel labelim=new JLabel("bir şey söyleee");
			JLabel labelim2=new JLabel();
			labelim2.setIcon(new ImageIcon(image));
			panelim.add(labelim);
			panelim.add(labelim2);
			add(panelim);
			validate();
			
	}
	 
	
	
	
}
