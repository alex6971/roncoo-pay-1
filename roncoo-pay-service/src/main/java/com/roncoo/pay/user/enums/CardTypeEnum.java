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
 * 证件类型
 * 龙果学院：www.roncoo.com
 * @author：zenghao
 */
public enum CardTypeEnum {

    IDENTITY("身份证");

    /** 描述 */
    private String desc;

    private CardTypeEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static Map<String, Map<String, Object>> toMap() {
        CardTypeEnum[] ary = CardTypeEnum.values();
        Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>();
        for (CardTypeEnum cardTypeEnum : ary) {
            Map<String, Object> map = new HashMap<String, Object>();
            String key = cardTypeEnum.name();
            map.put("desc", cardTypeEnum.getDesc());
            map.put("name", cardTypeEnum.name());
            enumMap.put(key, map);
        }
        return enumMap;
    }

    public static List toList() {
        CardTypeEnum[] ary = CardTypeEnum.values();
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map;
        for (CardTypeEnum cardTypeEnum : ary) {
            map = new HashMap<String, String>();
            map.put("desc", cardTypeEnum.getDesc());
            list.add(map);
        }
        return list;
    }


    public static CardTypeEnum getEnum(String enumName) {
        CardTypeEnum resultEnum = null;
        CardTypeEnum[] enumAry = CardTypeEnum.values();
        for (CardTypeEnum cardTypeEnum : enumAry) {
            if (cardTypeEnum.name().equals(enumName)) {
                resultEnum = cardTypeEnum;
                break;
            }
        }
        return resultEnum;
    }
}
