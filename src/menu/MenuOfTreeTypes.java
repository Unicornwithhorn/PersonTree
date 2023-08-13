package menu;

import command.actionsWithTree.*;
import command.createNewTree.CreateNewDogTree;
import command.createNewTree.CreateNewFamilyTree;
import view.ConsoleUI;

public class MenuOfTreeTypes extends Menu{
    public MenuOfTreeTypes(ConsoleUI consoleUI) {
        super();
        commandList.add(new CreateNewFamilyTree(consoleUI));
        commandList.add(new CreateNewDogTree(consoleUI));
        commandList.add(new ExitToMainMenu(consoleUI));
    }
}
