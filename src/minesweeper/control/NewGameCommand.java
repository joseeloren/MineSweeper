package minesweeper.control;

import minesweeper.BoardPanel;
import minesweeper.Frame;
import minesweeper.view.BoardDisplay;

public class NewGameCommand implements Command {
    private BoardDisplay boardDisplay;

    public NewGameCommand(BoardDisplay boardDisplay, Frame father) {
        this.boardDisplay = boardDisplay;
    }
    
    @Override
    public void execute() {
        //this.boardDisplay = new BoardPanel(father);
    }

}