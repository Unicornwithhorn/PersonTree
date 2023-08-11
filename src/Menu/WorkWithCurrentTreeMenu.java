package Menu;

import view.ConsoleUI;
import command.actionsWithTree.AddNewPerson;
import command.actionsWithTree.ChangePersonData;
import command.actionsWithTree.SetWedding;
import command.actionsWithTree.SetDivorce;
import command.actionsWithTree.ViewTree;
import command.actionsWithTree.ExitToMainMenu;

public class WorkWithCurrentTreeMenu extends Menu{

    public WorkWithCurrentTreeMenu(ConsoleUI consoleUI, int numberTree) {
        super();
        commandList.add(new AddNewPerson(consoleUI, numberTree));
        commandList.add(new ViewTree(consoleUI, numberTree));
        commandList.add(new ChangePersonData(consoleUI, numberTree));
        commandList.add(new SetWedding(consoleUI, numberTree));
        commandList.add(new SetDivorce(consoleUI, numberTree));
        commandList.add(new ExitToMainMenu(consoleUI));
    }
//        1) Добавить человека
//        2) Изменить данные человека или удалить
//        3) Сыграть свадьбу
//        4) Произвести развод
//        СДЕЛАЛ ДОСЮДА!
//        5) Установить связь родитель-ребёнок
//        6) Разорвать связь родитель-ребёнок
//        7) Показать состав генеалогического древа
//        8) Вернуться в главное меню
//        9) Выйти

}
