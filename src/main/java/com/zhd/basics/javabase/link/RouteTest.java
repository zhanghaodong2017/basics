package com.zhd.basics.javabase.link;

/**
 * @Author: zhanghaodong
 * @Description
 * @Date: 2019-01-03 13:47
 */
public class RouteTest {
    public static int num = 1;

    public static void main(String[] args) {
        //起点
        Node start = new Node(0, 4);
        Node[] nextNodes = next(start);
        int num = 1;
        while (nextNodes != null) {
            Node[] allNext = null;
            for (int i = 0; i < nextNodes.length; i++) {
                Node[] nodes = next(nextNodes[i]);
                allNext = add(allNext,nodes);
            }
            nextNodes = allNext;
        }
    }

    public static Node[] add(Node[] n1, Node[] n2) {
        if (n1 == null && n2 == null) {
            return null;
        }
        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }
        Node[] n3 = new Node[n1.length + n2.length];
        for (int i = 0; i < n1.length; i++) {
            n3[i] = n1[i];
        }
        for (int i = 0; i < n2.length; i++) {
            n3[i + n1.length] = n2[i];
        }
        return n3;
    }

    public static int nextNum(Node node) {
        Node[] next = next(node);
        if (next != null) {
            return next.length;
        }
        return 1;
    }

    public static Node[] next(Node node) {
        if (isEnd(node)) {
            return null;
        }
        if (node.x == 4) {
            return new Node[]{new Node(4, node.y + 1)};
        }
        if (node.y == 0) {
            return new Node[]{new Node(node.x + 1, 0)};
        }
        return new Node[]{new Node(node.x + 1, node.y), new Node(node.x, node.y - 1)};

    }

    public static boolean isEnd(Node node) {
        if (node.x == 4 && node.y == 0) {
            return true;
        }
        return false;
    }


    public static int nextRoute(Node node) {
        if (node.x == 4 || node.y == 0) {
            return 1;
        }
        return 2;
    }

    private static class Node {
        public int x;
        public int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
