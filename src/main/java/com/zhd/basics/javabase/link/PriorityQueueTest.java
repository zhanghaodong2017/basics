package com.zhd.basics.javabase.link;

import java.util.PriorityQueue;

/**
 * @Author: zhanghaodong
 * @Description
 * @Date: 2019-01-09 14:16
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<String>();
        priorityQueue.add("1");
        priorityQueue.add("2");
        priorityQueue.add("3");
        priorityQueue.add("4");

        for (int i = 0; i < 4; i++) {
            String peek = priorityQueue.poll();
            System.out.println(peek);
        }


    }
}
