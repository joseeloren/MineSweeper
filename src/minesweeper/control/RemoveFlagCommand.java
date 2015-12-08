package minesweeper.control;

import minesweeper.view.CellDisplay;

public class RemoveFlagCommand implements Command{
    private final CellDisplay cellDisplay;

    public RemoveFlagCommand(CellDisplay cellDisplay) {
        this.cellDisplay = cellDisplay;
    }
    
    @Override
    public void execute() {
        
    }
}
