package othello;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/** 
 * Class representing the board. It has 8x8 fields (as a chessboard) and 
 * maintains the stones on the board. 
 */
public class BoardImpl implements Board {
	
	private Map<Pos, Stone> boardMap = new TreeMap<>();
	
	/** 
	 * Constructor initializing the board with two white stones on positions D 4 and E 5
	 * and two black stones on positions D 5 and E 4. 
	 */
	public BoardImpl() {
		// TODO
	}
	
	/* (non-Javadoc)
	 * @see othello.Board#getStone(othello.Pos)
	 */
	@Override
	public Stone getStone(Pos pos) {
		
		// TODO 
			return boardMap.get(pos); 
	}
	
	/* (non-Javadoc)
	 * @see othello.Board#setStone(othello.Pos, othello.Stone)
	 */
	@Override
	public void setStone(Pos pos, Stone stone) {
		// 1) isLegalMove
		// 2) placeStone
		// 3) flipColor
	}

	/* (non-Javadoc)
	 * @see othello.Board#isFree(othello.Pos)
	 */
	@Override
	public boolean isFree(Pos pos) {
		// TODO
		return getStone(pos) == Stone.FREE; 
	}
	
	/* (non-Javadoc)
	 * @see othello.Board#isFull()
	 */
	@Override
	public boolean isFull() {
		// TODO
		return true;
	}
	
	/* (non-Javadoc)
	 * @see othello.Board#getValidPositions(othello.Stone)
	 */
	@Override
	public Pos[] getValidPositions(Stone stone) {
		// TODO
		return null;
	}

	/* (non-Javadoc)
	 * @see othello.Board#iterator()
	 */
	@Override
	public Iterator<Pos> iterator() {
		// TODO 
		return boardMap.keySet().iterator();
	}


}
