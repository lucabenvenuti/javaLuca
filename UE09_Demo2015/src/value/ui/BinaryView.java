package value.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JToggleButton;

import value.model.ValueChangeEvent;
import value.model.ValueChangeListener;
import value.model.ValueModel;

public class BinaryView extends JComponent {

	private static final long serialVersionUID = -2201347995102344073L;
	private final JToggleButton[] buttons = new JToggleButton[8];
	private final ValueModel model;

	public BinaryView(ValueModel model) {
		this.model = model;
		model.addValueChangeListener(valueListener);
		initialize();
		repaint();
	}

	private void initialize() {
		setLayout(new GridBagLayout());
		buttons[7] = new JToggleButton("128");
		buttons[6] = new JToggleButton("64");
		buttons[5] = new JToggleButton("32");
		buttons[4] = new JToggleButton("16");
		buttons[3] = new JToggleButton("8");
		buttons[2] = new JToggleButton("4");
		buttons[1] = new JToggleButton("2");
		buttons[0] = new JToggleButton("1");
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipadx = 10;
		gbc.ipady = 10;
		for (JToggleButton b : buttons) {
			b.addActionListener(buttonPressed);
			add(b, gbc);
			gbc.gridy++;
			b.setSelected(true);
		}
	}

	private ActionListener buttonPressed = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int value = 0;
			value = getValueFromButtons(value);
			model.setValue(value);
		}

	};

	private ValueChangeListener valueListener = new ValueChangeListener() {
		@Override
		public void valueChanged(ValueChangeEvent e) {
			int value = e.getValue();
			setValueToButtons(value);
			repaint();
		}

	};

	private int getValueFromButtons(int value) {
		for (int i = 0; i < buttons.length; i++) {
			if (buttons[i].isSelected()) {
				value += Math.pow(2, i);
			}
		}
		return value;
	}

	private void setValueToButtons(int value) {
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].setSelected(!isZero(i, value));
		}
	}

	private static boolean isZero(int position, int value) {
		return (value &= (1 << position)) == 0;
	}
}
