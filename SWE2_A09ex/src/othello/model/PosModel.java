package othello.model;

import java.util.ArrayList;
import java.util.List;

import othello.model.PosChangeEvent;
import othello.model.PosChangeListener;

public class PosModel {
	
	private int row;
	private int column;
	private List<PosChangeListener> listeners = new ArrayList<PosChangeListener>();

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public void setValue(int row, int column) {
		this.row = row;
		this.column = column;
		fireChangeEvent();
	}

/*	public void incr() {
		this.value++;
		fireChangeEvent();
	}

	public void decr() {
		this.value--;
		fireChangeEvent();
	}

	public void reset() {
		this.value = 0;
		fireChangeEvent();
	}*/

	public void addValueChangeListener(PosChangeListener listener) {
		listeners.add(listener);
	}

	public void removeValueChangeListener(PosChangeListener listener) {
		listeners.remove(listener);
	}

	private void fireChangeEvent() {
		PosChangeEvent evt = new PosChangeEvent(this, getRow(), getColumn());
		for (PosChangeListener l : listeners) {
			l.valueChanged(evt);
		}
	}
	
}
