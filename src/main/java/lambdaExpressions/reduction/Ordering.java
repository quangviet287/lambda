package lambdaExpressions.reduction;

import java.util.*;

public class Ordering {
    public static void main(String[] args) {
        Integer[] intArray = {1,2,4,3,5,6,7};
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));
        System.out.println("List of Integer");
        listOfIntegers.stream().forEach(e-> System.out.print(e+" "));
        System.out.println("");

        Comparator<Integer> normal = Integer::compare;
        Comparator<Integer> reversed = normal.reversed();
        Collections.sort(listOfIntegers,reversed);
        System.out.println("List of Integer reversed");
        listOfIntegers.stream().forEach(e-> System.out.print(e+" "));
        System.out.println("");

        System.out.println("Parallel Stream");
        listOfIntegers.parallelStream().forEach(e-> System.out.print(e+" "));
        System.out.println("");

        System.out.println("anther parallel stream");
        listOfIntegers.parallelStream().forEach(e-> System.out.print(e+" "));
        System.out.println("");

        System.out.println("use forEachOrdered");
        listOfIntegers.parallelStream().forEachOrdered(e-> System.out.print(e+" "));
        System.out.println("");

        System.out.println("---------------------------Stateful Lambda Expressions----------------------------");
        //Stateful Lambda Expressions
        List<Integer> serial = new ArrayList<>();
        System.out.println("Serial stream");
        listOfIntegers.stream().map(e->{serial.add(e); return e;}).forEachOrdered(e-> System.out.print(e + " "));
        System.out.println("");
        serial.stream().forEachOrdered(e-> System.out.print(e+" "));
        System.out.println("");
        System.out.println("Parallel stream: ");
        List<Integer> parallelStorage = Collections.synchronizedList(new ArrayList<>());
        listOfIntegers.parallelStream().map(e->{parallelStorage.add(e); return e;}).forEachOrdered(e-> System.out.print(e+" "));
        System.out.println("");
        parallelStorage.stream().forEachOrdered(e-> System.out.print(e+" "));
    }
}
