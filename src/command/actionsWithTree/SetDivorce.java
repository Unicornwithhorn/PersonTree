package command.actionsWithTree;

import Tree.FamilyTree;
import View.ConsoleUI;

public class SetDivorce extends ActionWithTree {
    public SetDivorce(ConsoleUI consoleUI, FamilyTree familyTree) {
        super(consoleUI, "Произвести развод", familyTree);
    }

    @Override
    public void useThisMethod() {
        getConsoleUI().setDivorce(familyTree);
    }
}