package red.hxc.util;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
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

    @Override
    public boolean all(Predicate<E> condition) {
        return false;
    }

    @Override
    public boolean any(Predicate<E> condition) {
        return false;
    }

    @Override
    public boolean none() {
        return false;
    }

    @Override
    public boolean none(Predicate<E> condition) {
        return false;
    }

    @Override
    public Long countBy(Predicate<E> condition) {
        return null;
    }

    @Override
    public BigDecimal sumBy(Function<E, BigDecimal> mapper) {
        return null;
    }

    @Override
    public BigDecimal averageBy(Function<E, BigDecimal> mapper) {
        return null;
    }

    @Override
    public <K> ExList<E> distinctBy(Function<E, K> mapper) {
        return null;
    }

    @Override
    public ExList<E> find(Predicate<E> condition) {
        return null;
    }

    @Override
    public <K, V> Map<K, V> associate(Function<E, Pair<K, V>> mapper) {
        return null;
    }

    @Override
    public <K> Map<K, E> associateBy(Function<E, K> mapper) {
        return null;
    }

    @Override
    public <K> Map<K, ExList<E>> grouppingBy(Function<E, K> mapper) {
        return null;
    }

    @Override
    public <K, V> Map<K, ExList<V>> grouppingBy(Function<E, K> keyMapper, Function<E, V> valueMapper) {
        return null;
    }

    @Override
    public ExList<E> intersectionWith(ExList<E> otherList) {
        return null;
    }

    @Override
    public <T> ExList<E> intersectionWith(ExList<T> otherList, Function<T, E> mapper) {
        return null;
    }

    @Override
    public ExList<E> unionWith(ExList<E> otherList) {
        return null;
    }

    @Override
    public <T> ExList<E> unionWith(ExList<T> otherList, Function<T, E> mapper) {
        return null;
    }

    @Override
    public ExList<E> complementWith(ExList<E> otherList) {
        return null;
    }

    @Override
    public <T> ExList<E> complementWith(ExList<T> otherList, Function<T, E> mapper) {
        return null;
    }

    @Override
    public BigDecimal sum() {
        return null;
    }

    @Override
    public BigDecimal average() {
        return null;
    }

    @Override
    public Pair<ExList<E>, ExList<E>> partition(Predicate<E> condition) {
        return null;
    }

    @Override
    public <T> ExList<Pair<E, T>> zip(ExList<T> otherList) {
        return null;
    }

    @Override
    public <T, R> ExList<R> zip(ExList<T> otherList, BiFunction<E, T, R> mapper) {
        return null;
    }

    @Override
    public <T> ExList<Pair<E, T>> leftJoinOn(ExList<T> otherList, BiPredicate<E, T> condition) {
        return null;
    }

    @Override
    public <T> ExList<Pair<E, T>> innerJoinOn(ExList<T> otherList, BiPredicate<E, T> condition) {
        return null;
    }

    @Override
    public String joinToString(String separator) {
        return null;
    }

    @Override
    public String joinToString(Appendable buffer, String separator) {
        return null;
    }

    @Override
    public String joinToString(Appendable buffer, String separator, String prefix, String postfix) {
        return null;
    }

    @Override
    public String joinToString(Appendable buffer, String separator, int limit, String truncated) {
        return null;
    }

    @Override
    public String joinToString(Appendable buffer, String separator, String prefix, String postfix, int limit, String truncated) {
        return null;
    }

    private void checkEmpty() {
        if (this.isEmpty())
            throw new NoSuchElementException("List is empty.");
    }

}
