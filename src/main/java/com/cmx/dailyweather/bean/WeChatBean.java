package com.cmx.dailyweather.bean;

import com.alibaba.fastjson2.JSONObject;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author 陈蒙欣
 * @date 2022/12/26 22:01
 */
@Data
@Component
@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix = "wechat")
public class WeChatBean {
    @Value("${tianxin.server}")
    public String API_WEATHER;
    @Value("${tianxin.key}")
    public String key;
    @Value("${tencent.wechat.appId}")
    private String appid;
    @Value("${tencent.wechat.appSecret}")
    private String secret;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public JSONObject getJSONObject() {
        return new JSONObject();
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getAPI_WEATHER() {
        return API_WEATHER;
    }

    public void setAPI_WEATHER(String API_WEATHER) {
        this.API_WEATHER = API_WEATHER;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
