package FileHandler;

import FamilyTree.FamilyTree;

import java.io.Serializable;

public interface Writeable {

    void saveTree(String path, FamilyTree tree);

    FamilyTree loadTree(String path);
}
