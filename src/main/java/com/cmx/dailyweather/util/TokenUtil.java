package com.cmx.dailyweather.util;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.cmx.dailyweather.common.Constant;
import com.cmx.dailyweather.config.WeChatConfigure;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.annotations.Cacheable;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author 陈蒙欣
 * @date 2022/12/25 23:45
 */
@Component
public class TokenUtil {
    @Resource
    RestTemplate restTemplate;
    @Resource
    com.alibaba.fastjson2.JSONObject jsonObject;

    @Resource
    RedisTemplate<String, String> redisTemplate;


    @Cacheable(value = "#result")
    public String getToken() {
        String url = Constant.HOST + Constant.API_TOKEN;
        // 这里的参数要和下面的Map Key值对应
        String path = "?grant_type={grant_type}&appid={appid}&secret={secret}";
        Map<String, String> params = new HashMap<>(20);
        params.put("grant_type", "client_credential");
        params.put("appid", WeChatConfigure.AppID);
        params.put("secret", WeChatConfigure.App_Secret);
        ResponseEntity<String> forObject = restTemplate.getForEntity(url + path, String.class, params);
        redisTemplate.opsForValue().set("token" , Objects.requireNonNull(forObject.getBody()),90 , TimeUnit.SECONDS);
        System.out.println(forObject.getBody());
        JSONObject jsonObject = JSONUtil.parseObj(forObject.getBody());
        return jsonObject.getStr("access_token");
    }

    public JSONObject getUserList(String accessToken) {
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=" + accessToken + "&next_openid=";
        String resp = HttpUtil.get(requestUrl);
        cn.hutool.json.JSONObject result = JSONUtil.parseObj(resp);
        System.out.println("用户列表:" + resp);
        return result;
    }
}
