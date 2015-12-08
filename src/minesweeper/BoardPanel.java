package minesweeper;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import minesweeper.model.Cell;
import minesweeper.model.EmptyCell;
import minesweeper.model.MineCell;
import minesweeper.model.Point;
import minesweeper.view.BoardBuilder;
import minesweeper.view.BoardDisplay;
import minesweeper.view.ObservableCell;

public class BoardPanel extends JPanel implements BoardDisplay{
    private Cell[][] board;
    private JFrame parent;
    private CellPanel[][] cellPanels;

    public BoardPanel(JFrame parent) {
        this.parent = parent;
        this.board = BoardBuilder.generateBoard(new Point(15, 15), 30);
        this.setLayout(new GridLayout(15, 15));
        this.cellPanels = new CellPanel[15][15];
        addCellsToPanel();
    }

    private void addCellsToPanel() {
        Cell[][] cells = board.getCells();
        for (int i = 0; i < cellPanels.length; i++) {
            for (int j = 0; j < cellPanels[i].length; j++) {
                CellPanel cellPanel = new CellPanel(cells[i][j],this);
                this.add(cellPanel);
                cellPanels[i][j] = cellPanel;
            }
        }
    }

    public JFrame getParent() {
        return parent;
    }

    
    public void refreshAllCells(ObservableCell cell){
        Point p = cell.get().getPosition();
        int row = p.getRow();
        int col = p.getCol();
        Cell[][] cells  = board.getCells();
        refreshAllCells(cellPanels[row][col], cellPanels);
    }
    
    public void refreshAllCells(CellPanel cellPanel, CellPanel[][] cells) {
        Point size = cellPanel.get().getPosition();
        if (cellPanel.isHidden()) {
            cellPanel.showCell();
            if (cellPanel.get() instanceof EmptyCell) {
                for (int i = Math.max(0,size.getRow()-1) ;i<Math.min(size.getRow()+2, cells.length);i++) 
                    for (int j=Math.max(0,size.getCol()-1);j<Math.min(size.getCol()+2,cells[i].length);j++) 
                        if (!(cells[i][j].get() instanceof MineCell)) 
                            refreshAllCells(cells[i][j], cells);
            }
        }
        
    }
}
