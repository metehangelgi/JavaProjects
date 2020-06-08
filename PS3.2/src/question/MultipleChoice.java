package question;

public abstract class MultipleChoice extends Question{
	
	private String[] choices;
	

	public MultipleChoice(String questionText, double point,String[] choices ) {
		super(questionText,point);
		this.choices=choices;
		
	
	}

	
	public abstract boolean isAnsweredCompletelyCorrectly();
	
	public String toString() {
		String res="Multiple Choices question: "+"\n";
		res+=super.toString()+"\n";
		
		return res;
	}
}
