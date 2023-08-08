package command.actionsWithTree;

import Tree.FamilyTree;
import View.ConsoleUI;
import command.Command;

public class AddNewPerson extends ActionWithTree {
    public AddNewPerson(ConsoleUI consoleUI, FamilyTree familyTree) {
        super(consoleUI, "Добавить нового человека", familyTree);
    }
    @Override
    public void useThisMethod() {
        getConsoleUI().addNewPerson(familyTree);
    }
}
