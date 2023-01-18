package com.cmx.dailyweather.util;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.cmx.dailyweather.common.Constant;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈蒙欣
 * @date 2022/12/25 22:15
 */
@Component
public class DataUtil {
    @Resource
    RestTemplate restTemplate;

    public Map<String,String> getWeather() {
        String url = Constant.API_WEATHER + "/tianqi/index?key=" + Constant.key + "&city=重庆&type=1";
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        JSONObject jsonObject = JSONUtil.parseObj(forEntity.getBody());
        JSONArray newslist = jsonObject.getJSONArray("newslist");
        Map<String,String> weather = new HashMap<>();
        weather.put("weather",newslist.getJSONObject(0).getStr("weather"));
        weather.put("highest",newslist.getJSONObject(0).getStr("highest"));
        weather.put("lowest",newslist.getJSONObject(0).getStr("lowest"));
        weather.put("week",newslist.getJSONObject(0).getStr("week"));
        weather.put("quality",newslist.getJSONObject(0).getStr("quality"));
        weather.put("tips",newslist.getJSONObject(0).getStr("tips"));
        return weather;
    }

    public String getEveryDay() {
        String everyDay;
        String url = Constant.API_WEATHER + "/everyday/index?key=" + Constant.key;
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        JSONObject jsonObject = JSONUtil.parseObj(forEntity.getBody());
        everyDay = jsonObject.getJSONArray("newslist").getJSONObject(0).getStr("content") + "\n" +
                jsonObject.getJSONArray("newslist").getJSONObject(0).getStr("note");
        return everyDay;
    }
}
