package minesweeper;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import minesweeper.model.Board;
import minesweeper.model.Cell;
import minesweeper.model.Point;
import minesweeper.view.BoardBuilder;
import minesweeper.view.BoardDisplay;

public class BoardPanel extends JPanel implements BoardDisplay{
    private Board board;
    private JFrame parent;

    public BoardPanel(JFrame parent) {
        this.parent = parent;
        this.board = BoardBuilder.generateBoard(new Point(15, 15), 30);
        this.setLayout(new GridLayout(15, 15));
        addCellsToPanel();
    }

    private void addCellsToPanel() {
        for (Cell[] cellRow : board.getCells()) 
            for (Cell cell : cellRow) 
                this.add(new CellPanel(cell,this));
    }

    @Override
    public Board board() {
        return board;
    }

    @Override
    public void show(Board board) {
        this.board = board;
        this.repaint();
    }

    public JFrame getParent() {
        return parent;
    }

}
