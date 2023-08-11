package command.actionsWithTree;

import view.ConsoleUI;

public class AddNewPerson extends ActionWithTree {
    public AddNewPerson(ConsoleUI consoleUI, int numberTree) {
        super(consoleUI, "Добавить нового человека", numberTree);
    }
    @Override
    public void useThisMethod() {
        getConsoleUI().addNewPerson(numberTree);
    }
}
