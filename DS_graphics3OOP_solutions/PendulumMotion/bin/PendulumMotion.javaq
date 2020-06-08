/*
 * (**) In this problem we will simulate the pendulum motion. You will
 * implement the Pendulum class. Pendulum class extends to GCompound and
 * has 2 fields called theta and length. Recall that you can find the
 * angle of the pendulum at any time from its initial angle and length of
 * the rope (equation for the unfamiliar at end). Pendulum constructor
 * takes two variables thet and len which are initial angle and length of
 * the roper. You should also create and add the ball and rope (line)
 * that you will animate. Step function takes an argument t which is the
 * time. Step function should set the location of the ball and rope
 * according to given time. Initial position of the ball and rope can be
 * determined from givens.
 * theta = theta0 * cos(sqrt(g / length) * t)
 */

import acm.program.*;

public class PendulumMotion extends GraphicsProgram{

	public void run() {
		Pendulum p1 = new Pendulum(30, 800);
		add(p1, 400, 0);
		Pendulum p2 = new Pendulum(30, 450);
		add(p2, 400, 0);
		Pendulum p3 = new Pendulum(30, 288);
		add(p3, 400, 0);
		Pendulum p4 = new Pendulum(30, 200);
		add(p4, 400, 0);
		Pendulum p5 = new Pendulum(30, 72);
		add(p5, 400, 0);
		Pendulum p6 = new Pendulum(30, 50);
		add(p6, 400, 0);
		for (int i = 0; i < 15000; i++) {
			p1.step(i / 10.0);
			p2.step(i / 10.0);
			p3.step(i / 10.0);
			p4.step(i / 10.0);
			p5.step(i / 10.0);
			p6.step(i / 10.0);
			pause(10);
		}
	}
}
