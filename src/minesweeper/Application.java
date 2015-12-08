package minesweeper;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import minesweeper.control.Command;
import minesweeper.control.NewGameCommand;
import minesweeper.control.SettingsCommand;

public class Application extends JFrame {
    private Map<String,Command> commands = new HashMap<>();
    private SettingsPanel settingsPanel;
    private BoardPanel boardPanel;
    
    public static void main(String[] args) {
        new Application().setVisible(true);
    }
    
    public Application() {
        this.deployUI();
        this.createCommand();
    }
    
    private void createCommand() {
        this.commands.put("New Game", new NewGameCommand(boardPanel));
        this.commands.put("Settings", new SettingsCommand(settingsPanel));
    }

    private void deployUI() {
        this.settingsPanel = new SettingsPanel(this); 
        this.getContentPane().add(board());
        this.setTitle("Minesweeper");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setSize(new Dimension(500, 500));
        this.setJMenuBar(menuBar());
        this.setLocationRelativeTo(null);
    }

    private JPanel board() {
        this.boardPanel = new BoardPanel(this, this.settingsPanel);
        return boardPanel;
    }

    private JMenuBar menuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(newGameButton());
        menuBar.add(settingsButton());
        return menuBar;
    }

    private JMenu newGameButton() {
        JMenu menuItem = new JMenu("New game");
        menuItem.addMouseListener(doCommand("New Game"));
        return menuItem;
    }

    private JMenu settingsButton() {
        JMenu menuItem = new JMenu("Settings");
        menuItem.addMouseListener(doCommand("Settings"));
        return menuItem;
    }

    public MouseListener doCommand(final String command) {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1)
                    commands.get(command).execute();    
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
    }
}