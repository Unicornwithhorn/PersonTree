package presenter;

import model.TreeService;
import view.ConsoleUI;

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
    public void createNewTree(String name){
        treeService.createNewTree(name);
    }
    public void addNewPerson(int numberTree, String personName, int birthYear, int birthMonth, int birthDay,
                             int deathYear, int deathMonth, int deathDay, int genderChoice ){
        treeService.createNewPerson(numberTree, personName, birthYear, birthMonth, birthDay,
                deathYear, deathMonth, deathDay, genderChoice);
    }
    public String viewTree(int numberTree){ return treeService.viewTree(numberTree); }
    public int getNumberUnits(int numberTree){ return treeService.getNumberUnits(numberTree); }
    public int setWedding(int numberTree, int choice1, int choice2){
        return treeService.setWedding(numberTree, choice1, choice2);
    }

    public String getNameUnit(int numberOfTree, int numberOfUnit){ return treeService.getNameUnit(numberOfTree, numberOfUnit);};
    public boolean setDivorce(int numberTree, int choice1, int choice2){
        return treeService.setDivorce(numberTree, choice1, choice2);
    }







}
