package mdraw.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

import mdraw.model.ShapeModel;
import mdraw.shapes.*;
import mdraw.visitor.*;
import mdraw.shapes.Shape;
import mdraw.ui.tools.*;

/**
 * Application object for micro drawing tool.
 * 
 * @author Herbert Praehofer & Luca Benvenuti
 * @version 1.2
 * @since 1.1
 */
public class DrawApp {

	/**
	 * Starts the drawing application with new drawing model.
	 * 
	 * @param args
	 *            the program arguments (not used)
	 */
	public static void main(String[] args) {
		ShapeModel model = new ShapeModel();
		DrawApp app = new DrawApp(model);
		app.start();
	}

	/** Drawing model */
	private final ShapeModel model;

	/** Frame object */
	private final JFrame frame;

	/** Tool palette representing tools in tool bar */
	private ToolPalette toolPalette;

	/** Drawing panel object */
	private DrawPanel drawPanel;

	/**
	 * Constructor initializing model and setting up application.
	 * 
	 * @param model
	 *            the model for this application
	 */
	public DrawApp(ShapeModel model) {
		super();
		this.model = model;
		frame = new JFrame("Micro Draw");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setUpUI();
	}

	/**
	 * Creates UI components and tool palette.
	 */
	private void setUpUI() {

		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());

		// menu bar
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		JMenu fileMenu = new JMenu("Menu");
		menuBar.add(fileMenu);
		JMenuItem exitMenu = new JMenuItem(exitAction);
		fileMenu.add(exitMenu);
		JMenu editMenu = new JMenu("Edit");
		menuBar.add(editMenu);
		editMenu.add(delAction);
		editMenu.addSeparator();
		editMenu.add(groupAction);
		editMenu.add(ungroupAction);
		editMenu.addSeparator();
		editMenu.addSeparator();
		editMenu.add(undoAction);
		editMenu.add(redoAction);
		editMenu.addSeparator();
		editMenu.addSeparator();
		editMenu.add(strechShapes);
		editMenu.add(unstrechShapes);
		editMenu.add(computeArea);

		// tools and tool palette
		toolPalette = new ToolPalette();
		contentPane.add(toolPalette, BorderLayout.PAGE_START);
		toolPalette.addTool(new SelTool(toolPalette, model));
		toolPalette.addTool(new RectTool(toolPalette, model));
		toolPalette.addTool(new OvalTool(toolPalette, model));
		toolPalette.addTool(new ImageTool(toolPalette, model));
		toolPalette.addSeparator(new Dimension(8, 12));
		toolPalette.add(delAction);
		toolPalette.addSeparator(new Dimension(8, 12));
		toolPalette.add(groupAction);
		toolPalette.add(ungroupAction);
		toolPalette.addSeparator(new Dimension(8, 12));
		toolPalette.add(undoAction);
		toolPalette.add(redoAction);
		toolPalette.addSeparator(new Dimension(8, 12));
		toolPalette.add(strechShapes);
		toolPalette.add(unstrechShapes);
		toolPalette.add(computeArea);

		// drawing panel
		drawPanel = new DrawPanel(model, toolPalette);
		contentPane.add(drawPanel, BorderLayout.CENTER);

		frame.pack();
	}

	/**
	 * Starts application by opening frame.
	 */
	private void start() {
		frame.setVisible(true);
	}

	// Action objects

	/** Handler for exit actions */
	@SuppressWarnings("serial")
	private Action exitAction = new AbstractAction("Exit") {
		{
			putValue(Action.SHORT_DESCRIPTION, "Exit application");
		}

		@SuppressWarnings("synthetic-access")
		@Override  // Javadoc: see super class
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		}
	};

	/** Handler for delete actions */
	@SuppressWarnings("serial")
	private Action delAction = new AbstractAction("Del") {
		{
			putValue(Action.ACCELERATOR_KEY,
					KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
			putValue(Action.SHORT_DESCRIPTION, "Delete selected shapes");
		}

		@SuppressWarnings("synthetic-access")
		@Override  // Javadoc: see super class
		public void actionPerformed(ActionEvent e) {
			Shape[] selected = model.getSelected();
			if (selected.length == 0) {
				return;
			}
			for (Shape s : selected) {
				model.removeShape(s);
			}
			model.clearSelection();
		}
	};

	/** Handler for group actions */
	@SuppressWarnings({ "serial", "static-access" })
	private Action groupAction = new AbstractAction("Group") {
		{
			putValue(Action.ACCELERATOR_KEY,
					KeyStroke.getKeyStroke(KeyEvent.VK_G, KeyEvent.CTRL_MASK));
			putValue(Action.SHORT_DESCRIPTION, "Group selected shapes");
		}

		@SuppressWarnings("synthetic-access")
		@Override  // Javadoc: see super class
		public void actionPerformed(ActionEvent e) {
			Shape[] selected = model.getSelected();
			if (selected.length <= 1) {
				JOptionPane.showMessageDialog(frame,
						"Must select at least two elements to build group");
				return;
			}
			for (Shape s : selected) {
				model.removeShape(s);
			}
			Group group = new Group(selected);
			model.addShape(group);
			model.clearSelection();
			model.addSelections(group);
		}
	};

	/** Handler for ungroup actions */
	@SuppressWarnings({ "serial", "static-access" })
	private Action ungroupAction = new AbstractAction("Ungroup") {
		{
			putValue(Action.ACCELERATOR_KEY,
					KeyStroke.getKeyStroke(KeyEvent.VK_U, KeyEvent.CTRL_MASK));
			putValue(Action.SHORT_DESCRIPTION, "Ungroup selected group");
		}

		@SuppressWarnings("synthetic-access")
		@Override  // Javadoc: see super class
		public void actionPerformed(ActionEvent e) {
			Shape[] selected = model.getSelected();
			if (selected.length != 1 || !(selected[0] instanceof Group)) {
				JOptionPane.showMessageDialog(frame,
						"Must select a single group to ungroup");
				return;
			}
			Group group = (Group) selected[0];
			model.removeShape(group);
			model.clearSelection();
			for (Shape s : group.getElements()) {
				model.addShape(s);
				model.addSelections(s);
			}
		}
	};

	/** Handler for undo actions */
	@SuppressWarnings({ "serial", "static-access" })
	private Action undoAction = new AbstractAction("Undo") {
		{
			putValue(Action.ACCELERATOR_KEY,
					KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_MASK));
			putValue(Action.SHORT_DESCRIPTION, "Undo last operation");
		}

		@Override  // Javadoc: see super class
		public void actionPerformed(ActionEvent e) {
			throw new UnsupportedOperationException();
		}
	};

	/** Handler for redo actions */
	@SuppressWarnings({ "serial", "static-access" })
	private Action redoAction = new AbstractAction("Redo") {
		{
			putValue(Action.ACCELERATOR_KEY,
					KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_MASK));
			putValue(Action.SHORT_DESCRIPTION, "Redo last undone operation");
		}

		@Override  // Javadoc: see super class
		public void actionPerformed(ActionEvent e) {
			throw new UnsupportedOperationException();
			// model.redoCommand();
		}
	};

	/** Handler for strech shapes actions */
	@SuppressWarnings({ "serial", "static-access" })
	private Action strechShapes = new AbstractAction("Strech shapes") {
		{
			putValue(Action.ACCELERATOR_KEY,
					KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_MASK));
			putValue(Action.SHORT_DESCRIPTION, "Strech the shapes");
		}

		@SuppressWarnings("synthetic-access")
		@Override  // Javadoc: see super class
		public void actionPerformed(ActionEvent e) {

			Shape[] selected = model.getSelected();
			if (selected.length < 1) {
				JOptionPane.showMessageDialog(new JFrame(),"Please select at least one element", "Dialog",
				        JOptionPane.ERROR_MESSAGE);
			}
			for (Shape s : selected) {
				ShapeVisitor<Void> stretchVisitor = new StretchVisitor();
				s.accept(stretchVisitor);
			}
			model.clearSelection();
		}
	};
	
	/** Handler for unstrech shapes actions */
	@SuppressWarnings({ "serial", "static-access" })
	private Action unstrechShapes = new AbstractAction("Unstrech shapes") {
		{
			putValue(Action.ACCELERATOR_KEY,
					KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_MASK));
			putValue(Action.SHORT_DESCRIPTION, "Unstrech the shapes");
		}

		@SuppressWarnings("synthetic-access")
		@Override  // Javadoc: see super class
		public void actionPerformed(ActionEvent e) {

			Shape[] selected = model.getSelected();
			if (selected.length < 1) {
				JOptionPane.showMessageDialog(new JFrame(),"Please select at least one element", "Dialog",
				        JOptionPane.ERROR_MESSAGE);
			}
			for (Shape s : selected) {
				ShapeVisitor<Void> unstretchVisitor = new UnstretchVisitor();
				s.accept(unstretchVisitor);
			}
			model.clearSelection();
		}
	};

	/** Handler for compute area actions */
	@SuppressWarnings({ "serial", "static-access" })
	private Action computeArea = new AbstractAction("Compute area") {
		{
			putValue(Action.ACCELERATOR_KEY,
					KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_MASK));
			putValue(Action.SHORT_DESCRIPTION, "Compute the area");
		}

		@SuppressWarnings("synthetic-access")
		@Override  // Javadoc: see super class
		public void actionPerformed(ActionEvent e) {
			Shape[] selected = model.getSelected();
			if (selected.length < 1) {
				JOptionPane.showMessageDialog(new JFrame(),"Please select at least one element", "Dialog",
				        JOptionPane.ERROR_MESSAGE);
			}
			int area = 0;
			for (Shape s : selected) {
				ShapeVisitor<Integer> areaVisitor = new AreaVisitor();
				area += s.accept(areaVisitor);
			}
			System.out.println("Area of selected images is:");
			System.out.println(area);
			model.clearSelection();
		}
	};

}
