import FamilyTree.FamilyTree;
import Person.Person;

import java.util.ArrayList;
import java.util.List;

public class TreeService {
    private List<FamilyTree> listTree;
    private FamilyTree currentFamilyTree;

    public TreeService(FamilyTree currenrFamilyTree) {
        this.listTree = new ArrayList<>();
        this.currentFamilyTree = currenrFamilyTree;
    }

    public void addTreeToService(FamilyTree newTree){
        listTree.add(newTree);
    }

    public void addPersonInCurrentTree (Person person){
        currentFamilyTree.addPerson(person);
    }

    public String currentTreeInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Person person : currentFamilyTree) {
            stringBuilder.append(person);
            stringBuilder.append("\n");
        }
    return stringBuilder.toString();
    }

    public void sortByName(){
        currentFamilyTree.sortByName();
    }

    public void sortByAge(){
        currentFamilyTree.sortByAge();
    }
}


