package light.ui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JToggleButton;

import light.*;
import light.model.Light;

public class LightButton extends JToggleButton {
	private static final long serialVersionUID = -8933910706465044870L;
	private Light light = Light.OFF;

	public void setLight(Light light) {
		this.light = light;
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		Color ovalBorderColor;
		Color ovalFillColor;
		switch (light) {
		case ON:
			ovalFillColor = Color.WHITE;
			ovalBorderColor = Color.BLACK;
			break;
		default:
			ovalFillColor = Color.GRAY;
			ovalBorderColor = Color.GRAY;
			break;
		}
		g.setColor(Color.GRAY);
		g.fillRect(getHorizontalAlignment(), getVerticalAlignment(),
				getWidth(), getHeight());
		g.setColor(ovalFillColor);
		g.fillOval(getHorizontalAlignment(), getVerticalAlignment(),
				getWidth(), getHeight());
		g.setColor(ovalBorderColor);
		g.drawOval(getHorizontalAlignment(), getVerticalAlignment(),
				getWidth(), getHeight());
	}
}
