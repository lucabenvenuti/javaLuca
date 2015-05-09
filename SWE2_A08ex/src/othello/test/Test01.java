package othello.test;

import othello.Direction;
import othello.Pos;
import othello.Stone;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Stone.FREE);
		
		for (Pos pos:Pos.values()){
			System.out.println("Position");
			System.out.println(pos);
			System.out.println("Check");
		for (Direction dir : Direction.values()) {

			System.out.println(pos.next(dir));

		}
		
		System.out.println();
		System.out.println();
		}
		
	}

}
