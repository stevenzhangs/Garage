package garage;


/**
 * @author Steven Zhang
 * 
 */
public class Car {
	/**
	 * The registration number of the car
	 */
	private String registrationNumber;

	/**
	 * The number of hours it takes to fix the car
	 */
	private int repairHours;

	/**
	 * The number of euros you can charge the customer for the repairs
	 */
	private int repairPrice;

	/**
	 * Constructor
	 * @param registrationNumber ³µÅÆºÅ
	 * @param repairHours Î¬ÐÞºÄÊ±
	 * @param repairPrice Î¬ÐÞ¼Û¸ñ
	 */
	public Car(String registrationNumber, int repairHours, int repairPrice) {
		this.registrationNumber = registrationNumber;
		this.repairHours = repairHours;
		this.repairPrice = repairPrice;
	}

	/**
	 * @return The registration number of the car
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRepairHours(int repairHours) {
		this.repairHours = repairHours;
	}

	public int getRepairHours() {
		return repairHours;
	}

	public void setRepairPrice(int repairPrice) {
		this.repairPrice = repairPrice;
	}

	public int getRepairPrice() {
		return repairPrice;
	}
}
