package command.createNewTree;

import command.Command;
import view.ConsoleUI;

public class CreateNewDogTree extends Command {
    public CreateNewDogTree(ConsoleUI consoleUI) {
        super(consoleUI, "Создать новую родословную собак");
    }

    @Override
    public void useThisMethod() {
        getConsoleUI().makeNewTree("Введите название линии", "Вы создали новую линию собак ");
    }
}
