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
public class ExArrayList<T> extends ArrayList<T> implements ExList<T> {

    @Override
    public T first() {
        checkEmpty();

        return this.get(0);
    }

    @Override
    public T first(Predicate<T> condition) {
        checkEmpty();

        for (T T : this) {
            if (condition.test(T)) {
                return T;
            }
        }
        return null;
    }

    @Override
    public T maxBy(Function<T, Comparable> mapper) {
        checkEmpty();

        if (this.size() == 1) return this.first();

        Optional<Pair<T, Comparable>> reduce = this.stream().map(it -> new Pair<>(it, mapper.apply(it)))
                .reduce((a, b) -> {
                    if (a.getSecond().compareTo(b.getSecond()) < 0)
                        a = b;
                    return a;
                });
        return reduce.map(Pair::getFirst).orElse(null);
    }

    @Override
    public T maxWith(Comparator<T> comparator) {
        checkEmpty();

        if (this.size() == 1) return this.first();

        Optional<T> reduce = this.stream().reduce((a, b) -> {
            if (comparator.compare(a, b) < 0)
                a = b;
            return a;
        });
        return reduce.orElse(null);
    }

    @Override
    public T minBy(Function<T, Comparable> mapper) {
        checkEmpty();

        if (this.size() == 1) return this.first();

        Optional<Pair<T, Comparable>> reduce = this.stream().map(it -> new Pair<>(it, mapper.apply(it)))
                .reduce((a, b) -> {
                    if (a.getSecond().compareTo(b.getSecond()) > 0)
                        a = b;
                    return a;
                });
        return reduce.map(Pair::getFirst).orElse(null);
    }

    @Override
    public T minWith(Comparator<T> comparator) {
        checkEmpty();

        if (this.size() == 1) return this.first();

        Optional<T> reduce = this.stream().reduce((a, b) -> {
            if (comparator.compare(a, b) > 0)
                a = b;
            return a;
        });
        return reduce.orElse(null);
    }

    @Override
    public ExList<T> sortedBy(Function<T, Comparable> mapper) {
        Comparator<T> comparator = ExCollections.compareBy(mapper);
        return this.sortedWith(comparator);
    }

    @Override
    public ExList<T> sortedDescBy(Function<T, Comparable> mapper) {
        Comparator<T> comparator = ExCollections.compareDescBy(mapper);
        return this.sortedWith(comparator);
    }

    @Override
    public ExList<T> sortedWith(Comparator<T> comparator) {
        if (this.size() <= 1)
            return this;
        this.sort(comparator);
        return this;
    }

    @Override
    public boolean all(Predicate<T> condition) {
        return false;
    }

    @Override
    public boolean any(Predicate<T> condition) {
        return false;
    }

    @Override
    public boolean none() {
        return false;
    }

    @Override
    public boolean none(Predicate<T> condition) {
        return false;
    }

    @Override
    public Long countBy(Predicate<T> condition) {
        return null;
    }

    @Override
    public BigDecimal sumBy(Function<T, BigDecimal> mapper) {
        return null;
    }

    @Override
    public BigDecimal averageBy(Function<T, BigDecimal> mapper) {
        return null;
    }

    @Override
    public <K> ExList<T> distinctBy(Function<T, K> mapper) {
        return null;
    }

    @Override
    public ExList<T> find(Predicate<T> condition) {
        return null;
    }

    @Override
    public <K, V> Map<K, V> associate(Function<T, Pair<K, V>> mapper) {
        return null;
    }

    @Override
    public <K> Map<K, T> associateBy(Function<T, K> mapper) {
        return null;
    }

    @Override
    public <K> Map<K, ExList<T>> grouppingBy(Function<T, K> mapper) {
        return null;
    }

    @Override
    public <K, V> Map<K, ExList<V>> grouppingBy(Function<T, K> keyMapper, Function<T, V> valueMapper) {
        return null;
    }

    @Override
    public ExList<T> intersectionWith(ExList<T> otherList) {
        return null;
    }

    @Override
    public <A> ExList<T> intersectionWith(ExList<A> otherList, Function<A, T> mapper) {
        return null;
    }

    @Override
    public ExList<T> unionWith(ExList<T> otherList) {
        return null;
    }

    @Override
    public <A> ExList<T> unionWith(ExList<A> otherList, Function<A, T> mapper) {
        return null;
    }

    @Override
    public ExList<T> complementWith(ExList<T> otherList) {
        return null;
    }

    @Override
    public <A> ExList<T> complementWith(ExList<A> otherList, Function<A, T> mapper) {
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
    public Pair<ExList<T>, ExList<T>> partition(Predicate<T> condition) {
        return null;
    }

    @Override
    public <A> ExList<Pair<T, A>> zip(ExList<A> otherList) {
        return null;
    }

    @Override
    public <A, R> ExList<R> zip(ExList<A> otherList, BiFunction<T, A, R> mapper) {
        return null;
    }

    @Override
    public <A> ExList<Pair<T, A>> leftJoinOn(ExList<A> otherList, BiPredicate<T, A> condition) {
        return null;
    }

    @Override
    public <A> ExList<Pair<T, A>> innerJoinOn(ExList<A> otherList, BiPredicate<T, A> condition) {
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
