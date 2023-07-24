package FileHandler;

import FamilyTree.FamilyTree;

import java.io.*;

public class FileHandler implements Writeable{
    @Override
    public void saveTree(String path, FamilyTree tree) {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream( new FileOutputStream(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            objectOutputStream.writeObject(tree);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public FamilyTree loadTree(String path) {
        ObjectInputStream objectInputStream = null;
        FamilyTree familyTree = new FamilyTree();
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            familyTree = (FamilyTree) objectInputStream.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            objectInputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return familyTree;
    }
}
