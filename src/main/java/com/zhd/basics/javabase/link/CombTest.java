package com.zhd.basics.javabase.link;

import com.lmax.disruptor.dsl.Disruptor;
import com.zhd.basics.javabase.collections.MyHashMap;

/**
 * 排列组合计算 C(m,n) = C(m,m-n) eg:C(7,3)=C(7,4)
 *
 * @Author: zhanghaodong
 * @Description
 * @Date: 2019-01-03 16:40
 */
public class CombTest {

    public static void main(String[] args) {
        System.out.println(comb(8, 4));
//        Disruptor
    }

    /**
     * @see MyHashMap#main(java.lang.String[]))
     * {@link SingleLinkedList#add(java.lang.Object) }
     * @param m
     * @param n
     * @return
     */
    public static int comb(int m, int n) {
        int k = convert(m, n);
        int result = factorial(m, k) / factorial(k);
        return result;

    }

    public static int convert(int m, int n) {
        if (n <= m / 2) {
            return n;
        }
        return m - n;
    }

    public static int factorial(int k) {
        if (k == 1) {
            return 1;
        }
        return k * factorial(k - 1);
    }

    public static int factorial(int m, int k) {
        int sum = 1;
        for (int i = 0; i < k; i++) {
            sum *= m--;
        }
        return sum;

    }

}
