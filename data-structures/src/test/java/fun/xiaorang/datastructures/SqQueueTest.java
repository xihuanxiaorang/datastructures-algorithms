package fun.xiaorang.datastructures;

import fun.xiaorang.common.utils.Asserts;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author liulei
 * @description <p style = " font-weight:bold ; ">顺序队测试类<p/>
 * @github <a href="https://github.com/xihuanxiaorang/datastructures-algorithms">datastructures-algorithms</a>
 * @Copyright 博客：<a href="https://blog.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2022/11/14 9:29
 */
class SqQueueTest {
    public static final Logger LOGGER = LoggerFactory.getLogger(SqQueueTest.class);

    @Test
    public void test() {
        Queue<Integer> queue = new SqQueue<>(5);
        queue.offer(55);
        queue.offer(44);
        queue.offer(33);
        queue.offer(22);
        queue.offer(11);

        queue.forEach(System.out::println);

        Asserts.test(queue.element() == 55); // [55, 44, 33, 22, 11]
        Asserts.test(queue.poll() == 55); // [44, 33, 22, 11] -> 55
        Asserts.test(queue.poll() == 44); // [33, 22, 11] -> 44
        Asserts.test(queue.poll() == 33); // [22, 11] -> 33
        Asserts.test(queue.poll() == 22); // [11] -> 22
        Asserts.test(queue.poll() == 11); // [] -> 11
        Asserts.test(queue.isEmpty());
    }
}