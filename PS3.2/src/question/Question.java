package question;

public abstract class Question {

	private String questionText;
	private double point;

	public Question(String questionText, double point) {
		this.questionText = questionText;
		this.point = point;
	}

	public String getQuestionText() {
		return questionText;
	}

	public double getPoint() {
		return point;
	}

	public abstract double getGrade();

	
	public String toString() {
		String res="\n"+"questionText: "+getQuestionText()+"\n";
		res+="point: "+getPoint();
		return res;
	}

	
	
}
