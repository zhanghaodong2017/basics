package com.zhd.basics.sockets;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * @Author: zhanghaodong
 * @Description
 * @Date: 2019-03-07 17:59
 */
public class Util {

    public static String decode(String str, String charCode) {
        try {
            return new String(new BASE64Decoder().decodeBuffer(str), charCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String encode(byte[] bstr) {
        return new BASE64Encoder().encode(bstr);
    }
}
