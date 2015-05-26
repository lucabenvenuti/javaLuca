package othello.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JComponent;

import othello.Board;
import othello.GameState;
import othello.Pos;
import othello.Stone;
import othello.UserInterface;
import othello.controller.OthelloController;

/**
 * OthelloView.java
 *
 * A {@link OthelloView} is a public interface extending {@link JComponent} and
 * implementing {@link UserInterface}. It allows drawing a Board and filling it
 * with stones.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author Luca Benvenuti
 */
public class OthelloView extends JComponent implements UserInterface {

	private static final long serialVersionUID = -2201347995102344073L;
	private StoneButton[] buttons;

	/**
	 * Initialize the View given a Controller.
	 * 
	 * @param controller
	 */
	public void initialize(OthelloController controller) {
		removeAll();
		setLayout(new GridLayout(8, 8));
		Dimension boardSize = new Dimension(600, 600);
		setPreferredSize(boardSize);
		setBounds(0, 0, boardSize.width, boardSize.height);

		GridBagConstraints gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(0, 0, 0, 0), 10, 10);
		Pos[] allPos = Pos.ALL;
		buttons = new StoneButton[allPos.length];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new StoneButton(allPos[i]);
			buttons[i].addActionListener(controller);
			add(buttons[i], gbc);
		}
		repaint();
	}

	@Override
	public void boardChanged(Board board) {
		Pos[] allPos = Pos.ALL;
		for (int i = 0; i < allPos.length; i++) {
			buttons[i].setStone(board.getStone(allPos[i]));
		}
	}

	@Override
	public void stoneSet(Pos pos, Stone stone) {
		Pos[] allPos = Pos.ALL;
		for (int i = 0; i < allPos.length; i++) {
			if (buttons[i].getPos() == pos) {
				buttons[i].setStone(stone);
			}
		}
	}

	@Override
	public void gameOver(GameState game) {
		System.out.println();
		System.out.println("!!!!!!!!!!!!! Game over !!!!!!!!!!!!!!!!!!!!");
		System.out.println(game.toString());
	}

	@Override
	public void reset(Board board) {
		board.reset();
		Pos[] allPos = Pos.ALL;
		for (int i = 0; i < allPos.length; i++) {
			buttons[i].setStone(board.getStone(allPos[i]));
		}
	}
}
