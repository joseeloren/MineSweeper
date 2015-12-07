package minesweeper.view;

import minesweeper.model.Board;

public interface BoardDisplay {
    Board board();
    
    void show (Board board);
}
