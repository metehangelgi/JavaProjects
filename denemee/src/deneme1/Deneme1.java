package deneme1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Deneme1 extends JFrame implements DenemeInterFace{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
	
	
	public Deneme1() {
		Panel panelim =new Panel();
		this.add(panelim);
		
		
		
		
		
        //this.add(panel,BorderLayout.SOUTH);
        
        // registering listeners
//        button.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent event) {
//          	   clock.setCurrentTime();
//            }
//        });
        
        
        // to animate clock
        Timer timer = new Timer(1000,new ActionListener() {
            public void actionPerformed(ActionEvent event) {
           	   panelim.repaint();
             }
         } );
        
        timer.start();
	}
	
	public static void main(String[] args) {
		Deneme1 checkBoxFrame = new Deneme1(); 
	      checkBoxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      checkBoxFrame.setSize(275, 100); 
	      checkBoxFrame.setVisible(true); 
		
		
		
	}

}
