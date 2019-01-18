package com.zhd.basics.javabase.suanfa;

import java.util.Arrays;

/**
 * @Author: zhanghaodong
 * @Description 栈的链表实现
 * @Date: 2019-01-18 11:38
 */
public class StackLink<E> {

    private MyNode top = null;
    private int myCount = 0;

    public static void main(String[] args) {
        StackLink<Integer> integerStackLink = new StackLink<Integer>();
        integerStackLink.push(10);
        integerStackLink.push(11);
        integerStackLink.push(12);
        integerStackLink.push(13);
        integerStackLink.push(14);
        Integer pop = integerStackLink.pop();
        System.out.println(pop);
        System.out.println(integerStackLink.toString());
    }

    public int size() {
        return myCount;
    }

    public void push(E e) {
        MyNode myNode = new MyNode(top, e);
        top = myNode;
        myCount++;
    }

    public E pop() {
        if (top == null) {
            return null;
        }
        E e = (E) top.data;
        top = top.next;
        --myCount;
        return e;
    }

    @Override
    public String toString() {
        Object[] objects = new Object[myCount];
        MyNode myNode = this.top;
        int mySize = myCount;
        while (myNode != null) {
            objects[--mySize] = myNode.data;
            myNode = myNode.next;
        }
        return Arrays.toString(objects);
    }

    private static class MyNode {
        private MyNode next;
        private Object data;


        public MyNode(MyNode next, Object data) {
            this.next = next;
            this.data = data;
        }
    }

}
