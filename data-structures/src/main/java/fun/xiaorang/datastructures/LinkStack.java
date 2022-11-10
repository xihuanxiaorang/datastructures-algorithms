package fun.xiaorang.datastructures;

/**
 * @author liulei
 * @description <p style = " font-weight:bold ; ">链栈<p/>
 * @github <a href="https://github.com/xihuanxiaorang/datastructures-algorithms">datastructures-algorithms</a>
 * @Copyright 博客：<a href="https://blog.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2022/11/10 5:03
 */
public class LinkStack<E> implements Stack<E> {
    private Node<E> head;

    @Override
    public E push(E element) {
        head = new Node<>(element, head);
        return element;
    }

    @Override
    public E pop() {
        if (empty()) return null;
        E element = head.item;
        head = head.next;
        return element;
    }

    @Override
    public E peek() {
        return head.item;
    }

    @Override
    public boolean empty() {
        return head == null;
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }
}
