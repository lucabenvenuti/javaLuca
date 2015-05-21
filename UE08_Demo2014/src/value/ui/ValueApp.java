package value.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import value.model.ValueModel;

/*
 * This implementation of a Swing frame shows:
 * 1) Creation and display of a frame
 * 2) Closing a frame
 * 3) Menus
 * 4) Creation of hierarchy of components and layouting 
 * 5) Definition and using models 
 * 6) Implementation of ActionListeners
 * 7) Using JOptionPane and JFileChooser
 */
public class ValueApp {

	// 1) Declaration of frame
	private JFrame frame;

	// 5) Declaration of model variable
	private final ValueModel model;

	// 4) Declaration of component variables
	private JLabel valueLabel;
	private JButton incrButton, decrButton, resetButton;
	private JTextField newValueField;
	private DefaultListModel<Integer> historyListModel;
	private JList<Integer> historyList;
	
	private boolean saved = false; 

	/**
	 * Creates the application and sets the model
	 * 
	 * @param model the model to work on. 
	 */
	public ValueApp(ValueModel model) {
		super();
		// 5) Set model
		this.model = model;
		setup();
	}

	/** 
	 * Starts the application by creating all the view components. 
	 */
	private void setup() {

		// 1) Create frame
		frame = new JFrame("Value");

		// 2) Closing frame
		// option 1: with setDefaultCloseOperation
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		// option 1: using windowListener
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (!saved) {
				int reply = JOptionPane.showConfirmDialog(frame, "Save data", "Save data",
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					saveToFile();
					super.windowClosing(e);
				} 
				if (reply == JOptionPane.NO_OPTION) {
					super.windowClosing(e);
				} 
				} else {
					super.windowClosing(e);
				}
			}
		});

		// 3) Menus
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		// file menu
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		JMenuItem loadMI = new JMenuItem("Load");
		fileMenu.add(loadMI);
		JMenuItem saveMI = new JMenuItem("Save");
		fileMenu.add(saveMI);
		fileMenu.addSeparator();
		JMenuItem exitMenu = new JMenuItem("Exit");
		fileMenu.add(exitMenu);
		// edit menu
		JMenu editMenu = new JMenu("Edit");
		menuBar.add(editMenu);
		JMenuItem incrMI = new JMenuItem("Incr");
		editMenu.add(incrMI);
		JMenuItem decrMI = new JMenuItem("Decr");
		editMenu.add(decrMI);
		JMenuItem resetMI = new JMenuItem("Reset");
		editMenu.add(resetMI);
		JMenuItem setMI = new JMenuItem("Set");
		editMenu.add(setMI);

		// 4) Creation of hierarchy of components and layouting
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());

		JPanel topPanel = new JPanel();
		contentPane.add(topPanel, BorderLayout.NORTH);
		topPanel.setBorder(BorderFactory.createEtchedBorder());
		incrButton = new JButton("Incr");
		topPanel.add(incrButton);
		decrButton = new JButton("Decr");
		topPanel.add(decrButton);
		resetButton = new JButton("Reset");
		topPanel.add(resetButton);

		JPanel bottomPanel = new JPanel();
		contentPane.add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.setBorder(BorderFactory.createTitledBorder("Value"));
		bottomPanel.setLayout(new GridLayout(2, 2, 5, 5));
		bottomPanel.add(new JLabel("Value: "));
		valueLabel = new JLabel();
		valueLabel.setBorder(BorderFactory.createEtchedBorder());
		bottomPanel.add(valueLabel);
		bottomPanel.add(new JLabel("New value: "));
		newValueField = new JTextField(10);
		bottomPanel.add(newValueField);

		JPanel historyPanel = new JPanel();
		contentPane.add(historyPanel, BorderLayout.CENTER);
		historyPanel.setBorder(BorderFactory.createTitledBorder("History"));
		historyPanel.setLayout(new BorderLayout());
		historyListModel = new DefaultListModel<Integer>();
		historyList = new JList<Integer>(historyListModel);
		historyList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		historyPanel.add(new JScrollPane(historyList), BorderLayout.CENTER);

		// 6) Implementierung der ActionListener
		loadMI.addActionListener(loadHandler);
		saveMI.addActionListener(saveHandler);
		exitMenu.addActionListener(exitHandler);
		incrButton.addActionListener(incrHandler);
		incrMI.addActionListener(incrHandler);
		decrButton.addActionListener(decrHandler);
		decrMI.addActionListener(decrHandler);
		resetButton.addActionListener(resetHandler);
		resetMI.addActionListener(resetHandler);
		newValueField.addActionListener(newValueHandler);
		setMI.addActionListener(setValueHandler);
		historyList.getSelectionModel().addListSelectionListener(
				listSelectionHandler);

		// initialize view 
		updateViews();
	}
	
	/**
	 * Starts the application by opening the frame
	 */
	private void start() {
		// 1) show the frame
		frame.setLocation(100, 100);
		// frame.setSize(400, 280);
		frame.pack();
		frame.setVisible(true);
	}

	// 6) Implementation of ActionListeners

	/**
	 * Listener to laod events. 
	 */
	private ActionListener loadHandler = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			loadFromFile();
		}
	};

	/**
	 * Listener to save menu events. 
	 */
	private ActionListener saveHandler = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			saveToFile();
		}
	};

	/**
	 * Loads data from a file and updates the model and views. 
	 */
	private void loadFromFile() {
		// 7) Using JOptionPane and JFileChooser
		JFileChooser chooser = new JFileChooser(
				"C:\\Users\\hp\\Dropbox\\Lehre\\SW2_UE\\HP\\LVA_WS\\UE08_Muster");
		chooser.setFileFilter(new FileNameExtensionFilter("Value model files",
				"vm"));
		if (chooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
			try (BufferedReader reader = new BufferedReader(new FileReader(
					chooser.getSelectedFile()))) {
				historyListModel.clear();
				String line = reader.readLine();
				while (line != null) {
					try {
						int v = Integer.parseInt(line);
						model.setValue(v);
						updateViews();
					} catch (NumberFormatException e) {
					}
					line = reader.readLine();
				}
			} catch (Exception e) {
				// 7) Using JOptionPane and JFileChooser
				JOptionPane.showMessageDialog(frame, e.toString(),
						"File Load Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Saves the data to a file. 
	 */
	private boolean saveToFile() {
		// 7) Using JOptionPane and JFileChooser
		JFileChooser chooser = new JFileChooser(
				"C:\\Users\\hp\\Dropbox\\Lehre\\SW2_UE\\HP\\LVA_WS\\UE08_Muster");
		chooser.setFileFilter(new FileNameExtensionFilter("Value model files",
				"vm"));
		if (chooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			try (PrintWriter writer = new PrintWriter(file)) {
				for (int i = 0; i < historyListModel.size(); i++) {
					writer.println(historyListModel.get(i));
				}
				saved = true; 
				return true; 
			} catch (Exception e) {
				// 7) Using JOptionPane and JFileChooser
				JOptionPane.showMessageDialog(frame, e.toString(),
						"File Save Error", JOptionPane.ERROR_MESSAGE);
				return false; 
			}
		} else {
			return false;
		}
	}

	/**
	 * Listener to exit events. Asks if the data should be saved. 
	 */
	private ActionListener exitHandler = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (! saved) {
				// 7) Using JOptionPane 
				int reply = JOptionPane.showConfirmDialog(frame, "Save data", "Save data",
						JOptionPane.YES_NO_CANCEL_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					if (saveToFile()) {
						frame.dispose();
					}
				} 
				if (reply == JOptionPane.NO_OPTION) {
					frame.dispose();
				} 
			} else {
				frame.dispose();
			}
			// otherwise do nothing
		}
	};

	/**
	 * Listener to increment events. 
	 */
	private ActionListener incrHandler = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			model.incr();
			updateViews();
		}

	};

	/**
	 * Listener to decrement events. 
	 */
	private ActionListener decrHandler = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			model.decr();
			updateViews();
		}
	};

	/**
	 * Listener to reset events. 
	 */
	private ActionListener resetHandler = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			historyListModel.clear();
			model.reset();
			updateViews();
		}
	};

	/**
	 * Listener for menu item to set a value. Pops up a value dialog. 
	 */
	private ActionListener setValueHandler = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// 7) Using JOptionPane and JFileChooser
			Object o = JOptionPane.showInputDialog(frame, "Enter value",
					model.getValue());
			try {
				int val = Integer.parseInt((String) o);
				model.setValue(val);
				updateViews();
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(frame,
						"Wrong format for new value", frame.getTitle(),
						JOptionPane.ERROR_MESSAGE);
			}
		}
	};

	/**
	 * Listener to inputs in value field. 
	 */
	private ActionListener newValueHandler = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				int val = Integer.parseInt(newValueField.getText());
				model.setValue(val);
				updateViews();
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(frame,
						"Wrong format for new value", frame.getTitle(),
						JOptionPane.ERROR_MESSAGE);
			}
		}
	};

	/**
	 * Listener to list selection events. 
	 */
	private ListSelectionListener listSelectionHandler = new ListSelectionListener() {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			int i = historyList.getSelectedIndex();
			if (i >= 0 && i < historyListModel.size() - 1) {
				int value = historyListModel.get(i);
				historyListModel.removeRange(i, historyListModel.size() - 1);
				model.setValue(value);
				updateViews();
			}
		}
	};

	/**
	 * Updates all the view components the model value
	 */
	private void updateViews() {
		int value = model.getValue();
		saved = false; 
		valueLabel.setText(String.valueOf(value));
		newValueField.setText(String.valueOf(value));
		historyListModel.addElement(value);
		// scroll to bottom of list
		int lastIndex = historyList.getModel().getSize() - 1;
		if (lastIndex >= 0) {
			historyList.ensureIndexIsVisible(lastIndex);
		}
	}

	/**
	 * Creates the model, the application and starts the application
	 * @param args
	 */
	public static void main(String[] args) {
		ValueApp app = new ValueApp(new ValueModel());
		app.start(); 
	}
}
