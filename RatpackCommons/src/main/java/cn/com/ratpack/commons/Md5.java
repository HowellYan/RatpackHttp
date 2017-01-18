package cn.com.ratpack.commons;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by samland on 17/1/16.
 */
public class Md5 {
    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };


    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static String encode(String origin) {
        String resultString = null;

        try {
            resultString = origin;
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(resultString
                    .getBytes()));
        } catch (Exception ex) {

        }
        return resultString;
    }

    public static String MD5Encode(String sourceString) {
        String resultString = null;
        try {
            resultString = new String(sourceString);
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byte2hexString(md.digest(resultString.getBytes()));
        } catch (Exception ex) {
        }
        return resultString;
    }

    private static final String byte2hexString(byte[] bytes) {
        StringBuffer bf = new StringBuffer(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            if ((bytes[i] & 0xff) < 0x10) {
                bf.append("0");
            }
            bf.append(Long.toString(bytes[i] & 0xff, 16));
        }
        return bf.toString();
    }

    public static String encodeMD5(String str) {
        if (str == null)
            return null;

        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest code = MessageDigest.getInstance("MD5");
            code.update(str.getBytes());
            byte[] bs = code.digest();
            for (int i = 0; i < bs.length; ++i) {
                int v = bs[i] & 0xFF;
                if (v < 16)
                    sb.append(0);

                sb.append(Integer.toHexString(v));
            }
        } catch (NoSuchAlgorithmException e) {
        }
        return sb.toString();
    }
    /**
     * 理想网关支付MD5加密方法-UTF8
     * @param str
     * @return
     */
    public static final String encodeUTF8(String str) {
        try {
            byte strtemp[] = str.getBytes("UTF8");
            MessageDigest mdtemp = MessageDigest.getInstance("MD5");
            mdtemp.update(strtemp);
            byte md[] = mdtemp.digest();
            return byteToHEX(md);
        } catch (Exception e) {
            return null;
        }
    }

    private static String byteToHEX(byte bytes[]) {
        char Digit[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
                'B', 'C', 'D', 'E', 'F' };
        StringBuffer sb = new StringBuffer();
        char ob[] = new char[2];
        for (int i = 0; i < bytes.length; i++) {
            byte byte0 = bytes[i];
            ob[0] = Digit[byte0 >>> 4 & 0xf];
            ob[1] = Digit[byte0 & 0xf];
            sb.append(ob);
        }

        return sb.toString();
    }
}
