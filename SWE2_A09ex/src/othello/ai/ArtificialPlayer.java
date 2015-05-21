package othello.ai;

import static othello.Pos.A_1;
import static othello.Pos.A_8;
import static othello.Pos.H_1;
import static othello.Pos.H_8;
import inout.Out;

import java.util.ArrayList;
import java.util.List;

import othello.Board;
import othello.Player;
import othello.Pos;
import othello.Stone;

/**
 * Class implementing an artificial player with a simple strategy. 
 */
public class ArtificialPlayer implements Player {
	
	/** Stone of this player */
	private Stone stone;

	/* (non-Javadoc)
	 * @see othello.Player#getName()
	 */
	@Override
	public String getName() {
		return "AI";
	}

	/* (non-Javadoc)
	 * @see othello.Player#nextMove(othello.Board)
	 */
	@Override
	public Pos nextMove(Board board) {
		Out.println(); 
		Out.println("Move of " + getName() + " with stone " + this.getStone());
		List<Pos> valid = new ArrayList<Pos>();
		for (Pos pos : board.getValidPositions(this.getStone())) {
			valid.add(pos);
		}
		if (valid.size() == 0) {
			Out.println("No valid position for " + getName() + "!");
			return null;
		} else if (valid.contains(A_1)) {
			return A_1;
		} else if (valid.contains(H_1)) {
			return H_1;
		} else if (valid.contains(A_8)) {
			return A_8;
		} else if (valid.contains(H_8)) {
			return H_8;
		} else {
			return valid.get((int)(Math.random()*valid.size()));
		}
	}

	/* (non-Javadoc)
	 * @see othello.Player#setStone(othello.Stone)
	 */
	@Override
	public void setStone(Stone stone) {
		this.stone = stone;
	}

	/* (non-Javadoc)
	 * @see othello.Player#getStone()
	 */
	@Override
	public Stone getStone() {
		return stone;
	}

}
