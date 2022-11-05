package fun.xiaorang.datastructure;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author liulei
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/datastructures-algorithms">datastructures-algorithms</a>
 * @Copyright 博客：<a href="https://xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2022/11/6 3:53
 */
public class LinkedListTest {
    public static final Logger LOGGER = LoggerFactory.getLogger(LinkedListTest.class);

    @Test
    public void test() {
        List<Integer> integerList = new LinkedList<>();
        integerList.add(1);
        integerList.add(0, 2);
        integerList.add(3);
        integerList.add(integerList.size(), 4);
        integerList.remove(0);
        // 1, 3 , 4
        LOGGER.info(integerList.toString());
    }
}