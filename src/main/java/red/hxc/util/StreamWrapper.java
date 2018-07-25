package red.hxc.util;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * Create by linhao3 on 2018/7/10.
 */
public class StreamWrapper<T> implements ExStream<T> {
    private Stream<T> stream;

    StreamWrapper(Stream<T> stream) {
        this.stream = stream;
    }

    @Override
    public List<T> toList() {
        return this.collect(Collectors.toList());
    }


    @Override
    public T first() {

        return null;
    }

    @Override
    public T first(Predicate<T> condition) {
        return null;
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
    public BigDecimal sum() {
        return null;
    }

    @Override
    public BigDecimal sumBy(Function<T, BigDecimal> mapper) {
        return null;
    }

    @Override
    public BigDecimal average() {
        return null;
    }

    @Override
    public BigDecimal averageBy(Function<T, BigDecimal> mapper) {
        return null;
    }

    @Override
    public <A> ExList<T> distinctBy(Function<T, A> mapper) {
        return null;
    }

    @Override
    public ExList<T> find(Predicate<T> condition) {
        return null;
    }

    @Override
    public T maxBy(Function<T, Comparable> mapper) {
        return null;
    }

    @Override
    public T maxWith(Comparator<T> comparator) {
        return null;
    }

    @Override
    public T minBy(Function<T, Comparable> mapper) {
        return null;
    }

    @Override
    public T minWith(Comparator<T> comparator) {
        return null;
    }

    @Override
    public ExList<T> sortedBy(Function<T, Comparable> mapper) {
        return null;
    }

    @Override
    public ExList<T> sortedDescBy(Function<T, Comparable> mapper) {
        return null;
    }

    @Override
    public ExList<T> sortedWith(Comparator<T> comparator) {
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

    @Override
    public ExStream<T> filter(Predicate<? super T> predicate) {
        this.stream = this.stream.filter(predicate);
        return this;
    }

    @Override
    public <R> ExStream<R> map(Function<? super T, ? extends R> mapper) {
        return new StreamWrapper<>(this.stream.map(mapper));
    }

    @Override
    public IntStream mapToInt(ToIntFunction<? super T> mapper) {
        return this.stream.mapToInt(mapper);
    }

    @Override
    public LongStream mapToLong(ToLongFunction<? super T> mapper) {
        return this.stream.mapToLong(mapper);
    }

    @Override
    public DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper) {
        return this.stream.mapToDouble(mapper);
    }

    @Override
    public <R> ExStream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper) {
        return new StreamWrapper<>(this.stream.flatMap(mapper));
    }

    @Override
    public IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper) {
        return this.stream.flatMapToInt(mapper);
    }

    @Override
    public LongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper) {
        return this.stream.flatMapToLong(mapper);
    }

    @Override
    public DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper) {
        return this.stream.flatMapToDouble(mapper);
    }

    @Override
    public ExStream<T> distinct() {
        this.stream = this.stream.distinct();
        return this;
    }

    @Override
    public ExStream<T> sorted() {
        this.stream = this.stream.sorted();
        return this;
    }

    @Override
    public ExStream<T> sorted(Comparator<? super T> comparator) {
        this.stream = this.stream.sorted(comparator);
        return this;
    }

    @Override
    public ExStream<T> peek(Consumer<? super T> action) {
        this.stream = this.stream.peek(action);
        return this;
    }

    @Override
    public ExStream<T> limit(long maxSize) {
        this.stream = this.stream.limit(maxSize);
        return this;
    }

    @Override
    public ExStream<T> skip(long n) {
        this.stream = this.stream.skip(n);
        return this;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        this.stream.forEach(action);
    }

    @Override
    public void forEachOrdered(Consumer<? super T> action) {
        this.stream.forEachOrdered(action);
    }

    @Override
    public Object[] toArray() {
        return this.stream.toArray();
    }

    @Override
    public <A> A[] toArray(IntFunction<A[]> generator) {
        return this.stream.toArray(generator);
    }

    @Override
    public T reduce(T identity, BinaryOperator<T> accumulator) {
        return this.stream.reduce(identity, accumulator);
    }

    @Override
    public Optional<T> reduce(BinaryOperator<T> accumulator) {
        return this.stream.reduce(accumulator);
    }

    @Override
    public <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner) {
        return this.stream.reduce(identity, accumulator, combiner);
    }

    @Override
    public <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner) {
        return this.stream.collect(supplier, accumulator, combiner);
    }

    @Override
    public <R, A> R collect(Collector<? super T, A, R> collector) {
        return this.stream.collect(collector);
    }

    @Override
    public Optional<T> min(Comparator<? super T> comparator) {
        return this.stream.min(comparator);
    }

    @Override
    public Optional<T> max(Comparator<? super T> comparator) {
        return this.stream.max(comparator);
    }

    @Override
    public long count() {
        return this.stream.count();
    }

    @Override
    public boolean anyMatch(Predicate<? super T> predicate) {
        return this.stream.anyMatch(predicate);
    }

    @Override
    public boolean allMatch(Predicate<? super T> predicate) {
        return this.stream.allMatch(predicate);
    }

    @Override
    public boolean noneMatch(Predicate<? super T> predicate) {
        return this.stream.noneMatch(predicate);
    }

    @Override
    public Optional<T> findFirst() {
        return this.stream.findFirst();
    }

    @Override
    public Optional<T> findAny() {
        return this.stream.findAny();
    }

}
