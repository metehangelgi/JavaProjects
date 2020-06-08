package denemeArray;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class test {

	public static void main(String[] args) {
		Point[][] points=new Point[9][9];
		points[1][1]=new Point(10,10);
		JPanel panels=new JPanel();
		JPanel panels2=new JPanel();
		panels.setBounds(50, 50, 20, 20);
		panels2.setBounds(50, 40, 10, 10);
		for(int i=0;i<9;i++) {
			for(int a=0;a<9;a++) {
				System.out.println(points[i][a]);
			}
		}
		
		
		Rectangle rectPanel=panels.getBounds();
		Rectangle rectPanel2=panels2.getBounds();
		if(rectPanel.intersects(rectPanel2)) System.out.println("doğru çalışıyorum");;
	}

}
