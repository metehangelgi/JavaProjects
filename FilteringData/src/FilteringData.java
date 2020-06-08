import java.awt.Color;

import acm.graphics.GCompound;
import acm.graphics.GLine;
import acm.program.GraphicsProgram;


public class FilteringData extends GraphicsProgram{
	//Coordinates of the origin for the plot
	double orgX=10;double orgY=300;

	public void run(){
		//reading data from file into an array
		double[] dataArray=DataFileReader.readDoubleArray("USDTRYtable.txt");

		//plotting the original data together with axis lines and labels
		GCompound graph=Draw.plot2D(dataArray,orgX,orgY,true);
		add(graph);

		//filtering the data
		double[] filtArray=movingAverage(dataArray,10);

		//plotting filtered data (without axis lines and labels)
		GCompound filtGraph=Draw.plot2D(filtArray,orgX,orgY,false);
		filtGraph.setColor(Color.RED);
		add(filtGraph);


	}
	//Moving average filter computes a new series of data
	//every i.th point of the new series is obtained as 
	//the average of 2d+1 data points: data[i-d] to data[i+d]
	public double[] movingAverage(double[] data,int d){
		//Your code starts here
		double[] filtered=new double[data.length-d];
		for(int i=d;i<data.length-d;i++){
			double sum=0;
			for(int j=-d;j<=d;j++){
				sum+=data[i+j];
			}
			filtered[i]=sum/(2*d+1);
		}
		return filtered;
		//Your code ends here
	}

}
