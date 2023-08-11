package command.changePersonData;

import view.ConsoleUI;

public class ChangeBirthDate extends ChangePersonData {
    public ChangeBirthDate(ConsoleUI consoleUI, int numberOfTree, int numberOfPerson) {
        super(consoleUI, "Изменить дату рождения", numberOfTree, numberOfPerson);
    }
    @Override
    public void useThisMethod() {
        getConsoleUI().changeBirthDate(numberOfTree, numberOfPerson);
    }
}
