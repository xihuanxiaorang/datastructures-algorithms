package fun.xiaorang.datastructures;

/**
 * @author liulei
 * @description <p style = " font-weight:bold ; ">栈<p/>
 * @github <a href="https://github.com/xihuanxiaorang/datastructures-algorithms">datastructures-algorithms</a>
 * @Copyright 博客：<a href="https://blog.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2022/11/10 3:14
 */
public interface Stack<E> {
    /**
     * 元素进栈
     *
     * @param element 进栈的元素
     * @return 进栈的元素
     */
    E push(E element);

    /**
     * 元素出栈
     *
     * @return 栈顶元素
     */
    E pop();

    /**
     * 查看栈顶元素
     *
     * @return 栈顶元素
     */
    E peek();

    /**
     * 栈是否为空
     *
     * @return true表示栈为空，false表示栈不为空
     */
    boolean empty();
}
