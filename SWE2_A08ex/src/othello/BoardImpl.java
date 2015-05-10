package othello;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * BoardImpl.java
 *
 * A {@link BoardImpl} is a public class representing the board. It has 8x8
 * fields (as a chessboard) and maintains the stones on the board. It implements
 * the methods given in {@link Board}, plus a method to find the candidates to
 * be flipped.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author TAs & Luca Benvenuti
 * 
 * 
 */
public class BoardImpl implements Board {

	private Map<Pos, Stone> boardMap = new TreeMap<>();

	/**
	 * TAs: Constructor initializing the board with two white stones on
	 * positions D 4 and E 5 and two black stones on positions D 5 and E 4.
	 */
	public BoardImpl() {
		for (Pos p : Pos.ALL) {
			boardMap.put(p, Stone.FREE);
		}
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
		boardMap.put(pos, stone);
		for (Direction dir : Direction.values()) {
			ArrayList<Pos> candidatesToCapture = new ArrayList<>();
			findCaptureCandidates(candidatesToCapture, pos, stone, dir);
			for (Pos candidateToCapture : candidatesToCapture) {
				boardMap.put(candidateToCapture, stone);
			}
		}
	}

	private void findCaptureCandidates(List<Pos> candidatesToCapture, Pos pos,
			Stone stone, Direction dir) {
		Pos nextPos = pos.next(dir);
		if (nextPos == null) {
			candidatesToCapture.clear();
		} else {
			Stone nextStone = getStone(nextPos);
			if (nextStone == Stone.FREE) {
				candidatesToCapture.clear();
			} else if (nextStone.isOther(stone)) {
				candidatesToCapture.add(nextPos);
				findCaptureCandidates(candidatesToCapture, nextPos, stone, dir);
			}
		}
	}

	@Override
	public boolean isFree(Pos pos) {
		return Stone.FREE.equals(getStone(pos));
	}

	@Override
	public boolean isFull() {
		for (Iterator<Pos> iter = iterator(); iter.hasNext();) {
			if (isFree(iter.next())) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Pos[] getValidPositions(Stone stone) {
		List<Pos> validPositions = new ArrayList<>();
		for (Iterator<Pos> iter = iterator(); iter.hasNext();) {
			Pos pos = iter.next();
			if (isFree(pos)) {
				for (Direction dir : Direction.values()) {
					if (isValidDirection(pos, stone, dir)) {
						validPositions.add(pos);
						break;
					}
				}
			}
		}
		return validPositions.toArray(new Pos[validPositions.size()]);
	}

	private boolean isValidDirection(Pos pos, Stone stone, Direction dir) {
		LinkedList<Pos> candidatesToCapture = new LinkedList<>();
		findCaptureCandidates(candidatesToCapture, pos, stone, dir);
		return !candidatesToCapture.isEmpty();
	}

	@Override
	public Iterator<Pos> iterator() {
		return boardMap.keySet().iterator();
	}

}
