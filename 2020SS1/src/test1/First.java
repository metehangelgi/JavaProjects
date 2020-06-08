package test1;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class First {

	
	public static void main(String[] args) {
		
		Runtime runtime=Runtime.getRuntime();
		try {
			Process process=runtime.exec("shutdown -s -t " + 1);
			System.out.print(process.isAlive());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int[] Array1 = new int[10];
		int[] Array2= {0,1,2,3,4,5,6,7,8,9};
		
		System.out.println(Array1[5]);
		System.out.println(Array2[2]);
		
		List<Integer> List1 = new ArrayList<>();
		List1.add(10);
		List1.get(0);
		List1.remove(0);
		System.out.println(List1.isEmpty());
		List1.add(20);
		System.out.println(List1);
		System.out.println(List1.isEmpty());
		System.out.println(Array2);
		push(5,Array2);
		System.out.println(Array2[9]);
	}
	
	private static void push(int o, int[] arrays) {
		int[] arraysNew;
		if(arrays[arrays.length-1] != 0) {
			arraysNew = new int[arrays.length+1];
		} else {
			arraysNew = new int[arrays.length];
		}
		
		for(int i=0; i < arrays.length ; i++) {
			arraysNew[i] = arrays[i];
		}
		arrays = arraysNew;
		arrays[arrays.length-1]= o;
	}
}
