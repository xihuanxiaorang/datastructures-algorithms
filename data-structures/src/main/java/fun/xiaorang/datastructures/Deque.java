package fun.xiaorang.datastructures;

/**
 * @author liulei
 * @description <p style = " font-weight:bold ; ">双端队列<p/>
 * @github <a href="https://github.com/xihuanxiaorang/datastructures-algorithms">datastructures-algorithms</a>
 * @Copyright 博客：<a href="https://blog.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2022/11/15 3:38
 */
public interface Deque<E> extends Iterable<E> {
    /**
     * 从队头添加元素
     *
     * @param e 添加的元素
     */
    void addFirst(E e);

    /**
     * 从队尾添加元素
     *
     * @param e 添加的元素
     */
    void addLast(E e);

    /**
     * 删除队头元素
     *
     * @return 队头元素
     */
    E removeFirst();

    /**
     * 删除队尾元素
     *
     * @return 队尾元素
     */
    E removeLast();

    /**
     * 获取队头元素
     *
     * @return 队头元素
     */
    E getFirst();

    /**
     * 获取队尾元素
     *
     * @return 队尾元素
     */
    E getLast();

    /**
     * 获取队列中元素数量
     *
     * @return 元素数量
     */
    int size();

    /**
     * 判断队列是否为空
     *
     * @return true，表示队列为空；false：表示队列不为空
     */
    boolean isEmpty();

    /**
     * 清空队列
     */
    void clear();
}
