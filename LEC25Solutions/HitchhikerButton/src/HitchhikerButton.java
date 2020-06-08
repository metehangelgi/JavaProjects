import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * This program puts up a button on the screen, which triggers a
 * message inspired by Douglas Adams's novel.
 */
public class HitchhikerButton extends ConsoleProgram {

	/* Initializes the user-interface buttons */
	public void init() {
		// Your code starts here
		JButton pushMeButton=new JButton("WTF");
		add(pushMeButton,SOUTH);
		add(new JButton("WTF2"),SOUTH);
		addActionListeners();
		// Your code ends here
	}

	/* Responds to a button action */
	public void actionPerformed(ActionEvent e) {
		// Your code starts here
		if(e.getActionCommand().equals("WTF")) {
			println("please do not push this button again");
		}
		if(e.getActionCommand().equals("WTF2")) {
			println("please do push button ");
		}
		// Your code ends here
	}
}
