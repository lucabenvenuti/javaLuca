package othello.model;

import java.util.EventListener;

public interface PosChangeListener extends EventListener {
	
	public void valueChanged(PosChangeEvent evt);
	
}