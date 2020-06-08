package compensationModel;

public class BasePlusCommisionCompensationModel extends CompensationModel {
	
	private double grossSales; // gross weekly sales
	private double commisionRate; // commission percentage
	private double baseSalary; // base salary per week

	public BasePlusCommisionCompensationModel(double grossSales,double commisionRate,double baseSalary) {
		super(grossSales,commisionRate);
		this.baseSalary=baseSalary;
	}

	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(double grossSales) {
		this.grossSales = grossSales;
	}

	public double getCommissionRate() {
		return commisionRate;
	}

	public void setCommissionRate(double commissionRate) {
		this.commisionRate = commissionRate;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	
	public double earnings() {
		return baseSalary+grossSales*commisionRate;
	}
	
	
	
	
	
	
	
}
