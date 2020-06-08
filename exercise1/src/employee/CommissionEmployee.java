package employee;

import compensationModel.CommissionCompensationModel;
import compensationModel.CompensationModel;





public class CommissionEmployee extends Employee {

	
	
	private double grossSales; // gross weekly sales
	private double commissionRate; // commission percentage
	private CompensationModel odemeyontemi=new CommissionCompensationModel(commissionRate, commissionRate);

	public CommissionEmployee(String name, String surname, String socialSecurityNumber, double grossSales,double commissionRate) {
		super(name, surname, socialSecurityNumber);
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
		

	}

	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(double grossSales) {
		this.grossSales = grossSales;
	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
	}
	 public double earnings() {
	      return odemeyontemi.earnings();
	   } 

	   // return String representation of CommissionEmployee object
	   @Override 
	   public String toString() {
	      return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f", 
	         "commission employee", super.getName(), super.getSurname(), 
	         "social security number", getSocialSecurityNumber(), 
	         "gross sales", getGrossSales(), 
	         "commission rate", getCommissionRate());
	   }


	public void setBaseSalary(int i) {
		// TODO Auto-generated method stub
		
	}
}
