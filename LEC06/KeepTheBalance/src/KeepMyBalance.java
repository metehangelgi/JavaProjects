import acm.program.ConsoleProgram;


public class KeepMyBalance extends ConsoleProgram {
	public void run(){
		//Your code starts here
		int count =0;
		for(int w500=1; w500<=100;w500++) {
			for (int w100=1; w100<=100;w100++) {
				for (int w5=1; w5<=100;w5++) {
					int totalWorkers = w500+w100+w5;
					int totalPaid= w500*500+w100*100+w5*5;
					
					count++;
					
					if (totalWorkers == 100&& totalPaid ==10000) {
		
						
						println (w500 + "people receive 500 units");
						println (w100 + "people receive 100 units");
						println (w5 + "people receive 5 units");
						println ("count = "+ count);
					}
				}
			}
		}
		//Your code ends here
	}

}
