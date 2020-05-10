package com.roncoo.pay.reconciliation.utils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 签名算法<br>
 * <br>
 * <b>算法规则: </b><br>
 * 参数名ASCII码从小到大排序（字典序）；<br>
 * 如果参数的值为空不参与签名；<br>
 * 参数名区分大小写；<br>
 * <br>
 * 使用方式可参考: https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=4_3#<br>
 * <br>
 * 2015-12-21
 * @author 叶鹏
 */
public class SignHelper {

    public static final String WX_SIGN_KEY = "key";
    private static final Log LOG = LogFactory.getLog(SignHelper.class);
    private static final String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /**
     * 签名结果比较忽略大小写
     * @param map
     * @param keyValue
     * @param sign
     * @return
     */
    public static boolean validate(Map<String, String> map, String keyValue, String sign) {
        return validate(map, WX_SIGN_KEY, keyValue, sign);
    }

    /**
     * 签名结果比较忽略大小写
     * @param map
     * @param keyName
     * @param keyValue
     * @param sign
     */
    public static boolean validate(Map<String, String> map, String keyName, String keyValue, String sign) {
        if (StringUtils.isBlank(sign)) {
            return false;
        }
        String resultSign = getSign(map, keyName, keyValue);
        return sign.toUpperCase().equals(resultSign.toUpperCase());
    }

    /**
     * 返回签名的大写字符串
     * @param map
     * @param keyValue
     * @param keyName
     * @return
     */
    public static String getSign(Map<String, String> map, String keyName, String keyValue) {
        // 过滤空值
        HashMap<String, String> temp = new HashMap<String, String>();
        for (Entry<String, String> entry : map.entrySet()) {
            if (StringUtils.isNotBlank(entry.getKey()) && StringUtils.isNotBlank(entry.getValue())) {
                temp.put(entry.getKey(), entry.getValue());
            }
        }

        // sort
        List<Entry<String, String>> paramsArray = new ArrayList<Entry<String, String>>(temp.entrySet());
        paramsArray.sort(Entry.comparingByKey());

        // 拼接字符串
        StringBuilder buff = new StringBuilder();
        for (Entry<String, String> entry : paramsArray) {
            buff.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        if (buff.length() > 0) {
            buff.setLength(buff.length() - 1);
        }

        buff.append("&").append(keyName).append("=").append(keyValue);
        String sourceStr = buff.toString();

        try {
            String resultSign = md5Encode(sourceStr, StandardCharsets.UTF_8.name()).toUpperCase();
            if (LOG.isDebugEnabled()) {
                LOG.debug("sign source: [" + sourceStr + "], result sign: [" + resultSign + "]");
            }
            return resultSign;
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new RuntimeException("验证签名失败", e);
        }
    }

    private static String md5Encode(String origin, String charsetname) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        if (StringUtils.isBlank(charsetname)) {
            return byteArrayToHexString(md.digest(origin.getBytes()));
        } else {
            return byteArrayToHexString(md.digest(origin.getBytes(charsetname)));
        }
    }

    private static String byteArrayToHexString(byte[] b) {
        StringBuffer sb = new StringBuffer();
        for (byte value : b) {
            sb.append(byteToHexString(value));
        }
        return sb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    /**
     * 返回签名的大写字符串
     * @param map
     * @param keyValue
     * @return
     */
    public static String getSign(Map<String, String> map, String keyValue) {
        return getSign(map, WX_SIGN_KEY, keyValue);
    }

}
