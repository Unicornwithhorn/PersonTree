package view;
import Gender.Gender;
import menu.MainMenu;
import menu.MenuOfTreeTypes;
import menu.WorkWithCurrentTreeMenu;
import menu.ChangePersonMenu;
import presenter.Presenter;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleUI implements Technicable{
    private Presenter presenter;
    private Scanner scanner;
    private MainMenu mainMenu;
    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        mainMenu = new MainMenu(this);
    }
    public void start(){
        presenter.setConsoleUI(this);
        while (true){
            mainMenu.menu();
        }
    }

//    public void showExistingTrees(){
//        readText(1);//Выберите интересующий вас пункт:
//        ArrayList<SimpleTree> arrayList = presenter.showExistingTrees();
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("Выберите дерево из списка\n");
//        for (int i = 0; i < arrayList.size(); i++) {
//            stringBuilder.append(i+1);
//            stringBuilder.append(") ");
//            stringBuilder.append(arrayList.get(i).getName());
//            stringBuilder.append(" ");
//            stringBuilder.append(arrayList.get(i).getClass());
//            stringBuilder.append("\n");
//        }
//        System.out.println(stringBuilder.toString());
//        presenter.choiceTree(arrayList);
//    }
    public void showExistingTrees(){
        ArrayList<String> arrayList = presenter.showExistingTrees();
        if (arrayList.size() == 0){
            System.out.println("Список деревьев пустой");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Выберите дерево из списка\n");
            for (int i = 0; i < arrayList.size(); i++) {
                stringBuilder.append(i + 1);
                stringBuilder.append(") ");
                stringBuilder.append(arrayList.get(i));
                stringBuilder.append("\n");
            }
            System.out.println(stringBuilder.toString());
            choiceTree(correctInput(arrayList.size()));
        }
    }
    public void choiceTree(int choice){//TODO А если не люди, то не FAMILYTREE!
        WorkWithCurrentTreeMenu workWithCurrentTreeMenu = new WorkWithCurrentTreeMenu(this, choice);
        while(true) {
            workWithCurrentTreeMenu.menu();
        }
    }

    public void createNewTree(){
        MenuOfTreeTypes menuOfTreeTypes = new MenuOfTreeTypes(this);
        menuOfTreeTypes.menu();
    }

    public void makeNewTree(String text1, String text2){
        int newTree = switch (text1) {
            case "Введите название генеалогичекого дерева" -> presenter.createNewFamilyTree();
            case "Введите название линии" -> presenter.createNewDogTree();
            default -> 0;
        };
        System.out.println(text1);
        String treeName = scanner.nextLine();
        presenter.setTreeName(newTree, treeName);
        System.out.println(text2 + treeName);
    }

    public LocalDate dateInput(String request){
        System.out.println(request);
        System.out.println(readText(25));
        int year = correctInput(0, Year.now().getValue());
        int month = 0;
        int day = 0;
        if (year!=0) {
            System.out.println(readText(26));
            month = correctInput(12);
            System.out.println(readText(27));
            day = correctInput(31);//TODO во всех месяцах 31 день, с 31 февраля получается ошибка =(
            return LocalDate.of(year, month, day);
        }
        return null;
    }

    public void addNewPerson(int numberTree){
        System.out.println(readText(24));
        String personName =  scanner.nextLine();
        System.out.println(readText(25));
        LocalDate birthDate = null;
        int birthYear = correctInput(0, Year.now().getValue());
        if (birthYear!=0) {
            System.out.println(readText(26));
            int birthMonth = correctInput(12);
            System.out.println(readText(27));
            int birthDay = correctInput(31);//TODO во всех месяцах 31 день, с 31 февраля получается ошибка =(
            birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
        }
        System.out.println(readText(28));
        LocalDate deathDate = null;
        int deathYear = correctInput(0, Year.now().getValue());//TODO остаётся возможность помереть до рождения
        if (deathYear!=0) {
            System.out.println(readText(29));
            int deathMonth = correctInput(12);
            System.out.println(readText(30));
            int deathDay = correctInput(31);//TODO во всех месяцах 31 день =(
            deathDate = LocalDate.of(deathYear, deathMonth, deathDay);
        }
        int genderChoice = menuStep(35,37);
        presenter.addNewPerson(numberTree, personName, birthDate, deathDate, genderChoice );
        System.out.println(readText(32) + personName);
    }

    public void viewTree(int numberTree){ System.out.println(presenter.viewTree(numberTree)); }

    public void changePersonData(int numberOfTree){
        int numberPerson = choicePersonFromTree(numberOfTree,"Выберите интересующего вас человека");
        ChangePersonMenu changePersonMenu = new ChangePersonMenu(this, numberOfTree, numberPerson);
        changePersonMenu.menu();
    }

    public void changeBirthDate(int numberOfTree, int numberOfPerson) {
        LocalDate newBirthDate = dateInput("Введите новые данные даты рождения");
        presenter.changeBirthDate(numberOfTree, numberOfPerson, newBirthDate);
    }

    public void changeDeathDate(int numberOfTree, int numberOfPerson) {
        LocalDate newDeathDate = dateInput("Введите новые данные даты смерти");
        presenter.changeDeathDate(numberOfTree, numberOfPerson, newDeathDate);
    }

    public void changeGender(int numberOfTree, int numberOfPerson) {
        int genderChoice = menuStep(35,37);
        presenter.changeGender(numberOfTree, numberOfPerson, genderChoice);
    }
    public void changeName(int numberOfTree, int numberOfPerson){
        System.out.println(readText(24));
        String personName =  scanner.nextLine();
        presenter.changeName(numberOfTree, numberOfPerson, personName);
    }



    public int choicePersonFromTree(int numberOfTree, String message){
        int numberOfUnits = presenter.getNumberUnits(numberOfTree);
        System.out.println(message);
        return correctInput(0, numberOfUnits);
    }

    public void setDivorce(int numberOfTree){
        System.out.println(presenter.viewTree(numberOfTree));
        boolean flag = true;
        while (flag) {
            int choice1 = choicePersonFromTree(numberOfTree, "Введите id первого разводящегося");
            int choice2 = choicePersonFromTree(numberOfTree, "Введите id второго разводящегося");
            boolean result = presenter.setDivorce(numberOfTree, choice1, choice2);
            if (result) {
                System.out.println("Развод успешно завершён. " + presenter.getNameUnit(numberOfTree, choice1) + " и " +
                        presenter.getNameUnit(numberOfTree, choice2) + " свободны.");
                        flag = false;
            } else {
                System.out.println("Эти люди и не были в браке");
                System.out.println("Желаете попытаться роизвести развод ещё раз?\n 1) да\n 2) нет");
                if (correctInput(2) == 2) {
                    flag = false;
                }
            }
        }
    }

    public void setWedding(int numberOfTree){
        boolean flag = true;
        while (flag) {
            System.out.println(presenter.viewTree(numberOfTree));
            int choice1 = choicePersonFromTree(numberOfTree, "Введите id первого молодожёна");
            int choice2 = choicePersonFromTree(numberOfTree, "Введите id второго молодожёна");
            int result = presenter.setWedding(numberOfTree, choice1, choice2);
            switch (result) {
                case 1:
                    System.out.println("Эти люди уже женаты!");
                    break;
                case 2:
                    System.out.println("Увы! " + presenter.getNameUnit(numberOfTree, choice1) + " уже находится в браке! ");
                    break;
                case 3:
                    System.out.println("Увы! " + presenter.getNameUnit(numberOfTree, choice2) + " уже находится в браке! ");
                    break;
                case 4:
                    System.out.println("Счастья молодым! Поздравляем следующих людей: " +
                            presenter.getNameUnit(numberOfTree, choice1) + " и " +
                            presenter.getNameUnit(numberOfTree, choice2));
                    flag = false;
                    break;
            }
            if (result != 4) {
                System.out.println("Желаете попытаться сыграть свадьбу ещё раз?\n 1) да\n 2) нет");
                if (correctInput(2) == 2) {
                    flag = false;
                }
            }
        }
    }

    public void setChildParentRelationship(int numberOfTree){
        boolean flag = true;
        while (flag) {
            System.out.println(presenter.viewTree(numberOfTree));
            int progenitor = choicePersonFromTree(numberOfTree, "Введите id родителя");
            int descendent = choicePersonFromTree(numberOfTree, "Введите id ребёнка");
            int result = presenter.addProgenitorDescendentRelationship(numberOfTree, progenitor, descendent);
            switch (result) {
                case 1:
                    System.out.println(presenter.getNameUnit(numberOfTree, progenitor) + " является ребёнком " +
                            presenter.getNameUnit(numberOfTree, descendent));
                    break;
                case 2:
                    System.out.println(presenter.getNameUnit(numberOfTree, progenitor) + "уже является родителем" +
                            presenter.getNameUnit(numberOfTree, descendent));
                    break;
                case 3:
                    System.out.println("Связь успешно установлена");
                    flag = false;
                    break;
            }
            if (result != 3) {
                System.out.println("Желаете попытаться ещё раз?\n 1) да\n 2) нет");
                if (correctInput(2) == 2) {
                    flag = false;
                }
            }
        }
    }
    public void exitProgram() {
        System.exit(0);
    }





//    private void showExistingTrees(){
//        FileHandler fileHandler = new FileHandler();
//        int maxIndex = (int) fileHandler.loadObject("src/SaveFiles/numberOfCurrentTrees.out");
//        ArrayList<Integer> arrayList = new ArrayList<Integer>();
//        for (int i = 1; i <= maxIndex; i++) {
//            SimpleTree system = (SimpleTree) fileHandler.loadObject("src/SaveFiles/" + i + ".out");
//            arrayList.add(system.getSystemId());
//            System.out.println(i + ") " + system.getName() + " " + system.getClass());
//        }
//        System.out.println((maxIndex+1) + readText(33));
//        System.out.println((maxIndex+2) + readText(34));
//        System.out.println();
//        System.out.println(readText(1));
//        int choice = correctInput(arrayList.size()+2);
//        if (choice == maxIndex+1){
//            start();
//        }else if(choice == maxIndex +2){
//            System.exit(0);
//        }else {
////            System.out.println(arrayList.get(choice-1)); //это ID выбранного дерева, он же - название файла, где оно хранится
//            String linkChoosenFile = "src/SaveFiles/" + arrayList.get(choice-1) + ".out";
//            SimpleTree chosenSystem = (SimpleTree) fileHandler.loadObject(linkChoosenFile);
//            if (chosenSystem instanceof FamilyTree){
//                TreeService treeService = new TreeService();
//                treeService.workWithFamilyTree((FamilyTree) fileHandler.loadObject(linkChoosenFile));
//            }else {
//                System.out.println("Это что-то другое, не фэмилитри, раздел типа в разработке=)");
//            }
//        }
//    }
}










