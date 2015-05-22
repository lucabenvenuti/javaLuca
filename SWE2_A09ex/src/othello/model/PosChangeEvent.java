package othello.model;

import java.util.EventObject;

@SuppressWarnings("serial")
public class PosChangeEvent extends EventObject {

	private final int row;
	private final int column;

	PosChangeEvent(PosModel source, int row, int column) {
		super(source);
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

}
