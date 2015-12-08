package minesweeper.view;

import minesweeper.model.Board;
import minesweeper.model.Cell;
import minesweeper.model.EmptyCell;
import minesweeper.model.MineCell;
import minesweeper.model.NumberedCell;
import minesweeper.model.Point;

public class BoardBuilder {
    public static Board generateBoard(Point size, int numberOfBombs) {
        Cell[][] cells = new Cell[size.getRow()][size.getCol()];
        for (int i=0;i<cells.length;i++)
            for (int j=0;j<cells[i].length;j++) 
                cells[i][j] = CellFactory.createCell("Empty", new Point(i, j));
        return putMines(new Board(cells),numberOfBombs);
    }
    
    public static Board putMines(Board board, int numberOfBombs) {
        Cell[][] cells = board.getCells();
        while (numberOfBombs != 0) {
            int ramdomRow = (int) (Math.random()*cells.length);
            int ramdomCol = (int) (Math.random()*cells[0].length);
            if (cells[ramdomRow][ramdomCol] instanceof EmptyCell) {
                cells[ramdomRow][ramdomCol] = CellFactory.createCell("Mine", new Point(ramdomRow, ramdomCol));
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
                    putNumbersArroundMine(cells, new Point(i, j));
        return new Board(cells);
    }

    private  static Cell[][] putNumbersArroundMine(Cell[][] cells, Point size) {        
        for (int i = size.getRow()-1;i<=size.getRow()+1;i++) 
            for (int j=size.getCol()-1;j<=size.getCol()+1;j++) {
                try {
                if (cells[i][j] instanceof EmptyCell) 
                    cells[i][j] = CellFactory.createCell("Number", new Point(i,j), 1);
                else if (cells[i][j] instanceof NumberedCell) 
                    cells[i][j] = CellFactory.createCell("Number", new Point(i,j), ((NumberedCell)cells[i][j]).getNumberOfMines()+1);
                } catch (Exception e) {}
            }
        return cells;
    }
}
