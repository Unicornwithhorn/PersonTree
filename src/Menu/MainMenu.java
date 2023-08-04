package Menu;

import command.mainMenuCommands.CreateNewTree;
import command.mainMenuCommands.ExitProgram;
import command.mainMenuCommands.ShowExistingTrees;
import View.ConsoleUI;

public class MainMenu extends Menu{
    public MainMenu(ConsoleUI consoleUI) {
        super();
        commandList.add(new ShowExistingTrees(consoleUI));
        commandList.add(new CreateNewTree(consoleUI));
        commandList.add(new ExitProgram(consoleUI));
    }
}
