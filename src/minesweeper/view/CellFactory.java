package minesweeper.view;

import minesweeper.model.Cell;
import minesweeper.model.EmptyCell;
import minesweeper.model.MineCell;
import minesweeper.model.NumberedCell;
import minesweeper.model.Point;

public class CellFactory {
    public static Cell createCell(String cellType, Point position) {
       return createCell(cellType, position, 0);
    }
    
    public static Cell createCell(String cellType, Point position, int number) {
        switch (cellType) {
            case "Mine":
                return new MineCell(position);
            case "Number":
                return new NumberedCell(position, number);
            case "Empty":
                return new EmptyCell(position);
            default:
                return null;
        }
    }
}
