package othello.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;

import othello.Pos;
import othello.controller.OthelloController;
import othello.model.OthelloModel;
import othello.model.PosChangeEvent;
import othello.model.PosChangeListener;
import othello.model.StateChangeEvent;
import othello.model.StateChangeListener;

/**
 * OthelloGuiApp.java
 *
 * A {@link OthelloGuiApp} is a public class. It creates a GUI app to play
 * Othello. It uses a MVC architecture, together with JFrame and JLabel, and
 * JList for the history.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author TAs & Luca Benvenuti
 */
public class OthelloGuiApp {

	private final OthelloModel model;
	private final OthelloView view;

	private JFrame frame;
	private JLabel stateLabel;
	private DefaultListModel<String> historyListModel;
	private JList<String> historyList;

	private PosChangeListener posChangedListener = new PosChangeListener() {
		@SuppressWarnings("synthetic-access")
		@Override
		public void posChanged(PosChangeEvent e) {
			Pos pos = e.getPos();
			if (pos == null) {
				historyListModel.addElement("No valid move for "
						+ e.getPlayer());
			} else {
				historyListModel.addElement(e.getPlayer().getName() + " on "
						+ pos);
			}
			historyList.setSelectedIndex(historyListModel.size() - 1);
			historyList.ensureIndexIsVisible(historyListModel.size() - 1);
		}
	};

	private StateChangeListener stateChangedListener = new StateChangeListener() {
		@SuppressWarnings("synthetic-access")
		@Override
		public void stateChanged(StateChangeEvent e) {
			stateLabel.setText(e.getState().toString());
		}
	};

	private ActionListener exitListener = new ActionListener() {
		@SuppressWarnings("synthetic-access")
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		}
	};

	private ActionListener resetListener = new ActionListener() {
		@SuppressWarnings("synthetic-access")
		@Override
		public void actionPerformed(ActionEvent e) {
			historyListModel.clear();
			model.reset();
		}
	};

	private OthelloGuiApp(OthelloModel model, OthelloView view) {
		this.model = model;
		this.view = view;
	}

	private void start() {
		frame = new JFrame("Othello");

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		JMenu gameMenu = new JMenu("Game");
		menuBar.add(gameMenu);
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(exitListener);
		fileMenu.add(exitMenuItem);
		JMenuItem resetMenuItem = new JMenuItem("Reset");
		resetMenuItem.addActionListener(resetListener);
		gameMenu.add(resetMenuItem);

		frame.setJMenuBar(menuBar);

		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());

		JPanel topPanel = new JPanel();
		contentPane.add(topPanel, BorderLayout.NORTH);
		topPanel.setBorder(BorderFactory.createEtchedBorder());

		JPanel bottomPanel = new JPanel();
		contentPane.add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.setBorder(BorderFactory.createTitledBorder("State:"));
		bottomPanel.setLayout(new GridLayout(1, 1, 5, 5));
		stateLabel = new JLabel("State is: "
				+ model.getInitalGameState().toString());
		stateLabel.setBorder(BorderFactory.createEtchedBorder());
		bottomPanel.add(stateLabel);

		JPanel historyPanel = new JPanel();
		contentPane.add(historyPanel, BorderLayout.CENTER);
		historyPanel.setBorder(BorderFactory.createTitledBorder("History"));
		historyPanel.setLayout(new BorderLayout());
		historyListModel = new DefaultListModel<String>();
		historyList = new JList<String>(historyListModel);
		historyList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		historyPanel.add(new JScrollPane(historyList), BorderLayout.CENTER);

		contentPane.add(view, BorderLayout.WEST);

		model.addListener(posChangedListener);
		model.addListener(stateChangedListener);

		frame.setLocation(100, 100);
		frame.pack();
		frame.setVisible(true);
		model.play();
	}

	public static void main(String[] args) {
		OthelloView view = new OthelloView();
		OthelloModel model = new OthelloModel(view);
		OthelloController controller = new OthelloController(model);
		view.initialize(controller);
		OthelloGuiApp app = new OthelloGuiApp(model, view);
		app.start();
	}
}
