package minesweeper.model;

public class NumberedCell implements Cell{
    private final Point position;
    private final int numberOfMines;

    public NumberedCell(Point position, int numberOfMines) {
        this.position = position;
        this.numberOfMines = numberOfMines;
    }

    public int getNumberOfMines() {
        return numberOfMines;
    }

    @Override
    public String toString() {
        return Integer.toString(numberOfMines);
    }

    @Override
    public Point getPosition() {
        return this.position;
    }
}
