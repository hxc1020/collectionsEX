package red.hxc.util.functional;

import java.util.function.Function;

/**
 * Create by linhao3 on 2018/6/29.
 */
@FunctionalInterface
public interface Selector<T,Comparable> extends Function<T,Comparable> {
}
