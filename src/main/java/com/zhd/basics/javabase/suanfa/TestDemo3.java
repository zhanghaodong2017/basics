package com.zhd.basics.javabase.suanfa;

import java.util.Arrays;

/**
 * @Author: zhanghaodong
 * @Description
 * @Date: 2019-01-29 15:06
 */
public class TestDemo3 {
    public static void main(String[] args) {
        int[] a = new int[10];
        int[] myarr = {1, 6, 4, 5,9, 7};
        for (int i = 0; i < myarr.length; i++) {
            a[myarr[i]] = 1;
        }

        for (int i = 0; i < a.length; i++) {
            if( a[i] == 1){
                System.out.println(i);
            }
        }

        System.out.println(a[2] == 1);

        System.out.println(Arrays.toString(a));
    }
}
