package beings5;

import inout.Out;

public interface CanListen extends HasName {
	
	default void listenTo(CanTalk other) {
		Out.println(this.getName() + " listens to " + other.getName());
	}

}
