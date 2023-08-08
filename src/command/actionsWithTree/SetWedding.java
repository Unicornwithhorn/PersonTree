package command.actionsWithTree;

import View.ConsoleUI;
import Tree.FamilyTree;
import command.Command;

public class SetWedding extends ActionWithTree {
    public SetWedding(ConsoleUI consoleUI, FamilyTree familyTree) {
        super(consoleUI, "Сыграть свадьбу", familyTree);
    }
    @Override
    public void useThisMethod() {
        getConsoleUI().setWedding(familyTree);
    }
}
