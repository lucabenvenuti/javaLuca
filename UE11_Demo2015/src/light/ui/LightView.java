package light.ui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JComponent;

import light.controller.LightController;
import light.model.LightModel;

public class LightView extends JComponent {

	private static final long serialVersionUID = -2201347995102344073L;
	private LightButton button;

	public LightView(LightModel model) {
		setLayout(new GridLayout(1, 1));
		Dimension boardSize = new Dimension(200, 200);
		setPreferredSize(boardSize);
		setBounds(0, 0, boardSize.width, boardSize.height);

		button = new LightButton(model.getLight());
		button.addActionListener(new LightController(model));
		add(button);
		repaint();
	}

}
