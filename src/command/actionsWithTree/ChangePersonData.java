package command.actionsWithTree;

import view.ConsoleUI;

public class ChangePersonData extends ActionWithTree {
    public ChangePersonData(ConsoleUI consoleUI, int numberTree) {
        super(consoleUI, "Изменить данные человека", numberTree);
    }

    @Override
    public void useThisMethod() {
        getConsoleUI().changePersonData(numberTree);
    }
}