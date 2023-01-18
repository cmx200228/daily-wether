package com.cmx.dailyweather.service.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.cmx.dailyweather.bean.DataItem;
import com.cmx.dailyweather.config.WeChatConfigure;
import com.cmx.dailyweather.service.SendService;
import com.cmx.dailyweather.util.DataUtil;
import com.cmx.dailyweather.util.TokenUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈蒙欣
 * @date 2022/12/26 23:33
 */
@Service("sendService")
public class SendServiceImpl implements SendService {
    @Resource
    TokenUtil tokenUtil;

    @Resource
    DataUtil dataUtil;
    /**
     * 向客户端发送消息
     */
    @Scheduled(cron = "0 0 7 * * *")
    @Override
    public String sendMsg() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String token = tokenUtil.getToken();
        String requestUrl = " https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="  + token;
        Map<String,Object> content=new HashMap<>();
        Map<String , Object> data = new HashMap<>();
        JSONObject userList = tokenUtil.getUserList(token);
        Map<String, String> weather = dataUtil.getWeather();
        JSONArray openIds = userList.getJSONObject("data").getJSONArray("openid");
        String s = "";
        for (Object openId : openIds) {
            data.put("now" , new DataItem(dateFormat.format(new Date())+weather.get("week"), "#173177"));
            data.put("city" , new DataItem("重庆" , "#FF00FF"));
            data.put("text" , new DataItem(weather.get("weather") , "#FF1493"));
            data.put("low" , new DataItem(weather.get("lowest") , "#FF00FF"));
            data.put("high" , new DataItem(weather.get("highest") , "#173177"));
            data.put("quality" , new DataItem(weather.get("quality") , "#FF00FF"));
            data.put("tips" , new DataItem(weather.get("tips") , "#FF00FF"));
            data.put("daily_english_cn" , new DataItem(dataUtil.getEveryDay() , "#173177"));
            content.put("touser",openId);
            content.put("template_id", WeChatConfigure.Template_ID);
            content.put("data",data);
            s = JSONUtil.toJsonStr(content);
            String resp = HttpUtil.post(requestUrl, s);
            System.out.println("发送结果:" + resp);
        }
        System.out.println(s);
        return s;
    }
}
