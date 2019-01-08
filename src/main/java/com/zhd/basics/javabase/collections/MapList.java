package com.zhd.basics.javabase.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @Author: zhanghaodong
 * @Description
 * @Date: 2018-12-24 15:24
 */
public class MapList {

    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();


        System.out.println("--------------分割---------------");
        for (int i = 0; i < 17; i++) {
            map.put("abc" + i, "123" + i);

        }
        System.out.println(map);
        ArrayList<String> arrayList = new ArrayList<String>();

        ArrayList arrayList1 = new ArrayList();
        arrayList1.add(null);

    }

    private static int getMaxLength(int length) {

        if (length <= 16) return 16;

        for (int i = 4; i < 32; i++) {


            if (length < (2 << i)) {
                return 2 << i;
            }
            if (i > 10 && length < ((2 << i) * 1.2)) {
                return 2 << i;
            }


        }

        return Integer.MAX_VALUE;

    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        System.out.println(n);
        n |= n >>> 1;
        System.out.println(n);
        n |= n >>> 2;
        System.out.println(n);
        n |= n >>> 4;
        System.out.println(n);
        n |= n >>> 8;
        System.out.println(n);
        n |= n >>> 16;
        System.out.println(n);
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
