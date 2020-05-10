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
 * 结算发起方式
 * 龙果学院：www.roncoo.com
 * @author：zenghao
 */
public enum SettModeTypeEnum {


    /**
     * 手工结算
     */
    SELFHELP_SETTLE("手工结算"),

    /**
     * 自动（定期）结算
     */
    REGULAR_SETTLE("自动结算");

    /** 描述 */
    private String desc;

    private SettModeTypeEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static SettModeTypeEnum getEnum(String enumName) {
        SettModeTypeEnum resultEnum = null;
        SettModeTypeEnum[] enumAry = SettModeTypeEnum.values();
		for (SettModeTypeEnum settModeTypeEnum : enumAry) {
			if (settModeTypeEnum.name().equals(enumName)) {
				resultEnum = settModeTypeEnum;
				break;
			}
		}
        return resultEnum;
    }

    public static Map<String, Map<String, Object>> toMap() {
        SettModeTypeEnum[] ary = SettModeTypeEnum.values();
        Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>();
        for (SettModeTypeEnum settModeTypeEnum : ary) {
            Map<String, Object> map = new HashMap<String, Object>();
            String key = settModeTypeEnum.name();
            map.put("desc", settModeTypeEnum.getDesc());
            enumMap.put(key, map);
        }
        return enumMap;
    }

    public static List toList() {
        SettModeTypeEnum[] ary = SettModeTypeEnum.values();
        List<Map<String, String>> list = new ArrayList<>();
        for (SettModeTypeEnum settModeTypeEnum : ary) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("desc", settModeTypeEnum.getDesc());
            list.add(map);
        }
        return list;
    }


}
