package com.zhd.basics.javabase.link;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 链表测试
 *
 * @Author: zhanghaodong
 * @Description
 * @Date: 2019-01-02 19:58
 */
public class LinkTest {

    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<Integer>();

        //新增
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        Object[] objects = linkedList.toArray();
        System.out.println(Arrays.toString(objects));

        //插入
        linkedList.add(2, 8);
        //修改
        linkedList.set(1, 9);
        objects = linkedList.toArray();
        System.out.println(linkedList.size());
        System.out.println(Arrays.toString(objects));

        //查询
        System.out.println(linkedList.get(2));

        //删除

        linkedList.remove(5);
        linkedList.add(10);
        linkedList.add(11);
        linkedList.add(10);
        linkedList.add(1);
        linkedList.removeAll(1);
        linkedList.add(17);
        objects = linkedList.toArray();
        System.out.println(linkedList.size());
        System.out.println(Arrays.toString(objects));

    }
}
