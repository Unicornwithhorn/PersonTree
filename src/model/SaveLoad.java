package model;

import FileHandler.FileHandler;
import systemUnit.SystemUnit;
import tree.DogTree;
import tree.FamilyTree;
import tree.SimpleTree;
import tree.SystemIdCount;
import tree.FamilyTree;
import tree.DogTree;

import java.util.ArrayList;

public interface SaveLoad <E extends SimpleTree, T extends SystemUnit> {
    FileHandler fileHandler = new FileHandler();
    default int saveNewTree(E tree){
        int newId = (int) fileHandler.loadObject("src/saveFiles/numberOfCurrentTrees.out") + 1;
        ArrayList<Integer> listOfTypes = (ArrayList<Integer>) fileHandler.loadObject("src/saveFiles/typeList.out");

//        int newId = 1;
//        ArrayList<Integer> listOfTypes = new ArrayList<>();

        tree.setSystemId(newId);
        if (tree instanceof FamilyTree){
            listOfTypes.add(1);
        }else if (tree instanceof DogTree){
            listOfTypes.add(2);
        }else {
            listOfTypes.add(0);
        }
        fileHandler.saveObject("src/saveFiles/numberOfCurrentTrees.out", newId);
        fileHandler.saveObject("src/saveFiles/typeList.out", listOfTypes);
        saveTree(tree);
        return newId;
    }
    default void saveTree(E tree){
        int filename = tree.getSystemId();
        String path = "src/saveFiles/" + filename + ".out";
        fileHandler.saveObject(path, tree);
    }

    default Object loadTree(int numberTree){
        String path = "src/saveFiles/" + numberTree + ".out";
        return fileHandler.loadObject(path);
    }
    default SimpleTree loadSimpleTree(int numberTree){ return (SimpleTree) loadTree(numberTree); }
    default FamilyTree loadFamilyTree(int numberTree){
        return (FamilyTree) loadTree(numberTree);
    }
    default DogTree loadDogTree(int numberTree){
        return (DogTree) loadTree(numberTree);
    }


}
