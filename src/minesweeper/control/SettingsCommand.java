package minesweeper.control;

import minesweeper.SettingsPanel;

public class SettingsCommand implements Command{

    private final SettingsPanel settingsPanel;

    public SettingsCommand(SettingsPanel settingsPanel) {
        this.settingsPanel = settingsPanel;
    }
    
    @Override
    public void execute() {
        settingsPanel.display();
    }
    
}
