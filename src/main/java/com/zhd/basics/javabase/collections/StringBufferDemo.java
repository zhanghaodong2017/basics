package com.zhd.basics.javabase.collections;

/**
 * @Author: zhanghaodong
 * @Description
 * @Date: 2019-02-14 10:27
 */
public class StringBufferDemo {
    public static void main(String[] args) {
        StringBuilder b1 = new StringBuilder("hello");
        StringBuilder b2 = new StringBuilder("world");
        System.out.println(b1 + "=====" + b2);
        change(b1, b2);
        System.out.println(b1 + "=====" + b2);
        MapList mapList1 = new MapList();
        MapList mapList2 = new MapList();
        change2(mapList1, mapList2);

    }

    private static void change2(MapList mapList1, MapList mapList2) {
        int i = mapList1.hashCode();
        System.out.println(i);
        mapList1 = mapList2;
    }

    private static void change(StringBuilder b1, StringBuilder b2) {
        b1 = b2;
        b2.append(b1);
    }
}
