package com.zhd.basics.javabase.collections;

/**
 * @Author: zhanghaodong
 * @Description
 * @Date: 2018-12-24 15:24
 */
public class MapList {

    public static void main(String[] args) {
//        HashMap<String, String> map = new HashMap<String, String>();
//        map.put("abc","123");

        Object key = "bac";
        int h = key.hashCode();
        System.out.println(key.hashCode());
        System.out.println(h >>> 16);
        int index = (h) ^ (h >>> 16);
        System.out.println(index);

        System.out.println(8 >>> 2);

        System.out.println(15 & 97284);
        System.out.println("--------------分割---------------");

        for (int i = 16; i < 33; i++) {
            int fenm = 30;
            System.out.print(i);
            System.out.print("  ,  ");
            System.out.print(fenm % i);
            System.out.print("  ,  ");
            System.out.println(fenm & (i - 1));

        }

        System.out.println("--------------分割---------------");
        System.out.println(getMaxLength(34));


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
}
