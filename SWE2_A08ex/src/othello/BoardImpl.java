package othello;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Class representing the board. It has 8x8 fields (as a chessboard) and
 * maintains the stones on the board.
 */
public class BoardImpl implements Board {

	private Map<Pos, Stone> boardMap = new TreeMap<>();

	/**
	 * Constructor initializing the board with two white stones on positions D 4
	 * and E 5 and two black stones on positions D 5 and E 4.
	 */
	public BoardImpl() {
		// TODO

		for (Pos p : Pos.ALL) {
			boardMap.put(p, Stone.FREE);
		}
		boardMap.remove(Pos.D_4);
		boardMap.remove(Pos.E_5);
		boardMap.remove(Pos.D_5);
		boardMap.remove(Pos.E_4);
		boardMap.put(Pos.D_4, Stone.WHITE);
		boardMap.put(Pos.E_5, Stone.WHITE);
		boardMap.put(Pos.D_5, Stone.BLACK);
		boardMap.put(Pos.E_4, Stone.BLACK);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see othello.Board#getStone(othello.Pos)
	 */
	@Override
	public Stone getStone(Pos pos) {
		// TODO
		return boardMap.get(pos);
	}

	/*
	 * // 1) isLegalMove // 2) placeStone // 3) flipColor (non-Javadoc)
	 * 
	 * @see othello.Board#setStone(othello.Pos, othello.Stone)
	 */
	@Override
	public void setStone(Pos pos, Stone stone) {
		if (isFull()){return;}
		Pos[] validPos = getValidPositions(stone);
		if (validPos == null) {
			return;
		}

		for (Pos p : validPos) {
			if (pos == p) {
				boardMap.remove(pos);
				boardMap.put(pos, stone);

				for (Direction dir : Direction.values()) {
					Pos pos3 = p.next(dir);
					if (pos3 == null) {
						continue;
					}

					List<Pos> candidatesToCapture = new ArrayList<>();
					if (isValidDirection(pos3, dir)) {
						if (isFree(pos3)) {// do nothing
							continue;
						} else if (stone.isOther(getStone(pos3))) {
							findCaptureCandidates(candidatesToCapture, pos,
									stone, dir);
						} else if (stone.equals(getStone(pos3))) {// do nothing
						} else {
							System.out.println("Wrong insertion");
						}
					} else {
						continue;
					}
					if (candidatesToCapture.size() > 0) {
						capture(candidatesToCapture, stone);
					}
				}
				break;
			}
		}
	}

	private void capture(List<Pos> candidatesToCapture, Stone stone) {
		// TODO Auto-generated method stub
		for (Pos p : candidatesToCapture) {
			boardMap.remove(p);
			boardMap.put(p, stone);
		}
	}

	private void findCaptureCandidates(List<Pos> candidatesToCapture, Pos pos,
			Stone stone, Direction dir) {
		// TODO Auto-generated method stub

		if (pos.next(dir) == null) {
			candidatesToCapture.clear();
			return;
		} else {
			candidatesToCapture.add(pos.next(dir));
		}

		if (stone.equals(getStone(pos.next(dir)))) {
		} else if (Stone.FREE.equals(getStone(pos.next(dir)))) {
			candidatesToCapture.clear();
			return;
		} else {
			findCaptureCandidates(candidatesToCapture, pos.next(dir), stone,
					dir);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see othello.Board#isFree(othello.Pos)
	 */
	@Override
	public boolean isFree(Pos pos) {
		// TODO
		return Stone.FREE.equals(getStone(pos));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see othello.Board#isFull()
	 */
	@Override
	public boolean isFull() {
		// TODO
		Iterator<Pos> iterator1 = iterator();
		while (iterator1.hasNext()) {
			Pos pos = iterator1.next();
			if (isFree(pos)) {
				return false;
			}
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see othello.Board#getValidPositions(othello.Stone)
	 */
	@Override
	public Pos[] getValidPositions(Stone stone) {

		Collection<Pos> validPositions = new TreeSet<>();
		Iterator<Pos> iterator1 = iterator();
		while (iterator1.hasNext()) {
			Pos pos = iterator1.next();
			if (isFree(pos)) {
				for (Direction dir : Direction.values()) {
					//
					if (!isValidDirection(pos, dir)) {
						continue;
					}
					if (stone.isOther(getStone(pos.next(dir)))
							&& getStone(pos.next(dir)).isOther(
									getStone(pos.next(dir).next(dir)))) {
						validPositions.add(pos);
						break;
					}
				}
			}
		}
		return validPositions.toArray(new Pos[validPositions.size()]);
	}

	public boolean isValidDirection(Pos pos, Direction dir) {
		if (pos.next(dir) == null)
			return false;
		if (pos.next(dir).next(dir) == null)
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see othello.Board#iterator()
	 */
	@Override
	public Iterator<Pos> iterator() {
		// TODO
		return boardMap.keySet().iterator();
	}

}
