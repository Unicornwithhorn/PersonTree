package presenter;

import Creater.TreeService;
import Tree.FamilyTree;
import Tree.SimpleTree;
import View.View;
import View.ConsoleUI;

import java.util.ArrayList;

public class Presenter {

    private View view;
    private TreeService treeService;
    private ConsoleUI consoleUI;

    public Presenter(View view){
        this.view = view;
        treeService = new TreeService(this);
    }
    public void setConsoleUI(ConsoleUI consoleUI){ this.consoleUI = consoleUI; }
    public ArrayList<SimpleTree> showExistingTrees(){ return treeService.showExistingTrees(); }
    public void choiceTree(ArrayList arrayList){ consoleUI.choiceTree(arrayList); }
    public void createNewTree(String name){
        treeService.createNewTree(name);
    }
    public void addNewPerson(FamilyTree familyTree, String personName, int birthYear, int birthMonth, int birthDay,
                             int deathYear, int deathMonth, int deathDay, int genderChoice ){
        treeService.createNewPerson(familyTree, personName, birthYear, birthMonth, birthDay,
                deathYear, deathMonth, deathDay, genderChoice);
    }
    public void viewTree(FamilyTree familyTree){ treeService.viewTree(familyTree); }
    public int setWedding(FamilyTree familyTree, int choice1, int choice2){
        return treeService.setWedding(familyTree, choice1, choice2);
    }
    public boolean setDivorce(FamilyTree familyTree, int choice1, int choice2){
        return treeService.setDivorce(familyTree, choice1, choice2);
    }







}
