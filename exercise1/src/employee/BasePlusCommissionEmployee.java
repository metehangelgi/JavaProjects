package employee;

import compensationModel.BasePlusCommisionCompensationModel;
import compensationModel.CompensationModel;

public class BasePlusCommissionEmployee extends Employee {

	private double grossSales; // gross weekly sales
	private double commissionRate; // commission percentage
	private double baseSalary; // base salary per week
	private CompensationModel odemeyontemi1=new BasePlusCommisionCompensationModel(grossSales, commissionRate, baseSalary);
	
	public BasePlusCommissionEmployee(String name, String surname, String socialSecurityNumber, double grossSales,
			double commissionRate, double baseSalary) {
		super(name, surname, socialSecurityNumber);
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;

		if (baseSalary < 0.0) {
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		}

		this.baseSalary = baseSalary;

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

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	 // calculate earnings
	   @Override 
	   public double earnings() {return odemeyontemi1.earnings();}

	   // return String representation of BasePlusCommissionEmployee
	   @Override
	   public String toString() {
	      return String.format("%s %s%n%s: %.2f%n%s: %.2f%n%s: %.2f%n %s: %f", "base-salaried",
	         super.toString(), "base salary", getBaseSalary(), 
	         "gross sales", getGrossSales(), 
	         "commission rate", getCommissionRate(),
	         "earnings",earnings());   
	      
	   } 
	} 
