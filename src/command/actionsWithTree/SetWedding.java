package command.actionsWithTree;

import view.ConsoleUI;

public class SetWedding extends ActionWithTree {
    public SetWedding(ConsoleUI consoleUI, int numberTree) {
        super(consoleUI, "Сыграть свадьбу", numberTree);
    }
    @Override
    public void useThisMethod() {
        getConsoleUI().setWedding(numberTree);
    }
}
