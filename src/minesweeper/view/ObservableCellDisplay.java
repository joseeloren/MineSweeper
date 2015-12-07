package minesweeper.view;

import minesweeper.model.Cell;

public class ObservableCellDisplay extends Observable implements CellDisplay{
    private Cell cell;

    public ObservableCellDisplay(Cell cell) {
        this.cell = cell;
    }

    public Cell getCell() {
        return cell;
    }
    
    @Override
    public void show(Cell cell) {
    }
}
