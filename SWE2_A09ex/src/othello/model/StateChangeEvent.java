package othello.model;

import java.util.EventObject;

import othello.GameState;

public class StateChangeEvent extends EventObject {

    private static final long serialVersionUID = -6979328807430005123L;
    private final GameState state;

    public StateChangeEvent(OthelloModel source, GameState state) {
        super(source);
        this.state = state;
    }

    public GameState getState() {
        return state;
    }
}
