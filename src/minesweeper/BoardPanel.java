package minesweeper;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import minesweeper.model.Cell;
import minesweeper.model.EmptyCell;
import minesweeper.model.MineCell;
import minesweeper.model.Point;
import minesweeper.view.BoardBuilder;
import minesweeper.view.ObservableCell;



public class BoardPanel extends JPanel {
    private int rows = 15;
    private int cols = 15; 

    public BoardPanel(JFrame parent) {
        this.setLayout(new GridLayout(15, 15));
        addCellsToPanel();
    }

    private void addCellsToPanel() {
        Cell[][] cells = BoardBuilder.generateBoard(new Point(rows, cols), 30);
        for (int i = 0; i < cells.length; i++) 
            for (int j = 0; j < cells[i].length; j++) 
                this.add(new CellPanel(cells[i][j]));
    }
    
    public void refreshAllCells(ObservableCell cell){
        refreshAllCells(cell.get().getPosition());
    }
    
    private void refreshAllCells(Point point) {
        CellPanel cellPanel = (CellPanel) this.getComponent(point.getRow() * 15 + point.getCol());
        Point size = cellPanel.get().getPosition();
        if (cellPanel.isHidden()) {
            cellPanel.showCell();
            if (cellPanel.get() instanceof EmptyCell) {
                for (int i = Math.max(0,point.getRow()-1) ;i<Math.min(point.getRow()+2, rows);i++) 
                    for (int j=Math.max(0,point.getCol()-1);j<Math.min(point.getCol()+2,cols);j++) { 
                        CellPanel cp = (CellPanel) this.getComponent(i * 15 + j);
                        if (!(cp.get() instanceof MineCell)) 
                            refreshAllCells(new Point(i,j));
                    }
            }
        }
        
    }
}
