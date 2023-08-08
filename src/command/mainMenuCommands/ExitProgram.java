package command.mainMenuCommands;

import View.ConsoleUI;
import command.Command;

public class ExitProgram extends Command {
    public ExitProgram(ConsoleUI consoleUI) {
        super(consoleUI, "Выйти из программы");
    }
    @Override
    public void useThisMethod() {
        getConsoleUI().exitProgram();
    }
}