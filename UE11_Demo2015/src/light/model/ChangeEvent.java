package light.model;

import java.util.EventObject;

@SuppressWarnings("serial")
public class ChangeEvent extends EventObject {

	private final Light light;

	public ChangeEvent(LightModel source, Light light) {
		super(source);
		this.light = light;

	}

	public Light getValue() {
		return light;
	}

}
