package red.hxc.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Create by linhao3 on 2018/6/28.
 */
public class ExArrayList<E> extends ArrayList<E> implements ExList<E> {

    @Override
    public E first() {
        checkEmpty();

        return this.get(0);
    }

    @Override
    public E first(Predicate<E> condition) {
        checkEmpty();

        for (E e : this) {
            if (condition.test(e)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public E maxBy(Function<E, Comparable> mapper) {
        checkEmpty();

        if (this.size() == 1) return this.first();

        Optional<Pair<E, Comparable>> reduce = this.stream().map(it -> new Pair<>(it, mapper.apply(it)))
                .reduce((a, b) -> {
                    if (a.getSecond().compareTo(b.getSecond()) < 0)
                        a = b;
                    return a;
                });
        return reduce.map(Pair::getFirst).orElse(null);
    }

    @Override
    public E maxWith(Comparator<E> comparator) {
        checkEmpty();

        if (this.size() == 1) return this.first();

        Optional<E> reduce = this.stream().reduce((a, b) -> {
            if (comparator.compare(a, b) < 0)
                a = b;
            return a;
        });
        return reduce.orElse(null);
    }

    @Override
    public E minBy(Function<E, Comparable> mapper) {
        checkEmpty();

        if (this.size() == 1) return this.first();

        Optional<Pair<E, Comparable>> reduce = this.stream().map(it -> new Pair<>(it, mapper.apply(it)))
                .reduce((a, b) -> {
                    if (a.getSecond().compareTo(b.getSecond()) > 0)
                        a = b;
                    return a;
                });
        return reduce.map(Pair::getFirst).orElse(null);
    }

    @Override
    public E minWith(Comparator<E> comparator) {
        checkEmpty();

        if (this.size() == 1) return this.first();

        Optional<E> reduce = this.stream().reduce((a, b) -> {
            if (comparator.compare(a, b) > 0)
                a = b;
            return a;
        });
        return reduce.orElse(null);
    }

    @Override
    public ExList<E> sortedBy(Function<E, Comparable> mapper) {
        Comparator<E> comparator = ExCollections.compareBy(mapper);
        return this.sortedWith(comparator);
    }

    @Override
    public ExList<E> sortedDescBy(Function<E, Comparable> mapper) {
        Comparator<E> comparator = ExCollections.compareDescBy(mapper);
        return this.sortedWith(comparator);
    }

    @Override
    public ExList<E> sortedWith(Comparator<E> comparator) {
        if (this.size() <= 1)
            return this;
        this.sort(comparator);
        return this;
    }

    private void checkEmpty() {
        if (this.isEmpty())
            throw new NoSuchElementException("List is empty.");
    }

}
