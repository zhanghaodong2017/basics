package com.zhd.basics.javabase.suanfa;

import com.googlecode.javaewah.EWAHCompressedBitmap;
import com.googlecode.javaewah32.EWAHCompressedBitmap32;
import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;
import sun.applet.Main;

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

    public static void main(String[] args) throws UnsupportedEncodingException {
        BitMap bitMap = new BitMap(15);
        bitMap.set(9);
        System.out.println(bitMap.get(9));


    }
}
