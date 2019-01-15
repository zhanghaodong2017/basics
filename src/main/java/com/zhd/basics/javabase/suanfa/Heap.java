package com.zhd.basics.javabase.suanfa;

import java.util.Arrays;

/**
 * @Author: zhanghaodong
 * @Description
 * @Date: 2019-01-14 19:37
 */
public class Heap {
    private int[] arr;//数组从1开始存储
    private int size;//最大存储个数
    private int count;//已经存储个数

    public Heap(int size) {
        this.size = size;
        count = 0;
        arr = new int[size + 1];
    }

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(10);
        heap.insert(4);
        heap.insert(3);
        heap.insert(2);
        heap.insert(130);
        heap.insert(1);
        System.out.println(heap.toString());
        int top = heap.deleteTop();
        System.out.println(top);
        top = heap.deleteTop();
        System.out.println(top);
        System.out.println(heap.toString());
    }

    public void insert(int data) {
        if (count >= size) {
            return;//✔堆满了
        }
        arr[++count] = data;
        //自下而上堆化
        int i = count;
        while (i / 2 > 0 && (arr[i] > arr[i / 2])) {
            swap(arr, i, i / 2);
            i = i / 2;
        }


    }

    public int deleteTop() {
        if (count == 0) {
            return -1;//表示堆已经空了
        }

        int top = arr[1];
        arr[1] = arr[count];
        arr[count] = 0;
        count--;

        //自上而下堆化
        int i = 1;
        while (true) {
            int max = i;
            if (2 * i <= size && arr[max] < arr[2 * i]) {
                max = 2 * i;
            }
            if (2 * i + 1 <= size && arr[max] < arr[2 * i + 1]) {
                max = 2 * i + 1;
            }
            if (max == i) {
                break;
            }
            swap(arr, i, max);
            i = max;
        }

        return top;
    }

    /**
     * 交换
     *
     * @param arr
     * @param x
     * @param y
     */
    public void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;

    }

    @Override
    public String toString() {
        return Arrays.toString(arr);

    }
}
