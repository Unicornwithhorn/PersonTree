//package SaveData;
//
//import FamilyTree.FamilyTree;
//import Gender.Gender;
//import Person.Person;
//import java.time.LocalDate;
//
//public class DataFileOne extends DataFile {
//
//    public FamilyTree giveDataForSave() {
//        FamilyTree familyTree = new FamilyTree();
//        Person semen = new Person("Семён Поздняков", LocalDate.of(1965, 4, 23),
//                LocalDate.of(1999, 9, 12), Gender.Male);
//        Person larisa = new Person("Лариса Позднякова", LocalDate.of(1967, 9, 1), Gender.Female);
//        Person nikifor = new Person("Никифор Поздняков", LocalDate.of(1993, 2, 11), Gender.Male);
//        Person pavel = new Person("Павел Перенуфай-Корыто", LocalDate.of(1955, 3, 27),
//                LocalDate.of(2001, 6, 2), Gender.Male);
//        Person uliana = new Person("Ульяна Сорокина", LocalDate.of(1973, 11, 30),
//                LocalDate.of(2022, 3, 25), Gender.Female);
//        Person julia = new Person("Юлия Сорокина", LocalDate.of(1992, 2, 13), Gender.Female);
//        Person fedja = new Person("Фёдор Поздняков", LocalDate.of(2015, 10, 2), Gender.Male);
//        Person petja = new Person("Пётр Поздняков", LocalDate.of(2015, 10, 2), Gender.Male);
//        Person glasha = new Person("Аглафья Позднякова", LocalDate.of(2015, 10, 2), Gender.Female);
//
//        julia.addParent(pavel);
//        julia.addParent(uliana);
//        pavel.addKid(julia);
//        semen.addKid(nikifor);
//        larisa.addKid(nikifor);
//        familyTree.setWedding(semen, larisa);
//        familyTree.setWedding(julia, nikifor);
//        nikifor.addKid(fedja);
//        julia.addKid(fedja);
//        nikifor.addKid(petja);
//        julia.addKid(petja);
//        nikifor.addKid(glasha);
//        julia.addKid(glasha);
//
//        familyTree.addPerson(pavel);
//        familyTree.addPerson(uliana);
//        familyTree.addPerson(julia);
//        familyTree.addPerson(semen);
//        familyTree.addPerson(larisa);
//        familyTree.addPerson(nikifor);
//        familyTree.addPerson(fedja);
//        familyTree.addPerson(petja);
//        familyTree.addPerson(glasha);
//        return familyTree;
//    }
//}
