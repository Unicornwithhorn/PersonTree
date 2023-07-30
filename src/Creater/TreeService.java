package Creater;

//import FamilyTree.FamilyTree;

import SystemUnit.Person;
import Tree.FamilyTree;

import java.util.Scanner;

public class TreeService implements Technicable{
    Scanner scanner = new Scanner(System.in);
    public void createNewTreeOfPerson(){
        System.out.println(readText(13));
        FamilyTree familyTree = new FamilyTree();
        familyTree.setName(scanner.nextLine());
        workWithFamilyTree(familyTree);
    }

    private void workWithFamilyTree(FamilyTree familyTree){
        int choice = menuStep(14,23);
        switch (choice){
            case 1: createNewPerson(familyTree);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9: break;
        }
        System.out.println("Done!");
        if (choice!=9) {
            workWithFamilyTree(familyTree);
        }
    }
    private void createNewPerson(FamilyTree familyTree) {
        System.out.println(readText(24));
        Person person = new Person(scanner.nextLine());
        System.out.println(readText(25));
        int year = scanner.nextInt();
        if (year!=0) {
            System.out.println(readText(26));
            int month = scanner.nextInt();
            System.out.println(readText(27));
            int day = scanner.nextInt();
            person.getBirthDate(year,month,day);
        }
        System.out.println(readText(28));
        int year2 = scanner.nextInt();
        if (year2!=0) {
            System.out.println(readText(29));
            int month2 = scanner.nextInt();
            System.out.println(readText(30));
            int day2 = scanner.nextInt();
            person.getBirthDate(year2,month2,day2);
        }
        familyTree.addSystemUnit(person);
        String path = "src/SaveTree.out";
        FileHandler fileHandler = new FileHandler();
        FileForSave fileForSave = new FileForSave();
        System.out.println("Добавлен новый человек:");

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
