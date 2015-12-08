package minesweeper.control;

import minesweeper.view.ObservableCell;

public class CellClickedCommand implements Command{
    private ObservableCell observableCell;

    public CellClickedCommand(ObservableCell observableCell) {
        this.observableCell = observableCell;
    }
     
    @Override
    public void execute() {
    }
}
