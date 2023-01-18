package com.cmx.dailyweather.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 陈蒙欣
 * @date 2022/12/25 23:49
 */
@Component
public class Constant {
    public static final String HOST = "https://api.weixin.qq.com";

    public static final String API_TOKEN = "/cgi-bin/token";

    public static String API_WEATHER;
    public static String key;

    @Value("${tianxin.server}")
    public void setApiWeather(String apiWeather) {
        API_WEATHER = apiWeather;
    }

    @Value("${tianxin.key}")
    public void setKey(String key) {
        Constant.key = key;
    }
}
