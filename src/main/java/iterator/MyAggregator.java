package iterator;

import java.util.Iterator;

public class MyAggregator<T> implements Aggregator<T> {
    @Override
    public Iterator<T> create(T[] t) {
        return new ImmutableArray<>(t);
    }
}
