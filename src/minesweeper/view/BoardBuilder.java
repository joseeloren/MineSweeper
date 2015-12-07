package minesweeper.view;

import java.awt.Dimension;
import minesweeper.model.Board;
import minesweeper.model.Cell;
import minesweeper.model.EmptyCell;
import minesweeper.model.MineCell;
import minesweeper.model.NumberedCell;

public class BoardBuilder {
    public static Board generateBoard(Dimension d, int numberOfBombs) {
        Cell[][] cells = new Cell[((int)d.getHeight())][((int)d.getWidth())];
        for (int i=0;i<cells.length;i++)
            for (int j=0;j<cells[i].length;j++) 
                cells[i][j] = CellFactory.createCell("Empty");
        return putMines(new Board(cells),numberOfBombs);
    }
    
    public static Board putMines(Board board, int numberOfBombs) {
        Cell[][] cells = board.getCells();
        while (numberOfBombs != 0) {
            int ramdomRow = (int) (Math.random()*cells.length);
            int ramdomCol = (int) (Math.random()*cells[0].length);
            if (cells[ramdomRow][ramdomCol] instanceof EmptyCell) {
                cells[ramdomRow][ramdomCol] = CellFactory.createCell("Mine");
                numberOfBombs--;
            }
        }
        return putNumbers(new Board(cells));
    }

    private static Board putNumbers(Board board) {
        Cell[][] cells = board.getCells();
        for (int i = 0; i < cells.length; i++) 
            for (int j = 0; j < cells[i].length; j++) 
                if (cells[i][j] instanceof MineCell)
                    putNumbersArroundMine(cells, new Dimension(i, j));
        return new Board(cells);
    }

    private  static Cell[][] putNumbersArroundMine(Cell[][] cells, Dimension dimension) {        
        for (int i = (int)dimension.getHeight()-1;i<=(int)dimension.getHeight()+1;i++) 
            for (int j=(int)dimension.getWidth()-1;j<=(int)dimension.getWidth()+1;j++) {
                try {
                if (cells[i][j] instanceof EmptyCell) 
                    cells[i][j] = CellFactory.createCell("Number");
                else if (cells[i][j] instanceof NumberedCell) 
                    cells[i][j] = new NumberedCell(((NumberedCell)cells[i][j]).getNumberOfMines()+1);
                } catch (Exception e) {}
            }
        return cells;
    }
}
