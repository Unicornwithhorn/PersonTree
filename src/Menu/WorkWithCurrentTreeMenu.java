package Menu;

import Tree.FamilyTree;
import View.ConsoleUI;
import command.actionsWithTree.AddNewPerson;
import command.actionsWithTree.ChangePersonData;
import command.actionsWithTree.SetWedding;
import command.actionsWithTree.SetDivorce;
import command.actionsWithTree.ViewTree;
import command.actionsWithTree.ExitToMainMenu;

public class WorkWithCurrentTreeMenu extends Menu{

    FamilyTree familyTree;
    public WorkWithCurrentTreeMenu(ConsoleUI consoleUI, FamilyTree familyTree) {
        super();
        this.familyTree = familyTree;
        commandList.add(new AddNewPerson(consoleUI, familyTree));
        commandList.add(new ViewTree(consoleUI, familyTree));
        commandList.add(new ChangePersonData(consoleUI, familyTree));
        commandList.add(new SetWedding(consoleUI, familyTree));
        commandList.add(new SetDivorce(consoleUI, familyTree));
        commandList.add(new ExitToMainMenu(consoleUI));
    }
    public void setFamilyTree(FamilyTree familyTree){
        this.familyTree = familyTree;
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
