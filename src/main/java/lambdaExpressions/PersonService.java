package lambdaExpressions;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class PersonService {

    //Approach 1: Create Methods That Search for Members That Match One Characteristic
    public static void printPersonOlderThan(List<Person> persons, int age){
        for (Person p : persons){
            if(p.getAge() >= age){
                p.printPerson();
            }
        }
    }

    //Approach 2: Create More Generalized Search Methods
    public static void printPersonsWithinAgeRange(List<Person> persons, int low, int high ){
        for (Person p : persons){
            if (low <= p.getAge() && p.getAge() < high){
                p.printPerson();
            }
        }
    }

    //Approach 3,4,5: Specify Search Criteria Code in a Local Class,Anonymous Class,Lambda Expression
    public static void printPersons(List<Person> list, CheckPerson check){
        for (Person p : list){
            if(check.test(p)){
                p.printPerson();
            }
        }
    }

    //Approach 6:  Use Standard Functional Interfaces with Lambda Expressions
    public static void printPersonsWithPredicate(List<Person> persons, Predicate<Person> test){
        for (Person p : persons){
            if (test.test(p)){
                p.printPerson();
            }
        }
    }

    //Approach 7: Use Lambda Expressions Throughout Your Application
    public static void processPerson(List<Person> persons, Predicate<Person> check, Consumer<Person> block){
        for (Person p : persons){
            if (check.test(p)){
                block.accept(p);
            }
        }
    }
    public static void processPersonWithFunction(List<Person> persons,
                                                 Predicate<Person> check,
                                                 Function<Person,String> mapper,
                                                 Consumer<String> block){
        for (Person p : persons){
            if (check.test(p)){
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    //Approach 8: Use Generics More Extensively
    public static <X, Y> void processElements(Iterable<X> source,
                                              Predicate<X> check,
                                              Function<X,Y> mapper,
                                              Consumer<Y> block){
        for (X p : source){
            if(check.test(p)){
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    //Approach 9: Use Aggregate Operations That Accept Lambda Expressions as Parameters

    public static void main(String[] args) {
        System.out.println("List person");
        List<Person> persons = Person.creatListPerson();
        for (Person p : persons){
            p.printPerson();
        }

        //Approach 1:
        System.out.println("---------------------------------------------");
        System.out.println("lambdaExpressions.Person older 20 years old: ");
        printPersonOlderThan(persons,20);
        System.out.println("---------------------------------------------");

        //Approach 2:
        System.out.println("lambdaExpressions.Person from 19-20 year old:");
        printPersonsWithinAgeRange(persons,19,23);
        System.out.println("---------------------------------------------");

        //Approach 3:
        System.out.println("lambdaExpressions.Person eligible: Use Local Class");
        printPersons(persons, new CheckPersonEligibleForSelectiveService());
        System.out.println("---------------------------------------------");

        //Approach 4:
        System.out.println("lambdaExpressions.Person eligible: Use Anonymous Class");
        printPersons(persons, new CheckPerson() {
            @Override
            public boolean test(Person person) {
                return person.getGender()==Person.Sex.MALE && person.getAge()>=19 && person.getAge()<=24;
            }
        });
        System.out.println("---------------------------------------------");

        //Approach 5:
        System.out.println("lambdaExpressions.Person eligible: Use Lambda expression");
        printPersons(persons, (Person p) -> p.getGender()==Person.Sex.MALE && p.getAge() >=19  && p.getAge() <=24);
        System.out.println("---------------------------------------------");

        //Approach 6:
        System.out.println("lambdaExpressions.Person eligible: Use Standard Functional Interfaces");
        printPersonsWithPredicate(persons, p -> p.getGender()==Person.Sex.MALE && p.getAge() >=19  && p.getAge() <=24);
        System.out.println("---------------------------------------------");

        //Approach 7:
        System.out.println("lambdaExpressions.Person eligible: User Lambda Expressions Throughout Your Application");
        processPerson(persons,p -> p.getGender()==Person.Sex.MALE && p.getAge() >=19  && p.getAge() <=24, p->p.printPerson());
        System.out.println("---------------------------------------------");
        System.out.println("lambdaExpressions.Person eligible: use Function");
        processPersonWithFunction(persons, p ->p.getGender()==Person.Sex.MALE && p.getAge() >=19  && p.getAge() <=24,p -> p.getEmailAddress(),email -> System.out.println(email));

        //Approach 8:
        System.out.println("lambdaExpressions.Person eligible: Use Generics More Extensively");
        processElements(persons,p -> p.getGender()==Person.Sex.MALE && p.getAge() >=19  && p.getAge() <=24,p->p.getGender(),gender-> System.out.println(gender));

        //Approach 9:
        System.out.println("lambdaExpressions.Person eligible: Use Aggregate Operations");
        persons.stream().filter(p -> p.getGender()==Person.Sex.MALE && p.getAge() >=19  && p.getAge() <=24).map(p->p.getGender()).forEach(gender-> System.out.println(gender));
    }
}
