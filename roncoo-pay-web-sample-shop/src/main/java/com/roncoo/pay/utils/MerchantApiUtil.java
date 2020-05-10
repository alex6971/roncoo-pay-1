/*
 * Copyright 2015-2102 RonCoo(http://www.roncoo.com) Group.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.roncoo.pay.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <b>功能说明:商户API工具类
 * </b>
 * @author Peter
 * <a href="http://www.roncoo.com">龙果学院(www.roncoo.com)</a>
 */
public class MerchantApiUtil {

    private static final Logger LOG = LoggerFactory.getLogger(MerchantApiUtil.class);

    /**
     * 获取参数签名
     * @param paramMap  签名参数
     * @param paySecret 签名密钥
     * @return
     */
    public static String getSign(Map<String, Object> paramMap, String paySecret) {
        SortedMap<String, Object> smap = new TreeMap<String, Object>(paramMap);
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, Object> m : smap.entrySet()) {
            Object value = m.getValue();
            if (!"sign".equals(m.getKey()) && value != null && StringUtils.isNotBlank(String.valueOf(value))) {
                stringBuffer.append(m.getKey()).append("=").append(m.getValue()).append("&");
            }
        }
        stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());

        LOG.info("签名原文：{}", stringBuffer.toString());

        String argPreSign = stringBuffer.append("&paySecret=").append(paySecret).toString();
        String signStr = MD5Util.encode(argPreSign).toUpperCase();
        LOG.info("签名结果:{}", signStr);
        return signStr;
    }

    /**
     * 获取参数拼接串
     * @param paramMap
     * @return
     */
    public static String getParamStr(Map<String, Object> paramMap) {
        SortedMap<String, Object> smap = new TreeMap<String, Object>(paramMap);
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, Object> m : smap.entrySet()) {
            Object value = m.getValue();
            if (value != null && StringUtils.isNotBlank(String.valueOf(value))) {
                stringBuffer.append(m.getKey()).append("=").append(value).append("&");
            }
        }
        stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());

        return stringBuffer.toString();
    }


    /**
     * 验证商户签名
     * @param paramMap  签名参数
     * @param paySecret 签名私钥
     * @param signStr   原始签名密文
     * @return
     */
    public static boolean isRightSign(Map<String, Object> paramMap, String paySecret, String signStr) {

        if (StringUtils.isBlank(signStr)) {
            return false;
        }

        String sign = getSign(paramMap, paySecret);
        return signStr.equals(sign);
    }

    /**
     * 建立请求，以表单HTML形式构造（默认）
     * @param sParaTemp     请求参数数组
     * @param strMethod     提交方式。两个值可选：post、get
     * @param strButtonName 确认按钮显示文字
     * @return 提交表单HTML文本
     */
    public static String buildRequest(Map<String, Object> sParaTemp, String strMethod, String strButtonName, String actionUrl) {
        //待请求参数数组
        List<String> keys = new ArrayList<String>(sParaTemp.keySet());
        StringBuffer sbHtml = new StringBuffer();

        sbHtml.append("<form id=\"rppaysubmit\" name=\"rppaysubmit\" action=\"").append(actionUrl).append("\" method=\"").append(strMethod).append("\">");

        for (String key : keys) {
            Object object = sParaTemp.get((String) key);
            String value = "";

            if (object != null) {
                value = (String) sParaTemp.get((String) key);
            }

            sbHtml.append("<input type=\"hidden\" name=\"").append((String) key).append("\" value=\"").append(value).append("\"/>");
        }

        //submit按钮控件请不要含有name属性
        sbHtml.append("<input type=\"submit\" value=\"").append(strButtonName).append("\" style=\"display:none;\"></form>");
        sbHtml.append("<script>document.forms['rppaysubmit'].submit();</script>");

        return sbHtml.toString();
    }

}
