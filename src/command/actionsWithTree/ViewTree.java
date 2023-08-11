package command.actionsWithTree;

import view.ConsoleUI;

public class ViewTree extends ActionWithTree {
    public ViewTree(ConsoleUI consoleUI, int numberTree) {
        super(consoleUI, "Показать всех членов данного дерева", numberTree);
    }
    @Override
    public void useThisMethod() {
        getConsoleUI().viewTree(numberTree);
    }
}