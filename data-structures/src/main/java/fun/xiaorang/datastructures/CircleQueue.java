package fun.xiaorang.datastructures;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author liulei
 * @description <p style = " font-weight:bold ; ">循环队列<p/>
 * @github <a href="https://github.com/xihuanxiaorang/datastructures-algorithms">datastructures-algorithms</a>
 * @Copyright 博客：<a href="https://blog.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2022/11/14 23:17
 */
@SuppressWarnings("unchecked")
public class CircleQueue<E> implements Queue<E> {
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

    public CircleQueue() {
        this(DEFAULT_CAPACITY);
    }

    public CircleQueue(int capacity) {
        if (capacity <= 0) capacity = DEFAULT_CAPACITY;
        elementData = new Object[capacity + 1];
        front = rear = 0;
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public int size() {
        return (rear - front + elementData.length) % elementData.length;
    }

    @Override
    public void offer(E element) {
        if ((rear + 1) % elementData.length == front) throw new IllegalStateException("Queue full");
        elementData[rear] = element;
        rear = (rear + 1) % elementData.length;
    }

    @Override
    public E poll() {
        if (isEmpty()) throw new IllegalStateException("Queue empty");
        E e = (E) elementData[front];
        front = (front + 1) % elementData.length;
        return e;
    }

    @Override
    public E element() {
        if (isEmpty()) throw new IllegalStateException("Queue empty");
        return (E) elementData[front];
    }

    @Override
    public void clear() {
        Arrays.fill(elementData, null);
        front = rear = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new CircleQueueIterator();
    }

    private class CircleQueueIterator implements Iterator<E> {
        int cursor;
        int remaining = size();

        CircleQueueIterator() {
            cursor = front;
        }

        @Override
        public boolean hasNext() {
            return remaining > 0;
        }

        @Override
        public E next() {
            if (remaining <= 0) throw new NoSuchElementException();
            E e = (E) elementData[cursor];
            cursor = (cursor + 1) % elementData.length;
            remaining--;
            return e;
        }
    }
}
