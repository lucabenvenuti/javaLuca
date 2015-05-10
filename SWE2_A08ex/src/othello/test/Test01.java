package othello.test;

import static org.junit.Assert.assertArrayEquals;
import othello.BoardImpl;
import othello.Direction;
import othello.Pos;
import othello.Stone;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*System.out.println(Stone.FREE);
		
		for (Pos pos:Pos.values()){
			System.out.println("Position");
			System.out.println(pos);
			System.out.println("Check");
		for (Direction dir : Direction.values()) {

			System.out.println(pos.next(dir));

		}
		
		System.out.println();
		System.out.println();
		
		
		}*/
		
		
		BoardImpl game = new BoardImpl();
		game.setStone(Pos.C_4, Stone.BLACK);
		game.setStone(Pos.E_3, Stone.WHITE);
		game.setStone(Pos.F_2, Stone.BLACK);
		game.setStone(Pos.C_5, Stone.WHITE);
		game.setStone(Pos.E_6, Stone.BLACK);
		for (Pos p:game.getValidPositions(Stone.WHITE)){
			System.out.println(p.toString());
		}
	}

}
