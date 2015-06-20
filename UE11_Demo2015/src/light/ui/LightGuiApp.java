package light.ui;

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

import light.controller.LightController;
import light.model.ChangeEvent;
import light.model.ChangeListener;
import light.model.LightModel;

public class LightGuiApp {

	private final LightModel model;
	private final LightView view;

	private JFrame frame;
	private JLabel stateLabel;

	private ChangeListener changedListener = new ChangeListener() {
		@SuppressWarnings("synthetic-access")
		@Override
		public void stateChanged(ChangeEvent e) {
			stateLabel.setText(e.getSource().toString()); // ??
		}
	};

	private ActionListener exitListener = new ActionListener() {
		@SuppressWarnings("synthetic-access")
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		}
	};

	private LightGuiApp(LightModel model, LightView view) {
		this.model = model;
		this.view = view;
	}

	private void start() {
		frame = new JFrame("Light");

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(exitListener);
		fileMenu.add(exitMenuItem);

		frame.setJMenuBar(menuBar);

		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());

		JPanel topPanel = new JPanel();
		contentPane.add(topPanel, BorderLayout.NORTH);
		topPanel.setBorder(BorderFactory.createEtchedBorder());

		contentPane.add(view, BorderLayout.WEST);

		model.addChangeListener(changedListener);

		frame.setLocation(100, 100);
		frame.pack();
		frame.setVisible(true);
		// model.play();
	}

	public static void main(String[] args) {
		LightView view = new LightView();
		LightModel model = new LightModel();// view);
		LightController controller = new LightController(model);
		view.initialize(controller);
		LightGuiApp app = new LightGuiApp(model, view);
		app.start();
	}
}
