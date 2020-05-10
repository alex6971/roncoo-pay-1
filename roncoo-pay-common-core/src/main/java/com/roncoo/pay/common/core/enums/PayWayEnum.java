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
 * 支付方式枚举
 * @author Along.shen
 * @company：广州领课网络科技有限公司（龙果学院 www.roncoo.com）.
 */
public enum PayWayEnum {

    WEIXIN("微信"),

    ALIPAY("支付宝");

    /** 描述 */
    private String desc;

    private PayWayEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static Map<String, Map<String, Object>> toMap() {
        PayWayEnum[] ary = PayWayEnum.values();
        Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>();
        for (PayWayEnum payWayEnum : ary) {
            Map<String, Object> map = new HashMap<String, Object>();
            String key = payWayEnum.name();
            map.put("desc", payWayEnum.getDesc());
            enumMap.put(key, map);
        }
        return enumMap;
    }

    public static List toList() {
        PayWayEnum[] ary = PayWayEnum.values();
        List<Map<String, String>> list = new ArrayList<>();
        for (PayWayEnum payWayEnum : ary) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("desc", payWayEnum.getDesc());
            map.put("name", payWayEnum.name());
            list.add(map);
        }
        return list;
    }

    public static PayWayEnum getEnum(String name) {
        PayWayEnum[] arry = PayWayEnum.values();
        for (PayWayEnum payWayEnum : arry) {
            if (payWayEnum.name().equalsIgnoreCase(name)) {
                return payWayEnum;
            }
        }
        return null;
    }

    /**
     * 取枚举的json字符串
     * @return
     */
    public static String getJsonStr() {
        PayWayEnum[] enums = PayWayEnum.values();
        StringBuffer jsonStr = new StringBuffer("[");
        for (PayWayEnum senum : enums) {
            if (!"[".equals(jsonStr.toString())) {
                jsonStr.append(",");
            }
            jsonStr.append("{id:'").append(senum).append("',desc:'").append(senum.getDesc()).append("'}");
        }
        jsonStr.append("]");
        return jsonStr.toString();
    }

}
