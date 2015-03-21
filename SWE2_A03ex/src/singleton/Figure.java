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
	
/*	public abstract class Base1 implements Animation {}


	protected Animation varClass1 = new Base1() {

		@Override
		public void animate(int frame) {
			// TODO Auto-generated method stub
			
		}};*/
	
	Animation createXAnimation(){
		
		//a.animate(Controller.FRAMES_PER_SECOND);
		//return a;
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
}
