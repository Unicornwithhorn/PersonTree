package command.createNewTree;

import command.Command;
import view.ConsoleUI;

public class CreateNewFamilyTree extends Command {
    public CreateNewFamilyTree(ConsoleUI consoleUI) {
        super(consoleUI, "Создать новое генеалогическое древо людей");
    }

    @Override
    public void useThisMethod() {
        getConsoleUI().makeNewTree("Введите название генеалогичекого дерева", "Вы создали новое генеалогическое древо ");
    }
}
