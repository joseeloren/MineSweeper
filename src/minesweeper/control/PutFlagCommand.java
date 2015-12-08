package minesweeper.control;

import minesweeper.view.CellDisplay;

public class PutFlagCommand implements Command{
    private final CellDisplay cellDisplay;

    public PutFlagCommand(CellDisplay cellDisplay) {
        this.cellDisplay = cellDisplay;
    }

    public void execute() {
        
    }
}
