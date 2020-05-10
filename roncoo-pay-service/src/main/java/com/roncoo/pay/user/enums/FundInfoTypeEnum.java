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

package com.roncoo.pay.user.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 资金流入类型
 * 龙果学院：www.roncoo.com
 * @author：Peter
 */
public enum FundInfoTypeEnum {

    PLAT_RECEIVES("平台收款"),
    MERCHANT_RECEIVES("商家收款");

    /** 描述 */
    private String desc;

    private FundInfoTypeEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static Map<String, Map<String, Object>> toMap() {
        FundInfoTypeEnum[] ary = FundInfoTypeEnum.values();
        Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>();
        for (FundInfoTypeEnum fundInfoTypeEnum : ary) {
            Map<String, Object> map = new HashMap<String, Object>();
            String key = fundInfoTypeEnum.name();
            map.put("desc", fundInfoTypeEnum.getDesc());
            enumMap.put(key, map);
        }
        return enumMap;
    }

    public static List toList() {
        FundInfoTypeEnum[] ary = FundInfoTypeEnum.values();
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map;
        for (FundInfoTypeEnum fundInfoTypeEnum : ary) {
            map = new HashMap<String, String>();
            map.put("desc", fundInfoTypeEnum.getDesc());
            map.put("name", fundInfoTypeEnum.name());
            list.add(map);
        }
        return list;
    }

    public static FundInfoTypeEnum getEnum(String name) {
        FundInfoTypeEnum[] arry = FundInfoTypeEnum.values();
        for (FundInfoTypeEnum fundInfoTypeEnum : arry) {
            if (fundInfoTypeEnum.name().equalsIgnoreCase(name)) {
                return fundInfoTypeEnum;
            }
        }
        return null;
    }

    /**
     * 取枚举的json字符串
     * @return
     */
    public static String getJsonStr() {
        FundInfoTypeEnum[] enums = FundInfoTypeEnum.values();
        StringBuffer jsonStr = new StringBuffer("[");
        for (FundInfoTypeEnum senum : enums) {
            if (!"[".equals(jsonStr.toString())) {
                jsonStr.append(",");
            }
            jsonStr.append("{id:'").append(senum).append("',desc:'").append(senum.getDesc()).append("'}");
        }
        jsonStr.append("]");
        return jsonStr.toString();
    }
}
