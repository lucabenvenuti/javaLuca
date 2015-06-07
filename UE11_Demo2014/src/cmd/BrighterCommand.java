package cmd;

public class BrighterCommand implements Command {

	private final Light light;
	private final int value;

	public BrighterCommand(Light light, int value) {
		this.light = light;
		this.value = value;
	}

	@Override
	public void doCmd() {
		light.brighter(value);
	}

	@Override
	public void undoCmd() {
		light.darker(value);
	}
}
