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
 * 账户类型
 * 龙果学院：www.roncoo.com
 * @author：zenghao
 */
public enum AccountTypeEnum {

    /**
     * 用户
     */
    USER("用户"),
    /**
     * 企业
     */
    ENTERPRISE("企业");

    /** 描述 */
    private String desc;

    private AccountTypeEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static AccountTypeEnum getEnum(String enumName) {
        AccountTypeEnum resultEnum = null;
        AccountTypeEnum[] enumAry = AccountTypeEnum.values();
		for (AccountTypeEnum accountTypeEnum : enumAry) {
			if (accountTypeEnum.name().equals(enumName)) {
				resultEnum = accountTypeEnum;
				break;
			}
		}
        return resultEnum;
    }

    public static Map<String, Map<String, Object>> toMap() {
        AccountTypeEnum[] ary = AccountTypeEnum.values();
        Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>();
		for (AccountTypeEnum accountTypeEnum : ary) {
			Map<String, Object> map = new HashMap<String, Object>();
			String key = accountTypeEnum.name();
			map.put("desc", accountTypeEnum.getDesc());
			enumMap.put(key, map);
		}
        return enumMap;
    }

    public static List toList() {
        AccountTypeEnum[] ary = AccountTypeEnum.values();
        List<Map<String, String>> list = new ArrayList<>();
		for (AccountTypeEnum accountTypeEnum : ary) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("desc", accountTypeEnum.getDesc());
			list.add(map);
		}
        return list;
    }

}
