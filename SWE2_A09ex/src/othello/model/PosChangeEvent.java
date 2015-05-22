package othello.model;

import java.util.EventObject;

import othello.Pos;

@SuppressWarnings("serial")
public class PosChangeEvent extends EventObject {

	private final int row;
	private final int column;
	private final Pos pos;

	PosChangeEvent(PosModel source, int row, int column) {
		super(source);
		this.row = row;
		this.column = column;
		this.pos = Pos.getPos(row, column);
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public Pos getPos() {
		return pos;
	}

}
