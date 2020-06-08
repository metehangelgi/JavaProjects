package deneme;

public class SecondYearSt extends Student{

	
	
	
	int grade;
	
	
	

	public SecondYearSt() {
		super();
	}
	
	
	public SecondYearSt(String name,String surname,int age,int grade) {
		super(name,surname,age);
		this.grade=grade;
	}
	

	
	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
	@Override
	public String toString() {
		return super.toString()+" "+grade;
	}

	
	
	
	
}
