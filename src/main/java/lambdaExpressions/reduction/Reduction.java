package lambdaExpressions.reduction;

import lambdaExpressions.Person;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Reduction {
    public static void main(String[] args) {
        List<Person> lists = Person.creatListPerson();

        //Stream.sum
        Integer totalAge = lists.stream().mapToInt(Person::getAge).sum();

        //Stream.reduce
        Integer totalAgeReduce = lists.stream().map(Person::getAge).reduce(0,(a,b)->a+b);

        System.out.println(totalAge + "----" + totalAgeReduce);

        //Stream.collect
        Averager averagerCollect = lists.stream()
                .filter(p->p.getGender()==Person.Sex.MALE).map(Person::getAge).collect(Averager::new,Averager::accept,Averager::combine);
        System.out.println(averagerCollect.average());

        // puts the names of the male members in a collection with the collect operation:
        List<String> nameOfMaleMembers = lists.stream().filter(p->p.getGender()== Person.Sex.MALE).map(p->p.getName()).collect(Collectors.toList());
        System.out.println(nameOfMaleMembers+" ");

        //groups members of the collection roster by gender:
        Map<Person.Sex, List<String>> byGender = lists.stream().collect(
                Collectors.groupingBy(Person::getGender, Collectors.mapping(Person::getName,Collectors.toList())
        ));
        System.out.println(byGender);

        //retrieves the total age of members of each gender
        Map<Person.Sex, Integer> totalAgeByGender = lists.stream().collect(
                Collectors.groupingBy(Person::getGender, Collectors.reducing(0,Person::getAge,Integer::sum))
        );
        System.out.println(totalAgeByGender);

        //retrieves the average age of members of each gender:
        Map<Person.Sex, Double> averageAgeByGender = lists.stream().collect(
                Collectors.groupingBy(Person::getGender, Collectors.averagingInt(Person::getAge))
        );
        System.out.println(averageAgeByGender);
        System.out.println("-----------------******************-----------------");
    }
}
