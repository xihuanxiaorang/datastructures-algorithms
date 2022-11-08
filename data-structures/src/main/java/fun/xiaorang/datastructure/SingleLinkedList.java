package fun.xiaorang.datastructure;

/**
 * @author liulei
 * @description <p style = " font-weight:bold ; ">单向链表<p/>
 * @github <a href="https://github.com/xihuanxiaorang/datastructures-algorithms">datastructures-algorithms</a>
 * @Copyright 博客：<a href="https://xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2022/11/6 2:10
 */
public class SingleLinkedList<E> extends AbstractList<E> {
    private Node<E> first;

    @Override
    public void add(E e) {
        add(size, e);
    }

    @Override
    public void clear() {
        first = null;
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
        if (index == 0) {
            first = new Node<>(element, first);
        } else {
            Node<E> prev = node(index - 1);
            prev.next = new Node<>(element, prev.next);
        }
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = first;
        if (index == 0) {
            first = first.next;
        } else {
            Node<E> prev = node(index - 1);
            node = prev.next;
            prev.next = node.next;
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
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(item).append("_");
            if (next != null) {
                sb.append(next.item);
            } else {
                sb.append("null");
            }
            return sb.toString();
        }
    }
}
