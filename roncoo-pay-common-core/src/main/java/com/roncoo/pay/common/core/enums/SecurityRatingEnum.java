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
 * 安全等级枚举
 * 龙果学院：www.roncoo.com
 * @author：zenghao
 */
public enum SecurityRatingEnum {

    MD5("MD5"),

    MD5_IP("MD5+IP白名单");

    /** 描述 */
    private String desc;

    private SecurityRatingEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static SecurityRatingEnum getEnum(String enumName) {
        SecurityRatingEnum resultEnum = null;
        SecurityRatingEnum[] enumAry = SecurityRatingEnum.values();
        for (SecurityRatingEnum securityRatingEnum : enumAry)
            if (securityRatingEnum.name().equals(enumName)) {
                resultEnum = securityRatingEnum;
                break;
            }
        return resultEnum;
    }

    public static Map<String, Map<String, Object>> toMap() {
        SecurityRatingEnum[] ary = SecurityRatingEnum.values();
        Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>();
        for (SecurityRatingEnum securityRatingEnum : ary) {
            Map<String, Object> map = new HashMap<String, Object>();
            String key = securityRatingEnum.name();
            map.put("desc", securityRatingEnum.getDesc());
            enumMap.put(key, map);
        }
        return enumMap;
    }

    public static List toList() {
        SecurityRatingEnum[] ary = SecurityRatingEnum.values();
        List<Map<String, String>> list = new ArrayList<>();
        for (SecurityRatingEnum securityRatingEnum : ary) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("name", securityRatingEnum.name());
            map.put("desc", securityRatingEnum.getDesc());
            list.add(map);
        }
        return list;
    }

    /**
     * 取枚举的json字符串
     * @return
     */
    public static String getJsonStr() {
        SecurityRatingEnum[] enums = SecurityRatingEnum.values();
        StringBuffer jsonStr = new StringBuffer("[");
        for (SecurityRatingEnum senum : enums) {
            if (!"[".equals(jsonStr.toString())) {
                jsonStr.append(",");
            }
            jsonStr.append("{id:'").append(senum).append("',desc:'").append(senum.getDesc()).append("'}");
        }
        jsonStr.append("]");
        return jsonStr.toString();
    }
}
