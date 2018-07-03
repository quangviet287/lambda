package lambdaExpressions;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

public class Person {
    public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public enum Sex {MALE,FEMALE}

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public String getName() {
        return name;
    }

    public Sex getGender() {
        return gender;
    }

    public int getAge(){
        return birthday.until(IsoChronology.INSTANCE.dateNow()).getYears();
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void printPerson() {
        System.out.println(name + ", " + this.getAge());
    }

    public static int compareByAge(Person a, Person b){
        return a.birthday.compareTo(b.birthday);
    }

    public static List<Person> creatListPerson() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("a", IsoChronology.INSTANCE.date(1991, 7, 8), Sex.MALE, "a@s.com"));
        list.add(new Person("b", IsoChronology.INSTANCE.date(1992, 7, 6), Sex.MALE, "b@s.com"));
        list.add(new Person("c", IsoChronology.INSTANCE.date(2001, 7, 16), Sex.FEMALE, "c@s.com"));
        list.add(new Person("d", IsoChronology.INSTANCE.date(1996, 7, 28), Sex.MALE, "d@s.com"));
        list.add(new Person("e", IsoChronology.INSTANCE.date(2000, 7, 28), Sex.MALE, "d@s.com"));
        return list;
    }
}
