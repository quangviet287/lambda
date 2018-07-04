package lambdaExpressions.reduction;

import java.util.function.IntConsumer;

public class Averager implements IntConsumer {

    private int count = 0;
    private int total = 0;
    public double average(){
        return count>0 ? ((double) total)/count : 0;
    }

    public void combine(Averager other){
        total += other.total;
        count += other.count;
    }

    @Override
    public void accept(int value) {
        total += value;
        count++;
    }
}
