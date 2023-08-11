package command.changePersonData;

import command.Command;
import view.ConsoleUI;

public class ChangeGender extends ChangePersonData {
    public ChangeGender(ConsoleUI consoleUI, int numberOfTree, int numberOfPerson)
    {
        super(consoleUI, "Изменить пол", numberOfTree, numberOfPerson);
    }
    @Override
    public void useThisMethod() {
        getConsoleUI().changeGender(numberOfTree, numberOfPerson);
    }
}