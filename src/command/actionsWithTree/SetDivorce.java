package command.actionsWithTree;

import view.ConsoleUI;

public class SetDivorce extends ActionWithTree {
    public SetDivorce(ConsoleUI consoleUI, int numberTree) {
        super(consoleUI, "Произвести развод", numberTree);
    }

    @Override
    public void useThisMethod() {
        getConsoleUI().setDivorce(numberTree);
    }
}