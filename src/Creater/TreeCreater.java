package Creater;

import FileHandler.FileHandler;
import Tree.FamilyTree;
import Tree.SimpleTree;

import java.util.ArrayList;


public class TreeCreater implements Technicable {


    private void createNewTree(){
        int choice = menuStep(5,12);
        TreeService treeService = new TreeService();
        switch (choice){
            case 1: treeService.createNewTreeOfPerson();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6: start();
                break;
            case 7: System.exit(0);
                break;
        }
    }


}





