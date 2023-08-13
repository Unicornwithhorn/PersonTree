package command.actionsWithTree;

import view.ConsoleUI;

public class SetChildParentRelationship extends ActionWithTree {
    public SetChildParentRelationship(ConsoleUI consoleUI, int numberTree) {
        super(consoleUI, "Создать связь между родителем и ребёнком", numberTree);
    }
    @Override
    public void useThisMethod() {
        getConsoleUI().setChildParentRelationship(numberTree);
    }
}