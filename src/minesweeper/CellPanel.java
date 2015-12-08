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
import minesweeper.control.CellClickedCommand;
import minesweeper.model.Cell;
import minesweeper.model.MineCell;
import minesweeper.view.CellDialog;
import minesweeper.view.ObservableCell;
import minesweeper.view.Observer;

public class CellPanel extends JPanel implements CellDialog, Observer {
    private ObservableCell observableCell;
    private CellClickedCommand cellClickedCommand;
    private JLabel label;
    private BoardPanel parent;
    private boolean hidden = true;
    
    public CellPanel(Cell cell, BoardPanel parent) {
        this.parent = parent;
        this.observableCell = new ObservableCell(cell);
        deployUI();
        createCommands();
    }
    
    private void deployUI() {
        this.setBackground(Color.blue);
        this.setLayout(new BorderLayout());
        this.label = new JLabel();
        add(label, BorderLayout.CENTER);
        label.setHorizontalAlignment(JTextField.CENTER);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        label.addMouseListener(doCommand());
    }
    
    private void createCommands() {
        this.cellClickedCommand = new CellClickedCommand(observableCell);
    }
    
    public void showCell() {
        label.setText(observableCell.get().toString());
        setBackground(Color.white);
        hidden = false;
    }

    public boolean isHidden() {
        return hidden;
    }
    

    private MouseListener doCommand() {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isHidden()) {
                    parent.refreshAllCells(observableCell);
                    if (observableCell.get() instanceof MineCell) {
                        int response = JOptionPane.showConfirmDialog(null, "!Perdiste!. ¿Quieres volver a jugar?", "Perdiste", JOptionPane.YES_NO_OPTION);
                        if (response == JOptionPane.YES_OPTION) {
                            new Application().setVisible(true);
                            parent.getParent().dispose();
                        }
                        else if (response == JOptionPane.NO_OPTION)
                            System.exit(0);
                    } else {
                        cellClickedCommand.execute();
                    }
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
        return this.observableCell.get();
    }

    @Override
    public void changed() {
        
    }

    public ObservableCell getObservableCell() {
        return observableCell;
    }

    public CellClickedCommand getCellClickedCommand() {
        return cellClickedCommand;
    }

    public JLabel getLabel() {
        return label;
    }

    public BoardPanel getParent() {
        return parent;
    }


}
