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
package com.roncoo.pay.common.core.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 支付类型枚举类
 * @company：广州领课网络科技有限公司（龙果学院 www.roncoo.com）.
 * @author Peter
 */
public enum PayTypeEnum {

    SCANPAY("WEIXIN","扫码支付"),

    H5PAY("WEIXIN","H5支付"),

    DIRECT_PAY("ALIPAY","即时到账"),

    HUA_BEI_FEN_QI_PAY("ALIPAY","花呗分期"),

    MICRO_PAY("WEIXIN","刷卡支付"),

    WX_PROGRAM_PAY("WEIXIN","微信小程序"),

    F2F_PAY("ALIPAY","条码支付"),

	ALI_TEST("ALIPAY","支付宝测试");

	/** 所属支付方式 */
    private String way;
    public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}

	/** 描述 */
    private String desc;

    private PayTypeEnum(String way,String desc) {
        this.desc = desc;
        this.way = way;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static Map<String, Map<String, Object>> toMap() {
        PayTypeEnum[] ary = PayTypeEnum.values();
        Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>();
        for (PayTypeEnum payTypeEnum : ary) {
            Map<String, Object> map = new HashMap<String, Object>();
            String key = payTypeEnum.name();
            map.put("desc", payTypeEnum.getDesc());
            enumMap.put(key, map);
        }
        return enumMap;
    }

    public static List toList() {
        PayTypeEnum[] ary = PayTypeEnum.values();
        List<Map<String, String>> list = new ArrayList<>();
        for (PayTypeEnum payTypeEnum : ary) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("desc", payTypeEnum.getDesc());
            map.put("name", payTypeEnum.name());
            list.add(map);
        }
        return list;
    }

    public static PayTypeEnum getEnum(String name) {
        PayTypeEnum[] arry = PayTypeEnum.values();
        for (PayTypeEnum payTypeEnum : arry) {
            if (payTypeEnum.name().equalsIgnoreCase(name)) {
                return payTypeEnum;
            }
        }
        return null;
    }

    public static List getWayList(String way) {
    	PayTypeEnum[] ary = PayTypeEnum.values();
        List<Map<String, String>> list = new ArrayList<>();
        for (PayTypeEnum payTypeEnum : ary) {
            if (payTypeEnum.way.equals(way)) {
                Map<String, String> map = new HashMap<String, String>();
                map.put("desc", payTypeEnum.getDesc());
                map.put("name", payTypeEnum.name());
                list.add(map);
            }
        }
        return list;
    }

    /**
     * 取枚举的json字符串
     *
     * @return
     */
    public static String getJsonStr() {
        PayTypeEnum[] enums = PayTypeEnum.values();
        StringBuffer jsonStr = new StringBuffer("[");
        for (PayTypeEnum senum : enums) {
            if (!"[".equals(jsonStr.toString())) {
                jsonStr.append(",");
            }
            jsonStr.append("{id:'").append(senum).append("',desc:'").append(senum.getDesc()).append("'}");
        }
        jsonStr.append("]");
        return jsonStr.toString();
    }

}
