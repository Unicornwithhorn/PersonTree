package command.actionsWithTree;

import view.ConsoleUI;
import command.Command;

public abstract class ActionWithTree extends Command {
    int numberTree;
    public ActionWithTree(ConsoleUI consoleUI, String description, int numberTree) {
        super(consoleUI, description);
        this.numberTree = numberTree;
    }
}
