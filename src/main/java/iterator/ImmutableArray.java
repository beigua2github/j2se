package iterator;


import java.util.Iterator;

public class ImmutableArray<T> implements Iterator<T> {
    private final T[] t;
    private int postion;

    public ImmutableArray(T[] t) {
        this.t = t;
    }

    @Override
    public boolean hasNext() {
        return postion < t.length;
    }

    @Override
    public T next() {
        return t[postion++];
    }
}
