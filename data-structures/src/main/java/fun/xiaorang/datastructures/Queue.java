package fun.xiaorang.datastructures;

import java.util.Iterator;

/**
 * @author liulei
 * @description <p style = " font-weight:bold ; ">队列<p/>
 * @github <a href="https://github.com/xihuanxiaorang/datastructures-algorithms">datastructures-algorithms</a>
 * @Copyright 博客：<a href="https://blog.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2022/11/14 9:31
 */
public interface Queue<E> extends Iterable<E> {
    /**
     * 队列是否为空
     *
     * @return true，表示队列为空；false，表示队列存在元素
     */
    boolean isEmpty();

    /**
     * 获取队中元素数量
     *
     * @return 元素数量
     */
    int size();

    /**
     * 入队，如果当前没有可用的空间，则抛出IllegalStateException异常
     *
     * @param element 入队的元素
     */
    void offer(E element);

    /**
     * 出队，如果队列为空，则抛出IllegalStateException异常
     *
     * @return 出队的元素
     */
    E poll();

    /**
     * 获取队头元素，如果队列为空，则抛出IllegalStateException异常
     *
     * @return 队头元素
     */
    E element();

    /**
     * 清空队列
     */
    void clear();

    Iterator<E> iterator();
}
