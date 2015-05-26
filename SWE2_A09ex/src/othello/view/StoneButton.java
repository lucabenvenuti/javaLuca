package othello.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JToggleButton;

import othello.Pos;
import othello.Stone;

/**
 * StoneButton.java
 *
 * A {@link StoneButton} is a public interface extending {@link JToggleButton}.
 * It allows painting a Stone in a GUI.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author Luca Benvenuti
 */
public class StoneButton extends JToggleButton {
	private static final long serialVersionUID = -8933910706465044870L;
	private final Pos pos;
	private Stone stone = Stone.FREE;

	public StoneButton(Pos pos) {
		this.pos = pos;
	}

	/**
	 * @return the Pos.
	 */
	public Pos getPos() {
		return pos;
	}

	/**
	 * set the Stone in the StoneButton.
	 * 
	 * @param stone
	 */
	public void setStone(Stone stone) {
		this.stone = stone;
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		Color ovalBorderColor;
		Color ovalFillColor;
		switch (stone) {
		case WHITE:
			ovalFillColor = Color.WHITE;
			ovalBorderColor = Color.BLACK;
			break;
		case BLACK:
			ovalFillColor = Color.BLACK;
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
