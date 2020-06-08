/*
 * (**) Implement the Bug compound. Its constructor takes an integer for number
 * of leg pairs, a boolean for orientation, and a color. Pair of legs
 * determine how many legs that bug has. Each bug has a head and a
 * tail. There are also spacing between legs as well. If the orientation
 * is true than bug is standing upright (legs are looking to left and
 * right). If it is false than bug is heading to left. Given values are
 * for the upright bugs, you should use suitable values for left-heading
 * bugs, as well.
 */

import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import java.awt.Color;

public class RandomBugs extends GraphicsProgram{

	public void run() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				GCompound b = createBug(rgen.nextInt(2, 7), rgen.nextBoolean(), rgen.nextColor());
				add(b, 50 + i * 100, 50 + j * 100);
			}
		}
	}


	private GCompound createBug(int pair_of_legs, boolean orientation, Color color) {
		GCompound c = new GCompound();
		// Your code starts here
		if (orientation == true) {
			double body_height = pair_of_legs * LEGS_HEIGHT +
					(pair_of_legs - 1) * BETWEEN_LEGS +
					HEAD_HEIGTH + TAIL_HEIGHT;
			GRect body = new GRect(HEAD_TAIL_WIDTH, body_height);
			body.setFilled(true);
			body.setFillColor(color);
			c.add(body, -HEAD_TAIL_WIDTH / 2, -body_height / 2);

			double legs_width = 2 * LEGS_WIDTH + HEAD_TAIL_WIDTH;
			for (int i = 0; i < pair_of_legs; i++) {
				GRect legs = new GRect(legs_width, LEGS_HEIGHT);
				legs.setFilled(true);
				legs.setFillColor(color);
				c.add(legs, -legs_width / 2, -body_height / 2 +
						HEAD_HEIGTH + i * (BETWEEN_LEGS + LEGS_HEIGHT));
			}			
		} else {
			double body_width = pair_of_legs * LEGS_HEIGHT +
					(pair_of_legs - 1) * BETWEEN_LEGS +
					HEAD_HEIGTH + TAIL_HEIGHT;
			GRect body = new GRect(body_width, HEAD_TAIL_WIDTH);
			body.setFilled(true);
			body.setFillColor(color);
			c.add(body, -body_width / 2, -HEAD_TAIL_WIDTH / 2);

			double legs_height = 2 * LEGS_WIDTH + HEAD_TAIL_WIDTH;
			for (int i = 0; i < pair_of_legs; i++) {
				GRect legs = new GRect(LEGS_HEIGHT, legs_height);
				legs.setFilled(true);
				legs.setFillColor(color);
				c.add(legs, -body_width / 2 + HEAD_HEIGTH + 
						i * (BETWEEN_LEGS + LEGS_HEIGHT),
						-legs_height / 2);
			}	
		}
		// Your code ends here
		return c;
	}

	private static final double HEAD_TAIL_WIDTH	= 10;
	private static final double HEAD_HEIGTH 	= 10;
	private static final double TAIL_HEIGHT		= 10;
	private static final double BETWEEN_LEGS	= 5;
	private static final double LEGS_WIDTH		= 20;
	private static final double LEGS_HEIGHT		= 5;

	RandomGenerator rgen = RandomGenerator.getInstance();

}
