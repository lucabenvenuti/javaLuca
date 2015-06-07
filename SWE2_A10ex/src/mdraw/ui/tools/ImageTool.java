package mdraw.ui.tools;

import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

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

	/** Default width of added image */
	private static final int DEFAULT_WIDTH = 50;
	
	/** Default height of added image */
	private static final int DEFAULT_HEIGHT = 40;

	/** Shape model where the rectangle is added */
	private final ShapeModel model;

	/**
	 * Constructor setting palette and model.
	 * 
	 * @param palette
	 *            the tool palette where this tool should be added
	 * @param model
	 *            the shape model where the image is added
	 */
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
		JFileChooser chooser = new JFileChooser(".");
		int code = chooser.showOpenDialog(null);
		if (code == 0) {
			File imgFile = chooser.getSelectedFile();
			try {
				BufferedImage image = javax.imageio.ImageIO.read(imgFile);
				ImageAdapter i = new ImageAdapter(image, me.getX(), me.getY(), DEFAULT_WIDTH, DEFAULT_HEIGHT);
				model.clearSelection();
				model.addShape(i);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("error");
		}
	}

}
