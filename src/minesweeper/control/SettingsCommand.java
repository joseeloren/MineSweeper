package minesweeper.control;

import minesweeper.view.SettingsDisplay;

public class SettingsCommand implements Command{
    private SettingsDisplay settingsDisplay;

    public SettingsCommand(SettingsDisplay settingsDisplay) {
        this.settingsDisplay = settingsDisplay;
    }

    @Override
    public void execute() {
        settingsDisplay.display();
    }
    
}
