package lambdaExpressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaException {
    public static void main(String[] args) {
        try {
            List<String> lists = new ArrayList<>(Arrays.asList("hello","goodbye"));
            String concatenatedString = lists.stream().peek(s->lists.add("seeYou")).reduce((a,b)->a+" "+b).get();
            System.out.println(concatenatedString);
        } catch (Exception e){
            System.out.println("Exception: " + e.toString());
        }
    }
}
