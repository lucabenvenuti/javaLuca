package value.model;

/**
 * Model for an integer value
 */
public class ValueModel {

	/** the integer value of this model */
	private int value;

	/**
	 * Gets the integer value of this model
	 * @return the integer value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Sets the integer value of this model
	 * @param value the new integer value
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * Increments the value of this model by 1
	 */
	public void incr() {
		this.value++;
	}

	/**
	 * Decrements the value of this model by 1
	 */
	public void decr() {
		this.value--;
	}

	/**
	 * Resets the value of this model to 0
	 */
	public void reset() {
		this.value = 0;
	}

}
