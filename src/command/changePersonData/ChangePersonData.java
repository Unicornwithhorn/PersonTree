package command.changePersonData;

import command.Command;
import view.ConsoleUI;

public abstract class ChangePersonData extends Command {
    int numberOfTree;
    int numberOfPerson;
    public ChangePersonData(ConsoleUI consoleUI, String description, int numberOfTree, int numberOfPerson){
        super(consoleUI, description);
        this.numberOfTree = numberOfTree;
        this.numberOfPerson = numberOfPerson;
    }
}
