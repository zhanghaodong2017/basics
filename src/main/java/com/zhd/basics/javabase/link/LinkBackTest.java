package com.zhd.basics.javabase.link;

import java.util.Arrays;

/**
 * @Author: zhanghaodong
 * @Description 单向链表 实现链表的反转，判断链表是否是回文链表
 * @Date: 2019-01-04 11:24
 */
public class LinkBackTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<Integer>();
        //新增
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        linkedList.reversal();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        System.out.println(Arrays.toString(linkedList.toArray()));

        boolean palindromeLink = isPalindromeLink(linkedList);
        System.out.println(palindromeLink);

    }

    /**
     * 判断链表是否是回文链表
     *
     * @param list
     * @return
     */
    public static boolean isPalindromeLink(SingleLinkedList list) throws CloneNotSupportedException {
        SingleLinkedList old = (SingleLinkedList) list.clone();
        list.reversal();
        System.out.println(Arrays.toString(list.toArray()));
        return Arrays.equals(list.toArray(), old.toArray());
    }

}
