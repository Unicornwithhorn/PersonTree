package command.mainMenuCommands;

import View.ConsoleUI;
import command.Command;

public class ShowExistingTrees extends Command {
    public ShowExistingTrees(ConsoleUI consoleUI) {
        super(consoleUI, "Создать новое дерево");
    }
    @Override
    public void useThisMethod() {
        getConsoleUI().showExistingTrees();
    }
}
