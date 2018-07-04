package lambdaExpressions;

import java.util.*;
import java.util.function.Supplier;

public class MethodReferenceTest {

    public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>>
        DEST transferElement(SOURCE source,
                             Supplier<DEST> collectionFactory){
        DEST result = collectionFactory.get();
        for(T t : source){
            result.add(t);
        }
        return result;
    }

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
        //with  method reference (Reference to a Static Method)
        Arrays.sort(personList, Person::compareByAge);
        Arrays.sort(personList, (a,b)->Person.compareByAge(a,b));

        //Reference to an Instance Method of a Particular Object
        ComparisonProvider myComparisonProvider = new ComparisonProvider();
        Arrays.sort(personList, myComparisonProvider::compareByName);
        Arrays.sort(personList, myComparisonProvider::compareByAge);
        Arrays.sort(personList, myComparisonProvider::compareByGender);

        //Reference to an Instance Method of an Arbitrary Object of a Particular Type
        System.out.println("------------------------------");
        String[] stringArray = {"a","e","h","d","b","f","g","c"};
        Arrays.sort(stringArray, String::compareToIgnoreCase);
        for (String x : stringArray){
            System.out.println(x + " ");
        }

        //Reference with lambda expression
        Set<Person> listPerson = transferElement(person,()->{return  new HashSet<>();});
        //Reference use constructor
        Set<Person> personSet = transferElement(person, HashSet::new);
        //Another way
        Set<Person> sets = transferElement(person,HashSet<Person>::new);
    }
}
