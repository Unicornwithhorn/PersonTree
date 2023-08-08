package command.mainMenuCommands;

import Tree.SimpleTree;
import View.ConsoleUI;
import command.Command;

import java.util.ArrayList;

public class ShowExistingTrees extends Command {
    private ArrayList<SimpleTree> arrayList;
    public ShowExistingTrees(ConsoleUI consoleUI) {
        super(consoleUI, "Показать существующие деревья");
    }

    public ArrayList<SimpleTree> getArrayList(){
        return arrayList;
    }

    @Override
    public void useThisMethod() {
        getConsoleUI().showExistingTrees();
    }
}
