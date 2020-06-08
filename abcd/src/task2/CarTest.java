package task2;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CarTest extends JFrame{

	Car  car = new Car();
    public CarTest(){
    	// panel to group buttons
    	//JPanel panel = new JPanel();
    	//panel.add(button);
    	
    	// adding panels to the         
        this.add(car);
        //this.add(panel,BorderLayout.SOUTH);
        
        // registering listeners
//        button.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent event) {
//          	   clock.setCurrentTime();
//            }
//        });
        
        
        // to animate clock
        Timer timer = new Timer(100,new ActionListener() {
            public void actionPerformed(ActionEvent event) {
           	   car.repaint();
             }
         } );
        
        timer.start();
        
    }

    public static void main(String [] args){
        CarTest frame = new CarTest();

        frame.setTitle("DisplayClock");
        frame.setSize(300, 350);

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}


