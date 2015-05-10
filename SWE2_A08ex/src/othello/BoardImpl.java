package othello;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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

	@Override
	public Stone getStone(Pos pos) {
		return boardMap.get(pos);
	}

	@Override
	public void setStone(Pos pos, Stone stone) {
		if (!isFull() && Optional.ofNullable(stone).isPresent()) {
			Pos[] validPos = getValidPositions(stone);

			if (Optional.ofNullable(validPos).isPresent()) {

				for (Pos p : validPos) {
					if (pos.equals(p)) { // 1) isLegalMove
						boardMap.remove(pos);
						boardMap.put(pos, stone); // 2) placeStone

						for (Direction dir : Direction.values()) {
							Pos pos3 = p.next(dir);
							if (!Optional.ofNullable(pos3).isPresent()) {
								continue; // this branch can be tested only when
											// the setStone starts to reach one
											// border of the Board.
							}

							List<Pos> candidatesToCapture = new ArrayList<>();
							if (isValidDirection(pos3, dir)) {
								if (isFree(pos3)) {
									continue;
								} else if (stone.isOther(getStone(pos3))) {
									findCaptureCandidates(candidatesToCapture,
											pos, stone, dir);
								} else if (stone.equals(getStone(pos3))) {// do
																			// nothing
								} else {
									System.out
											.println("Wrong insertion, this message should appear only if the constructor has been wrongly initialized");
								}
							}
							if (candidatesToCapture.size() > 0) {
								capture(candidatesToCapture, stone); // 3)
																		// flipColor
							}
						}
						break;
					}
				}
			}
		}
	}

	private void capture(List<Pos> candidatesToCapture, Stone stone) {
		for (Pos p : candidatesToCapture) {
			boardMap.remove(p);
			boardMap.put(p, stone);
		}
	}

	/**
	 * 
	 * Recursive function to update a list of Pos candidate to be flipped, given
	 * a direction. The list is filled with opposite stones Pos, completed with
	 * same stone, and emptied if a null or a opposite stone are in the last
	 * Pos.
	 * 
	 * @param candidatesToCapture
	 * @param pos
	 * @param stone
	 * @param dir
	 */
	public void findCaptureCandidates(List<Pos> candidatesToCapture, Pos pos,
			Stone stone, Direction dir) {
		if (!Optional.ofNullable(pos.next(dir)).isPresent()) {
			candidatesToCapture.clear();
		} else {
			candidatesToCapture.add(pos.next(dir));
			if (stone.equals(getStone(pos.next(dir)))) {
			} else if (Stone.FREE.equals(getStone(pos.next(dir)))) {
				candidatesToCapture.clear();
			} else {
				findCaptureCandidates(candidatesToCapture, pos.next(dir),
						stone, dir);
			}
		}
	}

	@Override
	public boolean isFree(Pos pos) {
		return Stone.FREE.equals(getStone(pos));
	}

	@Override
	public boolean isFull() {
		Iterator<Pos> iterator1 = iterator();
		while (iterator1.hasNext()) {
			Pos pos = iterator1.next();
			if (isFree(pos)) {
				return false;
			}
		}
		return true; // this branch can be tested only when the game is finished
						// with one winner, because the boardMap is private.
	}

	@Override
	public Pos[] getValidPositions(Stone stone) {
		Collection<Pos> validPositions = new TreeSet<>();
		if (Optional.ofNullable(stone).isPresent()) {

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
		}
		return validPositions.toArray(new Pos[validPositions.size()]);
	}

	public boolean isValidDirection(Pos pos, Direction dir) {
		return Optional.ofNullable(pos.next(dir)).isPresent()
				&& Optional.ofNullable(pos.next(dir).next(dir)).isPresent();
	}

	@Override
	public Iterator<Pos> iterator() {
		return boardMap.keySet().iterator();
	}

}
