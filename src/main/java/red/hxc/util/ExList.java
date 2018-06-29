package red.hxc.util;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Create by linhao3 on 2018/6/28.
 */
public interface ExList<E> extends List<E> {
    E first();

    E first(Predicate<E> condition);

    boolean all(Predicate<E> condition);

    boolean any(Predicate<E> condition);

    ExList<E> find(Predicate<E> condition);

    E maxBy(Function<E, Comparable> mapper);

    E maxWith(Comparator<E> comparator);

    E minBy(Function<E, Comparable> mapper);

    E minWith(Comparator<E> comparator);

    ExList<E> sortedBy(Function<E, Comparable> mapper);

    ExList<E> sortedDescBy(Function<E, Comparable> mapper);

    ExList<E> sortedWith(Comparator<E> comparator);

    <K, V> Map<K, V> associate(Function<E, Pair<K, V>> mapper);

//    <K, V> Map<K, V> grouppingBy(Function<E,K>

}
