package light.ui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JComponent;

import light.*;
import light.controller.LightController;

public class LightView extends JComponent {

	private static final long serialVersionUID = -2201347995102344073L;
	private LightButton buttons;

	public void initialize(LightController controller) {
		removeAll();
		setLayout(new GridLayout(1, 1));
		Dimension boardSize = new Dimension(600, 600);
		setPreferredSize(boardSize);
		setBounds(0, 0, boardSize.width, boardSize.height);

		GridBagConstraints gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(0, 0, 0, 0), 10, 10);
		buttons = new LightButton();
		repaint();
	}

}
