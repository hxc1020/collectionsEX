# collectionsEX

对Java8中 Stream类进行装饰，并扩展其方法

```java
 /**
     * 获取第一个元素
     */
    T first();

    /**
     * 根据判断条件获取第一个元素
     *
     * @param condition 判断条件
     */
    T first(Predicate<T> condition);

    /**
     * 根据判断条件，全部元素满足时返回true
     *
     * @param condition 判断条件
     * @return true or false
     */
    boolean all(Predicate<T> condition);

    /**
     * 根据判断条件，有任意元素满足条件时返回true
     *
     * @param condition 判断条件
     * @return true or false
     */
    boolean any(Predicate<T> condition);

    /**
     * 判断集合内是否不存在任意元素
     *
     * @return true or false
     */
    boolean none();

    /**
     * 根据条件判断，全部元素都不满足时返回ture
     *
     * @param condition 判断条件
     * @return true or false
     */
    boolean none(Predicate<T> condition);

    /**
     * 根据条件计数
     *
     * @param condition 判断条件
     * @return long
     */
    Long countBy(Predicate<T> condition);

    /**
     * 集合内元素求和
     *
     * @return BigDecimal
     */
    BigDecimal sum();

    /**
     * 根据转换条件集合内元素求和
     *
     * @param mapper 转换方法 将单个元素转换为BigDecimal
     * @return BigDecimal
     */
    BigDecimal sumBy(Function<T, BigDecimal> mapper);

    /**
     * 集合内元素求平均值
     *
     * @return BigDecimal
     */
    BigDecimal average();

    /**
     * 根据转换条件集合元素求平均值
     *
     * @param mapper 转换方法 将单个元素转换为BigDecimal
     * @return BigDecimal
     */
    BigDecimal averageBy(Function<T, BigDecimal> mapper);

    /**
     * 根据转换条件集合内元素去重
     *
     * @param mapper 转换方法 将单个元素转换为另一种对象
     * @return ExList
     */
    <A> ExList<T> distinctBy(Function<T, A> mapper);

    /**
     * 根据条件返回符合条件的集合
     *
     * @param condition 判断条件
     * @return ExList
     */
    ExList<T> find(Predicate<T> condition);

    /**
     * 根据转换条件求集合内最大元素
     *
     * @param mapper 集合内元素转换为可比较对象
     * @return 单个元素
     */
    T maxBy(Function<T, Comparable> mapper);

    /**
     * 根据比较器找出集合内最大元素
     *
     * @param comparator 比较器
     * @return 单个元素
     */
    T maxWith(Comparator<T> comparator);

    /**
     * 根据转换条件求集合内最小元素
     *
     * @param mapper 集合内元素转换为可比较对象
     * @return 单个元素
     */
    T minBy(Function<T, Comparable> mapper);

    /**
     * 根据比较器找出集合内最小元素
     *
     * @param comparator 比较器
     * @return 单个元素
     */
    T minWith(Comparator<T> comparator);

    /**
     * 根据转换条件返回自然排序后的集合
     *
     * @param mapper 集合内元素转换为可比较对象
     * @return ExList
     */
    ExList<T> sortedBy(Function<T, Comparable> mapper);

    /**
     * 根据转换条件返回自然排序倒序后的集合
     *
     * @param mapper 集合内元素转换为可比较对象
     * @return ExList
     */
    ExList<T> sortedDescBy(Function<T, Comparable> mapper);

    /**
     * 根据比较器返回自然排序后的集合
     *
     * @param comparator 比较器
     * @return ExList
     */
    ExList<T> sortedWith(Comparator<T> comparator);

    /**
     * 根据转换方法将集合转换为Map，如果出现key重复的情况下会覆盖之前的值
     *
     * @param mapper 将集合内元素转换为Pair对象的方法，其中pair的first为key，pair的second为value
     * @return Map
     */
    <K, V> Map<K, V> associate(Function<T, Pair<K, V>> mapper);

    /**
     * 根据转换方法将集合转换为Map，如果出现key重复的情况下会覆盖之前的值
     *
     * @param mapper 将集合内元素转换成其他对象
     * @return Map
     */
    <K> Map<K, T> associateBy(Function<T, K> mapper);

    /**
     * 根据转换方法得到的key值将结合分组
     *
     * @param mapper 将集合内元素转换成其他对象
     * @return Map
     */
    <K> Map<K, ExList<T>> grouppingBy(Function<T, K> mapper);

    /**
     * 通过key转换方法和value转换方法将结合分组
     *
     * @param keyMapper   将集合内的元素转换为key
     * @param valueMapper 将集合内的元素转换为value
     * @return Map
     */
    <K, V> Map<K, ExList<V>> grouppingBy(Function<T, K> keyMapper, Function<T, V> valueMapper);

    /**
     * 获得与另一个List的交集 ∩
     *
     * @param otherList 另一个list
     * @return ExList
     */
    ExList<T> intersectionWith(ExList<T> otherList);

    /**
     * 获得与另一个List的交集 ∩
     *
     * @param otherList 另一个list
     * @param mapper    将其他类型元素转化为与该集合元素相同
     * @return ExList
     */
    <A> ExList<T> intersectionWith(ExList<A> otherList, Function<A, T> mapper);

    /**
     * 获得与另一个list的并集 ∪
     *
     * @param otherList 另一个list
     * @return ExList
     */
    ExList<T> unionWith(ExList<T> otherList);

    /**
     * 获得与另一个list的并集 ∪
     *
     * @param otherList 另一个list
     * @param mapper    将其他类型元素转化为与该集合元素相同
     * @return ExList
     */
    <A> ExList<T> unionWith(ExList<A> otherList, Function<A, T> mapper);

    /**
     * 获得与另一个list的补集
     *
     * @param otherList 另一个list
     * @return ExList
     */
    ExList<T> complementWith(ExList<T> otherList);

    /**
     * 获得与另一个list的补集
     *
     * @param otherList 另一个list
     * @param mapper    将其他类型元素转化为与该集合元素相同
     * @return ExList
     */
    <A> ExList<T> complementWith(ExList<A> otherList, Function<A, T> mapper);

    /**
     * 根据判断条件 condition 将ExList 一份为二，first = 判断为true的ExList，second = 判断为false的ExList
     *
     * @param condition 判断条件
     * @return Pair
     */
    Pair<ExList<T>, ExList<T>> partition(Predicate<T> condition);

    /**
     * 将该list与另一个list连接起来
     *
     * @param otherList 另一个list
     * @return ExList
     */
    <A> ExList<Pair<T, A>> zip(ExList<A> otherList);

    /**
     * 将该list与另一个list连接起来
     *
     * @param otherList 另一个list
     * @param mapper    将该list内的元素与otherList的元素转化为一个其他对象
     * @return ExList
     */
    <A, R> ExList<R> zip(ExList<A> otherList, BiFunction<T, A, R> mapper);

    /**
     * 与otherList的左连接
     *
     * @param otherList 另一个list
     * @param condition 条件
     * @return ExList
     */
    <A> ExList<Pair<T, A>> leftJoinOn(ExList<A> otherList, BiPredicate<T, A> condition);

    /**
     * 与otherList的内连接
     *
     * @param otherList 另一个list
     * @param condition 条件
     * @return ExList
     */
    <A> ExList<Pair<T, A>> innerJoinOn(ExList<A> otherList, BiPredicate<T, A> condition);

    /**
     * 将list转换为string
     *
     * @param separator 分隔符
     * @return String
     */
    String joinToString(String separator);

    /**
     * 将list转换为string
     *
     * @param buffer    buffer
     * @param separator 分隔符
     * @return String
     */
    String joinToString(Appendable buffer, String separator);

    /**
     * 将list转换为string
     *
     * @param buffer    buffer
     * @param separator 分隔符
     * @param prefix    前缀
     * @param postfix   后缀
     * @return String
     */
    String joinToString(Appendable buffer, String separator, String prefix, String postfix);

    /**
     * 将list转换为string
     *
     * @param buffer    buffer
     * @param separator 分隔符
     * @param limit     限制元素数量
     * @param truncated 被删节后显示的字符
     * @return String
     */
    String joinToString(Appendable buffer, String separator, int limit, String truncated);

    /**
     * 将list转换为string
     *
     * @param buffer    buffer
     * @param separator 分隔符
     * @param prefix    前缀
     * @param postfix   后缀
     * @param limit     限制元素数量
     * @param truncated 被删节后显示的字符
     * @return String
     */
    String joinToString(Appendable buffer, String separator, String prefix, String postfix, int limit, String truncated);
```
