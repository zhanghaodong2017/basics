package com.zhd.basics.javabase.suanfa;

import java.util.Arrays;

/**
 * @Author: zhanghaodong
 * @Description
 * @Date: 2019-01-14 10:54
 */
public class XianXingSort {

    public static void main(String[] args) {
        Integer[] myArr2 = {38, 23, 6, 11, 29, 17, 8, 34, 1};

        System.out.println(Arrays.toString(tong(myArr2)));
        System.out.println(Arrays.toString(jishu(myArr2)));
    }

    /**
     * 数组拼接
     *
     * @return
     */
    public static Integer[] pinjie(int sumLen, Integer[]... arr) {
        Integer[] result = new Integer[sumLen];
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            Integer[] a = arr[i];
            for (int j = 0; j < a.length; j++) {
                if (a[j] == null) {
                    continue;
                }
                result[start++] = a[j];
            }
        }
        return result;
    }

    /**
     * 桶排序对数据有要求
     *
     * @param arr
     * @return
     */
    public static Integer[] tong(Integer[] arr) {
        Integer[][] tongArr = new Integer[4][10];
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i] / 10;
            int y = arr[i] % 10;
            tongArr[x][y] = arr[i];
        }
        return pinjie(arr.length, tongArr);
    }

    /**
     * 基数排序对数据有要求,不能重复
     *
     *
     * @param arr
     * @return
     */
    public static int[] jishu(Integer[] arr) {
        Integer[] jishuArr = new Integer[40];
        for (int i = 0; i < arr.length; i++) {
            jishuArr[arr[i]] = arr[i];
        }
        int[] result = new int[arr.length];
        int start = 0;
        for (int j = 0; j < jishuArr.length; j++) {
            if (jishuArr[j] == null) {
                continue;
            }
            result[start++] = jishuArr[j];

        }

        return result;
    }


}
