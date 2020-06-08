import acm.program.ConsoleProgram;
public class CreateAndTestSignals extends ConsoleProgram{
	public void run(){
		double[] data1={2.0, 0, -2.5, 0.5};
		double[] data2={1.0, 1.0, -1.0, 0};
		Signal sig1=new Signal(data1);
		Signal sig2=new Signal(data2);
		
		print("The dot product of "+sig1+" and "+sig2+" is: ");
		println(sig1.dotProduct(sig2));
		println("-----------------");
		
		//creating advanced-signals specifying length
		//this should call a constructor that takes the value specified as length
		//and put random values as elements of array
		AdvancedSignal randSig1=new AdvancedSignal(20);
		AdvancedSignal randSig2=new AdvancedSignal(20);
		println(randSig1);
		println(randSig2);
		println();
		println("Dot product of these random signals is: "+randSig1.dotProduct(randSig2));
		
	}
}
