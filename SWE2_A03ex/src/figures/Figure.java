package figures;

import animation.Animation;

public abstract class Figure {

	private final int xOrig;
	private final int yOrig;
	protected int x;
	protected int y;
	
	protected Figure(int x, int y) {
		this.xOrig = this.x = x;
		this.yOrig = this.y = y;
	}

	/**
	 * @param xOrigin
	 * @param yOrigin
	 * Draw the figure from the given origin coordinates
	 */
	public abstract void draw(int xOrigin, int yOrigin);
	
	/**
	 * @return
	 * an animation in which the figure is moved along the x axis
	 */
	public Animation createXAnimation(){
		return new Animation() {
	//		@Override
			public void animate(int frame) {
				x = xOrig + frame;
			}
		};
	}
	
	/**
	 * @return
	 * an animation in which the figure is moved along the y axis
	 */
	public Animation createYAnimation(){
		return new YAnimation(this);
	}
	
	public Animation createCircleAnimation(int radius, int framesPerRotation){
		return new CircleAnimation(radius, framesPerRotation);
	}
		
	static class YAnimation implements Animation {

		private Figure figure;
		
		public YAnimation(Figure figure) {
			this.figure = figure;
		}

	//	@Override
		public void animate(int frame) {
			figure.y = figure.yOrig + frame;
		}	
	}
	
	class CircleAnimation implements Animation{
		
			private int radius;
			private double angle;
		
			public CircleAnimation(int radius, int framesPerRotation) {
				this.radius=radius;
				angle = (Math.PI*2/framesPerRotation);
			}
		
		//	@Override
			public void animate(int frame) {
				x = (int) (xOrig  + radius*Math.cos(angle*frame)); //+ radius*Math.sqrt(2)/2
				y = (int) (yOrig  + radius*Math.sin(angle*frame)); //+ radius*Math.sqrt(2)/2
			}		
	}
	
}
