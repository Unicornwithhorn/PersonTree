package FileHandler;

import Tree.SimpleTree;

import java.io.*;

public class FileHandler <T extends SimpleTree> implements Writeable{
    @Override
    public void saveObject(String path, Object object) {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream( new FileOutputStream(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            objectOutputStream.writeObject(object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    @Override
//    public void saveTree(String path, System system) {
//        ObjectOutputStream objectOutputStream = null;
//        try {
//            objectOutputStream = new ObjectOutputStream( new FileOutputStream(path));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            objectOutputStream.writeObject(system);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            objectOutputStream.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }



//    @Override
//    public FamilyTree loadTree(String path) {
//        ObjectInputStream objectInputStream = null;
//        FamilyTree familyTree = new FamilyTree();
//        try {
//            objectInputStream = new ObjectInputStream(new FileInputStream(path));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            familyTree = (FamilyTree) objectInputStream.readObject();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            objectInputStream.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return familyTree;
//    }
    @Override
    public Object loadObject(String path) {
        ObjectInputStream objectInputStream = null;
        Object object = new Object();
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            object = objectInputStream.readObject();
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
        return object;
    }

}
