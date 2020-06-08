/*
 * (*) You are given the base class TrainCar. Boxcar and Engine classes extend 
 * to TrainCar class. Run the program and study the code to understand what base class 
 * and other classes do. Then do the necessary modifications in order to create a train 
 * and make it move until it exits the window with animation.
 */

import java.awt.Color;
import acm.program.*;

public class TrainRun extends GraphicsProgram{

	public void run() {
		setSize(800, 200);

		// Construct a train with one engine and two boxcars
		// Use train.append to add new cars
		Train train = new Train();
		train.append(new Engine(Color.RED));
		train.append(new Boxcar(Color.GREEN));
		train.append(new TrainCar(Color.BLUE));
		add(train, 400, 100);

		// Make the train move left until it exits the window
		// Your code starts here
		
		// Your code ends here
	}
}
