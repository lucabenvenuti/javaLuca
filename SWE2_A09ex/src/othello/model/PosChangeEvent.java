package othello.model;

import java.util.EventObject;

import othello.Player;
import othello.Pos;

@SuppressWarnings("serial")
public class PosChangeEvent extends EventObject {

    private final Player player;
    private final Pos pos;

	PosChangeEvent(OthelloModel source, Player player, Pos pos) {
		super(source);
		this.player = player;
		this.pos = pos;
	}

	public Player getPlayer() {
	    return player;
	}

	public Pos getPos() {
		return pos;
	}
}
