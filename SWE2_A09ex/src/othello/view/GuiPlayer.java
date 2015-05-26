package othello.view;

import othello.Board;
import othello.Player;
import othello.Pos;
import othello.Stone;

public class GuiPlayer implements Player {
    public static final String PLAYER_NAME = "Player";
    private Stone stone;
    private Pos[] validMoves;
    private Pos nextMove; // buffer of size 1

    @Override
    public String getName() {
        return PLAYER_NAME;
    }

    // consumer
    @Override
    public synchronized Pos nextMove(Board board) {
        validMoves = board.getValidPositions(this.getStone());
        if (validMoves.length == 0) {
            return null;
        } else {
            nextMove = null;
            while(nextMove == null) {
                try {
                    wait();
                } catch(InterruptedException e) { }
            }
            return nextMove;
        }
    }

    // producer
    public synchronized boolean setNextMove(Pos move) {
        if (nextMove == null) {
            for (Pos p : validMoves) {
                if (p == move) {
                    nextMove = move;
                    this.notify();
                    return true;
                }
            }
        }
        return false;
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
