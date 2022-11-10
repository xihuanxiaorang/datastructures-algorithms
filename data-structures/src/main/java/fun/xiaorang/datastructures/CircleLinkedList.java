package fun.xiaorang.datastructures;

/**
 * @author liulei
 * @description <p style = " font-weight:bold ; ">双向循环链表<p/>
 * @github <a href="https://github.com/xihuanxiaorang/datastructures-algorithms">datastructures-algorithms</a>
 * @Copyright 博客：<a href="https://blog.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2022/11/6 2:10
 */
public class CircleLinkedList<E> extends AbstractList<E> {
    private Node<E> first;
    private Node<E> last;

    @Override
    public void add(E e) {
        add(size, e);
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        return node(index).item;
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        Node<E> node = node(index);
        E oldValue = node.item;
        node.item = element;
        return oldValue;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if (index == size) {
            Node<E> oldLast = last;
            last = new Node<>(element, oldLast, first);
            if (oldLast == null) { // 这是链表添加的第一个元素
                first = last;
                first.prev = first;
                first.next = first;
            } else {
                oldLast.next = last;
                first.prev = last;
            }
        } else {
            Node<E> node = node(index);
            Node<E> newNode = new Node<>(element, node.prev, node);
            node.prev.next = newNode;
            node.prev = newNode;
            if (index == 0) first = newNode;
        }
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = first;
        if (size == 1) {
            first = null;
            last = null;
        } else {
            node = node(index);
            Node<E> prev = node.prev;
            Node<E> next = node.next;
            prev.next = next;
            next.prev = prev;
            if (last == node) last = prev;
            if (first == node) first = next;
        }
        size--;
        return node.item;
    }

    @Override
    public int indexOf(Object o) {
        Node<E> node = first;
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (node.item == null) return i;
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(node.item)) return i;
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Size=").append(size).append(", [");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(',').append(' ');
            }
            sb.append(node);
            node = node.next;
        }
        sb.append(']');
        return sb.toString();
    }

    private Node<E> node(int index) {
        Node<E> node;
        if (index < (size >> 1)) {
            node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
    }

    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        public Node(E item, Node<E> prev, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return (prev == null ? "null" : prev.item) + "_" + item + "_" + (next == null ? "null" : next.item);
        }
    }
}
