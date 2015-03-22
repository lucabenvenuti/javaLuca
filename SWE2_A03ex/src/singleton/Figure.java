package singleton;

import animation.Animation;
import animation.Controller;

public abstract class Figure {
	
	protected Figure(int x, int y, int w, int h) {
		this.x = x; 
		this.y = y;
		this.w = w;
		this.h = h;
	}

	protected int x;
	protected int y;
	protected int w;
	protected int h;

	public abstract void draw(int xOrigin, int yOrigin);
	
	Animation createXAnimation(){
		return new Animation() {
			@Override
			public void animate(int frame) {
				x++;
			}
		};
	}
	
	Animation createYAnimation(){
		return new YAnimation(this);
	}
	
	Animation createCircleAnimation(int radius, int framesPerRotation){
		return new CircleAnimation(radius, framesPerRotation);
	}
	
		
	static class YAnimation implements Animation{

		private Figure figure;
		
		public YAnimation(Figure figure) {
			this.figure = figure;
		}

		@Override
		public void animate(int frame) {
			figure.y++;
		}
		
	}
	
	class CircleAnimation implements Animation{
		
		private int radius, framesPerRotation, xC, yC;
		private double angle;
		private int counter =0;		

		public CircleAnimation(int radius, int framesPerRotation) {
			this.radius=radius;
			this.framesPerRotation=framesPerRotation;
			xC = (int) (x + radius*Math.sqrt(2)/2);
			yC = (int) (y + radius*Math.sqrt(2)/2);
			angle = (Math.PI*2/framesPerRotation);
		}

		@Override
		public void animate(int frame) {
			x = (int) (xC + radius*Math.cos(angle*counter));
			y = (int) (yC + radius*Math.sin(angle*counter));
			counter++;
		}
		
	}
}
