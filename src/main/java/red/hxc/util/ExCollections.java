package red.hxc.util;

import red.hxc.util.functional.Selector;

import java.util.Comparator;
import java.util.function.Function;

/**
 * Create by linhao3 on 2018/6/29.
 */
public class ExCollections {

    private ExCollections() {
    }

    static <E> Comparator<E> compareBy(Function<E,Comparable> mapper) {
        return (E t1, E t2) -> {
            Comparable s1 = mapper.apply(t1);
            Comparable s2 = mapper.apply(t2);
            return compareValues(s1, s2);
        };
    }

    static <E> Comparator<E> compareDescBy(Function<E,Comparable> mapper) {
        return (E t1, E t2) -> {
            Comparable s1 = mapper.apply(t1);
            Comparable s2 = mapper.apply(t2);
            return -compareValues(s1, s2);
        };
    }

    private static int compareValues(Comparable s1, Comparable s2) {
        return s1.compareTo(s2);
    }

    static <E>Comparator<E> reverseOrderComparator(Comparator<E> c) {
        return (o1, o2) -> -c.compare(o1, o2);
    }
}
