package compensationModel;

public class CommissionCompensationModel extends CompensationModel {

	private double grossSales; // gross weekly sales
	private double commissionRate; // commission percentage

	public CommissionCompensationModel(double grossSales,double commisionRate) {
		super(grossSales,commisionRate);
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
		return grossSales * commissionRate;
	}

}
