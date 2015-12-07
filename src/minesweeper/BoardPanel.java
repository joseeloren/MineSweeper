package minesweeper;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import minesweeper.model.Board;
import minesweeper.model.Cell;
import minesweeper.view.BoardBuilder;
import minesweeper.view.BoardDisplay;
import minesweeper.view.ObservableCellDisplay;

public class BoardPanel extends JPanel implements BoardDisplay{
    private Board board;
    private Frame father;

    public BoardPanel(Frame father) {
        this.father = father;
        this.board = BoardBuilder.generateBoard(new Dimension(15, 15), 30);
        this.setLayout(new GridLayout(15, 15));
        addCellsToPanel();
    }

    private void addCellsToPanel() {
        for (Cell[] cellRow : board.getCells()) 
            for (Cell cell : cellRow) 
                this.add(new CellPanel(cell, father));
    }

    @Override
    public Board board() {
        return board;
    }

    @Override
    public void show(Board board) {
    }
}
