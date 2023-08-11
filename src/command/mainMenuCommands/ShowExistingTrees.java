package command.mainMenuCommands;
import view.ConsoleUI;
import command.Command;
import java.util.ArrayList;

public class ShowExistingTrees extends Command {
    private ArrayList<String> arrayList;
    public ShowExistingTrees(ConsoleUI consoleUI) {
        super(consoleUI, "Показать существующие деревья");
    }

    @Override
    public void useThisMethod() {
        getConsoleUI().showExistingTrees();
    }
}
