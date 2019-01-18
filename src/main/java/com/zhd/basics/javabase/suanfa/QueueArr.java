package com.zhd.basics.javabase.suanfa;

import java.util.Arrays;

/**
 * @Author: zhanghaodong
 * @Description 数组实现队列
 * @Date: 2019-01-18 15:42
 */
public class QueueArr<E> {
    private Object[] arr = null;
    private int count = 0;
    private int size = 0;

    private int head = -1;
    private int tail = -1;

    public QueueArr(int size) {
        this.size = size;
        arr = new Object[size];
    }

    public static void main(String[] args) {
        QueueArr<Integer> queueArr = new QueueArr<Integer>(10);
        queueArr.push(0);
        queueArr.push(1);
        queueArr.push(2);
        queueArr.push(3);
        queueArr.push(4);
        queueArr.push(5);
        queueArr.push(6);
        queueArr.push(7);
        queueArr.push(8);
        queueArr.push(9);
        queueArr.getHead();
        queueArr.getHead();
        queueArr.getHead();
        queueArr.getHead();
        queueArr.getHead();
        queueArr.push(10);
        System.out.println(queueArr.toString());
        System.out.println(queueArr.toString2());
        System.out.println(queueArr.size());
    }

    public synchronized E getHead() {
        if (count <= 0) {
            return null;
        }
        E headE = (E) arr[head];
        arr[head] = null;
        count--;
        if (head >= size - 1) {
            head = 0;
        } else {
            head++;
        }
        return headE;
    }

    public synchronized boolean push(E e) {
        if (count >= size) {
            return false;
        }
        if (head < 0 || tail < 0) {
            head = 0;
            tail = 0;
            count++;
            arr[0] = e;
            return true;
        }
        if (tail >= size - 1) {
            tail = tail - size + 1;
            arr[tail] = e;
            count++;
            return true;
        }
        arr[++tail] = e;
        count++;
        return true;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    @Override
    public String toString() {
        if (head < 0 || tail < 0) {
            return "[]";
        }
        Object[] result = new Object[count];
        if (tail >= head) {
            System.arraycopy(arr, head, result, 0, count);
        } else {
            System.arraycopy(arr, head, result, 0, size - head);
            System.arraycopy(arr, 0, result, size - head, tail + 1);
        }
        return Arrays.toString(result);
    }
    public String toString2() {

        return Arrays.toString(arr);
    }


}
