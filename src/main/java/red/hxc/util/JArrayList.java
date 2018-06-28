package red.hxc.util;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Function;

/**
 * Create by linhao3 on 2018/6/28.
 */
public class JArrayList<E> extends ArrayList<E> implements JList<E> {

    @Override
    public E maxBy(Function<E, Comparable> mapper) {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException("Index: " + 1 + ", Size: " + 0);
        }

        Optional<Pair<E, Comparable>> reduce = this.stream().map(it -> new Pair<>(it, mapper.apply(it)))
                .reduce((a, b) -> {
                    if (a.getSecond().compareTo(b.getSecond()) < 0)
                        a = b;
                    return a;
                });
        return reduce.map(Pair::getFirst).orElse(null);
    }

}
