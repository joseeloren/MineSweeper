package minesweeper.control;

import minesweeper.model.Cell;
import minesweeper.view.CellDisplay;

public class CellClickedCommand implements Command{
    private CellDisplay cellDisplay;

    public CellClickedCommand(CellDisplay cellDisplay) {
        this.cellDisplay = cellDisplay;
    }

    @Override
    public void execute() {
        cellDisplay.display();
    }
}
