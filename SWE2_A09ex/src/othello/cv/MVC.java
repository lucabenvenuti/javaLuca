package othello.cv;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MVC {

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


	public static void main(String[] args) {
		MVC app = new MVC(new ValueModel());
		app.start();
	}
}
