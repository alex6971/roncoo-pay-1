package com.roncoo.pay.reconciliation.utils;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

/**
 * @类功能说明： 微信对账接口工具类.
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：广州领课网络科技有限公司（龙果学院:www.roncoo.com）
 * @作者：Along.shen
 * @创建时间：2016年5月23日,上午10:24:57.
 * @版本：V1.0
 */
public class WeiXinBaseUtils {

    private static final String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /**
     * 生成16位随机的字符串
     * @return
     */
    public static String createNoncestr() {
        return createNoncestr(16);
    }

    /**
     * 生成随机的字符串
     * @param length
     * @return
     */
    private static String createNoncestr(int length) {
        StringBuilder sb = new StringBuilder();
        Random rd = new Random();
        int clength = CHARS.length();
        for (int i = 0; i < length; i++) {
            sb.append(CHARS.charAt(rd.nextInt(clength - 1)));
        }
        return sb.toString();
    }

    /**
     * 生成xml文件
     * @param arr
     * @return
     */
    public static String arrayToXml(HashMap<String, String> arr) {
        StringBuilder xml = new StringBuilder("<xml>");

        for (Entry<String, String> entry : arr.entrySet()) {
            String key = entry.getKey();
            String val = entry.getValue();
            if (isNumeric(val)) {
                xml.append("<").append(key).append(">").append(val).append("</").append(key).append(">");

            } else
                xml.append("<").append(key).append("><![CDATA[").append(val).append("]]></").append(key).append(">");
        }

        xml.append("</xml>");
        return xml.toString();
    }

    private static boolean isNumeric(String str) {
        return str.matches("\\d *");
    }

}
