package minesweeper.model;

public class UnFlagedCell implements UnclickedCell{

    @Override
    public Point getPosition() {
        return new Point(0,0);
    }
    
}
