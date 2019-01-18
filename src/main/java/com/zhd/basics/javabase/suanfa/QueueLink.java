package com.zhd.basics.javabase.suanfa;

import java.util.Arrays;

/**
 * @Author: zhanghaodong
 * @Description 队列的链表实现
 * @Date: 2019-01-18 16:14
 */
public class QueueLink<E> {
    private MyNode head = null;
    private MyNode tail = null;

    private int size = 0;

    public static void main(String[] args) {
        QueueLink<Integer> integerQueueLink = new QueueLink<Integer>();
        integerQueueLink.push(1);
        integerQueueLink.push(2);
        integerQueueLink.push(3);
        integerQueueLink.push(4);
        integerQueueLink.push(5);
        integerQueueLink.push(6);
        integerQueueLink.push(7);
        Integer head = integerQueueLink.getHead();
        System.out.println(head);
        head = integerQueueLink.getHead();
        System.out.println(head);
        head = integerQueueLink.getHead();
        System.out.println(head);
        head = integerQueueLink.getHead();
        System.out.println(head);
        head = integerQueueLink.getHead();
        System.out.println(head);
        head = integerQueueLink.getHead();
        System.out.println(head);
        head = integerQueueLink.getHead();
        System.out.println(head);
        integerQueueLink.push(10);
        System.out.println(integerQueueLink.toString());
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public synchronized boolean push(E e) {
        if (head == null || tail == null) {
            size++;
            MyNode<E> eMyNode = new MyNode<E>(e);
            head = eMyNode;
            tail = eMyNode;
            return true;
        }
        MyNode<E> eMyNode = new MyNode<E>(e);
        tail.next = eMyNode;
        tail = eMyNode;
        size++;
        return true;
    }

    public synchronized E getHead() {
        if (size <= 0) {
            return null;
        }
        E data = (E) head.data;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        size--;
        return data;
    }

    @Override
    public String toString() {
        Object[] arr = new Object[size];
        int index = 0;
        MyNode myNode = head;
        while (myNode != null) {
            arr[index++] = myNode.data;
            myNode = myNode.next;
        }
        return Arrays.toString(arr);
    }

    private static class MyNode<E> {
        private E data;
        private MyNode next;

        public MyNode(E data) {
            this.data = data;
        }
    }
}
