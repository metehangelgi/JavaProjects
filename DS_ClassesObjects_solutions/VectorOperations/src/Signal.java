
public class Signal {
	//instance variables
	private double[] data;
	
	//constructor
	public Signal(double[] array){
		data = new double[array.length];
		for (int i=0; i<data.length; i++)
			data[i] = array[i];
	}
	
	public String toString(){
		String dataStr="[";
		for (int i = 0; i < data.length; i++) {
			dataStr=dataStr+" "+data[i];
		}
		dataStr=dataStr+"]";
		return dataStr;
	}
	public double dotProduct(Signal inSig){
		// Your code starts here
		if(inSig.data.length==data.length){
			Double sum=(double) 0;
			for (int i = 0; i < data.length; i++) {
				sum+=data[i]*inSig.getDataAtIndex(i);
			}
			return sum;
		} else{
			return 0;
		}
		// Your code ends here
	}
	public double getDataAtIndex(int index){
		return data[index];
	}
	
	public int getSignalLength(){
		return data.length;
	}
	
}
