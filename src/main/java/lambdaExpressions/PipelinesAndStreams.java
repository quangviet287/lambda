package lambdaExpressions;

import java.util.List;

public class PipelinesAndStreams {
    public static void main(String[] args) {
        List<Person> roster = Person.creatListPerson();

        //pipelines
        roster.stream().filter(e->e.getAge()==20).forEach(e-> {System.out.println(e.getName()); System.out.println();});

        double average = roster.stream().filter(e->e.getGender() == Person.Sex.MALE).mapToInt(Person::getAge).average().getAsDouble();
    }
}
