package minesweeper;

import java.awt.*;
import javax.swing.*;
import minesweeper.control.Command;
import minesweeper.control.NewGameCommand;

public class Application extends JFrame {
    private Command newGameCommand;
    private BoardPanel boardPanel;
    
    public static void main(String[] args) {
        new Application().setVisible(true);
    }
    
    public Application() throws HeadlessException {
        this.deployUI();
        this.createCommand();
    }
    
    private void createCommand() {
        this.newGameCommand = new NewGameCommand(this.boardPanel);
    }

    private void deployUI() {
        this.setTitle("MineSweeper");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setSize(new Dimension(500, 500));
        this.getContentPane().add(board());
        this.setLocationRelativeTo(null);
    }
    
    private JPanel board() {
        this.boardPanel = new BoardPanel(this);
        return boardPanel;
    }
}