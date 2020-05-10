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
 * 银行账户类型
 * 龙果学院：www.roncoo.com
 * @author：zenghao
 */
public enum BankAccountTypeEnum {

    PUBLIC_ACCOUNT("对公帐户"),
    PRIVATE_DEBIT_ACCOUNT("对私借记卡");

    /** 描述 */
    private String desc;

    private BankAccountTypeEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static Map<String, Map<String, Object>> toMap() {
        BankAccountTypeEnum[] ary = BankAccountTypeEnum.values();
        Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>();
        Map<String, Object> map;
        for (BankAccountTypeEnum bankAccountTypeEnum : ary) {
            map = new HashMap<String, Object>();
            String key = bankAccountTypeEnum.name();
            map.put("desc", bankAccountTypeEnum.getDesc());
            map.put("name", bankAccountTypeEnum.name());
            enumMap.put(key, map);
        }
        return enumMap;
    }

    public static List toList() {
        BankAccountTypeEnum[] ary = BankAccountTypeEnum.values();
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map;
        for (BankAccountTypeEnum bankAccountTypeEnum : ary) {
            map = new HashMap<String, String>();
            map.put("desc", bankAccountTypeEnum.getDesc());
            map.put("name", bankAccountTypeEnum.name());
            list.add(map);
        }
        return list;
    }


    public static BankAccountTypeEnum getEnum(String enumName) {
        BankAccountTypeEnum resultEnum = null;
        BankAccountTypeEnum[] enumAry = BankAccountTypeEnum.values();
        for (BankAccountTypeEnum bankAccountTypeEnum : enumAry) {
            if (bankAccountTypeEnum.name().equals(enumName)) {
                resultEnum = bankAccountTypeEnum;
                break;
            }
        }
        return resultEnum;
    }
}
