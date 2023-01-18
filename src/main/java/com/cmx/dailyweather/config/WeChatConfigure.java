package com.cmx.dailyweather.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 陈蒙欣
 * @date 2022/12/25 22:34
 */
@Component
public class WeChatConfigure {

    public static String AppID ;
    public static String App_Secret;
    public static String Template_ID;
    public static String Top_Color;

    @Value("${tencent.wechat.appId}")
    public void setAppID(String appId) {
        AppID = appId;
    }
    @Value("${tencent.wechat.appSecret}")
    public void setApp_Secret(String appSecret) {
        App_Secret = appSecret;
    }
    @Value("${tencent.templateList.templateId}")
    public void setTemplate_ID(String templateId) {
        Template_ID = templateId;
    }

    @Value("${tencent.wechat.topColor}")
    public void setTop_Color(String topColor) {
        Top_Color = topColor;
    }
}
