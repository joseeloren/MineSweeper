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
       class CellTypePair {
            private final String cellType;
            private Cell cell;

            public CellTypePair(String cellType, Cell cell) {
                this.cellType = cellType;
                this.cell = cell;
            }

            public Cell getCell() {
                return cell;
            }

            public String getCellType() {
                return cellType;
            }
        }
        CellTypePair[] cells = {new CellTypePair("Mine",new MineCell(position)),
            new CellTypePair("Number",new NumberedCell(position, number)),
            new CellTypePair("Empty",new EmptyCell(position))};
        for (CellTypePair cell : cells) 
            if (cell.getCellType().equals(cellType))
                return cell.getCell();
        return null;
    }
}
