package iterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Aggregator<String> stringAggregator = new MyAggregator<>();

        Iterator<String> stringIterator = stringAggregator.create(new String[]{"kobe", "24", "mvp"});


        stringIterator.forEachRemaining(it -> System.out.println(it));
    }
}
