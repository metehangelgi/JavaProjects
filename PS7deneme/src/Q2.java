import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;


public class Q2 {

	
	
	public static void main(String[] args) {
		PriorityQueue<Double> test=new PriorityQueue<>();
		
		
		test.offer(3.2);
		test.offer(9.8);
		test.offer(5.4);
		double temp1;
		System.out.println("reverse polling from queue");
		Set<Double> newSet=new TreeSet<>();
		List<Double> newList =new ArrayList<>();
		
		//java.util.Iterator<Double> testIter=test.iterator();
		
		
		while(test.size()>0) {
			//System.out.printf("%.1f ",test.peek());
			
			temp1=test.poll();
			newList.add(temp1);
			newSet.add(temp1);
		}
		for (Double double1 : newSet) {
			System.out.printf("%.1f ",double1);
		}
		Collections.reverse(newList);
		for (Double double1 : newList) {
			System.out.printf("%.1f ",double1);
		}
	}
}
