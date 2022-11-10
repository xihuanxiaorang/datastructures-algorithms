package fun.xiaorang.algorithms;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liulei
 * @description <p style = " font-weight:bold ; ">逆波兰表达式<p/>
 * @github <a href="https://github.com/xihuanxiaorang/datastructures-algorithms">datastructures-algorithms</a>
 * @Copyright 博客：<a href="https://blog.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2022/11/10 9:37
 */
public class ReversePolishNotation {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReversePolishNotation.class);

    public static void main(String[] args) {
        String infixExpression = "1+((2+3)*4)-5";
        // 中缀表达式转成 List，方便在后续操作中获取数据
        List<String> infixExpressionList = infixExp2List(infixExpression);
        LOGGER.info("中缀表达式为：{}，中缀表达式List为：{}", infixExpression, infixExpressionList);
        // 中缀表达式List 转成 后缀表达式List
        List<String> suffixExpressionList = infixExpressionList2SuffixExpressionList(infixExpressionList);
        LOGGER.info("中缀表达式为：{}，后缀表达式为：{}", infixExpression, suffixExpressionList);
        int res = evalRPN(suffixExpressionList);
        LOGGER.info("计算结果为：{} = {}", infixExpression, res);
    }

    /**
     * 计算后缀表达式的值，对应到<a href="https://leetcode.cn/problems/8Zf90G/description/">LeetCode的第36题：计算后缀表达式的值</a>
     *
     * @param suffixExpressionList 后缀表达式List
     * @return 表达式结果值
     */
    public static int evalRPN(List<String> suffixExpressionList) {
        Stack<Integer> stack = new Stack<>();
        for (String item : suffixExpressionList) {
            // 如果是操作数，则直接压入栈中
            if (item.matches("\\d+")) {
                stack.push(Integer.valueOf(item));
                continue;
            }
            Integer num2 = stack.pop(); // 栈顶操作数
            Integer num1 = stack.pop(); // 次顶操作数
            stack.push(cal(num1, num2, item));
        }
        return stack.pop();
    }

    /**
     * 中缀表达式 List 转换成后缀表达式 List
     *
     * @param infixExpressionList 中缀表达式 List
     * @return 后缀表达式 List
     */
    public static List<String> infixExpressionList2SuffixExpressionList(List<String> infixExpressionList) {
        // 符号栈
        Stack<String> s1 = new Stack<>();
        // 思路是使用栈来存储表达式元素
        // 仔细观察他的解析步骤，会发现：只是在入栈，并未出现出栈操作
        // 而且，最后的结果还要逆序，所以这里使用 list，直接顺序读取出来就是最后的结果了
        List<String> s2 = new ArrayList<>();
        for (String item : infixExpressionList) {
            if (item.matches("\\d+")) {
                // 如果是数字，则加入 s2
                s2.add(item);
            } else if ("(".equals(item)) {
                // 如果是左括号，直接压入 s1
                s1.push(item);
            } else if (")".equals(item)) {
                // 如果是右括号，则依次弹出 s1 栈顶的运算符，并压入 s2，直到遇到 左括号 为止
                while (!"(".equals(s1.peek())) {
                    s2.add(s1.pop());
                }
                // 丢弃左括号
                s1.pop();
            } else {
                // 如果 s1 为空，或则栈顶运算符为 （，则压入符号栈 s1
                // 如果优先级比栈顶运算符 高，则压入符号栈 s1,否则，否则将 s1 栈顶的运算符弹出，压入 s2 中
                // 上面两句话，转换成下面的描述
                // 上面如果  s1 栈顶符号优先级比 当前符号高，则弹出加入到 s2 中。
                // 因为：如果栈顶符号是 （ 返回优先级为 -1.比当前符号低，则不会走该方法
                while (!s1.isEmpty() && (priority(s1.peek()) >= priority(item))) {
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        // 将 s1 中剩余的运算符依次弹出并加入 s2 中
        while (!s1.isEmpty()) s2.add(s1.pop());
        return s2;
    }

    /**
     * 次顶操作数 运算符 栈顶操作数
     *
     * @param num1     次顶操作数
     * @param num2     栈顶操作数
     * @param operator 运算符
     * @return 结果值
     */
    private static int cal(int num1, int num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                throw new IllegalArgumentException("不支持的运算符：" + operator);
        }
    }

    /**
     * 计算操作符的优先级，目前只支持 + - * /
     *
     * @param operator 操作符
     * @return 优先级越高，数值越大
     */
    private static int priority(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 0;
            case "*":
            case "/":
                return 1;
            default:
                return -1;
        }
    }

    /**
     * 将中缀表达式解析成单个元素的 List，
     *
     * @param infixExpression 中缀表达式
     * @return 1+((2+3)*4)-5 -> [1,+,(,(,2,+,3,),*,4,),5]
     */
    private static List<String> infixExp2List(String infixExpression) {
        List<String> res = new ArrayList<>();
        // 扫描并解析
        int i = 0;
        char ch;
        String tempNum = ""; // 支持多位数
        while (i < infixExpression.length()) {
            // 如果不是操作数，就是运算符，直接添加到容器中
            // 0 = 48, 9 = 57
            ch = infixExpression.charAt(i++);
            if (!(ch >= 48 && ch <= 57)) {
                // 碰到运算符时，就将前面积攒下来的多位数添加到容器中
                if (!tempNum.isEmpty()) {
                    res.add(tempNum);
                    tempNum = "";
                }
                // 然后再将该运算符添加到容器中
                res.add(ch + "");
                continue;
            }
            // 如果是操作数，则考虑处理多位数
            tempNum += ch;
            // 如果已经是最后一个字符了，则将这个多位数添加到容器中
            if (i == infixExpression.length()) {
                res.add(tempNum);
                tempNum = "";
            }
        }
        return res;
    }
}
