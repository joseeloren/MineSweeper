package minesweeper;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import minesweeper.control.*;

public class Application extends JFrame {
    private Map<String,Command> commands = new HashMap<>();
    private Map<String,Component> components = new HashMap<>();
    private Command newGameCommand;
    private SettingsPanel settingsPanel;
    private BoardPanel boardPanel;
    
    public static void main(String[] args) {
        //new Application().setVisible(true);
        new SettingsPanel().setVisible(true);
        
        //new JFrame().setVisible(true);
    }
    
    public Application() throws HeadlessException {
        this.deployUI();
        this.createCommand();
    }
    
    private void createCommand() {
        this.commands.put("New Game", new NewGameCommand());
        this.commands.put("Settings", new SettingsCommand(settingsPanel));
    }

    private void deployUI() {
        this.setTitle("MineSweeper");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setSize(new Dimension(500, 500));
        //this.getContentPane().add(board());
        this.setJMenuBar(menuBar());
        this.setLocationRelativeTo(null);
        this.settingsPanel = new SettingsPanel(this);
    }

    private JPanel board() {
        this.boardPanel = new BoardPanel(this);
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

    private MouseListener doCommand(final String command) {
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