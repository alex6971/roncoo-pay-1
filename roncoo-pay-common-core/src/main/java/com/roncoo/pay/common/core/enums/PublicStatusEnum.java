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
 * 公共状态枚举. 只有 (冻结) 与(激活) 两种状态
 * @author along
 * @company：广州领课网络科技有限公司（龙果学院 www.roncoo.com）.
 */
public enum PublicStatusEnum {

    ACTIVE("激活"),

    UNACTIVE("冻结");

    /** 描述 */
    private String desc;

    private PublicStatusEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static Map<String, Map<String, Object>> toMap() {
        PublicStatusEnum[] ary = PublicStatusEnum.values();
        Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>();
        for (PublicStatusEnum publicStatusEnum : ary) {
            Map<String, Object> map = new HashMap<String, Object>();
            String key = publicStatusEnum.name();
            map.put("value", publicStatusEnum.name());
            map.put("desc", publicStatusEnum.getDesc());
            enumMap.put(key, map);
        }
        return enumMap;
    }

    public static List toList() {
        PublicStatusEnum[] ary = PublicStatusEnum.values();
        List<Map<String, String>> list = new ArrayList<>();
        for (PublicStatusEnum publicStatusEnum : ary) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("desc", publicStatusEnum.getDesc());
            map.put("name", publicStatusEnum.name());
            list.add(map);
        }
        return list;
    }

    public static PublicStatusEnum getEnum(String name) {
        PublicStatusEnum[] arry = PublicStatusEnum.values();
        for (PublicStatusEnum publicStatusEnum : arry) {
            if (publicStatusEnum.name().equalsIgnoreCase(name)) {
                return publicStatusEnum;
            }
        }
        return null;
    }

    /**
     * 取枚举的json字符串
     * @return
     */
    public static String getJsonStr() {
        PublicStatusEnum[] enums = PublicStatusEnum.values();
        StringBuffer jsonStr = new StringBuffer("[");
        for (PublicStatusEnum senum : enums) {
            if (!"[".equals(jsonStr.toString())) {
                jsonStr.append(",");
            }
            jsonStr.append("{id:'").append(senum).append("',desc:'").append(senum.getDesc()).append("'}");
        }
        jsonStr.append("]");
        return jsonStr.toString();
    }

}
