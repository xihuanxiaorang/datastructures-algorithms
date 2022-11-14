package fun.xiaorang.datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author liulei
 * @description <p style = " font-weight:bold ; ">链队<p/>
 * @github <a href="https://github.com/xihuanxiaorang/datastructures-algorithms">datastructures-algorithms</a>
 * @Copyright 博客：<a href="https://blog.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2022/11/15 1:04
 */
public class LinkedQueue<E> implements Queue<E> {
    private Node<E> front;
    private Node<E> rear;
    private int size;

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void offer(E element) {
        Node<E> node = new Node<>(element, null);
        if (isEmpty()) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
        size++;
    }

    @Override
    public E poll() {
        if (isEmpty()) return null;
        E element = front.item;
        front = front.next;
        size--;
        return element;
    }

    @Override
    public E element() {
        if (isEmpty()) return null;
        return front.item;
    }

    @Override
    public void clear() {
        front = rear = null;
        size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedQueueIterator();
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    private class LinkedQueueIterator implements Iterator<E> {
        Node<E> cursor;

        LinkedQueueIterator() {
            cursor = front;
        }

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public E next() {
            if (cursor == null) throw new NoSuchElementException();
            E e = cursor.item;
            cursor = cursor.next;
            return e;
        }
    }
}
