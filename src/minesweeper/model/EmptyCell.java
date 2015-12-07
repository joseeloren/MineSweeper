package minesweeper.model;

public class EmptyCell implements Cell{
    public EmptyCell() {
    }    

    @Override
    public String toString() {
        return " ";
    }
}
