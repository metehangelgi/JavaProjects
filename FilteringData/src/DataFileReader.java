import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class DataFileReader {
	public static double[] readDoubleArray(String filename){
		//Your code starts here
		try {
			BufferedReader rd=new BufferedReader(new FileReader(filename));
			ArrayList<Double> dataList=new ArrayList<Double>();
			while(true){//reading until end of file is reached
				String line=rd.readLine();
				if(line==null){
					rd.close();break;
				}
				dataList.add(Double.parseDouble(line));
			}
			//file read, copy content of arraylist to an array
			double[] data=new double[dataList.size()];
			for(int i=0;i<dataList.size();i++){
				data[i]=dataList.get(i);
			}
			return data;
		} catch (IOException e) {
			e.printStackTrace();return null;
		}
		//Your code ends here
	}
}
