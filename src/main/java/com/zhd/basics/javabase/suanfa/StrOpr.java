package com.zhd.basics.javabase.suanfa;

import java.util.HashMap;

/**
 * @Author: zhanghaodong
 * @Description 字符串匹配算法
 * @Date: 2019-01-18 17:14
 */
public class StrOpr {

    /**
     * 朴素查找
     *
     * @param father
     * @param son
     * @return
     */
    public static int indexOf(String father, String son) {

        int lenth = father.length() - son.length() + 1;
        int k = son.length();
        for (int i = 0; i < lenth; i++) {
            boolean flag = isExist(father, son, k, i);
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    /**
     * KMP查找
     *
     * @param father
     * @param son
     * @return
     */
    public static int indexOf2(String father, String son) {

        int lenth = father.length() - son.length() + 1;
        int k = son.length();
        int i = 0;
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for (int j = 0; j < son.length(); j++) {
            char charAt = son.charAt(j);
            hashMap.put(charAt, j);
        }

        while (i < lenth) {
            boolean flag = isExist(father, son, k, i);
            if (flag) {
                return i;
            }
            //不匹配，后移
            char last = father.charAt(i + k - 1);//最后一位
            Integer index = hashMap.get(last);
            if (index != null) {
                i += k - index + 1;
            } else {
                i += k;
            }

        }
        return -1;
    }


    private static boolean isExist(String father, String son, int k, int i) {
        boolean flag = false;
        for (int j = 0; j < k; j++) {
            if (father.charAt(i + j) != son.charAt(j)) {
                flag = false;
                break;
            }
            flag = true;
        }
        return flag;
    }

    public static void main(String[] args) {
        String father = "asdaksjdkjbkjbkasudkjbzkxjoihlqwkebmbmjbzckjugkuger";
        String son = "jdkjb";
        System.out.println(indexOf(father, son));
        System.out.println(indexOf2(father, son));

    }
}
