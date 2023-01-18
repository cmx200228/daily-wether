package com.cmx.dailyweather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *
 * @author 陈蒙欣
 * @date 2022/12/25
 */

@EnableCaching
@EnableScheduling
@SpringBootApplication
public class DailyWeatherApplication {

    public static void main(String[] args) {
        SpringApplication.run(DailyWeatherApplication.class, args);
    }

}
