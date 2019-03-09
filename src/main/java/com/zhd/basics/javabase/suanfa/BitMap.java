package com.zhd.basics.javabase.suanfa;

import org.apache.commons.lang.math.RandomUtils;

import java.io.UnsupportedEncodingException;
import java.util.BitSet;

/**
 * @Author: zhanghaodong
 * @Description位图:利用位运算表示一个二进制
 * @Date: 2019-01-25 11:09
 */
public class BitMap {

    private char[] bytes;
    private int nbits;

    public BitMap(int nbits) {
        this.bytes = new char[nbits / 16 + 1];
        this.nbits = nbits;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        BitMap bitMap = new BitMap(15);
        bitMap.set(9);
        System.out.println(bitMap.get(9));
        String ceshi = "ceshi";
        System.out.println(Integer.MAX_VALUE);

        sort();
    }

    /**
     *
     */
    private static void sort() {
        createData();
    }

    /**
     * 生成数据
     */
    private static void createData() {
        BitSet bitSet = new BitSet();
        for (int k = 0; k < 10000000; k++) {
            int random = getRandom();
            while (bitSet.get(random)) {
                random = getRandom();
            }
            bitSet.set(random);
            System.out.println(random);
        }


    }

    public static int getRandom() {
        int i = RandomUtils.nextInt(Integer.MAX_VALUE);
        return i;
    }

    public void set(int k) {
        if (k > nbits) {
            return;
        }
        int byteIndex = k / 16;

        int bitIndex = k % 16;
        System.out.println(bytes[byteIndex]);
        System.out.println(1 << bitIndex);
        bytes[byteIndex] |= (1 << bitIndex);

    }

    public boolean get(int k) {
        if (k > nbits) {
            return false;
        }
        int byteIndex = k / 16;
        int bitIndex = k % 16;

        return (bytes[byteIndex] & (1 << bitIndex)) != 0;
    }

}
