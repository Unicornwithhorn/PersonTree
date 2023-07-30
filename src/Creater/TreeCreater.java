package Creater;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class TreeCreater implements Technicable {




    public void createTree(){

        int choice = menuStep(1,4);
//        MenuForChoice menuForChoice = new MenuForChoice();
        switch (choice){
            case 1: showExistingTrees();
                break;
            case 2: createNewTree();
                break;
            case 3: break;
        }
    }

    private void createNewTree(){
        int choice = menuStep(5,12);
        TreeService treeService = new TreeService();
        switch (choice){
            case 1: treeService.createNewTreeOfPerson();
                break;
            case 2: createNewTree();
                break;
            case 3: showExistingTrees();
                break;
            case 4: showExistingTrees();
                break;
            case 5: showExistingTrees();
                break;
            case 6: createTree();
                break;
            case 7: break;
        }
    }

    private void showExistingTrees(){
        System.out.println("Уняня!");
    }
}





