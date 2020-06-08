/*
 * File: factorialSeries.java
 * ----------------------
 * This program calculates the factorial series.
 */

import acm.program.*;
import javafx.scene.chart.XYChart.Series;

public class factorialSeries extends ConsoleProgram {

	public void run() {
		double series=1;
		for (int i=SERIES_START; i <=SERIES_END; i++){
			series +=1/factorial(i);
		}
		println(series);
	}


    //Implement helper method factorial() here
	private double factorial(int a) {
		double result=1;
		for(int i=1; i<=a;i++) {
			result *= i;
		}
		return result;
	}
/*
 * Returns the factorial of n, which is defined as the
 * product of all integers from 1 up to n.
 */



/* Private constants */
	private static final int SERIES_START = 1;
	private static final int SERIES_END = 10;

}
