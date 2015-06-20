package light.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import light.model.LightModel;
import light.ui.LightButton;

public class LightController implements ActionListener {

	private final LightModel model;

	public LightController(LightModel model) {
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source instanceof LightButton) {
			// LightButton lightButton = (LightButton) source;  && source != null
			((LightButton)source).setLight(model.setLight());
		}
	}
}