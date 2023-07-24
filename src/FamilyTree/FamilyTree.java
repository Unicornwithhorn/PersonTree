package FamilyTree;

import Person.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FamilyTree {
    int personId;
    private List<Person> personList;
    public FamilyTree(ArrayList<Person> personList){ this.personList = personList; }
    public FamilyTree(){ this (new ArrayList<>());}



    public void addPerson(Person person) {
        if (person == null) {
            return;
        }
        if (!personList.contains(person)) {
            personList.add(person);
            person.setId(++personId);
            addToParents(person);
            addToKids(person);
        }
    }
//TODO тестовый туду комментарий
    private void addToParents(Person person){
        for (Person parent: person.getParents()){
            parent.addKid(person);
        }
    }

    private void addToKids(Person person){
        for (Person kid: person.getKids()){
            kid.addParent(person);
        }
    }

    public List<Person> getSiblings(int id){
        Person person = getById(id);
        if (person == null){
            return null;
        }
        List<Person> res = new ArrayList<Person>();
        for(Person parent: person.getParents()){
            for(Person kid: parent.getKids()){
                if(!kid.equals(person) && !res.contains(kid)){
                    res.add(kid);
                }
            }
        }
        return res;
    }

    public void printSiblings(int id){
        List<Person> siblings =  getSiblings(id);
        if (siblings.size()==0){
            System.out.println("Братьев и сестёр у " + getById(id).getName() + " не обнаружено");
        } else {
            System.out.println("Список братьев и сестёр человека по имени " + getById(id).getName());
            for (Person person: siblings){
                System.out.println(person.getId() + " " + person.getName());
            }
        }
    }

    public Person getById(int id){
        for (Person person: personList){
            if (person.getId() == id){
                return person;
            }
        }
        return null;
    }

    public boolean setWedding(Person person1, Person person2){
        if(person1.getSpouse() == null && person2.getSpouse() == null){
            person1.setSpouse(person2);
            person2.setSpouse(person1);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean setDivorce(Person person1, Person person2){
        boolean divorse1 = false;
        boolean divorse2 = false;
        if (person1.getSpouse().equals(person2)){
            person1.setSpouse(null);
            divorse1 = true;
        }
        if (person1.getSpouse().equals(person2)) {
            person1.setSpouse(null);
            divorse2 = true;
        }
        return divorse1 || divorse2;
    }

    public boolean remove (Person person){
        if (personList.contains(person)){
            personList.remove(person.getId()-1);
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        StringBuilder forPrint = new StringBuilder();
        for (Person person: this.personList){
            forPrint.append(person);
            forPrint.append("\n");
        }

        return forPrint.toString();
    }

    public String showTree(){
        return  personList.toString();
    }
}
