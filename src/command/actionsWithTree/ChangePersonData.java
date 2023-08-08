package command.actionsWithTree;

import Tree.FamilyTree;
import View.ConsoleUI;
import command.Command;

public class ChangePersonData extends ActionWithTree {
    public ChangePersonData(ConsoleUI consoleUI, FamilyTree familyTree) {
        super(consoleUI, "Изменить данные человека", familyTree);
    }

    @Override
    public void useThisMethod() {
        getConsoleUI().changePersonData(familyTree);
    }
}