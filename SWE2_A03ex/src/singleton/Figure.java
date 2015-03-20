package singleton;

public abstract class Figure {
	
	protected Figure(int x, int y) {
		this.x = x; //w
		this.y = y; //h
	}

	protected int x;
	protected int y;

	public abstract void draw(int xOrigin, int yOrigin);
	
}
