package minesweeper.model;

public class MineCell implements Cell{
    private final Point position;

    public MineCell(Point position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "M";
    }

    @Override
    public Point getPosition() {
        return this.position;
    }
}    
