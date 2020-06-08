import acm.util.RandomGenerator;

//header to be implemented (adding extends)
public class AdvancedSignal extends Signal{
	static RandomGenerator rgen=RandomGenerator.getInstance();
	//instance variables
	private double min,max;
	//constructors
	public AdvancedSignal(double[] array){
		// Your code starts here
		super(array);
		max=findMax();
		min=findMin();
		// Your code ends here
	}
	
	public AdvancedSignal(int size){
		// Your code starts here
		this(createRandomData(size));
		// Your code ends here
	}
	
	public String toString(){
		// Your code starts here
		return "[random signal with minimum value: "+this.getMin()+" and max value: "+this.getMax()+" ]";
		// Your code ends here
	}
	
	private static double[] createRandomData(int size){
		// Your code starts here
		double[] data=new double[size];
		for (int i = 0; i < data.length; i++) {
			data[i]=rgen.nextDouble();
		}
		return data;
		// Your code ends here
	}	
	
	private double findMax(){
		// Your code starts here
		double max=getDataAtIndex(0);
		for (int i = 1; i < getSignalLength(); i++) {
			max= (max<getDataAtIndex(i)) ? getDataAtIndex(i):max;
		}
		return max;
		// Your code ends here
	}
	
	private double findMin(){
		// Your code starts here
		double min=getDataAtIndex(0);
		for (int i = 1; i < getSignalLength(); i++) {
			min= (min<getDataAtIndex(i)) ? min:getDataAtIndex(i);
		}
		return min;
		// Your code ends here
	}

	//getter and setter methods
	public double getMax() {
		// Your code starts here
		return max;
		// Your code ends here
	}
	public double getMin() {
		// Your code starts here
		return min;
		// Your code ends here
	}

	
}
