package lambdaExpressions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MethodReferenceTest {
    public static void main(String[] args) {
        List<Person> person = Person.creatListPerson();

        for (Person p : person){
            p.printPerson();
        }

        Person[] personList = person.toArray(new Person[person.size()]);

        class PersonAgeComparator implements Comparator<Person>{
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        }

        //with lambda expression
        Arrays.sort(personList, (Person a, Person b) -> {return a.getBirthday().compareTo(b.getBirthday());});
        //without  method reference
        Arrays.sort(personList, new PersonAgeComparator());
        //with  method reference
        Arrays.sort(personList, Person::compareByAge);
        Arrays.sort(personList, (a,b)->Person.compareByAge(a,b));


        class ComparisonProvider {
            public int compareByName(Person a, Person b) {
                return a.getName().compareTo(b.getName());
            }

            public int compareByAge(Person a, Person b) {
                return a.getBirthday().compareTo(b.getBirthday());
            }
        }
        ComparisonProvider myComparisonProvider = new ComparisonProvider();
        Arrays.sort(personList, myComparisonProvider::compareByName);
    }
}
