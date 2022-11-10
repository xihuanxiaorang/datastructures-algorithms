package fun.xiaorang.datastructures;

import java.util.Arrays;

/**
 * @author liulei
 * @description <p style = " font-weight:bold ; ">顺序栈<p/>
 * @github <a href="https://github.com/xihuanxiaorang/datastructures-algorithms">datastructures-algorithms</a>
 * @Copyright 博客：<a href="https://blog.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2022/11/10 2:52
 */
public class SqStack<E> implements Stack<E> {
    private static final int DEFAULT_CAPACITY = 3;
    private static final int ELEMENT_NOT_FOUND = -1;
    private Object[] elementData;
    private int top;

    public SqStack() {
        elementData = new Object[DEFAULT_CAPACITY];
        top = ELEMENT_NOT_FOUND;
    }

    @Override
    public E push(E element) {
        ensureCapacity(top + 1);
        elementData[++top] = element;
        return element;
    }

    @Override
    public E pop() {
        if (empty()) return null;
        E obj = peek();
        elementData[top--] = null;
        return obj;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E peek() {
        return (E) elementData[top];
    }

    @Override
    public boolean empty() {
        return top == ELEMENT_NOT_FOUND;
    }

    private void ensureCapacity(int minCapacity) {
        // 判断扩容操作
        if (minCapacity < elementData.length) return;
        int oldCapacity = elementData.length;
        // 新容量=原来容量的两倍
        int newCapacity = oldCapacity << 1;
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        // 创建新数组，迁移数据
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
}
