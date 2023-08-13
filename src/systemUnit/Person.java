package systemUnit;

import Gender.Gender;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Person extends SystemUnit{
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private Person spouse;
    private List<Person> parents;
    private List<Person> kids;

    public Person(String name, LocalDate birthDate, LocalDate deathDate,
                  Gender gender, Person father, Person mother) {
        super(name);

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

    public Person(String name) {
        super(name);
    }
    public Person(String name, LocalDate birthDate, Gender gender) {
        this(name, birthDate, null, gender, null, null);
    }

    public Person(String name, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        this(name, birthDate, deathDate, gender, null, null);
    }

    public void setBirthDate(int year, int month, int day){
        this.birthDate = LocalDate.of(year, month, day);
    }
    public void setBirthDate(LocalDate localDate){
        this.birthDate = localDate;
    }
    public void setDeathDate(int year, int month, int day) {
        this.deathDate = LocalDate.of(year, month, day);
    }
    public void setDeathDate(LocalDate localDate) {
        this.deathDate = localDate;
    }

//    public boolean addKid(Person kid) {
//        if (!kids.contains(kid)) {
//            kids.add(kid);
//            return true;
//        }
//        return false;
//    }
//
//    public boolean addParent(Person parent) {
//        if (!parents.contains(parent)) {
//            parents.add(parent);
//            return true;
//        }
//        return false;
//    }

    public Person getFather() {
        if (parents == null) {
            return null;
        }
        for (Person parent : parents) {
            if (parent.getGender() == Gender.Male) {
                return parent;
            }
        }
        return null;
    }

    public Person getMother() {
        if (parents == null) {
            return null;
        }
        for (Person parent : parents) {
            if (parent.getGender() == Gender.Female) {
                return parent;
            }
        }
        return null;
    }

    public int getAge() {
        if (deathDate == null) {
            return getPeriod(birthDate, LocalDate.now());
        }
        return getPeriod(birthDate, deathDate);
    }

    private int getPeriod(LocalDate birthDate, LocalDate deathDate) {
        return Period.between(birthDate, deathDate).getYears();
    }

//    public String getName() {
//        return name;
//    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

//    public void setBirthDate(LocalDate birthDate) {
//        this.birthDate = birthDate;
//    }

    public LocalDate getDeathDate() {
        return deathDate;
    }


    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

//    public List<Person> getKids() {
//        return kids;
//    }
//
//    //    public void setKids() { this.kids = kids; }
//    public List<Person> getParents() {
//        return parents;
//    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public Person getSpouse() {
        return spouse;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("id ");
        res.append(id);
        res.append(", name ");
        res.append(name);
        res.append(", birthDate ");
        try {
            res.append(birthDate);
        } catch (Exception e){
            res.append("неизвестна");
        }
        res.append(", deathDate ");
        try{
            res.append(deathDate);
        } catch (Exception e){
            res.append("неизвестна");
        }
        res.append(", age ");
        try {
            res.append(getAge());
        } catch (Exception e){
            res.append("неизвестен");
        }
        res.append(", ");
        res.append("gender ");
        try {
            res.append(getGender());
        } catch (Exception e){
            res.append("неизвестен");
        }
        res.append(", ");
        res.append(getSpouseInfo());
        res.append(", Родители - ");
        res.append(showProgenitors());
        res.append(", Дети");
        res.append(showDescendents());
        return res.toString();
    }

    public String getSpouseInfo() {
        String res = "Супруг(а): ";
        if (spouse != null) {
            res += spouse.getName();
        } else {
            res += "нет";
        }
        return res;
    }

//    public String getMotherInfo() {
//        Person mother = getMother();
//        String res = "Мать: ";
//        if (mother != null) {
//            res += mother.getName();
//        } else {
//            res += "неизвестна";
//        }
//        return res;
//    }
//
//    public String getFatherInfo() {
//        Person father = getFather();
//        String res = "Отец: ";
//        if (father != null) {
//            res += father.getName();
//        } else {
//            res += "неизвестен";
//        }
//        return res;
//    }

    public String getKidsInfo() {
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (kids.size() != 0) {
            for (int i = 0; i < kids.size(); i++) {
                res.append(kids.get(i).getName());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }



//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (!(obj instanceof Person)) {
//            return false;
//        }
//        Person person = (Person) obj;
////        return person.getId() == this.getId();
//        return person.getName() == this.getName();
//    }
//
//    @Override
//    public int compareTo(Person o) {
//        return this.name.compareTo(o.name);
//    }
}



