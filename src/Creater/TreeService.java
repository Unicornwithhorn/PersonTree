package Creater;

import View.Technicable;
import Gender.Gender;
import SystemUnit.Person;
import Tree.FamilyTree;
import FileHandler.FileHandler;
import Tree.SimpleTree;
import View.View;
import presenter.Presenter;

import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

public class TreeService <E extends SimpleTree> implements Technicable {
//    public ArrayList<SimpleTree> showExistingTrees(){
//        FileHandler fileHandler = new FileHandler();
//        int maxIndex = (int) fileHandler.loadObject("src/SaveFiles/numberOfCurrentTrees.out");
//        ArrayList<SimpleTree> arrayList = new ArrayList<>();
//        for (int i = 1; i <= maxIndex; i++) {
//            SimpleTree system = (SimpleTree) fileHandler.loadObject("src/SaveFiles/" + i + ".out");
//            arrayList.add(system);
//            System.out.println(i + ") " + system.getName() + " " + system.getClass());
//        }
//        presenter. arrayList;
//    }


    //    private void showExistingTrees(){ //TODO а если сохранённых деревьев нет? получается ошибка=(
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

    public static void showExistingTrees(){
        FileHandler fileHandler = new FileHandler();
        int maxIndex = (int) fileHandler.loadObject("src/SaveFiles/numberOfCurrentTrees.out");
        ArrayList<SimpleTree> arrayList = new ArrayList<>();
        for (int i = 1; i <= maxIndex; i++) {
            SimpleTree system = (SimpleTree) fileHandler.loadObject("src/SaveFiles/" + i + ".out");
            System.out.println(i + ") " + system.getName() + " " + system.getClass());
        }

    }

    public static void createNewTree(){
        Scanner scanner = new Scanner(System.in);
        FamilyTree familyTree = new FamilyTree();
        FileHandler fileHandler = new FileHandler();
        int newId = (int) fileHandler.loadObject("src/SaveFiles/numberOfCurrentTrees.out") + 1;
//        int newId = 1;
        familyTree.setSystemId(newId);
        fileHandler.saveObject("src/SaveFiles/numberOfCurrentTrees.out", newId);
        System.out.println(readText(13));
        String newTreeName = scanner.nextLine();
        familyTree.setName(newTreeName);
        System.out.println(readText(31) + " " + newTreeName);

        String path = "src/SaveFiles/" + newId + ".out";
        System.out.println(path);
        fileHandler.saveObject(path, familyTree);

        workWithFamilyTree(familyTree);
    }

    public static void exitProgram(){

    }
//    public ArrayList<SimpleTree> showExistingTrees(){
//        FileHandler fileHandler = new FileHandler();
//        int maxIndex = (int) fileHandler.loadObject("src/SaveFiles/numberOfCurrentTrees.out");
//        ArrayList<SimpleTree> arrayList = new ArrayList<>();
//        for (int i = 1; i <= maxIndex; i++) {
//            SimpleTree system = (SimpleTree) fileHandler.loadObject("src/SaveFiles/" + i + ".out");
//            arrayList.add(system);
//            System.out.println(i + ") " + system.getName() + " " + system.getClass());
//        }
//        presenter. arrayList;
//    }

    public String catalogTreesForPrint(ArrayList<SimpleTree> arrayList){
        StringBuilder stringBuilder = new StringBuilder();
        int i = 1;
        for (SimpleTree system: arrayList){
            stringBuilder.append (i++ + ") " + system.getName() + " " + system.getClass()+ "\n");
        }
        stringBuilder.append((arrayList.size()+1) + readText(33)+ "\n");
        stringBuilder.append((arrayList.size()+2) + readText(34) + "\n");
        stringBuilder.append("\n");
        stringBuilder.append(readText(1));
        return stringBuilder.toString();
    }









//    public void createNewTreeOfPerson(){
//
//        Scanner scanner = new Scanner(System.in);
//        FamilyTree familyTree = new FamilyTree();
//        FileHandler fileHandler = new FileHandler();
//        int newId = (int) fileHandler.loadObject("src/SaveFiles/numberOfCurrentTrees.out") + 1;
////        int newId = 1;
//        familyTree.setSystemId(newId);
//        fileHandler.saveObject("src/SaveFiles/numberOfCurrentTrees.out", newId);
//        System.out.println(readText(13));
//        String newTreeName = scanner.nextLine();
//        familyTree.setName(newTreeName);
//        System.out.println(readText(31) + " " + newTreeName);
//
//        String path = "src/SaveFiles/" + newId + ".out";
//        System.out.println(path);
//        fileHandler.saveObject(path, familyTree);
//
//        workWithFamilyTree(familyTree);
//    }

    public void workWithFamilyTree(FamilyTree familyTree){
        int choice = menuStep(14,23);
        FileHandler fileHandler = new FileHandler();
        int filename;
        String path = new String();
        switch (choice){
            case 1: createNewPerson(familyTree);
                break;
            case 2:
                break;
            case 3: System.out.println(familyTree);
                System.out.println(familyTree.setWedding());

                filename = familyTree.getSystemId();
                path = "src/SaveFiles/" + filename + ".out";
                fileHandler.saveObject(path, familyTree);

                break;
            case 4: System.out.println(familyTree);
                familyTree.setDivorce();
                filename = familyTree.getSystemId();
                path = "src/SaveFiles/" + filename + ".out";
                fileHandler.saveObject(path, familyTree);
                break;
            case 5:
                break;
            case 6:
                break;
            case 7: System.out.println(familyTree);
                break;
            case 8: TreeCreater treeCreater = new TreeCreater();
                treeCreater.start();
                break;
            case 9: System.exit(0);
                break;
        }
        if (choice!=9) {
            workWithFamilyTree(familyTree);
        }
    }
    private void createNewPerson(FamilyTree familyTree) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(readText(24));
        Person person = new Person(scanner.nextLine());
        System.out.println(readText(25));
        int year = correctInput(0,Year.now().getValue());
        if (year!=0) {
            System.out.println(readText(26));
            int month = correctInput(12);
            System.out.println(readText(27));
            int day =  correctInput(31);//TODO во всех месяцах 31 день =(
            person.setBirthDate(year,month,day);
        }
        System.out.println(readText(28));
        int year2 = correctInput(0, Year.now().getValue());//TODO остаётся возможность помереть до рождения
        if (year2!=0) {
            System.out.println(readText(29));
            int month2 = correctInput(12);
            System.out.println(readText(30));
            int day2 = correctInput(31);//TODO во всех месяцах 31 день =(
            person.setDeathDate(year2,month2,day2);
        }
        int genderChoice = menuStep(35,37);
        switch (genderChoice) {
            case 1 -> person.setGender(Gender.Male);
            case 2 -> person.setGender(Gender.Female);
        }
        familyTree.addSystemUnit(person);
        FileHandler fileHandler = new FileHandler();
        int filename = familyTree.getSystemId();
        String path = "src/SaveFiles/" + filename + ".out";
        fileHandler.saveObject(path, familyTree);
        System.out.println(readText(32) + person.getName());
    }
}
//    private List<FamilyTree> listTree;
//    private FamilyTree currentFamilyTree;
//
//    public Creater.TreeService(FamilyTree currenrFamilyTree) {
//        this.listTree = new ArrayList<>();
//        this.currentFamilyTree = currenrFamilyTree;
//    }
//
//    public void addTreeToService(FamilyTree newTree){
//        listTree.add(newTree);
//    }
//
//    public void addPersonInCurrentTree (Person person){
//        currentFamilyTree.addPerson(person);
//    }
//
//    public String currentTreeInfo() {
//        StringBuilder stringBuilder = new StringBuilder();
//        for (Person person : currentFamilyTree) {
//            stringBuilder.append(person);
//            stringBuilder.append("\n");
//        }
//    return stringBuilder.toString();
//    }
//
//    public void sortByName(){
//        currentFamilyTree.sortByName();
//    }
//
//    public void sortByAge(){
//        currentFamilyTree.sortByAge();
//    }
//}
//
//
