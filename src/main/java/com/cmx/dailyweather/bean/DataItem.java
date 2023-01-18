package com.cmx.dailyweather.bean;

/**
 * @author 陈蒙欣
 * @date 2022/12/26 23:59
 */
public class DataItem {
    private String value;
    private String color;

    public DataItem(String value, String color) {
        this.value = value;
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
