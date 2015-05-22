package othello.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import othello.Pos;
import othello.model.PosChangeEvent;
import othello.model.PosChangeListener;
import othello.model.PosModel;

public class BoardView extends JComponent {

	private static final long serialVersionUID = -2201347995102344073L;
	private final JToggleButton[][] buttons = new JToggleButton[8][8];
	private final PosModel model;

	public BoardView(PosModel model) {
		this.model = model;
		model.addValueChangeListener(posListener);
		initialize();
		repaint();
	}

	private void initialize() {
		setLayout(new GridLayout(8, 8));
		Dimension boardSize = new Dimension(600, 600);
		setPreferredSize(boardSize);
		setBounds(0, 0, boardSize.width, boardSize.height);

		/*
		 * buttons[7] = new JToggleButton("128"); buttons[6] = new
		 * JToggleButton("64"); buttons[5] = new JToggleButton("32"); buttons[4]
		 * = new JToggleButton("16"); buttons[3] = new JToggleButton("8");
		 * buttons[2] = new JToggleButton("4"); buttons[1] = new
		 * JToggleButton("2"); buttons[0] = new JToggleButton("1");
		 */

		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				/*
				 * JPanel square = new JPanel( new BorderLayout() ); add( square
				 * ); square.setBackground(Color.GREEN);
				 */
				buttons[i][j] = new JToggleButton(Pos.getPos(i + 1, j + 1)
						.toString()); // wrong, now I want to see if they are
										// positioned correctly
			}
		}
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipadx = 10;
		gbc.ipady = 10;
		for (JToggleButton[] b1 : buttons) {
			for (JToggleButton b : b1) {
				b.addActionListener(buttonPressed);
				add(b, gbc);
				gbc.gridy++;
				b.setSelected(true);
			}
		}
	}

	private ActionListener buttonPressed = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Pos pos = getPosFromButtons();
			model.setPos(pos.row, pos.getColIdx());
		}

	};

	private PosChangeListener posListener = new PosChangeListener() {

		@Override
		public void posChanged(PosChangeEvent evt) {
			// TODO Auto-generated method stub
			int row = evt.getRow();
			int column = evt.getColumn();
			Pos pos = evt.getPos();
			setPosToButtons(row, column);
			repaint();
		}
		/*
		 * @Override public void posChanged(PosChangeEvent e) { int value =
		 * e.getValue(); setValueToButtons(value); repaint(); }
		 */

	};

	private Pos getPosFromButtons() {

		for (int i = 0; i < buttons.length; i++) {
			for (int j = 1; j < buttons[i].length; j++) {
				if (buttons[i][j].isSelected()) {
					return Pos.getPos(i + 1, j + 1);
				}
			}
		}
		/*
		 * for (int i = 0; i < buttons.length; i++) { if
		 * (buttons[i].isSelected()) { value += Math.pow(2, i); } }
		 */
		// return value;
		return Pos.getPos(1, 1);
	}

	private void setPosToButtons(int row, int column) {
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 1; j < buttons[i].length; j++) {
				buttons[i][j].setSelected(!isZero(row, column));
			}
		}
	}

	private static boolean isZero(int row, int column) {
		// return (value &= (1 << position)) == 0;
		return row == 0 || column == 0;
	}
}
