package Tree;

import SystemUnit.SystemUnit;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import SystemUnit.ComparatorNames;

public abstract class System <E extends SystemUnit> implements Serializable, Iterable<E>{
//    public static PrintStream out;
        String name;
        int elementId = 0;
        private ArrayList<E> systemUnitList; //изначально стоял просто list
        public System(ArrayList<E> systemUnitList){ this.systemUnitList = systemUnitList; }
        public System(){ this.systemUnitList = new ArrayList<E>();}
        public void setName(String name){
            this.name = name;
        }


        public void addSystemUnit(E systemUnit) {
            if (systemUnit == null) {
                return;
            }
            if (!systemUnitList.contains(systemUnit)) {
                systemUnitList.add(systemUnit);
                systemUnit.setId(++elementId);
                addToProgenitors(systemUnit);
                addToDescendents(systemUnit);
            }
        }
        public int getId() {
        return elementId;
    }

        public void setId(int id) {
        this.elementId = id;
    }

        /**метод, добавляющий ко всем потомкам данной единицы системы эту единицу системы как предка
         *
         */
        public void addToDescendents(E systemUnit){
            for (E unit: this.systemUnitList){
                if (unit.getProgenitors().contains(systemUnit)) {
                    systemUnit.addDescendent(unit);
                }
            }
        }
        /**метод, добавляющий ко всем предкам данной единицы системы эту единицу системы как потомка
         *
         */
        public void addToProgenitors(E systemUnit) {
            for (E unit : this.systemUnitList) {
                if (unit.getDescendents().contains(systemUnit)) {
                    systemUnit.addProgenitor(unit);
                }
            }
        }
        @Override
        public Iterator<E> iterator() {
            return systemUnitList.iterator();
        }

        public void sortByName(){
            Collections.sort(systemUnitList, new ComparatorNames());
        }

        public void remove (E systemUnit){
            if (systemUnitList.contains(systemUnit)){
                systemUnitList.remove(systemUnit.getId()-1);
            }
        }
//        public void sortByAge(){
//            Collections.sort(systemUnitList, new ComparatorAges());
//        }
//        public List<Person> getSiblings(int id){
//            Person systemUnit = getById(id);
//            if (systemUnit == null){
//                return null;
//            }
//            List<Person> res = new ArrayList<>();
//            for(Person progenitor: systemUnit.getProgenitors()){
//                for(Person descendent: progenitor.getDescendens()){
//                    if(!descendent.equals(systemUnit) && !res.contains(descendent)){
//                        res.add(descendent);
//                    }
//                }
//            }
//            return res;
//        }
//
//        ОТСЮДА!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//        public void printSiblings(int id){
//            List<Person> siblings =  getSiblings(id);
//            if (siblings.size()==0){
//                java.lang.Tree.System.out.println("Братьев и сестёр у " + getById(id).getName() + " не обнаружено");
//            } else {
//                java.lang.Tree.System.out.println("Список братьев и сестёр человека по имени " + getById(id).getName());
//                for (Person person: siblings){
//                    java.lang.Tree.System.out.println(person.getId() + " " + person.getName());
//                }
//            }
//        }
//
//        public Person getById(int id){
//            for (Person person: personList){
//                if (person.getId() == id){
//                    return person;
//                }
//            }
//            return null;
//        }
//
//        public boolean setWedding(Person person1, Person person2){
//            if(person1.getSpouse() == null && person2.getSpouse() == null){
//                person1.setSpouse(person2);
//                person2.setSpouse(person1);
//                return true;
//            }
//            else {
//                return false;
//            }
//        }
//
//        public boolean setDivorce(Person person1, Person person2){
//            boolean divorse1 = false;
//            boolean divorse2 = false;
//            if (person1.getSpouse().equals(person2)){
//                person1.setSpouse(null);
//                divorse1 = true;
//            }
//            if (person1.getSpouse().equals(person2)) {
//                person1.setSpouse(null);
//                divorse2 = true;
//            }
//            return divorse1 || divorse2;
//        }
//

//
//
//        @Override
//        public String toString() {
//            StringBuilder forPrint = new StringBuilder();
//            for (Person person: this.personList){
//                forPrint.append(person);
//                forPrint.append("\n");
//            }
//
//            return forPrint.toString();
//        }
//
////        public String showTree(){
////            return  personList.toString();
////        }
//

//
//    }

}
