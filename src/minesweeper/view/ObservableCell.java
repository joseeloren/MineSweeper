package minesweeper.view;

import minesweeper.model.Cell;

public class ObservableCell extends Observable implements CellDisplay, CellDialog{
    private Cell cell;

    public ObservableCell(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void show(Cell cell) {
        
    }

    @Override
    public Cell get() {
        return cell;
    }
}
