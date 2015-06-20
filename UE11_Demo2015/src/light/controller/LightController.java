package light.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import light.model.Light;
import light.model.LightModel;
import light.ui.LightButton;

public class LightController implements ActionListener {

	private final LightModel model;

	public LightController(LightModel model) {
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 1. an action has been performed -> the button has been clicked
		Object source = e.getSource();
		if (source instanceof LightButton) {
			// 2. obtain the model from the source
			LightButton button = (LightButton)source;
			// 3. notify the model that the button has been clicked (update model state)
			model.onActionPerformed();
			// 4. update the view (change view's presentation of the model)
			button.setLight(model.getLight());
		}
	}
}