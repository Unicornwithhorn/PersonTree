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
package model;

import systemUnit.SystemUnit;
import tree.DogTree;
//import model.SaveLoad;
import view.Technicable;
import Gender.Gender;
import systemUnit.Person;
import tree.FamilyTree;
import FileHandler.FileHandler;
import tree.SimpleTree;

import java.time.LocalDate;
import java.util.ArrayList;

public class TreeService implements SaveLoad {
    FileHandler fileHandler;
    public TreeService() {
        this.fileHandler = new FileHandler();
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


    public ArrayList<String> showExistingTrees() {
        FileHandler fileHandler = new FileHandler();
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            int maxIndex = (int) fileHandler.loadObject("src/saveFiles/numberOfCurrentTrees.out");
            for (int i = 1; i <= maxIndex; i++) {
                arrayList.add(pairNameTypeTreeCreater(loadSimpleTree(i)));
            }
        }catch (Exception e){
            return arrayList;
        }
        return arrayList;
    }

    private String pairNameTypeTreeCreater(SimpleTree simpleTree){
        return simpleTree.getName() + " " + simpleTree.getClass();
    }

    public void setTreeName(int newFamilyTreeId, String treeName){
        SimpleTree<SystemUnit> tree = loadSimpleTree(newFamilyTreeId);
        tree.setName(treeName);
        saveTree(tree);
    }

    public int setWedding(int numberTree, int choice1, int choice2) {
        return (loadFamilyTree(numberTree)).setWedding(choice1, choice2);
    }

    public int addProgenitorDescendentRelationship(int numberOfTree, int progenitorId, int descendentId){
        ArrayList<Integer> listOfTypes = (ArrayList<Integer>) fileHandler.loadObject("src/saveFiles/typeList.out");
        int result = 0;
        switch (listOfTypes.get(numberOfTree-1)){
            case 1: FamilyTree familyTree = loadFamilyTree(numberOfTree);
                result = familyTree.addProgenitorDescendentRelationship(
                    familyTree.getById(progenitorId),
                    familyTree.getById(descendentId));
                    saveTree(familyTree);
                    break;
            case 2: DogTree dogTree = loadDogTree(numberOfTree);
                result = dogTree.addProgenitorDescendentRelationship(
                        dogTree.getById(progenitorId),
                        dogTree.getById(descendentId));
                saveTree(dogTree);
                break;
        }
        return result;
    }

    public boolean setDivorce(int numberTree, int choice1, int choice2) {
        return ((FamilyTree) loadTree(numberTree)).setDivorce(choice1, choice2);
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
    //перенёс
//    public <T> T loadTree(int numberTree){
//        String path = "src/saveFiles/" + numberTree + ".out";
//        try {
//            ArrayList<Integer> listOfTypes = (ArrayList<Integer>) fileHandler.loadObject("src/saveFiles/typeList.out");
//            return (E) fileHandler.loadObject(path);
//        } catch ()
//    }
    //    public <E extends SimpleTree> E loadTree(int numberTree){
//        String path = "src/saveFiles/" + numberTree + ".out";
//        ArrayList<Integer> listOfTypes = (ArrayList<Integer>) fileHandler.loadObject("src/saveFiles/typeList.out");
//        FamilyTree familyTree = (FamilyTree) fileHandler.loadObject(path);
//        return switch (listOfTypes.get(numberTree - 1)) {
//            case 1 -> familyTree;
//            case 2 -> (DogTree) fileHandler.loadObject(path);
//            default -> null;
//        };
//    }

    public int createNewFamilyTree() {
        FamilyTree familyTree = new FamilyTree();
        return saveNewTree(familyTree);
    }
    public int createNewDogTree() {
        DogTree dogTree = new DogTree();
        return saveNewTree(dogTree);
    }

    //перенёс
//    public <E extends SimpleTree> int saveNewTree(E tree){
//        FileHandler fileHandler = new FileHandler();
//
//        int newId = (int) fileHandler.loadObject("src/saveFiles/numberOfCurrentTrees.out") + 1;
//        ArrayList<Integer> listOfTypes = (ArrayList<Integer>) fileHandler.loadObject("src/saveFiles/typeList.out");
//
////        int newId = 1;
////        ArrayList<Integer> listOfTypes = new ArrayList<>();
//
//        tree.setSystemId(newId);
//        if (tree instanceof FamilyTree){
//            listOfTypes.add(1);
//        }else if (tree instanceof DogTree){
//            listOfTypes.add(2);
//        }
//        fileHandler.saveObject("src/saveFiles/numberOfCurrentTrees.out", newId);
//        fileHandler.saveObject("src/saveFiles/typeList.out", listOfTypes);
//        saveTree(tree);
//        return newId;
//    }
    //перенёс
//    public <E extends SystemIdCount> void saveTree (E tree){
//        int filename = tree.getSystemId();
//        String path = "src/saveFiles/" + filename + ".out";
//        fileHandler.saveObject(path, tree);
//    }

    public int getNumberUnits(int numberTree){ return loadSimpleTree(numberTree).getId();}

    public String getNameUnit(int numberOfTree, int numberOfUnit){
        return (loadSimpleTree(numberOfTree).getById(numberOfUnit)).getName();
    }


    public String viewTree(int numberTree) {
        return loadSimpleTree(numberTree).toString();
    }

    public void createNewPerson(int numberTree, String personName, LocalDate birthDate, LocalDate deathDate, int genderChoice) {
        Person person = new Person(personName);
        FamilyTree familyTree = (FamilyTree) loadTree(numberTree);
        familyTree.addSystemUnit(person);
        saveTree(familyTree);
        int unitId = person.getId();
        changeBirthDate(numberTree, unitId, birthDate);
        changeDeathDate(numberTree, unitId, deathDate);
        changeGender(numberTree, unitId, genderChoice);
    }
    public void changeBirthDate(int numberOfTree, int numberOfPerson, LocalDate newBirthDate) {
        FamilyTree familyTree = (FamilyTree) loadTree(numberOfTree);
        Person currentPerson = (Person)(familyTree).getById(numberOfPerson);
        currentPerson.setBirthDate(newBirthDate);
        saveTree(familyTree);
    }

    public void changeDeathDate(int numberOfTree, int numberOfPerson, LocalDate newDeathDate) {
        FamilyTree familyTree = (FamilyTree) loadTree(numberOfTree);
        Person currentPerson = (Person)(familyTree).getById(numberOfPerson);
        currentPerson.setDeathDate(newDeathDate);
        saveTree(familyTree);
    }

    public void changeGender(int numberOfTree, int numberOfPerson, int genderChoice) {
        FamilyTree familyTree = (FamilyTree) loadTree(numberOfTree);
        Person currentPerson = (Person)(familyTree).getById(numberOfPerson);
        switch (genderChoice) {
            case 1 -> currentPerson.setGender(Gender.Male);
            case 2 -> currentPerson.setGender(Gender.Female);
        }
        saveTree(familyTree);
    }
    public void changeName(int numberOfTree, int numberOfPerson, String personName){
        FamilyTree familyTree = (FamilyTree) loadTree(numberOfTree);
        Person currentPerson = (Person)(familyTree).getById(numberOfPerson);
        currentPerson.setName(personName);
        saveTree(familyTree);
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

