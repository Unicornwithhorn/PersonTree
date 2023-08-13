package menu;

import command.actionsWithTree.*;
import view.ConsoleUI;

public class WorkWithDogTreeMenu extends Menu{
    public WorkWithDogTreeMenu(ConsoleUI consoleUI, int numberTree) {
        super();
        commandList.add(new AddNewPerson(consoleUI, numberTree));
        commandList.add(new ViewTree(consoleUI, numberTree));
        commandList.add(new ChangePersonData(consoleUI, numberTree));
        commandList.add(new SetWedding(consoleUI, numberTree));
        commandList.add(new SetDivorce(consoleUI, numberTree));
        commandList.add(new SetChildParentRelationship(consoleUI, numberTree));
        commandList.add(new ExitToMainMenu(consoleUI));
    }
}
