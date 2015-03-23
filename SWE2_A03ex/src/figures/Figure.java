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

	public abstract void draw(int xOrigin, int yOrigin);
	
	public Animation createXAnimation(){
		return new Animation() {
			@Override
			public void animate(int frame) {
				x = xOrig + frame;
			}
		};
	}
	
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

		@Override
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
		
			@Override
			public void animate(int frame) {
				x = (int) (xOrig + radius*Math.sqrt(2)/2 + radius*Math.cos(angle*frame));
				y = (int) (yOrig + radius*Math.sqrt(2)/2 + radius*Math.sin(angle*frame));
			}		
	}
	
}
