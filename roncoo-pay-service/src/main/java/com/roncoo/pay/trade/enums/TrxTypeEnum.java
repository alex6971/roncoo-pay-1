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

package com.roncoo.pay.trade.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>功能说明:交易类型枚举类</b>
 * @author Peter
 * <a href="http://www.roncoo.com">龙果学院(www.roncoo.com)</a>
 */
public enum TrxTypeEnum {

    ERRORHANKLE("差错处理"),

    REMIT("打款"),

    EXPENSE("消费");

    /** 描述 */
    private String desc;

    private TrxTypeEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static Map<String, Map<String, Object>> toMap() {
        TrxTypeEnum[] ary = TrxTypeEnum.values();
        Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>();
        Map<String, Object> map;
        for (TrxTypeEnum trxTypeEnum : ary) {
            map = new HashMap<String, Object>();
            map.put("desc", trxTypeEnum.getDesc());
            enumMap.put(trxTypeEnum.name(), map);
        }
        return enumMap;
    }

    public static List toList() {
        TrxTypeEnum[] ary = TrxTypeEnum.values();
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map;
        for (TrxTypeEnum trxTypeEnum : ary) {
            map = new HashMap<String, String>();
            map.put("desc", trxTypeEnum.getDesc());
            list.add(map);
        }
        return list;
    }

    public static TrxTypeEnum getEnum(String name) {
        TrxTypeEnum[] arry = TrxTypeEnum.values();
		for (TrxTypeEnum trxTypeEnum : arry) {
			if (trxTypeEnum.name().equalsIgnoreCase(name)) {
				return trxTypeEnum;
			}
		}
        return null;
    }

    /**
     * 取枚举的json字符串
     * @return
     */
    public static String getJsonStr() {
        TrxTypeEnum[] enums = TrxTypeEnum.values();
        StringBuffer jsonStr = new StringBuffer("[");
        for (TrxTypeEnum senum : enums) {
            if (!"[".equals(jsonStr.toString())) {
                jsonStr.append(",");
            }
            jsonStr.append("{id:'").append(senum).append("',desc:'").append(senum.getDesc()).append("'}");
        }
        jsonStr.append("]");
        return jsonStr.toString();
    }
}
