package othello.model;

import java.util.EventListener;

/**
 * PosChangeListener.java
 *
 * A {@link PosChangeListener} is a public interface extending
 * {@link EventListener}.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author Luca Benvenuti
 */
public interface PosChangeListener extends EventListener {

	/**
	 * Register the event in the listener.
	 * @param evt
	 */
	public void posChanged(PosChangeEvent evt);

}
