package view;
import Menu.MainMenu;
import Menu.WorkWithCurrentTreeMenu;
import presenter.Presenter;

import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleUI implements View, Technicable{
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
//        readText(1);//Выберите интересующий вас пункт:
        ArrayList<String> arrayList = presenter.showExistingTrees();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Выберите дерево из списка\n");
        for (int i = 0; i < arrayList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(") ");
            stringBuilder.append(arrayList.get(i));
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString());
        choiceTree(correctInput(arrayList.size()));
    }
    public void choiceTree(int choice){//TODO А если не люди, то не FAMILYTREE!
        WorkWithCurrentTreeMenu workWithCurrentTreeMenu = new WorkWithCurrentTreeMenu(this, choice);
        while(true) {
            workWithCurrentTreeMenu.menu();
        }
    }

    public void createNewTree(){
        System.out.println("Введите название дерева");
        String treeName = scanner.nextLine();
        presenter.createNewTree(treeName);
        System.out.println(readText(31) + " " + treeName);
    }

    public void addNewPerson(int numberTree){
        System.out.println(readText(24));
        String personName =  scanner.nextLine();
        System.out.println(readText(25));
        int birthYear = correctInput(0, Year.now().getValue());
        int birthMonth = 0;
        int birthDay = 0;
        if (birthYear!=0) {
            System.out.println(readText(26));
            birthMonth = correctInput(12);
            System.out.println(readText(27));
            birthDay = correctInput(31);//TODO во всех месяцах 31 день, с 31 февраля получается ошибка =(
        }
        System.out.println(readText(28));
        int deathYear = correctInput(0, Year.now().getValue());//TODO остаётся возможность помереть до рождения
        int deathMonth = 0;
        int deathDay = 0;
        if (deathYear!=0) {
            System.out.println(readText(29));
            deathMonth = correctInput(12);
            System.out.println(readText(30));
            deathDay = correctInput(31);//TODO во всех месяцах 31 день =(
        }
        int genderChoice = menuStep(35,37);
        presenter.addNewPerson(numberTree, personName, birthYear, birthMonth, birthDay,
                deathYear, deathMonth, deathDay, genderChoice );
        System.out.println(readText(32) + personName);
    }

    public void viewTree(int numberTree){ System.out.println(presenter.viewTree(numberTree)); }
    public void changePersonData(int numberTree){
    }

    public void setDivorce(int numberOfTree){
        boolean flag = true;
        while (flag) {
            System.out.println(presenter.viewTree(numberOfTree));
            int numberOfUnits = presenter.getNumberUnits(numberOfTree);
            System.out.println("Введите id первого разводящегося");
            int choice1 = correctInput(0, numberOfUnits);
            System.out.println("Введите id второго разводящегося");
            int choice2 = correctInput(0, numberOfUnits);
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
        int numberOfUnits = presenter.getNumberUnits(numberOfTree);
        while (flag) {
            System.out.println(presenter.viewTree(numberOfTree));
            System.out.println("Введите id первого молодожёна");
            int choice1 = correctInput(0, numberOfUnits);
            System.out.println("Введите id второго молодожёна");
            int choice2 = correctInput(0, numberOfUnits);
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

    public void exitProgram() {
        System.exit(0);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
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










