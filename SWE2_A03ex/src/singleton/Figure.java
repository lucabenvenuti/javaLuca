package singleton;

import animation.Animation;
import animation.Controller;

public abstract class Figure {
	
	protected Figure(int x, int y) {
		this.x = x; //w
		this.y = y; //h
	}

	protected int x;
	protected int y;

	public abstract void draw(int xOrigin, int yOrigin);
	
/*	public abstract class Base1 implements Animation {}


	protected Animation varClass1 = new Base1() {

		@Override
		public void animate(int frame) {
			// TODO Auto-generated method stub
			
		}};*/
	
	Animation createXAnimation(){
		a.animate(Controller.FRAMES_PER_SECOND);
		return a;
	}
	
	Animation a = new Animation(){

		@Override
		public void animate(int frame) {
			// TODO Auto-generated method stub
			
		}};
		
		static class YAnimation implements Animation{

			@Override
			public void animate(int frame) {
				// TODO Auto-generated method stub
				
			}
			
		Animation createYAnimation(){
			
			return a;}
			
		}
	
}
