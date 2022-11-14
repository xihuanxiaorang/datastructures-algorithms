package fun.xiaorang.datastructures;

import fun.xiaorang.common.utils.Asserts;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author liulei
 * @description <p style = " font-weight:bold ; ">双端队列测试类<p/>
 * @github <a href="https://github.com/xihuanxiaorang/datastructures-algorithms">datastructures-algorithms</a>
 * @Copyright 博客：<a href="https://blog.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2022/11/15 5:03
 */
class ArrayDequeTest {
    public static final Logger LOGGER = LoggerFactory.getLogger(ArrayDequeTest.class);

    @Test
    public void test() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(33);
        deque.addFirst(44);
        deque.addLast(22);
        deque.addFirst(55);
        deque.addLast(11);

        deque.forEach(System.out::println);

        Asserts.test(deque.getFirst() == 55); // [55, 44, 33, 22, 11]
        Asserts.test(deque.removeFirst() == 55); // [44, 33, 22, 11] -> 55
        Asserts.test(deque.removeLast() == 11); // [44, 33, 22] -> 11
        Asserts.test(deque.removeFirst() == 44); // [33, 22] -> 44
        Asserts.test(deque.removeLast() == 22); // [33] -> 22
        Asserts.test(deque.removeFirst() == 33); // [] -> 33
        Asserts.test(deque.isEmpty());
    }
}