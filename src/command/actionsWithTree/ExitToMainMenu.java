package command.actionsWithTree;

import view.ConsoleUI;
import command.Command;

public class ExitToMainMenu extends Command {
    public ExitToMainMenu(ConsoleUI consoleUI) {
        super(consoleUI, "Выйти в главное меню");
    }

    @Override
    public void useThisMethod() {
        getConsoleUI().start();
    }
}