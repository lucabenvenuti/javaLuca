package figures;

import animation.Animation;

/**
 * Figure.java
 *
 * A {@link Figure} is an abstract class with
 * a draw abstract method, 3 createAnimation methods
 * and 2 inner classes.
 * 
 * Software Development II, 2015SS
 * JKU Linz
 * 
 * @author Luca Benvenuti
 */
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
	 * an animation in which the figure is moved along the x axis.
	 * It is implemented through an anonymous inner class.
	 * The advantage is that the anonymous inner class can see all the 
	 * fields of a Figure class object. So, there is no need to
	 * create new fields. The disadvantage is that no different field
	 * can be used.
	 */
	public Animation createXAnimation(){
		return new Animation() {
			@Override
			public void animate(int frame) {
				x = xOrig + frame;
			}
		};
	}
	
	/**
	 * @return
	 * an animation in which the figure is moved along the y axis.
	 * It calls a static inner constructor.
	 * The disadvantage is that a method based on an inner class 
	 * cannot see the 
	 * fields of a Figure class object. So, there new fields
	 * must be created. The advantage is that different fields
	 * can be used.
	 */
	public Animation createYAnimation(){
		return new YAnimation(this);
	}
	
	/**
	 * @param radius
	 * @param framesPerRotation
	 * @return
	 * an animation in which the figure is moved in a circle with its 
	 * x, y coordinates as origin.
	 */
	public Animation createCircleAnimation(int radius, int framesPerRotation){
		return new CircleAnimation(radius, framesPerRotation);
	}
		
	static class YAnimation implements Animation {

		private Figure figure;
		
		YAnimation(Figure figure) {
			this.figure = figure;
		}

		/** (non-Javadoc)
		 * @see animation.Animation#animate(int)
		 * the y coordinate of a figure is incremented by the frame
		 */
		@Override
		public void animate(int frame) {
			figure.y = figure.yOrig + frame;
		}	
	}
	
	/**
	 * The advantage of an interface compared to an abstract class
	 * is that the children classes can implement as many interfaces
	 * as they like, but they can extend only one abstract class.
	 */
	class CircleAnimation implements Animation{
		
			private int radius;
			private double angle;
		
			CircleAnimation(int radius, int framesPerRotation) {
				this.radius=radius;
				angle = (Math.PI*2/framesPerRotation);
			}
		
			/** (non-Javadoc)
			 * @see animation.Animation#animate(int)
			 * the x, y coordinates of a figure are incremented by the frame to move in a circle
			 * x, y can become negative, making the figure disappear from the screen
			 */
			@Override
			public void animate(int frame) {
				x = (int) (xOrig  + radius*Math.cos(angle*frame)); 
				y = (int) (yOrig  + radius*Math.sin(angle*frame)); 
			}		
	}
	
}
