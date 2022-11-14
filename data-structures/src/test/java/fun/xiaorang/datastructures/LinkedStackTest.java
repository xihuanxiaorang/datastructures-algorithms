package fun.xiaorang.datastructures;

import fun.xiaorang.common.utils.Asserts;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author liulei
 * @description <p style = " font-weight:bold ; ">链栈测试类<p/>
 * @github <a href="https://github.com/xihuanxiaorang/datastructures-algorithms">datastructures-algorithms</a>
 * @Copyright 博客：<a href="https://blog.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2022/11/10 5:08
 */
class LinkedStackTest {
    public static final Logger LOGGER = LoggerFactory.getLogger(LinkedStackTest.class);

    @Test
    public void test() {
        Stack<Integer> stack = new LinkedStack<>();
        stack.push(11);
        stack.push(22);
        stack.push(33);
        stack.push(44);

        Asserts.test(stack.peek() == 44);
        Asserts.test(stack.pop() == 44); // [11, 22, 33] -> 44
        Asserts.test(stack.pop() == 33); // [11, 22] -> 33
        Asserts.test(stack.pop() == 22); // [11] -> 22
        Asserts.test(stack.pop() == 11); // [] -> 11
        Asserts.test(stack.empty());
    }
}