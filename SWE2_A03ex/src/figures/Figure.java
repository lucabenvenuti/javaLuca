package figures;

import animation.Animation;
import animation.Controller;

public abstract class Figure {

	private final int xOrig;
	private final int yOrig;
	protected int x;
	protected int y;
	//protected int w;
//	protected int h;
	
	protected Figure(int x, int y) {
		this.xOrig = this.x = x;
		this.yOrig = this.y = y;
	//	this.w = w;
		//this.h = h;
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
	
	public Animation createCircleAnimation(int radius, int framesPerRotation){
		return new CircleAnimation(radius, framesPerRotation);
	}
	
	class CircleAnimation implements Animation{
		
			private int radius; //, xC, yC; //framesPerRotation, 
			private double angle;
	//		private int counter =0;		
		
			public CircleAnimation(int radius, int framesPerRotation) {
				this.radius=radius;
			//	this.framesPerRotation=framesPerRotation;
			//	xC = (int) (xOrig + radius*Math.sqrt(2)/2);
			//	yC = (int) (yOrig + radius*Math.sqrt(2)/2);
				angle = (Math.PI*2/framesPerRotation);
				}
		
	/*		public CircleAnimation() {
				// TODO Auto-generated constructor stub
			}*/

			@Override
			public void animate(int frame) {
				x = (int) (xOrig + radius*Math.sqrt(2)/2 + radius*Math.cos(angle*frame));
				y = (int) (yOrig + radius*Math.sqrt(2)/2 + radius*Math.sin(angle*frame));
				//counter++;
			}
				
	}
	
}
