package systemUnit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SystemUnit <E extends SystemUnit> implements Serializable, Comparable<SystemUnit> {
    protected int id;
    protected String name;

    private List<E> progenitors;

    private List<E> descendents;

    public SystemUnit(String name) {
        id = -1;
        this.name = name;
        this.progenitors = new ArrayList<E>();
        this.descendents = new ArrayList<E>();
    }

    public List<E> getProgenitors() {
        return progenitors;
    }
    public List<E> getDescendents() {
        return descendents;
    }

    String showProgenitors(){
        if (progenitors.size() == 0){
            return "Отсутствуют";
        } else{
            StringBuilder stringBuilder = new StringBuilder();
            for (SystemUnit progenitor: progenitors){
                stringBuilder.append(progenitor.getName());
                stringBuilder.append(", ");
            }
            return stringBuilder.toString();
        }
    }
    String showDescendents(){
        if (descendents.size() == 0){
            return "Отсутствуют";
        } else{
            StringBuilder stringBuilder = new StringBuilder();
            for (SystemUnit descendent: descendents){
                stringBuilder.append(descendent.getName());
                stringBuilder.append(", ");
            }
            return stringBuilder.toString();
        }
    }

    public void addProgenitor(E progenitor) {
        if (!progenitors.contains(progenitor)) {
            progenitors.add(progenitor);
        }
    }
    public void addDescendent(E descendent) {
        if (!descendents.contains(descendent)) {
            descendents.add(descendent);
        }
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }








    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SystemUnit)) {
            return false;
        }
        SystemUnit systemUnit = (SystemUnit) obj;
//        return systemUnit.getId() == this.getId();
        return systemUnit.getName() == this.getName();
    }
    @Override
    public int compareTo(SystemUnit o) {
        return this.name.compareTo(o.name);
    }
}