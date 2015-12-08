package minesweeper.model;

public class EmptyCell implements Cell{
    private final Point position;

    public EmptyCell(Point position) {
        this.position = position;
    }
    
    
    @Override
    public String toString() {
        return " ";
    }

    @Override
    public Point getPosition() {
        return this.position;
    }
}
