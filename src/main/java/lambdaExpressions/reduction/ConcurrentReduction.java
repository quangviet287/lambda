package lambdaExpressions.reduction;

import lambdaExpressions.Person;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class ConcurrentReduction {
    public static void main(String[] args) {
        List<Person> lists = Person.creatListPerson();

        //Concurrent Reduction.
        Map<Person.Sex, List<Person>> mapByGender = lists.stream().collect(Collectors.groupingBy(Person::getGender));
        System.out.println("Map By Gender");
        System.out.println(mapByGender);

        ConcurrentMap<Person.Sex, List<Person>> concurrentMap = lists
                .parallelStream()
                .collect(Collectors.groupingByConcurrent(Person::getGender));
        System.out.println("Concurrent Map By Gender");
        System.out.println(concurrentMap);
    }
}
