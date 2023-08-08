package command.actionsWithTree;

import Tree.FamilyTree;
import View.ConsoleUI;
import command.Command;

public abstract class ActionWithTree extends Command {
    FamilyTree familyTree;
    public ActionWithTree(ConsoleUI consoleUI, String description, FamilyTree familyTree) {
        super(consoleUI, description);
        this.familyTree = familyTree;
    }

    public void setFamilyTree(FamilyTree familyTree){
        this.familyTree = familyTree;
    }

    @Override
    public abstract void useThisMethod();
}
