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

public class OthelloView extends JComponent implements UserInterface {

    private static final long serialVersionUID = -2201347995102344073L;
    private StoneButton[] buttons;

    public void initialize(OthelloController controller) {
        removeAll();
        setLayout(new GridLayout(8, 8));
        Dimension boardSize = new Dimension(600, 600);
        setPreferredSize(boardSize);
        setBounds(0, 0, boardSize.width, boardSize.height);

        GridBagConstraints gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 10, 10);
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
        // TODO Auto-generated method stub

    }

    @Override
    public void gameOver(GameState gameState) {
        // TODO Auto-generated method stub
        
    }
}
