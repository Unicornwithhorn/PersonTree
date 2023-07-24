package Person;

import Gender.Gender;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Person implements Serializable {
    private int id;
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private Person spouse;
    private List<Person> parents;
    private List<Person> kids;

    public Person(String name, LocalDate birthDate, LocalDate deathDate,
                  Gender gender, Person father, Person mother) {
        id = -1;
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.parents = new ArrayList<>();
        if (father != null) {
            parents.add(father);
        }
        if (mother != null) {
            parents.add(mother);
        }
        kids = new ArrayList<Person>();
    }

    public Person(String name, LocalDate birthDate, Gender gender) {
        this(name, birthDate, null, gender, null, null);
    }

    public Person(String name, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        this(name, birthDate, deathDate, gender, null, null);
    }

    public boolean addKid(Person kid) {
        if (!kids.contains(kid)) {
            kids.add(kid);
            return true;
        }
        return false;
    }

    public boolean addParent(Person parent) {
        if (!parents.contains(parent)) {
            parents.add(parent);
            return true;
        }
        return false;
    }

    public Person getFather() {
        for (Person parent : parents) {
            if (parent.getGender() == Gender.Male) {
                return parent;
            }
        }
        return null;
    }

    public Person getMother() {
        for (Person parent : parents) {
            if (parent.getGender() == Gender.Female) {
                return parent;
            }
        }
        return null;
    }

    public int getAge(){
        if (deathDate == null){
            return getPeriod(birthDate, LocalDate.now());
        }
        return getPeriod(birthDate, deathDate);
    }

    private int getPeriod(LocalDate birthDate, LocalDate deathDate) {
        return Period.between(birthDate, deathDate).getYears();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
    public LocalDate getDeathDate() { return deathDate; }
    public void setDeathDate(LocalDate deathDate) { this.deathDate = deathDate; }
    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = gender; }
    public List<Person> getKids() { return kids; }
//    public void setKids() { this.kids = kids; }
    public List<Person> getParents() { return parents; }
    public void setSpouse(Person spouse) {this.spouse = spouse; }
    public Person getSpouse() { return spouse; }
    public int getId() {return id;}
    public void  setId(int id){ this.id = id;}

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("id ");
        res.append(id);
        res.append(", name ");
        res.append(name);
        res.append(", birthDate ");
        res.append(birthDate);
        res.append(", deathDate ");
        res.append(deathDate);
        res.append(", age");
        res.append(getAge());
        res.append(", ");
        res.append(getSpouseInfo());
        res.append(", ");
        res.append(getMotherInfo());
        res.append(", ");
        res.append(getFatherInfo());
        res.append(", ");
        res.append(getKidsInfo());
        return res.toString();
    }

    public String getSpouseInfo(){
        String res = "Супруг(а): ";
        if (spouse != null){
            res += spouse.getName();
        }
        else {
            res += "нет";
        }
        return res;
    }

    public String getMotherInfo(){
        Person mother = getMother();
        String res = "Мать: ";
        if (mother != null){
            res += mother.getName();
        }
        else {
            res += "неизвестна";
        }
        return res;
    }

    public String getFatherInfo(){
        Person father = getFather();
        String res = "Отец: ";
        if (father != null){
            res += father.getName();
        }
        else {
            res += "неизвестен";
        }
        return res;
    }

    public String getKidsInfo(){
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (kids.size() != 0){
            for (int i = 0; i < kids.size(); i++) {
                res.append(kids.get(i).getName());
            }
        }
        else {res.append("отсутствуют");}
        return res.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Person)) {
            return false;
        }
        Person person = (Person) obj;
//        return person.getId() == this.getId();
        return person.getName() == this.getName();
    }
}


