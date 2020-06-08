import java.io.IOException;


public class MainFuncForDelay {
	//!! No external library is used
	//!! This is standard Java
	public static void main(String[] arr) throws IOException{
		//Initializing the file names
		String inputFileName="1.wav";
		String outputFileName="output.wav";
		
		//Reading the input file
		WaveFileReader reader = new WaveFileReader(inputFileName);
		float[] soundSignal=reader.getFloatArray();
		
		//Sampling freq.=22050Hz. i.e 22050 samples are taken each second
		//2205 samples correspond to a delay of 100 msec.s
		int delayInNumberOfSamples=2205;
		
		//creating a new signal composed of the original plus the delayed version
		soundSignal=addDelay(soundSignal,delayInNumberOfSamples);
		
		//Writing to output file
		new WaveFileWriter(soundSignal,reader.getSamplingFreq(),reader.getBitRate(),1,outputFileName);
		System.out.println("End of program. Output signal is written to the new file");
	}

	private static float[] addDelay(float[] inArray, int delay){
		float[] mixedArray=new float[inArray.length];
		// Your code starts here
		
		// Your code ends here
		//return an array that contains the original plus the delayed
		return mixedArray;
	}

}
