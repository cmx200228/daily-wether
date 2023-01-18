package com.cmx.dailyweather.controller;

import com.cmx.dailyweather.common.ApiRestResponse;
import com.cmx.dailyweather.service.SendService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 陈蒙欣
 * @date 2022/12/26 21:04
 */
@RestController
public class WeatherController {
    @Resource
    SendService sendService;

    @GetMapping("/send")
    public ApiRestResponse sendMsg() {
        return ApiRestResponse.success(sendService.sendMsg());
    }
}
