package lambdaExpressions.reduction;

import java.util.*;

public class Parallelism {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8 };
        List<Integer> lists =
                new ArrayList<>(Arrays.asList(intArray));
        /*lists.stream().forEach(e-> System.out.println(e + " "));
        System.out.println("-----------------******************-----------------");

        Comparator<Integer> normal = Integer::compare;
        Comparator<Integer> reversed = normal.reversed();
        Collections.sort(lists,reversed);
        lists.stream().forEach(e-> System.out.println(e + " "));
        System.out.println("-----------------******************-----------------");
        lists.parallelStream().forEach(e-> System.out.println(e+" "));
        lists.parallelStream().forEachOrdered(e-> System.out.println(e+" "));*/

        //Stateful Lambda Expressions
        List<Integer> list1 = new ArrayList<>();
        lists.stream().map(e->{list1.add(e); return e;}).forEachOrdered(e-> System.out.println(e+" "));
        System.out.println("----------------------------");
        list1.stream().forEachOrdered(e-> System.out.println(e+" "));

        System.out.println("Parallel stream:");
//        List<Integer> parallelStorage = Collections.synchronizedList(new ArrayList<>());
        List<Integer> parallelStorage = new ArrayList<>();
        lists.parallelStream().map(e->{parallelStorage.add(e);return e;}).forEachOrdered(e-> System.out.println(e+" "));
        System.out.println("-----------------------------");
        parallelStorage.stream().forEachOrdered(e-> System.out.println(e+" "));
    }
}
