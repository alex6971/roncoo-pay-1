package com.roncoo.pay.banklink.utils.weixin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.core.io.ClassPathResource;

public class WxCityNo {

    /**
     * @author:
     * @date:2018/8/30
     * @description:从txt文件读取List<String>
     */
    public static List getList() {
        List<Map<String, String>> strList = new ArrayList<>();
        InputStreamReader read = null;
        BufferedReader reader = null;
        try {
            read = new InputStreamReader(new ClassPathResource("WxCityNo.txt").getInputStream(), StandardCharsets.UTF_8);
            reader = new BufferedReader(read);
            String line;
            while ((line = reader.readLine()) != null) {
                Map<String, String> strMap = new HashMap<>();
                strMap.put("name", line.substring(0, line.indexOf("=")));
                strMap.put("desc", line.substring(line.indexOf("=") + 1));
                strList.add(strMap);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (read != null) {
                try {
                    read.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return strList;
    }

    public static String getCityNameByNo(String cityNo) {
        List list = getList();
        String cityName = null;
        for (Object o : list) {
            Map map = (HashMap) o;
            if (cityNo.equals(map.get("name"))) {
                cityName = (String) map.get("desc");
            }
        }
        return cityName;
    }
}
