package command.changePersonData;

import command.Command;
import view.ConsoleUI;

public class ChangeName extends ChangePersonData {
    public ChangeName(ConsoleUI consoleUI, int numberOfTree, int numberOfPerson) {
        super(consoleUI, "Изменить имя", numberOfTree, numberOfPerson);

    }
    @Override
    public void useThisMethod() {
        getConsoleUI().changeName(numberOfTree, numberOfPerson);
    }
}
