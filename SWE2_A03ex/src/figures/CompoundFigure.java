package figures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * CompoundFigure.java
 *
 * A {@link CompoundFigure} is a class which extends Figure,
 * allows to add figures to an iterable FigureList. This inner
 * FigureList class implements Iterable, so all its methods are
 * available. {@link CompoundFigure} also implements a draw method,
 * that draws all the figures in the FigureList.
 * 
 * Software Development II, 2015SS
 * JKU Linz
 * 
 * @author Luca Benvenuti
 */
public class CompoundFigure extends Figure{

	FigureList figureList = new FigureList();
	
	/**
	 * @param x
	 * @param y
	 * only the origin is necessary to create a 
	 * {@link CompoundFigure} object
	 */
	public CompoundFigure(int x, int y) {
		super(x, y);
	}

	/** (non-Javadoc)
	 * @see figures.Figure#draw(int, int)
	 * draws all the figures in the FigureList.
	 */
	@Override
	public void draw(int xOrigin, int yOrigin) {
		for (Figure f:figureList){
			f.draw(xOrigin+x, yOrigin+y);
		}
	}
	
	/**
	 * @param f
	 * add a figure to the FigureList.
	 */
	public void add(Figure f){
		figureList.push(f);
	}
	
	/**
	 * remove the first figure of the FigureList.
	 */
	public void removeListHead(){
		figureList.pop();
	}
	
	/**
	 * @return
	 * the first figure of figureList
	 */
	public Figure getListHead(){
		return figureList.top();
	}
	
	private static class Node {

		Figure figure;
		Node next;

		Node(Figure figure, Node next) {
			this.figure = figure;
			this.next = next;
		}
	}
	
	/**
	 * Implement FigureList as a private static inner class. The FigureList itself has
	 * nodes for storing the list of child figures. FigureList should implement the
	 * Iterable<Figure> interface, which allows iterating over all figures:
	 *
	 */
	private static class FigureList implements Iterable<Figure> {
			
			private Node head;
			
			void push(Figure val) {
				head = new Node(val, head);
			}

			void pop() throws NoSuchElementException {
				if (isEmpty())
					throw new NoSuchElementException();
				head = head.next;
			}
			
			Figure top() throws NoSuchElementException {
				if (isEmpty())
					throw new NoSuchElementException();
				return head.figure;
			}

			boolean isEmpty() {
				return head == null;
			}

			/**
			 * @return
			 * a new Figure iterator
			 */
			@Override
			public Iterator<Figure> iterator() {

				return new Iterator<Figure>() {

					Node current = head;

					/** (non-Javadoc)
					 * @see java.util.Iterator#hasNext()
					 * check if current is not null
					 */
					@Override
					public boolean hasNext() {
						return current != null;
					}

					/** (non-Javadoc)
					 * @see java.util.Iterator#next()
					 * return the figure next to current
					 */
					@Override
					public Figure next() throws NoSuchElementException {
						if (current == null)
							throw new NoSuchElementException();
						Figure val = current.figure;
						current = current.next;
						return val;
					}

					/** (non-Javadoc)
					 * @see java.util.Iterator#remove()
					 * remove the figure current 
					 */
					@Override
					public void remove() {
						current = current.next;
					}

				};
			}
		}
	
}


	