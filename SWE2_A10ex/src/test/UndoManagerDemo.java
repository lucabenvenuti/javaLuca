package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.UndoableEditEvent;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoManager;

public class UndoManagerDemo extends JFrame {
  protected Vector pointVector = new Vector();

  protected PaintCanvas canvas = new PaintCanvas(pointVector);

  protected UndoManager undoManager = new UndoManager();

  protected JButton undoButton = new JButton("Undo");

  protected JButton redoButton = new JButton("Redo");

  public UndoManagerDemo() {
    super("Undo/Redo Demo");

    undoButton.setEnabled(false);
    redoButton.setEnabled(false);

    JPanel buttonPanel = new JPanel(new GridLayout());
    buttonPanel.add(undoButton);
    buttonPanel.add(redoButton);

    getContentPane().add(buttonPanel, BorderLayout.NORTH);
    getContentPane().add(canvas, BorderLayout.CENTER);

    canvas.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        Point point = new Point(e.getX(), e.getY());
        pointVector.addElement(point);

        undoManager.undoableEditHappened(new UndoableEditEvent(
            canvas, new UndoablePaintSquare(point, pointVector)));

        undoButton.setText(undoManager.getUndoPresentationName());
        redoButton.setText(undoManager.getRedoPresentationName());
        undoButton.setEnabled(undoManager.canUndo());
        redoButton.setEnabled(undoManager.canRedo());
        canvas.repaint();
      }
    });

    undoButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          undoManager.undo();
        } catch (CannotRedoException cre) {
          cre.printStackTrace();
        }
        canvas.repaint();
        undoButton.setEnabled(undoManager.canUndo());
        redoButton.setEnabled(undoManager.canRedo());
      }
    });

    redoButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          undoManager.redo();
        } catch (CannotRedoException cre) {
          cre.printStackTrace();
        }
        canvas.repaint();
        undoButton.setEnabled(undoManager.canUndo());
        redoButton.setEnabled(undoManager.canRedo());
      }
    });

    setSize(400, 300);
    setVisible(true);
  }

  public static void main(String argv[]) {
    new UndoManagerDemo();
  }
  class PaintCanvas extends JPanel {
    private Vector points;

    protected int width = 50;

    protected int height = 50;

    public PaintCanvas(Vector v) {
      super();
      points = v;
      setOpaque(true);
      setBackground(Color.white);
    }

    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.setColor(Color.black);
      
      for(int i=0;i<points.size();i++){
        Point point = (Point) points.get(i);
        g.drawRect(point.x, point.y, width, height);
      }
    }
  }

  class UndoablePaintSquare extends AbstractUndoableEdit {
    protected Vector points;

    protected Point point;

    public UndoablePaintSquare(Point p, Vector v) {
      points = v;
      point = p;
    }

    public String getPresentationName() {
      return "Square Addition";
    }

    public void undo() {
      super.undo();
      points.remove(point);
    }

    public void redo() {
      super.redo();
      points.add(point);
    }
  }
}