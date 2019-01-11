package com.zhd.basics.javabase.leetcode;

/**
 * @Author: zhanghaodong
 * @Description
 * @Date: 2019-01-10 19:06
 */
public class ListNodeTest {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        boolean jinwei = false;
        ListNode preNode = null;

        while (l1 != null || l2 != null) {
            if (result == null) {
                int sum = l1.val + l2.val;
                if (sum >= 10) {
                    sum -= 10;
                    jinwei = true;
                }
                result = new ListNode(sum);
                preNode = result;
            } else {
                int val_1 = 0, val_2 = 0;
                if (l1 != null) {
                    val_1 = l1.val;
                }
                if (l2 != null) {
                    val_2 = l2.val;
                }
                int sum = val_1 + val_2;
                if (jinwei) {
                    sum++;
                    jinwei = false;
                }
                if (sum >= 10) {
                    sum -= 10;
                    jinwei = true;
                }
                preNode.next = new ListNode(sum);
                preNode = preNode.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        if (jinwei) {
            preNode.next = new ListNode(1);
        }

        return result;
    }

    public static ListNode build(int index) {
        char[] chars = String.valueOf(index).toCharArray();
        ListNode node = null;
        ListNode preNode = null;

        for (int i = chars.length - 1; i >= 0; i--) {
            ListNode currNode = new ListNode(Integer.valueOf(String.valueOf(chars[i])));
            if (node == null) {
                node = currNode;
            } else {
                preNode.next = currNode;
            }
            preNode = currNode;
        }
        return node;
    }

    public static int getValue(ListNode currNode) {
        int i = 0;
        int result = 0;
        while (currNode != null) {
            result += zhjishu(i++) * currNode.val;
            currNode = currNode.next;
        }
        return result;
    }

    public static int zhjishu(int i) {
        if (i == 0) {
            return 1;
        }
        int result = 1;
        for (int j = 0; j < i; j++) {
            result *= 10;
        }
        return result;
    }

    public static void main(String[] args) {

        ListNode l1 = build(5);
        ListNode l2 = build(5);
        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(getValue(listNode));

    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}


