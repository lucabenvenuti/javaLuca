package mdraw.ui.tools;

import java.awt.event.MouseEvent;

import javax.swing.Action;
import javax.swing.ImageIcon;

import mdraw.model.ShapeModel;
import mdraw.shapes.*;

/**
 * Tool for adding a {@link ImageShape} object. Object is added on
 * {@link RectTool#mouseClicked(MouseEvent)} events.
 * 
 * @author Luca Benvenuti
 * @version 1.0
 */
@SuppressWarnings("serial")
public class ImageTool extends Tool {

	private final ShapeModel model;


	public ImageTool(ToolPalette palette, ShapeModel model) {
		super("ImageShape", new ImageIcon("img.png"), palette);
		this.model = model;
		putValue(Action.SHORT_DESCRIPTION, "Put an image");
	}

	/**
	 * Handles mouse clicked events (forwarded from drawing panel) and adds a
	 * {@link ImageShape} object at current mouse position and with default width and
	 * height to the shape model.
	 * 
	 * @param me
	 *            the mouse event object
	 */
	@Override
	public void mouseClicked(MouseEvent me) {
		ImageAdapter i = new ImageAdapter(me.getX(), me.getY());
		model.clearSelection();
		model.addShape(i);
	}

}
