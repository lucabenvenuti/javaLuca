package othello.cv;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import value.model.ValueChangeEvent;
import value.model.ValueChangeListener;
import value.model.ValueModel;

public class Controller {

	private JFrame frame;

	private ValueModel model;

	private JLabel valueLabel;
	private JButton incrButton, decrButton, resetButton;
	private JTextField newValueField;
	private DefaultListModel<Integer> historyListModel;
	private JList<Integer> historyList;

	private GraphView graphView;

	private BinaryView binaryView;

	Controller(ValueModel model) {
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

		binaryView = new BinaryView(model);
		contentPane.add(binaryView, BorderLayout.EAST);

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
			model.incr();
		}

	};

	private ActionListener decrHandler = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			model.decr();
		}
	};

	private ActionListener resetHandler = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			historyListModel.clear();
			model.reset();
		}
	};

	private ActionListener newValueHandler = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				int val = Integer.parseInt(newValueField.getText());
				model.setValue(val);
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
				model.setValue(value);
			}
		}
	};

}
