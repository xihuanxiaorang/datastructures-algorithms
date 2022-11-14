package fun.xiaorang.datastructures;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author liulei
 * @description <p style = " font-weight:bold ; ">顺序队<p/>
 * @github <a href="https://github.com/xihuanxiaorang/datastructures-algorithms">datastructures-algorithms</a>
 * @Copyright 博客：<a href="https://blog.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2022/11/14 8:42
 */
@SuppressWarnings("unchecked")
public class SqQueue<E> implements Queue<E> {
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * 所有元素
     */
    private final Object[] elementData;
    /**
     * 队头指针
     */
    private int front;
    /**
     * 队尾指针
     */
    private int rear;

    public SqQueue() {
        this(DEFAULT_CAPACITY);
    }

    public SqQueue(int capacity) {
        if (capacity <= 0) capacity = DEFAULT_CAPACITY;
        elementData = new Object[capacity];
        front = rear = -1;
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public int size() {
        return rear - front;
    }

    @Override
    public void offer(E element) {
        if (rear == elementData.length - 1) {
            throw new IllegalStateException("Queue full");
        }
        elementData[++rear] = element;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue empty");
        }
        return (E) elementData[++front];
    }

    @Override
    public E element() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue empty");
        }
        return (E) elementData[front + 1];
    }

    @Override
    public void clear() {
        Arrays.fill(elementData, null);
        front = rear = -1;
    }

    @Override
    public Iterator<E> iterator() {
        return new SqQueueIterator();
    }

    private class SqQueueIterator implements Iterator<E> {
        int cursor;
        int remaining = size();

        SqQueueIterator() {
            cursor = front;
        }

        @Override
        public boolean hasNext() {
            return remaining > 0;
        }

        @Override
        public E next() {
            if (remaining <= 0) throw new NoSuchElementException();
            E e = (E) elementData[++cursor];
            remaining--;
            return e;
        }
    }
}
