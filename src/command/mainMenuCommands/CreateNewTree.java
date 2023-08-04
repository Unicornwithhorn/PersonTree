package command.mainMenuCommands;

import View.ConsoleUI;
import command.Command;

public class CreateNewTree extends Command {
    public CreateNewTree(ConsoleUI consoleUI) {
        super(consoleUI, "Создать новое дерево");
    }
    @Override
    public void useThisMethod() {
        getConsoleUI().createNewTree();
    }
}
