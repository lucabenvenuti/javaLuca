package light.model;

import java.util.ArrayList;
import java.util.List;

public class LightModel {
	private Light light = Light.OFF;
	private List<ChangeListener> listeners = new ArrayList<>();

	public Light getLight() {
		return light;
	}

	public void onActionPerformed() {
		this.light = light.other();
		fireChangeEvent();
	}

	public void addChangeListener(ChangeListener listener) {
		listeners.add(listener);
	}

	public void removeChangeListener(ChangeListener listener) {
		listeners.remove(listener);
	}

	protected void fireChangeEvent() {
		ChangeEvent evt = new ChangeEvent(this, getLight());
		for (ChangeListener l : listeners) {
			l.stateChanged(evt);
		}
	}
}
