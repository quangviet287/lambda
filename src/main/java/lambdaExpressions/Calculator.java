package lambdaExpressions;

public class Calculator {
    interface IntergerMath{
        int operation(int a, int b);
    }
    public int operateBinary(int a, int b, IntergerMath op){
        return op.operation(a,b);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        IntergerMath add = (a,b) -> a+b;
        IntergerMath sub = (a, b) -> a-b;

        System.out.println(calculator.operateBinary(10,10,add));
        System.out.println(calculator.operateBinary(10,10,sub));
    }
}
