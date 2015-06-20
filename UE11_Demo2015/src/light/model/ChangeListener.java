package light.model;

import java.util.EventListener;

public interface ChangeListener extends EventListener {

	public void stateChanged(ChangeEvent evt);

}
