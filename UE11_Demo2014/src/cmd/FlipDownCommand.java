package cmd;

public class FlipDownCommand implements Command {

	private final Light light;
	private final int value;

	public FlipDownCommand(Light light, int value) {
		this.light = light;
		this.value = value;
	}

	@Override
	public void doCmd() {
		light.darker(value);
	}

	@Override
	public void undoCmd() {
		light.brighter(value);
	}

}
