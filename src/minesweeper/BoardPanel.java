package minesweeper;

import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;
import minesweeper.control.Command;
import minesweeper.control.NewGameCommand;
import minesweeper.model.Cell;
import minesweeper.model.EmptyCell;
import minesweeper.model.MineCell;
import minesweeper.model.Point;
import minesweeper.view.BoardBuilder;
import minesweeper.view.BoardDisplay;
import minesweeper.view.SettingsDialog;

public class BoardPanel extends JPanel implements BoardDisplay{
    private Map<String, Command> commands = new HashMap<>();
    private int rows, cols, mines;
    private SettingsDialog settingsDialog;
    private JFrame parent;
    private int unclickedCellsCounter;

    public BoardPanel(JFrame parent, SettingsDialog settingsDialog) {
        this.settingsDialog = settingsDialog;
        this.parent = parent;
        addCellsToPanel();
        createCommands();
    }
    private void createCommands() {
        commands.put("New Game", new NewGameCommand(this));
    }

    private void addCellsToPanel() {
        this.rows = this.settingsDialog.getRows();
        this.cols = this.settingsDialog.getCols();
        this.mines = this.settingsDialog.getMines();
        this.unclickedCellsCounter = rows*cols;
        this.setLayout(new GridLayout(rows, cols));
        Cell[][] cells = BoardBuilder.generateBoard(new Point(rows, cols), mines);
        for (int i = 0; i < cells.length; i++) 
            for (int j = 0; j < cells[i].length; j++) 
                this.add(new CellPanel(cells[i][j],this));
    }
    
    public void refreshAllCells(CellPanel cellPanel){
        int cellRow = cellPanel.get().getPosition().getRow();
        int cellCol = cellPanel.get().getPosition().getCol();
        if (cellPanel.isHidden()) {
            decreaseUnClickedCells();
            cellPanel.display();
            if (cellPanel.get() instanceof EmptyCell) {
                for (int i = Math.max(0,cellRow-1) ;i<Math.min(cellRow+2, rows);i++) 
                    for (int j=Math.max(0,cellCol-1);j<Math.min(cellCol+2,cols);j++) { 
                        CellPanel cp = (CellPanel) this.getComponent(i * this.cols + j);
                        if (!(cp.get() instanceof MineCell)) 
                            refreshAllCells(cp);
                    }
            }
        }
    }

    @Override
    public void display() {
        this.invalidate();
        this.removeAll();
        addCellsToPanel();
        repaint();
        this.validate();
    }
    
    public void decreaseUnClickedCells() {
        this.unclickedCellsCounter--;
    }

    public int getUnclickedCellsCounter() {
        return unclickedCellsCounter;
    }
    
    @Override
    public JFrame getParent() {
        return this.parent;
    }

    void showAll() {
        for(int i =0;i<rows*cols;i++) 
            ((CellPanel) this.getComponent(i)).display();
    }

    int getMines() {
        return this.mines;
    }
}

