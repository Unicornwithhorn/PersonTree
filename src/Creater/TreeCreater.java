package Creater;

import FileHandler.FileHandler;
import Tree.FamilyTree;
import Tree.SimpleTree;
import java.util.ArrayList;
import java.util.Scanner;


public class TreeCreater implements Technicable {




    public void start(){
        int choice = menuStep(1,4);
        switch (choice){
            case 1: showExistingTrees();
                break;
            case 2: createNewTree();
                break;
            case 3: System.exit(0);
                break;
        }
    }

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

    private void showExistingTrees(){ //TODO а если сохранённых деревьев нет? получается ошибка=(
        FileHandler fileHandler = new FileHandler();
        int maxIndex = (int) fileHandler.loadObject("src/SaveFiles/numberOfCurrentTrees.out");
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 1; i <= maxIndex; i++) {
            SimpleTree system = (SimpleTree) fileHandler.loadObject("src/SaveFiles/" + i + ".out");
            arrayList.add(system.getSystemId());
            System.out.println(i + ") " + system.getName() + " " + system.getClass());
        }
        System.out.println((maxIndex+1) + readText(33));
        System.out.println((maxIndex+2) + readText(34));
        System.out.println();
        System.out.println(readText(1));
        int choice = correctInput(arrayList.size()+2);
        if (choice == maxIndex+1){
            start();
        }else if(choice == maxIndex +2){
            System.exit(0);
        }else {
//            System.out.println(arrayList.get(choice-1)); //это ID выбранного дерева, он же - название файла, где оно хранится
            String linkChoosenFile = "src/SaveFiles/" + arrayList.get(choice-1) + ".out";
            SimpleTree chosenSystem = (SimpleTree) fileHandler.loadObject(linkChoosenFile);
            if (chosenSystem instanceof FamilyTree){
                TreeService treeService = new TreeService();
                treeService.workWithFamilyTree((FamilyTree) fileHandler.loadObject(linkChoosenFile));
            }else {
                System.out.println("Это что-то другое, не фэмилитри, раздел типа в разработке=)");
            }
        }
    }
}





