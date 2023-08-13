package tree;
import FileHandler.FileHandler;
import view.Technicable;
import systemUnit.Person;
import systemUnit.SystemUnit;

import java.util.ArrayList;

public class FamilyTree extends SimpleTree implements Technicable {

    public FamilyTree() {
        this.systemUnitList = new ArrayList<Person>();
    }

    public int setWedding(int choice1, int choice2) {
        FileHandler fileHandler = new FileHandler();
        Person person1 = (Person) getById(choice1);
        Person person2 = (Person) getById(choice2);
        if (person1.getSpouse() == person2) {
            return 1;//"Эти люди уже женаты!";
        } else if (person1.getSpouse() != null) {
            return 2; //"Увы! " + person1.getName() + " уже находится в браке! ";
        } else if (person2.getSpouse() != null) {
            return 3; //"Увы! " + person2.getName() + " уже находится в браке! ";
        } else {
            person1.setSpouse(person2);
            person2.setSpouse(person1);
            String path = "src/SaveFiles/" + systemId + ".out";
            fileHandler.saveObject(path, this);
            return 4; //"Счастья молодым! Поздравляем следующих людей: " + person1.getName() + " и " + person2.getName();
        }
    }
    public boolean setDivorce(int choice1, int choice2){
        FileHandler fileHandler = new FileHandler();
        Person person1 = (Person) getById(choice1);
        Person person2 = (Person) getById(choice2);
        if (person1.getSpouse().equals(person2)){
            person1.setSpouse(null);
            person2.setSpouse(null);
            String path = "src/SaveFiles/" + systemId + ".out";
            fileHandler.saveObject(path, this);
            return true;
            //"Развод успешно завершён. " + person1.getName() + " и " + person2.getName() + " свободны."
        }else {
            return false;
            //"Эти люди и не были в браке"
        }


    }

//    public FamilyTree(ArrayList<Person> personList){
//        super(ArrayList<E>);
//        this.personList = personList;
//    }
//    public FamilyTree(){ this (new ArrayList<Person>);}



//    public List<Person> getSiblings(int id){
//        Person person = getById(id);
//        if (person == null){
//            return null;
//        }
//        List<Person> res = new ArrayList<Person>();
//        for(Person parent: person.getParents()){
//            for(Person kid: parent.getKids()){
//                if(!kid.equals(person) && !res.contains(kid)){
//                    res.add(kid);
//                }
//            }
//        }
//        return res;
//    }
//    public void printSiblings(int id){
//        List<Person> siblings =  getSiblings(id);
//        if (siblings.size()==0){
//            Tree.System.out.println("Братьев и сестёр у " + getById(id).getName() + " не обнаружено");
//        } else {
//            Tree.System.out.println("Список братьев и сестёр человека по имени " + getById(id).getName());
//            for (Person person: siblings){
//                Tree.System.out.println(person.getId() + " " + person.getName());
//            }
//        }
//    }



//

//
////    public boolean remove (Person person){
////        if (personList.contains(person)){
////            personList.remove(person.getId()-1);
////            return true;
////        }
////        return false;
////    }
//
//
////    @Override
////    public String toString() {
////        StringBuilder forPrint = new StringBuilder();
////        for (Person person: this.personList){
////            forPrint.append(person);
////            forPrint.append("\n");
////        }
////
////        return forPrint.toString();
////    }
//
////    public String showTree(){
////        return  personList.toString();
////    }
//
////    @Override
////    public Iterator<Person> iterator() {
////        return personList.iterator();
////    }
//
////    public void sortByName(){
////        Collections.sort(personList, new ComparatorNames());
////    }
////    public void sortByAge(){
////        Collections.sort(systemUnitList, new ComparatorAges());
////    }
//
}
