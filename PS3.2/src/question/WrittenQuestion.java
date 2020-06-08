package question;

public class WrittenQuestion extends Question implements PartialCreditGiveable{
	
	
	private String[] correctAnswerWords;
	private String[] responseWords;
	
	

	public WrittenQuestion(String questionText,String[] correctAnswerWords,String[] responseWords,  double point) {
		super(questionText,point);
		this.correctAnswerWords=correctAnswerWords;
		this.responseWords=responseWords;
		
}

	
	
	
	public String[] getResponseWords() {
		return responseWords;
	}




	public void setResponseWords(String[] responseWords) {
		for (String resWord : responseWords) {
			// have to use try catch ?
			if(!resWord.contains(" ")) this.responseWords = responseWords;
		}
		
		
		
		this.responseWords = responseWords;
	}




	@Override
	public double getGrade() {		
		if(correctAnswerWords.length != responseWords.length)
		    return 0;
		
		for(int i = 0; i < correctAnswerWords.length; i++) {
			if(!correctAnswerWords[i].equals(responseWords[i]))
				return 0;
		}
		
		return getPoint();
	}
	public double getPartialCredit() {
		double result = 0;
		int correctNums = 0;
		
		for(int i = 0; i < correctAnswerWords.length; i++) {
			if(correctAnswerWords[i].equals(responseWords[i]))
				correctNums++;
		}
		
		result = (getPoint() / correctAnswerWords.length) * correctNums;
		return result;
	}
	
	public String toString() {
		String res="\n"+"WrittenPart: "+"\n";
		res+=super.toString()+"\n";
		return res;
	}
	
	
	
	

}
