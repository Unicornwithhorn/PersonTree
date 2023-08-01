package FileHandler;

import Tree.SimpleTree;

public interface Writeable /*<T extends System>*/{

//    void saveTree(String path, T tree);
    void saveObject(String path, Object object);

//    Object loadTree(String path);
    Object loadObject(String path);
}
