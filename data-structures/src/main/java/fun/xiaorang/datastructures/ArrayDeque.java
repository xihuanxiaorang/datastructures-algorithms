package fun.xiaorang.datastructures;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author liulei
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/datastructures-algorithms">datastructures-algorithms</a>
 * @Copyright 博客：<a href="https://blog.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2022/11/15 4:27
 */
@SuppressWarnings("unchecked")
public class ArrayDeque<E> implements Deque<E> {
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * 所有元素
     */
    private Object[] elementData;
    /**
     * 队尾指针
     */
    private int rear;
    /**
     * 元素数量
     */
    private int size;
    /**
     * 队头指针
     */
    private int front;

    public ArrayDeque() {
        elementData = new Object[DEFAULT_CAPACITY + 1];
        front = rear = size = 0;
    }

    @Override
    public void addFirst(E e) {
        if (isFull()) resize(2 * elementData.length + 1);
        front = (front - 1 + elementData.length) % elementData.length;
        elementData[front] = e;
        size++;
    }

    @Override
    public void addLast(E e) {
        if (isFull()) resize(2 * elementData.length + 1);
        elementData[rear] = e;
        rear = (rear + 1) % elementData.length;
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) throw new IllegalStateException("Deque empty");
        E e = (E) elementData[front];
        front = (front + 1) % elementData.length;
        size--;
        if (size <= (elementData.length - 1) / 4 && elementData.length - 1 > DEFAULT_CAPACITY)
            resize((elementData.length >> 1) + 1);
        return e;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) throw new IllegalStateException("Deque empty");
        rear = (rear - 1 + elementData.length) % elementData.length;
        E e = (E) elementData[rear];
        size--;
        if (size <= (elementData.length - 1) / 4 && elementData.length - 1 > DEFAULT_CAPACITY)
            resize((elementData.length >> 1) + 1);
        return e;
    }

    @Override
    public E getFirst() {
        if (isEmpty()) throw new IllegalStateException("Deque empty");
        return (E) elementData[front];
    }

    @Override
    public E getLast() {
        if (isEmpty()) throw new IllegalStateException("Deque empty");
        return (E) elementData[(rear - 1 + elementData.length) % elementData.length];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        elementData = new Object[DEFAULT_CAPACITY + 1];
        front = rear = size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator();
    }

    @Override
    public String toString() {
        return "ArrayDeque{" +
                "elementData=" + Arrays.toString(elementData) +
                ", rear=" + rear +
                ", size=" + size +
                ", front=" + front +
                '}';
    }

    private void resize(int newCapacity) {
        Object[] newElementData = new Object[newCapacity];
        int cursor = front;
        int index = 0;
        while (cursor != rear) {
            newElementData[index++] = elementData[cursor];
            cursor = (cursor + 1) % elementData.length;
        }
        elementData = newElementData;
        front = 0;
        rear = index;
    }

    private boolean isFull() {
        return (rear + 1) % elementData.length == front;
    }

    private class ArrayIterator implements Iterator<E> {
        private int remaining = size();
        private int cursor;

        public ArrayIterator() {
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
