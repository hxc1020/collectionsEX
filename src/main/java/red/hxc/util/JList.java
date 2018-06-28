package red.hxc.util;

import java.util.List;
import java.util.function.Function;

/**
 * Create by linhao3 on 2018/6/28.
 */
public interface JList<E> extends List<E> {

    E maxBy(Function<E,Comparable> mapper);
}
