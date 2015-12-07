package minesweeper;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import minesweeper.model.Cell;
import minesweeper.model.MineCell;
import minesweeper.view.CellDialog;
import minesweeper.view.ObservableCellDisplay;
import minesweeper.view.Observer;

public class CellPanel extends JPanel implements CellDialog, Observer{
    private ObservableCellDisplay observableCell;
    private JLabel label;
    private Frame father;
    
    public CellPanel(Cell cell, Frame father) {
        this.father = father;
        this.observableCell = new ObservableCellDisplay(cell);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.blue);
        this.label = new JLabel();
        add(label, BorderLayout.CENTER);
        label.setHorizontalAlignment(JTextField.CENTER);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        label.addMouseListener(doCommand());
    }

    private MouseListener doCommand() {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label.setText(observableCell.getCell().toString());
                setBackground(Color.white);
                if (observableCell.getCell() instanceof MineCell) {
                    int response = JOptionPane.showConfirmDialog(father, "!Perdiste!. ¿Quieres volver a jugar?", "Perdiste", JOptionPane.YES_NO_OPTION);
                    if (response == JOptionPane.YES_OPTION)
                        father.newGame();
                    else if (response == JOptionPane.NO_OPTION)
                        System.exit(0);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
    }    

    @Override
    public Cell get() {
        return null;
    }

    @Override
    public void changed() {
        
    }
}
