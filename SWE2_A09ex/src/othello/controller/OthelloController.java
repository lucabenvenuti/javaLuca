package othello.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import othello.model.OthelloModel;
import othello.view.StoneButton;

public class OthelloController implements ActionListener {
    private final OthelloModel model;

    public OthelloController(OthelloModel model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof StoneButton) {
            StoneButton stoneButton = (StoneButton)source;
            model.attemptMove(stoneButton.getPos());
        }
    }
}