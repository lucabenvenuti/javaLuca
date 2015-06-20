package light.model;

public enum Light {

	ON(true),
	OFF(false);

	private final boolean condition;

	private Light(boolean bool) {
		this.condition = bool;
	}

	@Override
	public String toString() {
		return this.name();
	}

	public Light other() {
		if (this == OFF) {
			return ON;
		} else {
			return OFF;
		}
	}

	public boolean isCondition() {
		return condition;
	}

}
