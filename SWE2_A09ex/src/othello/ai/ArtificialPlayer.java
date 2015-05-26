package othello.ai;

import static othello.Pos.A_1;
import static othello.Pos.A_8;
import static othello.Pos.H_1;
import static othello.Pos.H_8;

import java.util.ArrayList;
import java.util.List;

import othello.Board;
import othello.Player;
import othello.Pos;
import othello.Stone;

/**
 * ArtificialPlayer.java
 *
 * A {@link ArtificialPlayer} is a public class implementing an artificial
 * player with a simple strategy.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author TAs & Luca Benvenuti
 */
public class ArtificialPlayer implements Player {

	private static final int DECISION_TIME = 1000;

	/** Stone of this player */
	private Stone stone;

	@Override
	public String getName() {
		return "AI";
	}

	@Override
	public Pos nextMove(Board board) {
		try {
			Thread.sleep(DECISION_TIME);
		} catch (InterruptedException e) {
		}

		List<Pos> valid = new ArrayList<Pos>();
		for (Pos pos : board.getValidPositions(this.getStone())) {
			valid.add(pos);
		}
		if (valid.size() == 0) {
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
			return valid.get((int) (Math.random() * valid.size()));
		}
	}

	@Override
	public void setStone(Stone stone) {
		this.stone = stone;
	}

	@Override
	public Stone getStone() {
		return stone;
	}

}
