public class Unit {
	private String abbreviation;
	private double meterRatio;

	public Unit(String abbrv) {
		this.abbreviation = abbrv;

		if (abbrv.equals("km"))
			this.meterRatio = 1000.0;
		else if (abbrv.equals("cm"))
			this.meterRatio = .01;
		else
			this.meterRatio = 1.0;
	}

	public double getMeterRatio() {
		return meterRatio;
	}

	public String toString() {
		return abbreviation;
	}

}
