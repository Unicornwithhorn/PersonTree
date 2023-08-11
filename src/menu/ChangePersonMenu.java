package menu;

import view.ConsoleUI;
import command.changePersonData.ChangeName;
import command.changePersonData.ChangeGender;
import command.changePersonData.ChangeBirthDate;
import command.changePersonData.ChangeDeathDate;

public class ChangePersonMenu extends Menu{

    public ChangePersonMenu (ConsoleUI consoleUI, int numberTree, int numberPerson){
        super();
        commandList.add(new ChangeName(consoleUI, numberTree, numberPerson));
        commandList.add(new ChangeBirthDate(consoleUI, numberTree, numberPerson));
        commandList.add(new ChangeDeathDate(consoleUI, numberTree, numberPerson));
        commandList.add(new ChangeGender(consoleUI, numberTree, numberPerson));
    }
}
