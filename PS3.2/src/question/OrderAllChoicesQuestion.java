package question;

public class OrderAllChoicesQuestion extends MultipleChoice implements PartialCreditGiveable{
	
	
	private int[] studentsOrdering;
	private int[] correctOrdering;

	public OrderAllChoicesQuestion(String questionText, double point,String[] choices,int[] studentsOrdering,int[] correctOrdering) {
		super(questionText,point,choices);
		this.studentsOrdering=studentsOrdering;
		this.correctOrdering=correctOrdering;
		
		
		
		}

	@Override
	public boolean isAnsweredCompletelyCorrectly() {
		boolean test=true;
		
		for(int i=0;i<studentsOrdering.length;i++) {
			if(correctOrdering[i]!=studentsOrdering[i]) {
				test=false;
				break;
			} 
			
		}
		return test;
	}

	@Override
	public double getGrade() {
		double result = 0;
		
		if(isAnsweredCompletelyCorrectly())
			result = getPoint();
		
		return result;
	}

	
	public double getPartialCredit() {
		double result = 0;
		int correctNum = 0;
		
		for(int i = 0; i < correctOrdering.length; i++) {
			if(correctOrdering[i] == studentsOrdering[i])
				correctNum ++;
		}
		
		result = (getPoint() / correctOrdering.length) * correctNum;
		
		return result;
	}

	
	
	public String toString() {
		String res="\n"+super.toString()+"\n";
		for(int i=0;i<studentsOrdering.length;i++) {
			res+=studentsOrdering[i]+" ";
			
			
		}
		res+="\n";
		for(int i=0;i<studentsOrdering.length;i++) {
			res+=correctOrdering[i]+" ";
			
			
		}
		res+="\n";
		
		
		return res;
	}
	
	
	
}
