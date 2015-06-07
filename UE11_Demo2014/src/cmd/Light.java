package cmd;

public class Light {

	private int brightness = 0;

	public void brighter(int value) {
		System.out.println("Brighter: " + brightness + " --> "
				+ (value + brightness));
		brightness += value;
	}

	public void darker(int value) {
		System.out.println("Darker: " + brightness + " --> "
				+ (brightness - value));
		brightness -= value;
	}

}
