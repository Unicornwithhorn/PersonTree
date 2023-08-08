package command.actionsWithTree;

import Tree.FamilyTree;
import View.ConsoleUI;
import command.Command;

public class ViewTree extends ActionWithTree {
    public ViewTree(ConsoleUI consoleUI, FamilyTree familyTree) {
        super(consoleUI, "Показать всех членов данного дерева", familyTree);
    }
    @Override
    public void useThisMethod() {
        getConsoleUI().viewTree(familyTree);
    }
}