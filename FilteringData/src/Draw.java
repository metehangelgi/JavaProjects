import java.util.Collections;

import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GLine;


public class Draw extends GCompound{
	/**
	 * method to create graphical object for the plot
	 * @param data: data sequence to be plotted 
	 * @param originX: coordinate of x axis for origin
	 * @param originY: coordinate of y axis for origin
	 * @param addAxisComponents: boolean to specify if the axis will be added to the graph or not
	 * @return
	 */
	public static GCompound plot2D(double[] data,double originX,double originY,boolean addAxisComponents){
		
		//computing the factor to set dynamic range 
		//to 0.9 of maximum positive range
		double maxVal=max(data);
		double fact=originY*0.9/maxVal;
		
		GCompound graph=new GCompound();
		//adding lines between consecutive data points 
		for(int i=0;i<data.length-1;i++){
			GLine l=new GLine(originX+i,originY-data[i]*fact,originX+i+1,originY-data[i+1]*fact);
			graph.add(l);
		}
		
		if(addAxisComponents){
			//adding lines for axis
			GLine xax=new GLine(originX,originY,originX+data.length,originY);
			graph.add(xax);
			GLine yax=new GLine(originX,originY,originX,originX);
			graph.add(yax);
			//adding labels
			GLabel origin=new GLabel("(0,0)");
			graph.add(origin,0,originY+originX);
			GLabel yLabel=new GLabel("Value");
			graph.add(yLabel,0,originX);
			GLabel xLabel=new GLabel("Index");
			graph.add(xLabel,originX+data.length/2,originY+originX);
		}
		return graph;
	}
	private static double max(double[] data){
		double max=Double.MIN_VALUE;
		for(int i=0;i<data.length;i++){
			if(data[i]>max)
				max=data[i];
		}
		return max;
	}
	private static double min(double[] data){
		double min=Double.MAX_VALUE;
		for(int i=0;i<data.length;i++){
			if(data[i]<min)
				min=data[i];
		}
		return min;
	}
}
