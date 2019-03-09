package com.zhd.basics.javabase.suanfa;

/**
 * @Author: zhanghaodong
 * @Description
 * @Date: 2019-03-05 16:37
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
    }

    ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }
}
