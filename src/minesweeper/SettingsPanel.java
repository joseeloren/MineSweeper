package minesweeper;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import minesweeper.control.AcceptNewSettingsCommand;
import minesweeper.control.Command;
import minesweeper.view.SettingsDialog;
import minesweeper.view.SettingsDisplay;

public class SettingsPanel extends JDialog implements SettingsDialog,SettingsDisplay{
    private Map<String, Component> components = new HashMap<>();
    private Map<String, Command> commands = new HashMap<>();
    private JFrame parent;
    
    public SettingsPanel(JFrame parent) {
        this.parent = parent;
        deployUI();
        createCommands();
    }

    private void deployUI() {
        this.setTitle("Settings");
        this.setResizable(false);
        this.pack();
        this.setSize(250, 100);
        this.getContentPane().add(components());
        this.setModal(true);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        this.setResizable(false);
    }
    
    private void createCommands() {
        commands.put("Accept", new AcceptNewSettingsCommand(this));
    }

    private JPanel components() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.add(titles());
        panel.add(text());
        panel.add(accept());
        return panel;
    }

    private JPanel titles() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));
        panel.add(new JLabel("Rows"));
        panel.add(new JLabel("Columns"));
        panel.add(new JLabel("Mines"));
        return panel;
    }
    
    private JPanel text() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));
        panel.add(textBox("Rows"));
        panel.add(textBox("Columns"));
        panel.add(textBox("Mines"));
        return panel;
    }

    private JTextField textBox(String text) {
        JTextField textField = new JTextField();
        textField.setText("15");
        components.put(text, textField);
        return textField;
    }
    
    private JButton accept() {
        JButton accept = new JButton("Accept");
        accept.addActionListener(doCommand("Accept"));
        return accept;
    }

    public int getNumberOf(String type) {
        return Integer.parseInt(((JTextField)components.get(type)).getText());
    }

    @Override
    public void display() {
        this.setLocationRelativeTo(parent);
        this.setVisible(!this.isShowing());
    }

    private ActionListener doCommand(final String command) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get(command).execute();
                setVisible(false);
            }
        };
    }

    @Override
    public int getRows() {
        return this.getNumberOf("Rows");
    }

    @Override
    public int getCols() {
        return this.getNumberOf("Columns");
    }

    @Override
    public int getMines() {
        return this.getNumberOf("Mines");
    }
}
