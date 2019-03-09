package com.zhd.basics.javabase.suanfa;

import org.apache.commons.lang.math.RandomUtils;

import java.util.Arrays;

/**
 * @Author: zhanghaodong
 * @Description 排序
 * @Date: 2019-01-11 14:32
 */
public class MySort {

    /**
     * 从小到大顺序排序
     *
     * @param args
     */
    public static void main(String[] args) {
//        test1();
        int[] arr2 = {2, 9, 3, 5, 1, 2, 4, 7, 8, 9, 3, 9};
        int[] result = jishu(arr2);
        System.out.println(Arrays.toString(result));

    }

    private static void test1() {
        int[] arr = {1, 4, 2, 6, 9, 4, 102, 5, 6, 8, 2, 34, 54, 12, 3, -10, -8, 100, 99};
//        int[] myArr = {101, 1, 60, 9, 108, 20, 188};
//        shuaxin(myArr, 0, myArr.length - 1, 2);
//        System.out.println(Arrays.toString(myArr));
//        System.out.println(Arrays.toString(maopao(arr)));
//        System.out.println(Arrays.toString(xuanze(arr)));
//        System.out.println(Arrays.toString(charu(arr)));
//        System.out.println(Arrays.toString(guibing(arr)));
//        \kuaisu(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));
        shellSort(arr);
        System.out.println(Arrays.toString(arr));


//        如何在 O(n) 的时间复杂度内查找一个无序数组中的第 K 大元素？快排的思想
    }

    /**
     * 冒泡排序：原地排序，时间复杂度O(n^2)，稳定排序
     *
     * @param arr
     * @return
     */
    public static int[] maopao(int[] arr) {

        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 选择排序：原地排序，时间复杂度O(n^2)，不稳定排序
     *
     * @param arr
     * @return
     */
    public static int[] xuanze(int[] arr) {

        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int min_index = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
            //交换
            if (min_index != i) {
                temp = arr[min_index];
                arr[min_index] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }

    /**
     * 希尔排序：原地排序，时间复杂度O(n^2)，不稳定排序
     *
     * @param arr
     * @return
     */
    public static int[] shellSort(int[] arr) {

        int increase = arr.length / 2 + 1;
        while (increase > 1) {
            for (int i = 0; i < arr.length - increase; i++) {
                if (arr[i] > arr[i + increase]) {
                    swap(arr, i, i + increase);
                }
            }
            increase--;
        }
        return arr;
    }

    /**
     * 插入排序：原地排序，时间复杂度O(n^2)，稳定排序
     *
     * @param arr
     * @return
     */
    public static int[] charu(int[] arr) {

        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int min_index = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
            //[i,min_index-1]下标后的数据后移一位
            if (min_index != i) {
                temp = arr[min_index];
                for (int j = min_index; j > i; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[i] = temp;
            }

        }
        return arr;
    }

    /**
     * 归并排序：不是原地排序，时间复杂度O(n*longN)，稳定排序
     *
     * @param arr
     * @return
     */
    public static int[] guibing(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int mod = arr.length / 2;
        int[] a = new int[mod];
        int[] b = new int[arr.length - mod];
        System.arraycopy(arr, 0, a, 0, mod);
        System.arraycopy(arr, mod, b, 0, arr.length - mod);
        return hebing(guibing(a), guibing(b));
    }

    /**
     * /**
     * 计数排序：不是原地排序，时间复杂度O(longN)，稳定排序
     * 计数排序对数据有要求
     *
     * @param arr
     * @return
     */
    public static int[] jishu(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int[] result = new int[arr.length];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int[] arrA = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            arrA[arr[i]]++;
        }
        int sum = 0;
        for (int k = 1; k < max + 1; k++) {
            sum += arrA[k];
            arrA[k] = sum;
        }

        for (int i = 0; i < arr.length; i++) {
            int num = arrA[arr[i]];
            result[num - 1] = arr[i];
            arrA[arr[i]]--;
        }


        return result;
    }

    /**
     * 两个有序数组合并
     *
     * @param a
     * @param b
     * @return
     */
    public static int[] hebing(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int index_a = 0, index_b = 0;
        for (int i = 0; i < result.length; i++) {
            if (index_a >= a.length) {
                result[i] = b[index_b++];
                continue;
            }
            if (index_b >= b.length) {
                result[i] = a[index_a++];
                continue;
            }
            if (a[index_a] <= b[index_b]) {
                result[i] = a[index_a++];
            } else {
                result[i] = b[index_b++];
            }
        }
        return result;
    }


    /**
     * 快速排序：原地排序，时间复杂度O(n*longN)，稳定排序
     *
     * @param arr
     * @return
     */
    public static void kuaisu(int[] arr, int start_index, int end_index) {
        if (start_index >= end_index) {
            return;
        }
        int pivot = partition(start_index, end_index);
        System.out.println("start_index:" + start_index + ",end_index:" + end_index + ",pivot:" + pivot);
        //将小于arr[pivot] 的数放在左边，大于arr[pivot] 的数放在右边
        pivot = shuaxin(arr, start_index, end_index, pivot);

        kuaisu(arr, start_index, pivot - 1);
        kuaisu(arr, pivot + 1, end_index);
    }

    /**
     * 101, 1, 60, 9, 108, 20, 188
     *
     * @param arr
     * @param start_index
     * @param end_index
     * @param pivot
     */
    public static int shuaxin(int[] arr, int start_index, int end_index, int pivot) {
        if (pivot < start_index || pivot > end_index) {
            return 0;
        }
//        int i = start_index;
        for (int j = start_index; j <= end_index; j++) {
            if (j < pivot && arr[j] > arr[pivot]) {
                swap(arr, pivot, j);
                pivot = j;
            } else if (j > pivot && arr[j] < arr[pivot]) {
                swap(arr, pivot, j);
                int temp = pivot;
                pivot = j;
                j = temp;
            }
        }
        return pivot;
    }


    /**
     * @param start_index
     * @param end_index
     * @return
     */
    public static int partition(int start_index, int end_index) {
        int nextInt = RandomUtils.nextInt(end_index - start_index);
        return start_index + nextInt;

    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;

    }

}
