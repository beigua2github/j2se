package iterator;

import java.util.Iterator;

/**
 * @author beigua
 */
public interface Aggregator<T> {
    Iterator<T> create(T[] t);
}
