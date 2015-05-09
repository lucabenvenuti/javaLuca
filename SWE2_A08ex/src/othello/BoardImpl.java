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
	private int i = 0;

	/**
	 * Constructor initializing the board with two white stones on positions D 4
	 * and E 5 and two black stones on positions D 5 and E 4.
	 */
	public BoardImpl() {
		// TODO

		for (Pos p : Pos.values()) {
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
	 * (non-Javadoc)
	 * 
	 * @see othello.Board#setStone(othello.Pos, othello.Stone)
	 */
	@Override
	public void setStone(Pos pos, Stone stone) {
		// System.out.println("test");
		Pos[] validPos = getValidPositions(stone);
		if (validPos == null) {
		//	System.out.println("error");
			return;
		} /*else {
			System.out.println(validPos.length);
			System.out.println(pos);
		}
*/
		first:
		for (Pos p : validPos) {
			
			if (pos == p) {
				//System.out.println(pos);
			//	System.out.println(p);
				boardMap.put(pos, stone);
				// boardMap.remove(key)

				for (Direction dir : Direction.values()) {
					Pos pos3 = p.next(dir);
				//	System.out.println(i++);
				//	System.out.println(pos3);
					
					if (pos3 == null){
						System.out.println(pos3);
						System.out.println("null3");
					}
					
					else if (isFree(pos3)) {// do nothing
						System.out.println("free");
					//	continue;
					} else{
						System.out.println("occupied");
					}
					

					/*List<Pos> candidatesToCapture = new ArrayList<>();
					if (isValidDirection(pos3, dir)) {
						// System.out.println(pos==null);
						if (isFree(pos3)) {// do nothing
							continue;
						} else if (stone.isOther(getStone(pos3))) {// do
																	// nothing
						} else if (stone.equals(getStone(pos3))) {
							findCaptureCandidates(candidatesToCapture, pos,
									stone, dir);
						} else {
							System.out.println("Wrong insertion");
						}
					}
					if (candidatesToCapture.size() > 0) {
						capture(candidatesToCapture, stone);
					}*/

					/*
					 * Iterator<Pos> iterator1 = iterator(); while
					 * (iterator1.hasNext()) { Pos pos2 = iterator1.next();
					 * List<Pos> candidatesToCapture = new ArrayList<>(); if
					 * (isValidDirection(pos2, dir)) {
					 * System.out.println(pos==null); if (isFree(pos2)) {// do
					 * nothing } else if (stone.isOther(getStone(pos2))) {// do
					 * // nothing } else if (stone == getStone(pos2)) {
					 * findCaptureCandidates(candidatesToCapture, pos, stone,
					 * dir); } else { System.out.println("Wrong insertion"); } }
					 * 
					 * capture(candidatesToCapture, stone);
					 * 
					 * 
					 * System.out.println(pos2); if (isFree(pos2)) { return;//
					 * false; }
					 * 
					 * }
					 */

				} break first;
				// System.out.println("test");
			//	return;
			}

		}

		// 1) isLegalMove
		// 2) placeStone
		// 3) flipColor
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
		if (pos.next(dir) != null) {
			candidatesToCapture.add(pos.next(dir));
		} else {
			candidatesToCapture.clear();
		}

		if (stone.equals(getStone(pos.next(dir)))) {
		} else if (Stone.FREE.equals(getStone(pos.next(dir)))) {
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
			// System.out.println(pos);
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
		// System.out.println(validPositions.isEmpty());
		Iterator<Pos> iterator1 = iterator();
		while (iterator1.hasNext()) {
			Pos pos = iterator1.next();
			// System.out.println(pos.name());
			// System.out.println(pos);
			// System.out.println(pos);
			if (isFree(pos)) {
				for (Direction dir : Direction.values()) {
					//
					if (!isValidDirection(pos, dir)) {
						// System.out.println("test1");
						continue;
					}
					// System.out.println(pos.next(dir));
					// System.out.println(dir);
					// if (getStone(pos).isOther(getStone(pos.next(dir)))
					//
					// System.out.println(getStone(pos.next(dir)).name());
					// System.out.println(stone.isOther(getStone(pos.next(dir))));
					// System.out.println(getStone(Pos.D_4).isOther(getStone(Pos.D_4.next(Direction.E))));

					/*
					 * if (stone.isOther(getStone(pos.next(dir)))){ //
					 * System.out.println("test3"); }
					 */

					if (stone.isOther(getStone(pos.next(dir)))
					// && getStone(pos) == (getStone(pos.next(dir).next(
							&& getStone(pos.next(dir)).isOther(
									getStone(pos.next(dir).next(dir)))) {
						validPositions.add(pos);
						// System.out.println("test2");
						break;
					}
				}
			}
		}
		// System.out.println(validPositions.size());
		return validPositions.toArray(new Pos[validPositions.size()]);
	}

	public boolean isValidDirection(Pos pos, Direction dir) {
		if (pos.next(dir) == null)
			return false;
		if (pos.next(dir).next(dir) == null)
			return false;
		return true;// pos.next(dir) != null && pos.next(dir).next(dir) != null;
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
