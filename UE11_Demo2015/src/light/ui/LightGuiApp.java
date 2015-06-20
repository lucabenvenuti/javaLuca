package light.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import light.model.ChangeEvent;
import light.model.ChangeListener;
import light.model.LightModel;

public class LightGuiApp {

	private final LightModel model;

	private JFrame frame;
	private JLabel stateLabel;

	private ChangeListener changedListener = new ChangeListener() {
		@SuppressWarnings("synthetic-access")
		@Override
		public void stateChanged(ChangeEvent e) {
			if (e.getSource() instanceof LightModel) {
				stateLabel.setText(((LightModel)e.getSource()).getLight().name());
			} else {
				throw new RuntimeException();
			}
		}
	};

	private ActionListener exitListener = new ActionListener() {
		@SuppressWarnings("synthetic-access")
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		}
	};

	private LightGuiApp(LightModel model) {
		this.model = model;
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

		LightView view = new LightView(model);
		topPanel.add(view, BorderLayout.CENTER);

		stateLabel = new JLabel(model.getLight().name());
		topPanel.add(stateLabel, BorderLayout.SOUTH);
		model.addChangeListener(changedListener);

		frame.setLocation(100, 100);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		LightGuiApp app = new LightGuiApp(new LightModel());
		app.start();
	}
}
