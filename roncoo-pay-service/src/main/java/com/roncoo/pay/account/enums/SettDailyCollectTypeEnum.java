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

package com.roncoo.pay.account.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 结算日汇总类型
 * 龙果学院：www.roncoo.com
 * @author：zenghao
 */
public enum SettDailyCollectTypeEnum {

    /**
     * 存入/减少汇总
     */
    ALL("存入/减少汇总"),

    /**
     * 临时汇总
     */
    TEMP("临时汇总"),
    /**
     * 未结算遗留汇总(例如：小数点后两位部分)
     */
    LEAVE("遗留汇总");

    /** 描述 */
    private String desc;

    private SettDailyCollectTypeEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static SettDailyCollectTypeEnum getEnum(String enumName) {
        SettDailyCollectTypeEnum resultEnum = null;
        SettDailyCollectTypeEnum[] enumAry = SettDailyCollectTypeEnum.values();
        for (SettDailyCollectTypeEnum settDailyCollectTypeEnum : enumAry) {
            if (settDailyCollectTypeEnum.name().equals(enumName)) {
                resultEnum = settDailyCollectTypeEnum;
                break;
            }
        }
        return resultEnum;
    }

    public static Map<String, Map<String, Object>> toMap() {
        SettDailyCollectTypeEnum[] ary = SettDailyCollectTypeEnum.values();
        Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>();
        for (SettDailyCollectTypeEnum settDailyCollectTypeEnum : ary) {
            Map<String, Object> map = new HashMap<String, Object>();
            String key = settDailyCollectTypeEnum.name();
            map.put("desc", settDailyCollectTypeEnum.getDesc());
            enumMap.put(key, map);
        }
        return enumMap;
    }

    public static List toList() {
        SettDailyCollectTypeEnum[] ary = SettDailyCollectTypeEnum.values();
        List<Map<String, String>> list = new ArrayList<>();
        for (SettDailyCollectTypeEnum settDailyCollectTypeEnum : ary) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("desc", settDailyCollectTypeEnum.getDesc());
            list.add(map);
        }
        return list;
    }
}
