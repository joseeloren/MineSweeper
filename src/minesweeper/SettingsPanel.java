package minesweeper;

import java.awt.Component;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import minesweeper.view.SettingsDisplay;

public class SettingsPanel extends JFrame  {
    //private Map<String, Component> components = new HashMap<>();
    
    public SettingsPanel() {
        super();
        //deployUI();
    }

    private void deployUI() {/*
        this.setSize(50, 50);
        this.getContentPane().add(components());
        this.setModal(true);
        this.pack();
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        this.setResizable(false);*/
    }

    private JPanel components() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(titles());
        panel.add(text());
        return panel;
    }

    private JPanel titles() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(new JLabel("Filas"));
        panel.add(new JLabel("Columnas"));
        panel.add(new JLabel("Minas"));
        return panel;
    }
    
    private JPanel text() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(textBox("Filas"));
        panel.add(textBox("Columnas"));
        panel.add(textBox("Minas"));
        return panel;
    }

    private JTextField textBox(String filas) {
        JTextField textField = new JTextField();
        textField.setText("15");
        components.put(filas, textField);
        return textField;
    }

    public int getNumberOf(String type) {
        return Integer.parseInt(((JTextField)components.get(type)).getText());
    }

    @Override
    public void show() {
        this.setVisible(true);
    }
}
