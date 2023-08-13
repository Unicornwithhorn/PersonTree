package presenter;

import Gender.Gender;
import model.TreeService;
import view.ConsoleUI;

import java.time.LocalDate;
import java.util.ArrayList;

public class Presenter {

    private TreeService treeService;
    private ConsoleUI consoleUI;

    public Presenter(ConsoleUI consoleUI){
        this.consoleUI = consoleUI;
        treeService = new TreeService();
    }
    public void setConsoleUI(ConsoleUI consoleUI){ this.consoleUI = consoleUI; }
    public ArrayList<String> showExistingTrees(){ return treeService.showExistingTrees(); }
//    public void choiceTree(ArrayList arrayList){ consoleUI.choiceTree(arrayList); }
    public void choiceTree(int choice){ consoleUI.choiceTree(choice); }
    public int createNewFamilyTree(){
        return treeService.createNewFamilyTree();
    }
    public int createNewDogTree(){
        return treeService.createNewDogTree();
    }
    public void setTreeName(int newFamilyTreeId, String treeName){
        treeService.setTreeName(newFamilyTreeId, treeName);
    }
    public void addNewPerson(int numberTree, String personName, LocalDate birthDate, LocalDate deathDate, int genderChoice ){
        treeService.createNewPerson(numberTree, personName, birthDate, deathDate, genderChoice);
    }
    public String viewTree(int numberTree){ return treeService.viewTree(numberTree); }
    public int getNumberUnits(int numberTree){ return treeService.getNumberUnits(numberTree); }
    public int setWedding(int numberTree, int choice1, int choice2){
        return treeService.setWedding(numberTree, choice1, choice2);
    }
    public int addProgenitorDescendentRelationship(int numberOfTree, int parentId, int childId){
        return treeService.addProgenitorDescendentRelationship(numberOfTree,parentId, childId);
    }

    public String getNameUnit(int numberOfTree, int numberOfUnit){ return treeService.getNameUnit(numberOfTree, numberOfUnit);};
    public boolean setDivorce(int numberTree, int choice1, int choice2){
        return treeService.setDivorce(numberTree, choice1, choice2);
    }

    public void changeBirthDate(int numberOfTree, int numberOfPerson, LocalDate newBirthDate) {
        treeService.changeBirthDate(numberOfTree, numberOfPerson, newBirthDate);
    }
    public void changeDeathDate(int numberOfTree, int numberOfPerson, LocalDate newDeathDate) {
        treeService.changeDeathDate(numberOfTree, numberOfPerson, newDeathDate);
    }
    public void changeGender(int numberOfTree, int numberOfPerson, int genderChoice) {
        treeService.changeGender(numberOfTree, numberOfPerson, genderChoice);
    }
    public void changeName(int numberOfTree, int numberOfPerson, String personName){
        treeService.changeName(numberOfTree, numberOfPerson, personName);
    }







}
