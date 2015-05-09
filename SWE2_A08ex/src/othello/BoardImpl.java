package othello;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

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
	 * (non-Javadoc)
	 * 
	 * @see othello.Board#setStone(othello.Pos, othello.Stone)
	 */
	@Override
	public void setStone(Pos pos, Stone stone) {
		Pos[] validPos = getValidPositions(stone);

		for (Pos p : validPos) {
			if (pos == p) {
				boardMap.put(pos, stone);
				// boardMap.remove(key)

				for (Direction dir : Direction.values()) {

					while (iterator().hasNext()) {
						Pos pos2 = iterator().next();
						List<Pos> candidatesToCapture = new ArrayList<>();
						if (isValidDirection(pos2, dir)) {
							if (isFree(pos)) {// do nothing
							} else if (stone.isOther(getStone(pos2))) {// do
																		// nothing
							} else if (stone == getStone(pos2)) {
								findCaptureCandidates(candidatesToCapture, pos,
										stone, dir);
							} else {
								System.out.println("Wrong insertion");
							}
						}
						
						capture(candidatesToCapture, stone);

						/*
						 * System.out.println(pos2); if (isFree(pos2)) {
						 * return;// false; }
						 */
					}

				}

				return;
			}

		}

		// 1) isLegalMove
		// 2) placeStone
		// 3) flipColor
	}

	private void capture(List<Pos> candidatesToCapture, Stone stone) {
		// TODO Auto-generated method stub
		for (Pos p:candidatesToCapture){
			boardMap.remove(p);
			boardMap.put(p,stone);
		}		
	}

	private void findCaptureCandidates(List<Pos> candidatesToCapture, Pos pos,
			Stone stone, Direction dir) {
		// TODO Auto-generated method stub
		if (pos.next(dir) != null) {
			candidatesToCapture.add(pos.next(dir));
		} else {
			candidatesToCapture.clear();
		}

		if (getStone(pos.next(dir)) == stone) {
		} else if (getStone(pos.next(dir)) == Stone.FREE) {
			candidatesToCapture.clear();
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
		return getStone(pos) == Stone.FREE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see othello.Board#isFull()
	 */
	@Override
	public boolean isFull() {
		// TODO
		while (iterator().hasNext()) {
			Pos pos = iterator().next();
			System.out.println(pos);
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
		// TODO
		/*
		 * Map<Pos, Stone> boardMap2 = boardMap.entrySet().stream() .filter(s ->
		 * s.getValue().equals(Stone.FREE)) .collect(Collectors.toMap(p ->
		 * p.getKey(), p -> p.getValue()));
		 * 
		 * boardMap2.keySet().stream().filter(p -> p.)
		 */

		Collection<Pos> validPositions = new TreeSet<>();

		while (iterator().hasNext()) {
			Pos pos = iterator().next();
			System.out.println(pos);
			if (isFree(pos)) {
				for (Direction dir : Direction.values()) {
					if (!isValidDirection(pos, dir)) {
						break;
					}

					// if (getStone(pos).isOther(getStone(pos.next(dir)))
					if (stone.isOther(getStone(pos.next(dir)))
					// && getStone(pos) == (getStone(pos.next(dir).next(
							&& stone == (getStone(pos.next(dir).next(dir)))) {
						validPositions.add(pos);
						break;
					}
				}
			}
		}

		return validPositions.toArray(new Pos[validPositions.size()]);
	}

	public boolean isValidDirection(Pos pos, Direction dir) {
		return pos.next(dir) != null && pos.next(dir).next(dir) != null;
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
