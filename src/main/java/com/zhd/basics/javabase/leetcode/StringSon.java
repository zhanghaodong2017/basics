package com.zhd.basics.javabase.leetcode;

import java.util.HashMap;

/**
 * @Author: zhanghaodong
 * @Description 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @Date: 2019-01-11 10:40
 */
public class StringSon {

    public static int lengthOfLongestSubstring(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        String son = str.substring(0, 1);
        int maxLenth = 1;
        for (int i = 1; i < str.length(); i++) {
            int sonLength = son.length();
            for (int j = 0; j < sonLength; j++) {
                if (son.charAt(j) == str.charAt(i)) {
                    son = son.substring(j + 1);
                    break;
                }
            }
            son = son + str.charAt(i);
            maxLenth = Math.max(maxLenth, son.length());
        }
        return maxLenth;

    }

    public static int lengthOfLongestSubstring2(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        int maxLenth = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0, j = 0; j < str.length(); j++) {
            if (map.containsKey(str.charAt(j))) {
                i = Math.max(map.get(str.charAt(j)), i);
            }
            maxLenth = Math.max(maxLenth, j - i + 1);
            map.put(str.charAt(j), j + 1);
        }
        return maxLenth;

    }

    public static void main(String[] args) {
        String fStr = "abcabcbb";
        System.out.println(lengthOfLongestSubstring2(fStr));

    }
}
