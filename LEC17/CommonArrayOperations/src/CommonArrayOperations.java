import acm.program.ConsoleProgram;

public class CommonArrayOperations extends ConsoleProgram{
	public void run(){
		//sourceArray and targetArray are defined as global variables
		//initializing an array
		initTargetArray();
		//printing all elements of an array
		println("-----SourceArray----");
		printArray(sourceArray);
		println("-----TargetArray----");
		printArray(targetArray);
		//copying part of an array into another one
		copySubArray(targetArray,5,sourceArray,1,3);
		println("-----new TargetArray----");
		printArray(targetArray);	
		//search for the first index of an specified value in an array
		println("-----searching for 30 in TargetArray----");
		int ind=indexOf(targetArray,30);
		println("Element 30 found at index: "+ind);
		//cyclic rotation of an array (of 5 samples)
		int numSamples=4;
		rotateArrayToLeft(sourceArray,numSamples);
		println("-----rotated SourceArray by "+numSamples+" samples to left----");
		printArray(sourceArray);	
	}
	private void initTargetArray(){
		for(int ind=0;ind<targetArray.length;ind++){
			targetArray[ind]=0;
		}
	}
	private void printArray(int[] array){
		print("[");
		for(int ind=0;ind<array.length;ind++){
			print(array[ind]+" ");
		}	
		println("]");
	}
	private void copySubArray(int[] targetArray,int targetStartInd,int[] sourceArray,int sourceStartInd,int subArrayLen){
		//check if the sizes permit the operation
		if((targetStartInd+subArrayLen)<targetArray.length && (sourceStartInd+subArrayLen)<sourceArray.length && targetStartInd>0 && sourceStartInd>0){
			for(int ind=sourceStartInd;ind<(sourceStartInd+subArrayLen);ind++){
				targetArray[targetStartInd+ind-sourceStartInd]=sourceArray[ind];
			}
		}else{
			println("Index of out of range. Operation not performed");
		}
	}
	private int indexOf(int[] array,int x){
		for(int ind=0;ind<array.length;ind++){
			if(array[ind]==x){
				return ind;
			}
		}
		return -1;
	}
	private void rotateArrayToLeft(int[] array,int numSamples){
		int[] copyArray=new int[array.length];
		for(int k=0;k<array.length;k++){
			copyArray[k]=array[k];
		}
		for(int k=0;k<array.length;k++){
			array[k]=copyArray[(k+numSamples)%array.length];
		}		
	}
	int[] sourceArray={10,20,30,40,50,60,70,80};
	int[] targetArray=new int[20];

}
