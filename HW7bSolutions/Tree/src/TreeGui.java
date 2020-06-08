import javax.swing.*;
import java.awt.event.*;

import acm.program.*;

/*
 * TreeGui class uses a Tree object and makes interactions with three buttons.
 */

public class TreeGui extends GraphicsProgram{

    private Tree tr;

    public void init(){
	// Your code starts here
	tr = new Tree();
	add(tr, getWidth()/2, getHeight()/2);
	add(new JButton("Red"),SOUTH);
	add(new JButton("Yellow"),SOUTH);
	add(new JButton("Blue"),SOUTH);
	// Your code ends here

	addActionListeners();
    }

    public void actionPerformed(ActionEvent e) {
	// Your code starts here
	tr.changeColor(e.getActionCommand());
	// Your code ends here
    }
}
