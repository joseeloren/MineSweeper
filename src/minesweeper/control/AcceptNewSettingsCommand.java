package minesweeper.control;

import minesweeper.view.SettingsDisplay;

public class AcceptNewSettingsCommand implements Command{
    private SettingsDisplay settingsDisplay;

    public AcceptNewSettingsCommand(SettingsDisplay settingsDisplay) {
        this.settingsDisplay = settingsDisplay;
    }
    
    @Override
    public void execute() {
        settingsDisplay.display();
    }
    
}
