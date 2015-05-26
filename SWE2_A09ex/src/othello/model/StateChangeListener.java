package othello.model;

import java.util.EventListener;

/**
 * StateChangeListener.java
 *
 * A {@link StateChangeListener} is a public interface extending {@link EventListener}.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author Luca Benvenuti
 */
public interface StateChangeListener extends EventListener {

	/**
	 * Register the event in the listener.
	 * @param evt
	 */
	public void stateChanged(StateChangeEvent evt);
}
