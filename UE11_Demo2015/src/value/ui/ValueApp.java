package value.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
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
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import value.cmd.CmdProcessor;
import value.cmd.DecrCmd;
import value.cmd.IncrCmd;
import value.cmd.SetValueCmd;
import value.model.ValueChangeEvent;
import value.model.ValueChangeListener;
import value.model.ValueModel;

public class ValueApp {

	private JFrame frame;

	private ValueModel model;

	private JLabel valueLabel;
	private JButton incrButton, decrButton, resetButton;
	private JTextField newValueField;
	private DefaultListModel<Integer> historyListModel;
	private JList<Integer> historyList;

	private GraphView graphView;

	ValueApp(ValueModel model) {
		this.model = model;
	}

	public void start() {
		frame = new JFrame("Value");

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		JMenuItem exitMenu = new JMenuItem("Exit");
		fileMenu.add(exitMenu);
		frame.setJMenuBar(menuBar);
		
		JMenu editMenu = new JMenu("Edit");
		menuBar.add(editMenu);
		JMenuItem undoMI = new JMenuItem(undoAction);
		editMenu.add(undoMI);
		JMenuItem redoMI = new JMenuItem(redoAction);
		editMenu.add(redoMI);
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

		graphView = new GraphView(model);
		contentPane.add(graphView, BorderLayout.WEST);

		model.addValueChangeListener(modelChangedHandler);
		model.reset();

		exitMenu.addActionListener(exitHandler);
		incrButton.addActionListener(incrHandler);
		decrButton.addActionListener(decrHandler);
		resetButton.addActionListener(resetHandler);
		newValueField.addActionListener(newValueHandler);
		historyList.getSelectionModel().addListSelectionListener(
				listSelectionHandler);

		frame.setLocation(100, 100);
		frame.pack();
		frame.setVisible(true);
	}

	private ValueChangeListener modelChangedHandler = new ValueChangeListener() {
		@Override
		public void valueChanged(ValueChangeEvent e) {
			// reset history list and command processor when model reset 
			if (e.getChange() == ValueChangeEvent.ChangeType.Reset) {
				historyListModel.clear();
				CmdProcessor.getInstance().reset(); 
			}
			valueLabel.setText(Integer.toString(e.getValue()));
			historyListModel.addElement(e.getValue());
			historyList.setSelectedIndex(historyListModel.size() - 1);
			historyList.ensureIndexIsVisible(historyListModel.size() - 1);
		}
	};

	private ActionListener exitHandler = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		}
	};

	private ActionListener incrHandler = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			//model.incr();
			CmdProcessor.getInstance().doCmd(new IncrCmd(model));
		}

	};

	private ActionListener decrHandler = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			//model.decr();
			CmdProcessor.getInstance().doCmd(new DecrCmd(model));
		}
	};

	private ActionListener resetHandler = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// reset model directly without using command processor because reset cannot be undone!!
			model.reset();
		}
	};

	private ActionListener newValueHandler = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				int value = Integer.parseInt(newValueField.getText());
				//model.setValue(value);
				CmdProcessor.getInstance().doCmd(new SetValueCmd(model, value));
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(frame,
						"Wrong format for new value", frame.getTitle(),
						JOptionPane.ERROR_MESSAGE);
			}
		}
	};

	private ListSelectionListener listSelectionHandler = new ListSelectionListener() {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			int i = historyList.getSelectedIndex();
			if (i >= 0 && i < historyListModel.size() - 1) {
				int value = historyListModel.get(i);
				historyListModel.removeRange(i, historyListModel.size() - 1);
				//model.setValue(value);
				CmdProcessor.getInstance().doCmd(new SetValueCmd(model, value));
			}
		}
	};
	
	@SuppressWarnings("serial")
	private Action undoAction = new AbstractAction("Undo") {

		{
			putValue(Action.ACCELERATOR_KEY,
					KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_MASK));
			putValue(Action.SHORT_DESCRIPTION, "Undo last operation");
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			CmdProcessor.getInstance().undoCmd();
		}
		
	};

	@SuppressWarnings("serial")
	private Action redoAction = new AbstractAction("Redo") {

		{
			putValue(Action.ACCELERATOR_KEY,
					KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_MASK));
			putValue(Action.SHORT_DESCRIPTION, "Redo last undone operation");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			CmdProcessor.getInstance().redoCmd();
		}
		
	};

	// main

	public static void main(String[] args) {
		ValueApp app = new ValueApp(new ValueModel());
		app.start();
	}
}
