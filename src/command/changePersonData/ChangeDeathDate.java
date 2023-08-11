package command.changePersonData;

import view.ConsoleUI;

public class ChangeDeathDate extends ChangePersonData {
    public ChangeDeathDate(ConsoleUI consoleUI, int numberOfTree, int numberOfPerson) {
        super(consoleUI, "Изменить дату смерти", numberOfTree, numberOfPerson);
    }
    @Override
    public void useThisMethod() {
        getConsoleUI().changeDeathDate(numberOfTree, numberOfPerson);
    }
}
