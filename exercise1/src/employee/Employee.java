package employee;

public abstract class  Employee {
	
	private String name;
	private String surname;
	private String socialSecurityNumber;
	

	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Employee(String name,String surname,String socialSecurityNumber2) {
		this.name=name;
		this.surname=surname;
		this.socialSecurityNumber=socialSecurityNumber2;
		
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSurname() {
		return surname;
	}



	public void setSurname(String surname) {
		this.surname = surname;
	}



	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}



	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}



	public double earnings() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	 public String toString() {
	      return String.format("%s: %s %s%n%s: %s%n", 
	         "commission employee", getName(), getSurname(), 
	         "social security number", getSocialSecurityNumber());
	   }



	public double getGrossSales() {
		// TODO Auto-generated method stub
		return 0;
	}



	public double getCommissionRate() {
		// TODO Auto-generated method stub
		return 0;
	}



	public double getBaseSalary() {
		// TODO Auto-generated method stub
		return 0;
	}



	public void setBaseSalary(int i) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	

}
