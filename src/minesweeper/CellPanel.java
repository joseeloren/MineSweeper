package minesweeper;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import minesweeper.control.CellClickedCommand;
import minesweeper.control.Command;
import minesweeper.control.NewGameCommand;
import minesweeper.model.Cell;
import minesweeper.model.MineCell;
import minesweeper.view.CellDialog;
import minesweeper.view.CellDisplay;

public class CellPanel extends JPanel implements CellDialog, CellDisplay {
    private Map<String, Command> commands = new HashMap<>();
    private CellClickedCommand cellClickedCommand;
    private JLabel label;
    private boolean hidden = true;
    private boolean flagged = false;
    private BoardPanel parent;
    private Cell cell;
    
    public CellPanel(Cell cell, BoardPanel boardPanel) {
        this.cell = cell;
        this.parent = boardPanel;
        deployUI();
        createCommands();
    }
    
    private void deployUI() {
        this.setBackground(Color.PINK);
        this.setLayout(new BorderLayout());
        this.label = new JLabel();
        add(label, BorderLayout.CENTER);
        label.setHorizontalAlignment(JTextField.CENTER);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        label.addMouseListener(doCommand("Cell Clicked"));
    }
    
    private void createCommands() {
        this.commands.put("Cell Clicked", new CellClickedCommand(this));
        this.commands.put("New Game", new NewGameCommand(parent));
    }

    public boolean isHidden() {
        return hidden;
    }
    

    private MouseListener doCommand(final String command) {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1 && isHidden()) {
                    parent.refreshAllCells(CellPanel.this);
                    if (cell instanceof MineCell) {
                        parent.showAll();
                        RetryDialog.retry(parent, "Lose", commands.get("New Game"));
                    } else {
                        if (parent.getUnclickedCellsCounter() == parent.getMines())
                            RetryDialog.retry(parent, "Win", commands.get("New Game"));
                    }
                } else if (e.getButton() == MouseEvent.BUTTON3 && isHidden()) {
                    putFlag();
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
        return this.cell;
    }

    @Override
    public void display() {
        label.setText(this.cell.toString());
        setBackground(Color.white);
        hidden = false;
    }
    
    public void putFlag() {
        label.setText((!label.getText().equals("F")) ? "F" : "");
    }
}
