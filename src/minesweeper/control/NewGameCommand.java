package minesweeper.control;

import minesweeper.view.BoardDisplay;

public class NewGameCommand implements Command {
    private BoardDisplay boardDisplay;

    public NewGameCommand(BoardDisplay boardDisplay) {
        this.boardDisplay = boardDisplay;
    }
    
    @Override
    public void execute() {
        //this.boardDisplay = new BoardPanel(father);
    }
}