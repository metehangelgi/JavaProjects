package deneme;

public class FirstYearSt extends Student{

	
	
	
	

	int point;
	
	public FirstYearSt() {
		super();
	}
	
	
	public FirstYearSt(String name,String surname,int age,int point) {
		super(name,surname,age);
		this.point=point;
	}
	

	
	public int getPoint() {
		return point;
	}


	public void setPoint(int point) {
		this.point = point;
	}

	
	@Override
	public String toString() {
		
		
		return super.toString()+" "+point;
	}
	
	
	
	
}
