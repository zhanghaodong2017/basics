package com.zhd.basics.javabase.suanfa;

import java.util.Stack;

/**
 * @Author: zhanghaodong
 * @Description 四则运算 +-/*
 * @Date: 2019-01-18 13:39
 */
public class FourOperation {

    public static Stack<Object> operation(String expression) {
        Stack<Object> numStack = new Stack<Object>();
        Stack<String> charStack = new Stack<String>();

        String[] array = expression.split(" ");
        for (int i = 0; i < array.length; i++) {
            String str = array[i];
            if ("(".equals(str) || "*".equals(str) || "/".equals(str)) {
                charStack.push(str);//直接压栈
                continue;
            }
            if (")".equals(str)) {
                String pop;
                while (charStack.size() > 0 && !(pop = charStack.pop()).equals("(")) {
                    numStack.push(pop);
                }
                continue;
            }
            Integer num = convert(str);
            if (num != null) {
                numStack.push(num);
                continue;
            }

            /**
             * 如果是加减法，全部出栈道(
             */
            while (charStack.size() > 0 && !charStack.peek().equals("(")) {
                numStack.push(charStack.pop());
            }
            charStack.push(str);//直接压栈


        }
        while (charStack.size() > 0) {
            numStack.push(charStack.pop());
        }
        return numStack;

    }

    /**
     * 表达式以空格分割
     *
     * @param args
     */
    public static void main(String[] args) {
        String expression = "9 + ( 3 - 1 ) * 3 + 10 / 2";
        Stack<Object> stack = operation(expression);

        System.out.println(stack.toString());
        System.out.println(jisuan(back(stack)));
    }

    public static int jisuan(Stack<Object> stack) {
        Stack<Integer> numStack = new Stack<Integer>();
        while (stack.size() > 0) {
            Object pop = stack.pop();
            if (pop instanceof Integer) {
                numStack.push((Integer) pop);
            } else {
                Integer num2 = numStack.pop();
                Integer num1 = numStack.pop();
                Integer result = jjxc(num1, num2, pop);
                numStack.push(result);
            }
        }
        System.out.println(numStack.toString());
        return numStack.peek();
    }

    private static Integer jjxc(Integer num1, Integer num2, Object pop) {
        if (pop.equals("+")) {
            return num1 + num2;
        }
        if (pop.equals("-")) {
            return num1 - num2;
        }
        if (pop.equals("*")) {
            return num1 * num2;
        }
        if (pop.equals("/")) {
            return num1 / num2;
        }
        return null;
    }


    public static Stack<Object> back(Stack<Object> stack) {
        Stack<Object> result = new Stack<Object>();

        while (stack.size() > 0) {
            result.push(stack.pop());
        }
        return result;
    }

    public static Integer convert(String str) {
        try {
            return Integer.valueOf(str);
        } catch (NumberFormatException e) {
        }
        return null;
    }

}
