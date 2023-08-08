/*реализовать:
изменить данные человека (имя, год рождения и т.д.)
создать связь родитель ребёнок
разорвать связь родитель ребёнок
удалить человека
показать полную информацию про человека
упорядочить список людей (по возрасту или имени)
пакеты с маленькой буквы
замечания в ответах на дз
*/
package Creater;

import View.Technicable;
import Gender.Gender;
import SystemUnit.Person;
import Tree.FamilyTree;
import FileHandler.FileHandler;
import Tree.SimpleTree;
import presenter.Presenter;
import java.util.ArrayList;

public class TreeService implements Technicable {
    Presenter presenter;

    public TreeService(Presenter presenter) {
        this.presenter = presenter;
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

    public ArrayList<SimpleTree> showExistingTrees() {
        FileHandler fileHandler = new FileHandler();
        int maxIndex = (int) fileHandler.loadObject("src/SaveFiles/numberOfCurrentTrees.out");
        ArrayList<SimpleTree> arrayList = new ArrayList<>();
        for (int i = 1; i <= maxIndex; i++) {
            SimpleTree system = (SimpleTree) fileHandler.loadObject("src/SaveFiles/" + i + ".out");
            arrayList.add(system);
        }
        return arrayList;
    }

    public void createNewTree(String name) {
        FamilyTree familyTree = new FamilyTree();
        FileHandler fileHandler = new FileHandler();
        int newId = (int) fileHandler.loadObject("src/SaveFiles/numberOfCurrentTrees.out") + 1;
//        int newId = 1;
        familyTree.setSystemId(newId);
        fileHandler.saveObject("src/SaveFiles/numberOfCurrentTrees.out", newId);
        familyTree.setName(name);
        System.out.println(readText(31) + " " + name);
        String path = "src/SaveFiles/" + newId + ".out";
        fileHandler.saveObject(path, familyTree);
    }

    public int setWedding(FamilyTree familyTree, int choice1, int choice2) {
        return familyTree.setWedding(choice1, choice2);
    }

    public boolean setDivorce(FamilyTree familyTree, int choice1, int choice2) {
        return familyTree.setDivorce(choice1, choice2);
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

    //    public void workWithFamilyTree(FamilyTree familyTree){
//        int choice = menuStep(14,23);
//        FileHandler fileHandler = new FileHandler();
//        int filename;
//        String path = new String();
//        switch (choice){
//            case 1: createNewPerson(familyTree);
//                break;
//            case 2:
//                break;
//            case 3: System.out.println(familyTree);
//                System.out.println(familyTree.setWedding());
//
//                filename = familyTree.getSystemId();
//                path = "src/SaveFiles/" + filename + ".out";
//                fileHandler.saveObject(path, familyTree);
//
//                break;
//            case 4: System.out.println(familyTree);
//                familyTree.setDivorce();
//                filename = familyTree.getSystemId();
//                path = "src/SaveFiles/" + filename + ".out";
//                fileHandler.saveObject(path, familyTree);
//                break;
//            case 5:
//                break;
//            case 6:
//                break;
//            case 7: System.out.println(familyTree);
//                break;
//            case 8: TreeCreater treeCreater = new TreeCreater();
//                treeCreater.start();
//                break;
//            case 9: System.exit(0);
//                break;
//        }
//        if (choice!=9) {
//            workWithFamilyTree(familyTree);
//        }
//    }
    public void createNewPerson(FamilyTree familyTree, String personName, int birthYear, int birthMonth, int birthDay,
                                int deathYear, int deathMonth, int deathDay, int genderChoice) {
        Person person = new Person(personName);
        if (birthYear != 0) {
            person.setBirthDate(birthYear, birthMonth, birthDay);
        }
        if (deathYear != 0) {
            person.setDeathDate(deathYear, deathMonth, deathDay);
        }
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

    public void viewTree(FamilyTree familyTree) {
        System.out.println(familyTree);
    }
}


//    public void sortByName(){
//        currentFamilyTree.sortByName();
//    }
//
//    public void sortByAge(){
//        currentFamilyTree.sortByAge();
//    }
//}

