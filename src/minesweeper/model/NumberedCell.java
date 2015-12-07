package minesweeper.model;

public class NumberedCell implements Cell{
    private final int numberOfMines;

    public NumberedCell() {
        this(1);
    }
    
    public NumberedCell(int numberOfMines) {
        this.numberOfMines = numberOfMines;
    }

    public int getNumberOfMines() {
        return numberOfMines;
    }

    @Override
    public String toString() {
        return Integer.toString(numberOfMines);
    }
}
