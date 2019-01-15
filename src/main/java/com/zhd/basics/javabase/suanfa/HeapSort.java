package com.zhd.basics.javabase.suanfa;

import org.apache.commons.lang.math.RandomUtils;

import java.util.Arrays;

/**
 * @Author: zhanghaodong
 * @Description 堆排序
 * 数组从0开始：父节点 (i-1)/2,左子节点2i+1,右子节点2i+2,
 * 数组从1开始：父节点 i/2    ,左子节点2i  ,右子节点2i+1
 * 数组从y开始：父节点 (i+y-1)/2    ,左子节点2i+1-y  ,右子节点2i+2-y
 * 堆的中间点(start+end-1)/2
 * @Date: 2019-01-14 18:55
 */
public class HeapSort {
    public static void main(String[] args) {
//        test1();

        int lenth = 3000;
        int[] arr = new int[lenth];
        for (int i = 0; i < lenth; i++) {
            int nextInt = RandomUtils.nextInt(10000);
            arr[i] = nextInt;
        }
        buildHeap(arr, arr.length);
        long startTime = System.nanoTime();
        sort2(arr);
        long endTime = System.nanoTime();
        System.out.println("2用时:" + (endTime - startTime));
        System.out.println(Arrays.toString(arr));

        long startTime1 = System.nanoTime();
        sort(arr);
        long endTime1 = System.nanoTime();
        System.out.println("1用时:" + (endTime1 - startTime1));
        System.out.println(Arrays.toString(arr));

    }

    private static void test1() {
        int[] arr = {1, 4, 2, 6, 9, 4, 102, 5, 6, 8, 2, 34, 54, 12, 3, -10, -8, 100, 99};
        buildHeap(arr, arr.length);
        System.out.println(Arrays.toString(arr));
        long startTime = System.nanoTime();
        sort2(arr);
        long endTime = System.nanoTime();
        System.out.println("用时:" + (endTime - startTime));
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 原地排序
     *
     * @param arr
     * @return
     */
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            buildHeap(arr, i, arr.length - 1);
        }

    }

    /**
     * 原地排序2:思路-》去除顶点，把最后一个节点放到顶点
     *
     * @param arr
     * @return
     */
    public static void sort2(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            removeTop(arr, i, arr.length - 1);
        }

    }

    private static void removeTop(int[] arr, int top, int end) {
        int start = top + 1;
        int tail = arr[end];
        for (int k = end; k > start; k--) {
            arr[k] = arr[k - 1];
        }
        arr[start] = tail;

        int i = start;
        //自上而下堆化
        while (true) {
//            System.out.println("start:" + start + ",end:" + end + ",i=" + i + ":" + Arrays.toString(arr));
            int min = i;
            int zuo = 2 * i + 1 - start;
            if (zuo <= end && arr[min] > arr[zuo]) {
                min = zuo;
            }
            int you = 2 * i + 2 - start;
            if (you <= end && arr[min] > arr[you]) {
                min = you;
            }
            if (min == i) {
                break;
            }
            swap(arr, i, min);
            i = min;

        }
    }

    public static void buildHeap(int[] arr, int n) {
        for (int i = n / 2; i >= 0; --i) {
            heapify(arr, n, i);
        }
    }

    /**
     * @param arr
     * @param start
     * @param end
     */
    public static void buildHeap(int[] arr, int start, int end) {
        int middle = (end + start - 1) / 2;
        for (int i = middle; i >= start; i--) {
            heapify2(arr, start, end, i);
        }
    }

    public static void heapify2(int[] arr, int start, int end, int i) {

        while (true) {
//            System.out.println("start:" + start + ",end:" + end + ",i=" + i + ":" + Arrays.toString(arr));
            int min = i;
            int zuo = 2 * i + 1 - start;
            if (zuo <= end && arr[min] > arr[zuo]) {
                min = zuo;
            }
            int you = 2 * i + 2 - start;
            if (you <= end && arr[min] > arr[you]) {
                min = you;
            }
            if (min == i) {
                break;
            }
            swap(arr, i, min);
            i = min;

        }

    }

    public static void heapify(int[] arr, int n, int i) {

        while (true) {
//            System.out.println(i + ":" + Arrays.toString(arr));
            int min = i;

            if (2 * i + 1 < n && arr[min] > arr[2 * i + 1]) {
                min = 2 * i + 1;
            }
            if (2 * i + 2 < n && arr[min] > arr[2 * i + 2]) {
                min = 2 * i + 2;
            }
            if (min == i) {
                break;
            }
            swap(arr, i, min);
            i = min;

        }

    }


    /**
     * 交换
     *
     * @param arr
     * @param x
     * @param y
     */
    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;

    }
}

