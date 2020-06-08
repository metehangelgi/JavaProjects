import acm.program.ConsoleProgram;

public class ResampleAnArray extends ConsoleProgram{
	public void run(){
		int N=readInt("Specify N:");
		int deltaInd=readInt("Specify resampling rate : ");
		int[] array=createArray(N);
		println("Array created : "+arrayToString(array));
		println("Resampled array : "+arrayToString(resample(array,deltaInd)));
	}
	private int[] createArray(int N){
		// Your code starts here
		int[] arrr=new int[2*N+1];
		for(int i=0;i<arrr.length;i++) {
			arrr[i]=i-N;
		}
		// Your code ends here
	}
	private String arrayToString(int[] array){
		String result="";
		for(int ind=0;ind<array.length;ind++){
			result+=(array[ind]+" ");
		}
		return result;
	}
	private int[] resample(int[] array, int deltaInd){
		// Your code starts here
		int newLength=(array.length/deltaInd)+1;
		
		// Your code ends here
	}
}
