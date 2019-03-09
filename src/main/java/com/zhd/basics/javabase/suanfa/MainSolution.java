package com.zhd.basics.javabase.suanfa;

import java.time.LocalDate;

/**
 * @Author: zhanghaodong
 * @Description
 * @Date: 2019-03-05 16:38
 */
public class MainSolution {

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        int lenth = 1;
        ListNode end = head;
        ListNode nextNode = null;
        while ((nextNode = end.next) != null) {
            end = nextNode;
            lenth++;
        }
        System.out.println("链表长度：" + lenth);
        System.out.println("链表尾部值：" + end.val);
        k = k % lenth;
        System.out.println("K=" + k);
        if (k == 0) {
            return head;
        }
        int n = lenth - k - 1;
        int i = 0;
        ListNode pointN = head;
        while (i++ < n) {
            pointN = pointN.next;
        }
        System.out.println("pointN=" + pointN.val);
        end.next = head;
        head = pointN.next;
        pointN.next = null;
        return head;

    }

    public static ListNode rotateRight2(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {//链表为空或者只有一个元素或k为0
            return head;
        }

        for (int i = 0; i < k; i++) {

        }
        int lenth = 1;
        ListNode end = head;
        ListNode nextNode = null;
        while ((nextNode = end.next) != null) {
            end = nextNode;
            lenth++;
        }
        System.out.println("链表长度：" + lenth);
        System.out.println("链表尾部值：" + end.val);
        k = k % lenth;
        System.out.println("K=" + k);
        if (k == 0) {
            return head;
        }
        int n = lenth - k - 1;
        int i = 0;
        ListNode pointN = head;
        while (i++ < n) {
            pointN = pointN.next;
        }
        System.out.println("pointN=" + pointN.val);
        end.next = head;
        head = pointN.next;
        pointN.next = null;
        return head;

    }

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode head = new ListNode(1, listNode2);

        print(head);
        ListNode result = rotateRight2(head, 7);
        print(result);

        System.out.println();
//        System.out.println(LocalDate.now());
    }

    public static void print(ListNode head) {
        if (head == null) {
            return;
        }
        while (head.next != null) {
            System.out.print(head.val);
            System.out.print(" -> ");
            head = head.next;
        }
        System.out.print(head.val);

    }

}
