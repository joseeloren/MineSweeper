package minesweeper.view;

import minesweeper.model.Cell;
import minesweeper.model.EmptyCell;
import minesweeper.model.MineCell;
import minesweeper.model.NumberedCell;

public class CellFactory {
    public static Cell createCell(String cellType) {
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
        CellTypePair[] cells = {new CellTypePair("Mine",new MineCell()),
            new CellTypePair("Number",new NumberedCell()),
            new CellTypePair("Empty",new EmptyCell())};
        for (CellTypePair cell : cells) 
            if (cell.getCellType().equals(cellType))
                return cell.getCell();
        return null;
    }
}
