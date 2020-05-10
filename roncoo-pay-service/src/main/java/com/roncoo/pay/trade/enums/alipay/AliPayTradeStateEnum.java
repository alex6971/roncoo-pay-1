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

package com.roncoo.pay.trade.enums.alipay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>功能说明:支付宝订单状态枚举类.</b>
 * @author Peter
 * <a href="http://www.roncoo.com">龙果学院(www.roncoo.com)</a>
 */
public enum AliPayTradeStateEnum {
    TRADE_FINISHED("支付完成"),
    TRADE_SUCCESS("支付成功"),
    FAIL("支付失败");

    /** 描述 */
    private String desc;

    private AliPayTradeStateEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static Map<String, Map<String, Object>> toMap() {
        AliPayTradeStateEnum[] ary = AliPayTradeStateEnum.values();
        Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>();
        Map<String, Object> map = null;
        for (AliPayTradeStateEnum aliPayTradeStateEnum : ary) {
            map = new HashMap<String, Object>();
            String key = aliPayTradeStateEnum.name();
            map.put("desc", aliPayTradeStateEnum.getDesc());
            enumMap.put(key, map);
        }
        return enumMap;
    }

    public static List toList() {
        AliPayTradeStateEnum[] ary = AliPayTradeStateEnum.values();
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map = null;
        for (AliPayTradeStateEnum aliPayTradeStateEnum : ary) {
            map = new HashMap<String, String>();
            map.put("desc", aliPayTradeStateEnum.getDesc());
            list.add(map);
        }
        return list;
    }

    public static AliPayTradeStateEnum getEnum(String name) {
        AliPayTradeStateEnum[] arry = AliPayTradeStateEnum.values();
        for (AliPayTradeStateEnum aliPayTradeStateEnum : arry) {
            if (aliPayTradeStateEnum.name().equalsIgnoreCase(name)) {
                return aliPayTradeStateEnum;
            }
        }
        return null;
    }

    /**
     * 取枚举的json字符串
     * @return
     */
    public static String getJsonStr() {
        AliPayTradeStateEnum[] enums = AliPayTradeStateEnum.values();
        StringBuffer jsonStr = new StringBuffer("[");
        for (AliPayTradeStateEnum senum : enums) {
            if (!"[".equals(jsonStr.toString())) {
                jsonStr.append(",");
            }
            jsonStr.append("{id:'").append(senum).append("',desc:'").append(senum.getDesc()).append("'}");
        }
        jsonStr.append("]");
        return jsonStr.toString();
    }
}
