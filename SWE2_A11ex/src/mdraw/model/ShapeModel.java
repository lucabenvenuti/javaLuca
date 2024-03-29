package mdraw.model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.EventListenerList;

import mdraw.command.AddShapeCommand;
import mdraw.command.Command;
import mdraw.command.MoveShapeCommand;
import mdraw.command.RemoveShapeCommand;
import mdraw.command.ResizeShapeCommand;
import mdraw.command.StretchSelectionCommand;
import mdraw.command.UnstretchSelectionCommand;
import mdraw.shapes.Shape;

/**
 * Model maintaining a list of shapes in a drawing application and selection of
 * shapes. Allows accessing shapes, adding and removing shapes, and moving and
 * resizing shapes. Allows setting, adding, and removing selected shapes. Will
 * signal <code>shapeChangeEvents</code> when changing the set of shapes. Will
 * signal <code>shapeSelectionEvents</code> when changing the selection of
 * shapes.
 * 
 * @author Herbert Praehofer
 * @author Luca Benvenuti
 * @version 1.2
 * @since 1.1
 */
public class ShapeModel {

	/** List of shapes */
	private final ArrayList<Shape> shapes;

	/** List of selected shapes */
	private final ArrayList<Shape> selected;

	/** List for event listeners */
	private final EventListenerList listeners;

	private final Deque<Command> undoStack;
	private final Deque<Command> redoStack;

	/** Default constructor */
	public ShapeModel() {
		shapes = new ArrayList<>();
		selected = new ArrayList<>();
		listeners = new EventListenerList();
		undoStack = new ArrayDeque<>();
		redoStack = new ArrayDeque<>();
	}

	// shapes

	/**
	 * Gets the shapes of this model.
	 * 
	 * @return the shapes of this model
	 */
	public Shape[] getShapes() {
		return getListShapes().toArray(new Shape[getListShapes().size()]);
	}

	/**
	 * Adds a shape to this shape model. Shape must not be null.
	 * 
	 * @param s
	 *            the shape to add
	 */
	public void addShape(Shape s) {
		assert (s != null);
		AddShapeCommand addShapeCommand = new AddShapeCommand(this, s);
		addShapeCommand.doCmd();
		undoStack.addFirst(addShapeCommand);
		redoStack.clear();
	}

	/**
	 * Removes a shape from this model. Shape must not be null.
	 * 
	 * @param s
	 *            the shape to remove
	 */
	public void removeShape(Shape s) {
		assert (s != null);
		RemoveShapeCommand removeShapeCommand = new RemoveShapeCommand(this, s);
		removeShapeCommand.doCmd();
		undoStack.addFirst(removeShapeCommand);
		redoStack.clear();
	}

	/**
	 * Moves a shape to a new position
	 * 
	 * @param s
	 *            the shape to move
	 * @param dx
	 *            the delta in x
	 * @param dy
	 *            the delta in y
	 */
	public void moveShape(Shape s, int dx, int dy) {
		assert (s != null);
		MoveShapeCommand moveShapeCommand = new MoveShapeCommand(this, s, dx,
				dy);
		moveShapeCommand.doCmd();
		undoStack.addFirst(moveShapeCommand);
		redoStack.clear();
	}

	/**
	 * Resizes the shape to new width and height
	 * 
	 * @param s
	 *            the shape to resize
	 * @param w
	 *            the new width
	 * @param h
	 *            the new height
	 */
	public void resizeShape(Shape s, int w, int h) {
		assert (s != null);
		ResizeShapeCommand resizeShapeCommand = new ResizeShapeCommand(this, s,
				w, h);
		resizeShapeCommand.doCmd();
		undoStack.addFirst(resizeShapeCommand);
		redoStack.clear();
	}

	/**
	 * Adds a shape change listener
	 * 
	 * @param l
	 *            the shape change listener to add
	 */
	public void addShapeChangedListener(ShapeChangedListener l) {
		listeners.add(ShapeChangedListener.class, l);
	}

	/**
	 * Removes a shape change listener
	 * 
	 * @param l
	 *            the shape change listener to remove
	 */
	public void removeShapeChangedListener(ShapeChangedListener l) {
		listeners.remove(ShapeChangedListener.class, l);
	}

	// selections

	/**
	 * Gets the currently selected shapes.
	 * 
	 * @return the selected shapes
	 */
	public Shape[] getSelected() {
		return getListSelected().toArray(new Shape[getListSelected().size()]);
	}

	/**
	 * Sets the selected shapes. Selected shapes must be a subset of all the
	 * shapes in model.
	 * 
	 * @param shapes
	 *            the selected shapes
	 */
	public void setSelection(Shape[] shapes) {
		assert (shapes != null);
		getListSelected().clear();
		getListSelected().addAll(Arrays.asList(shapes));
		fireSelectionChanged(getListSelected());
	}

	/**
	 * Adds a shape to the currently selected shapes.
	 * 
	 * @param s
	 *            the shape to add to the selected shapes
	 */
	public void addSelections(Shape s) {
		assert (s != null);
		if (getListSelected().add(s)) {
			fireSelectionChanged(getListSelected());
		}
	}

	/**
	 * Removes a shape to the currently selected shapes.
	 * 
	 * @param s
	 *            the shape to remove to the selected shapes
	 */
	public void removeSelection(Shape s) {
		assert (s != null);
		if (getListSelected().remove(s)) {
			fireSelectionChanged(getListSelected());
		}
	}

	/**
	 * Clears the selected shapes. Selected shapes will be empty afterwards.
	 */
	public void clearSelection() {
		getListSelected().clear();
		fireSelectionChanged(getListSelected());
	}

	/**
	 * Stretch the selected Shapes. Gives a message error if there is none
	 * selected.
	 */
	public void stretchShapes() {
		if (getListSelected().isEmpty()) {
			JOptionPane.showMessageDialog(new JFrame(),
					"Please select at least one element", "Dialog",
					JOptionPane.ERROR_MESSAGE);
		} else {
			StretchSelectionCommand stretchSelectionCommand = new StretchSelectionCommand(
					this);
			stretchSelectionCommand.doCmd();
			undoStack.addFirst(stretchSelectionCommand);
			redoStack.clear();
		}
	}

	/**
	 * Stretch the selected Shapes. Gives a message error if there is none
	 * selected.
	 */
	public void unstretchShapes() {
		if (getListSelected().isEmpty()) {
			JOptionPane.showMessageDialog(new JFrame(),
					"Please select at least one element", "Dialog",
					JOptionPane.ERROR_MESSAGE);
		} else {
			UnstretchSelectionCommand unstretchSelectionCommand = new UnstretchSelectionCommand(
					this);
			unstretchSelectionCommand.doCmd();
			undoStack.addFirst(unstretchSelectionCommand);
			redoStack.clear();
		}
	}

	/**
	 * Tests if the given shape is in the set of selected shapes.
	 * 
	 * @param shape
	 *            the shape to test if in the set of selected shapes.
	 * @return <code>true</code> if shape is in the set of selected shapes
	 */
	public boolean isSelected(Shape shape) {
		for (Shape s : getListSelected()) {
			if (s == shape) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Adds a shape selection listener
	 * 
	 * @param l
	 *            the shape selection listener to add
	 */
	public void addShapeSelectionListener(ShapeSelectionListener l) {
		listeners.add(ShapeSelectionListener.class, l);
	}

	/**
	 * Removes a shape selection listener
	 * 
	 * @param l
	 *            the shape selection listener to remove
	 */
	public void removeShapeSelectionListener(ShapeSelectionListener l) {
		listeners.remove(ShapeSelectionListener.class, l);
	}

	/**
	 * Fires a shape added event for the given shape.
	 * 
	 * @param s
	 *            the shape which has been added
	 */
	public void fireShapeAdded(Shape s) {
		ShapeChangedEvent evt = new ShapeChangedEvent(this, "added",
				new Shape[] { s });
		for (ShapeChangedListener l : listeners
				.getListeners(ShapeChangedListener.class)) {
			l.shapeAdded(evt);
		}
	}

	/**
	 * Fires a shape removed event for the given shape.
	 * 
	 * @param s
	 *            the shape which has been removed
	 */
	public void fireShapeRemoved(Shape s) {
		ShapeChangedEvent evt = new ShapeChangedEvent(this, "removed",
				new Shape[] { s });
		for (ShapeChangedListener l : listeners
				.getListeners(ShapeChangedListener.class)) {
			l.shapeRemoved(evt);
		}
	}

	/**
	 * Fires a shape changed event for the given shape.
	 * 
	 * @param shapes
	 *            the shapes which have been changed
	 */
	public void fireShapeChanged(Shape... shapes) {
		ShapeChangedEvent evt = new ShapeChangedEvent(this, "changed", shapes);
		for (ShapeChangedListener l : listeners
				.getListeners(ShapeChangedListener.class)) {
			l.shapeChanged(evt);
		}
	}

	/**
	 * Signals a change in the selected shapes.
	 * 
	 * @param selected
	 *            the shapes which are now selected
	 */
	public void fireSelectionChanged(List<Shape> selected) {
		ShapeSelectionEvent evt = new ShapeSelectionEvent(this, getSelected());
		for (ShapeSelectionListener l : listeners
				.getListeners(ShapeSelectionListener.class)) {
			l.shapeSelectionChanged(evt);
		}
	}

	/**
	 * Undo the latest command performed.
	 */
	public void undoCommand() {
		if (undoStack.isEmpty()) {
			return;
		}
		Command cmd = undoStack.getFirst();
		cmd.undoCmd();
		undoStack.removeFirst();
		redoStack.addFirst(cmd);
	}

	/**
	 * Redo the latest command performed.
	 */
	public void redoCommand() {
		if (redoStack.isEmpty()) {
			return;
		}
		Command cmd = redoStack.removeFirst();
		cmd.doCmd();
		undoStack.addFirst(cmd);
	}

	/**
	 * Getter.
	 * 
	 * @return the <code>selected</code> as an <code>ArrayList<Shape></code>
	 */
	public ArrayList<Shape> getListSelected() {
		return selected;
	}

	/**
	 * Getter.
	 * 
	 * @return the <code>shapes</code> as an <code>ArrayList<Shape></code>
	 */
	public ArrayList<Shape> getListShapes() {
		return shapes;
	}

}
