package fun.xiaorang.datastructure;

/**
 * @author liulei
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/datastructures-algorithms">datastructures-algorithms</a>
 * @Copyright 博客：<a href="https://xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2022/11/5 10:26
 */
public interface List<E> {
    Integer ELEMENT_NOT_FOUND = -1;

    /**
     * 获取元素的数量
     *
     * @return 元素的数量
     */
    int size();

    /**
     * @return 如果集合中没有元素则返回true，反之为false
     */
    boolean isEmpty();

    /**
     * @param o 需要判断的元素
     * @return 如果存在该元素则返回true，反之为false
     */
    boolean contains(Object o);

    /**
     * 添加元素到最后面
     *
     * @param e 待添加的元素
     */
    void add(E e);

    /**
     * 清除集合中所有的元素
     */
    void clear();

    /**
     * 获取索引为index的位置的元素
     *
     * @param index 索引
     * @return 元素
     */
    E get(int index);

    /**
     * 设置索引为index的位置的元素
     *
     * @param index   索引
     * @param element 元素
     * @return 原来的元素
     */
    E set(int index, E element);

    /**
     * 在索引为index的位置添加元素
     *
     * @param index   索引
     * @param element 元素
     */
    void add(int index, E element);

    /**
     * 删除索引为index的位置的元素
     *
     * @param index 索引
     * @return 删除的元素
     */
    E remove(int index);

    /**
     * 获取元素所在索引位置
     *
     * @param o 元素
     * @return 索引
     */
    int indexOf(Object o);
}
