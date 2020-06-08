/*
 * File: ChessBoard.java
 * -------------------------
 * This program draws a Chess board as an illustration
 * of the GLine class. 
 * 
 * Class: ChessBoard.java
 * Score: (Challenging)
 * Prerequisites: For Loops, ACM Task Force Graphics Commands
 */

import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

public class ChessBoard extends GraphicsProgram {

	public void run() {


		double sqSize= (double)getHeight()/N_ROWS;
		
			for(int i=0;i<N_ROWS;i++) {
			for (int j = 0; j < N_COLUMNS; j++) {
				// Your code starts here
				double x = j*sqSize;
				double y = i*sqSize;
				GRect sq =new GRect (x,y,sqSize,sqSize);
				add(sq);
				
				sq.setFilled((i+j)%2!=0);
				sq.setFillColor(Color.BLACK);
				sq.move(sqSize, sqSize);
				pause(500);
				sq.move(-sqSize, -sqSize);
				
				
				
				// Your code ends here
			}
		}

	}

	//Global Variable Declarations
	private static final int N_ROWS = 8;
	private static final int N_COLUMNS = 8;

}
