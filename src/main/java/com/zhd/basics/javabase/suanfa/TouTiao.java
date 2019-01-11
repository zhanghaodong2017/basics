package com.zhd.basics.javabase.suanfa;

import java.util.*;

public class TouTiao {

    /**
     * 题目描述：输出数组中相差为给定值的数对个数，重复的一对只算一次。 输入：
     * 第一行输入整数n和k，（n在[1，1000000]，k在[0，100]）； 第二行输入n个正整数。 输出： 整数，表示求出的数对个数。
     */
    private static void fun1() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        long start = System.nanoTime();
        // insertionSort(array);
        Arrays.sort(array);
        // System.out.println(Arrays.toString(array));
        System.out.println(count2(array, k));
        long end = System.nanoTime();
        System.out.println("用时：" + (end - start) + "纳秒");

    }

    private static void fun2() {
        // 随机生成1万个10万以内的整数
        int[] array = new int[10000];
        for (int i = 0; i < array.length; i++) {
            int nextInt = new Random().nextInt(100000);
            array[i] = nextInt;
        }
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        long start = System.nanoTime();
        // insertionSort(array);
        Arrays.sort(array);
        // System.out.println(Arrays.toString(array));
        System.out.println(count(array, k));
        long end = System.nanoTime();
        System.out.println("用时：" + (end - start) + "纳秒");

    }

    // 插入排序，从小到大
    private static void insertionSort(int[] array) {
        int temp;
        int hole;
        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            for (hole = i; hole > 0 && temp < (array[hole - 1]); ) {
                array[hole] = array[--hole];
            }

            array[hole] = temp;
        }
    }

    private static int count(int[] array, int k) {
        int count = 0;
        int size = array.length;
        if (size == 1) {
            return 0;
        }
        for (int i = 0; i < size - 1; i++) {
            if (array[i] == array[i + 1]) {
                i = tail(array, i + 1);
                if (k == 0) { // k = 0时，重复的一组元素算一对
                    count++;
                    continue;
                }
            }
            for (int j = i + 1; j < size; j++) {
                if (j != size - 1 && array[j] == array[j + 1]) {
                    j = tail(array, j + 1);
                }
                if (array[i] + k == array[j]) {
                    count++;
                }
            }
        }
        return count;

    }

    private static int count2(int[] array, int k) {
        int size = array.length;
        int count = 0;
        if (size == 1) {
            return 0;
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < size - 2; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int result = Math.abs(array[i] - array[j]);
                int result2 = array[i] + array[j];
                if (result == k && !list.contains(result2)) {
                    list.add(result2);
                    count++;
                }
            }
        }
        return count;

    }

    // 定位到连续重复元素的末尾
    private static int tail(int[] array, int index) {
        for (int i = index; i < array.length; i++) {
            if (array[i] != array[i - 1]) {
                return i - 1;
            }
        }
        return array.length - 1;
    }

    public static void main(String[] args) {
        // fun2();

    }
}



