/*
 * File: TicTacToeBoard.java
 * -------------------------
 * This program draws a Tic-Tac-Toe board as an illustration
 * of the GLine class.  
 * 
 * Class: TicTacToeBoard.java
 * Score: (Easy)
 * Prerequisites: ACM Task Force Graphics Commands
 */

import acm.graphics.*;
import acm.program.*;

public class TicTacToeBoard extends GraphicsProgram {

	public void run() {
		// Your code starts here
		
		double cx= getWidth()/2;
		double cy =getHeight()/2;
		
		double x0 =cx-BOARD_SIZE/2;
		double y0 =cy-BOARD_SIZE/2;
		println("hghgfhgfhfg");
		double delta= BOARD_SIZE/3;
		
		add(new GLine(x0, y0+delta, cx+BOARD_SIZE/2, y0+delta) );
		add(new GLine(x0, y0+(2*delta), cx+BOARD_SIZE/2, y0+(2*delta)) );
		add(new GLine(x0+delta, y0, x0+delta, cy+BOARD_SIZE/2) );
		add(new GLine(x0+(2*delta), y0, x0+(2*delta), cy+BOARD_SIZE/2) );
		
		// Your code ends here
	}

	//Global Variable Declarations
	private static final double BOARD_SIZE = 90;

}
