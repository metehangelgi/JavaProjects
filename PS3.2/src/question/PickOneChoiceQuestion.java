package question;


public class PickOneChoiceQuestion extends MultipleChoice{
	
	
	private int choiceIndex;
	private int correctlyIndex;
	

	public PickOneChoiceQuestion(String questionText, double point,String[] choices,int choiceIndex,int correctlyIndex) {
		super(questionText,point,choices);
		this.choiceIndex=choiceIndex;
		this.correctlyIndex=correctlyIndex;
		
	}


	@Override
	public boolean isAnsweredCompletelyCorrectly() {
		if(choiceIndex==correctlyIndex) {
			return true;
		} else
		return false;
	}


	@Override
	public double getGrade() {
		double result = 0;
		
		if(isAnsweredCompletelyCorrectly())
			result = getPoint();
		
		return result;
	}

}
