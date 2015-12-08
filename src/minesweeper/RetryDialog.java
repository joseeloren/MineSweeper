package minesweeper;

import java.awt.Component;
import javax.swing.JOptionPane;
import minesweeper.control.Command;

public class RetryDialog {
    public static void retry(Component parent, String state, Command newGameCommand) {
        int response = JOptionPane.showConfirmDialog(parent,"You "+state+"! Play Again?", state, JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) 
            newGameCommand.execute();
        else if (response == JOptionPane.NO_OPTION)
            System.exit(0);
    }
}
